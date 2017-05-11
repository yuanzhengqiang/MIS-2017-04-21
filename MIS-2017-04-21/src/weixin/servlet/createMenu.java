package weixin.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mis.entity.MenuEntity;
import mis.service.MenuService;

import org.apache.log4j.Logger;

import sbtj.init.SystemInit;
import weixin.tools.SignUtil;

import com.framework.system.db.query.OrderVO;
import com.framework.system.db.query.PageList;
import com.framework.system.util.JsonUtil;

public class createMenu {
	private static Logger logger = Logger.getLogger(createMenu.class);

	/**
	 * 服务类
	 */
	private static MenuService menuService = MenuService.getInstance();

	// 创建目录,单独运行，网页直接调
	public static int createMenu() throws IOException {
		Integer flag = 0;
		String menus = splicingMenu();

		logger.debug("微信服务器       创建菜单" + menus);
		// 此处改为自己想要的结构体，替换即可
		String access_token = SystemInit.access_token;

		String action = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + access_token;
		try {
			URL url = new URL(action);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();

			http.setRequestMethod("POST");
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒

			http.connect();
			OutputStream os = http.getOutputStream();
			os.write(menus.getBytes("UTF-8"));// 传入参数
			os.flush();
			os.close();

			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] jsonBytes = new byte[size];
			is.read(jsonBytes);
			String message = new String(jsonBytes, "UTF-8");
			Map demoJson = JsonUtil.getMap4Json(message);
			if (demoJson != null) {
				String errmsg = (String) demoJson.get("errmsg");
				if ("ok".equals(errmsg)) {
					flag = 1;
				}
			}
			System.out.println(message);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 拼接微信菜单 注:最多3*5
	 * 
	 * @param
	 * @return menu
	 */
	public static String splicingMenu() {
		String menus = "{\"button\":[";

		List<MenuEntity> menuListFather = new ArrayList<MenuEntity>();// 父菜单
		List<MenuEntity> menuListSon = new ArrayList<MenuEntity>();// 子菜单
		// 获取父菜单列表
		menuListFather = weChatMenuRequest(3, 0);
		if (menuListFather != null && menuListFather.size() > 0) {
			// 循环父菜单列表，根据父菜单id分别获取子菜单列表
			for (int i = 0; i < menuListFather.size(); i++) {
				MenuEntity menujson = menuListFather.get(i);
				Integer id = menujson.getId();
				menuListSon = weChatMenuRequest(5, id);
				menus += splicingMenuSon(menujson, menuListSon);
			}
			menus = menus.substring(0, menus.length() - 1);
		}
		menus += "]}";
		return menus;
	}

	/**
	 * 微信菜单请求
	 * 
	 * @param
	 * @return menu
	 */
	public static List<MenuEntity> weChatMenuRequest(Integer pagesize, Integer parentId) {
		List<MenuEntity> menuList = new ArrayList<MenuEntity>();// 菜单

		Map<String, Object> query = new HashMap<String, Object>();
		query.put("parentId", parentId);
		List<OrderVO> orderList = new ArrayList<OrderVO>();
		OrderVO order = new OrderVO();
		order.setName("orderColumn");
		order.setOrderType(OrderVO.asc);
		orderList.add(order);
		PageList menuPageList = menuService.getListByCondition(query, orderList, 1, pagesize);
		if (menuPageList != null && menuPageList.getResultList() != null) {
			List<Object> objlist = menuPageList.getResultList();
			if (objlist != null) {
				for (Object obj : objlist) {
					MenuEntity menuenty = (MenuEntity) obj;
					menuList.add(menuenty);// 已根据菜单顺序字段升序排序
				}
			}
		}
		return menuList;
	}

	/**
	 * 拼接微信菜单 每一列
	 * 
	 * @param
	 * @return menu
	 */
	public static String splicingMenuSon(MenuEntity menuListFather, List<MenuEntity> menuListSon) {
		String menus = "";
		if (menuListFather != null) {
			Integer id = null;
			String name = null;
			String address = null;
			Integer addressType = null;
			String redirect_uri = null;
			if (menuListSon == null || menuListSon.size() == 0) {// 当前菜单列1只有一个父菜单
				id = menuListFather.getId();
				name = menuListFather.getName();
				address = menuListFather.getAddress();
				addressType = menuListFather.getAddressType();
				if (addressType == 1) {// 属于自己系统的访问地址，直接跳转
					redirect_uri = "http://" + SignUtil.yumingdizhi + "/" + address + "&weixin=weixin";
					redirect_uri = URLEncoder.encode(redirect_uri);
					menus += "{\"type\":\"view\",\"name\":\"" + name + "\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + SignUtil.APPID
					        + "&redirect_uri=" + redirect_uri + "&response_type=code&scope=snsapi_base&state=123#wechat_redirect\"},";
				} else if (addressType == 2 || addressType == 3) {// 属于微盟或者链接跳转的访问地址，需要先跳转自己地址，再跳转，二次跳转
					redirect_uri = "http://" + SignUtil.yumingdizhi + "/" + "wechatweimob.do?microJumpModule&menuId=" + id + "&weixin=weixin";
					redirect_uri = URLEncoder.encode(redirect_uri);
					menus += "{\"type\":\"view\",\"name\":\"" + name + "\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + SignUtil.APPID
					        + "&redirect_uri=" + redirect_uri + "&response_type=code&scope=snsapi_base&state=123#wechat_redirect\"},";
				}  else if (addressType == 4) {
					menus += "{\"type\":\"media_id\",\"name\":\"图文消息\",\"media_id\":\"" +  address + "\"},";
				}
			} else {// 当前菜单列1包括一个父菜单和子菜单
				name = menuListFather.getName();
				menus += "{";
				menus += "\"name\":\"" + name + "\",";
				menus += "\"sub_button\":[";
				// 循环遍历，开始拼接菜单
				for (int i = 0; i < menuListSon.size(); i++) {
					MenuEntity menujson = menuListSon.get(i);
					id = menujson.getId();
					name = menujson.getName();
					address = menujson.getAddress();
					addressType = menujson.getAddressType();
					if (addressType == 1) {// 属于自己系统的访问地址，直接跳转
						redirect_uri = "http://" + SignUtil.yumingdizhi + "/" + address + "&weixin=weixin";
						redirect_uri = URLEncoder.encode(redirect_uri);
						menus += "{\"type\":\"view\",\"name\":\"" + name + "\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid="
						        + SignUtil.APPID + "&redirect_uri=" + redirect_uri + "&response_type=code&scope=snsapi_base&state=123#wechat_redirect\"},";
					} else if (addressType == 2 || addressType == 3) {// 属于微盟或者链接跳转的访问地址，需要先跳转自己地址，再跳转，二次跳转
						redirect_uri = "http://" + SignUtil.yumingdizhi + "/" + "wechatweimob.do?microJumpModule&menuId=" + id + "&weixin=weixin";
						redirect_uri = URLEncoder.encode(redirect_uri);
						menus += "{\"type\":\"view\",\"name\":\"" + name + "\",\"url\":\"https://open.weixin.qq.com/connect/oauth2/authorize?appid="
						        + SignUtil.APPID + "&redirect_uri=" + redirect_uri + "&response_type=code&scope=snsapi_base&state=123#wechat_redirect\"},";
					}  else if (addressType == 4) {
						menus += "{\"type\":\"media_id\",\"name\":\"图文消息\",\"media_id\":\"" +  address + "\"},";
					}
					
				}
				menus = menus.substring(0, menus.length() - 1);
				menus += "]";
				menus += "},";
			}
		}
		return menus;
	}
}
