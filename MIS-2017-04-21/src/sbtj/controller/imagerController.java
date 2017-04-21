package sbtj.controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.framework.system.util.JsonUtil;

import sun.misc.BASE64Encoder;

@RequestMapping("/position")
@Controller	
public class imagerController {
	private static Logger logger = Logger.getLogger(imagerController.class);

	/**
	 * 上传位置图片
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "pic")
	@ResponseBody
	public String uploadPic(HttpServletRequest request) {
		String result = "";
		
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					// 取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					// 如果名称不为"",说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						try {
							// 重命名上传后的文件名
							String fileName = "photos/" + new Date().getTime() + new Double(1000 * Math.random()).intValue() + myFileName.substring(myFileName.lastIndexOf("."));
							// 定义上传路径
							String path = request.getSession().getServletContext().getRealPath("/") + fileName;
							File localFile = new File(path);
							file.transferTo(localFile);
							result = fileName;
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						} catch (IndexOutOfBoundsException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		return result;
	}
	
	/**
	 * 上传位置图片
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "pic1")
	@ResponseBody
	public String uploadPic1(HttpServletRequest request) {
		String result = "";
		
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					// 取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					// 如果名称不为"",说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						try {
							// 重命名上传后的文件名
							String fileName = new Date().getTime() + new Double(1000 * Math.random()).intValue() + myFileName.substring(myFileName.lastIndexOf("."));
							// 定义上传路径
							String path1 = request.getSession().getServletContext().getRealPath("/") + "photos/linshi/" + fileName;
							File localFile1 = new File(path1);
							file.transferTo(localFile1);
							result = "photos/linshi/" + fileName;
							
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						} catch (IndexOutOfBoundsException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		return result;
	}


	/**
	 * 保存截图。
	 * 
	 * @param tarPath
	 * @param tarPath
	 */
	@RequestMapping(params = "pic2")
	@ResponseBody
	public String save2(HttpServletRequest request, String srcPath, int x1,
			int y1, int x2, int y2,String type) {
		String url = "";
		String base64 = "";
		try {
			String imgType = srcPath.substring(srcPath.lastIndexOf(".") + 1);// 获取图片类型
			srcPath = request.getSession().getServletContext().getRealPath("/")
					+ srcPath;// 原图片地址

			BufferedImage bufImg = ImageIO.read(new File(srcPath));
			BufferedImage subImg = bufImg.getSubimage(x1, y1, x2, y2);

			String imgName = type + new Date().getTime()
					+ new Double(1000 * Math.random()).intValue();// 裁剪后图片名字

			BufferedImage tempImg = new BufferedImage(x2, y2,
					BufferedImage.TYPE_INT_RGB);

			tempImg.getGraphics().drawImage(
					subImg.getScaledInstance(x2, y2, Image.SCALE_SMOOTH), 0, 0,
					null);
			srcPath = request.getSession().getServletContext().getRealPath("/")
					+ "photos/linshi/" + imgName + "." + imgType;// 设置裁剪后图片保存地址
			ImageIO.write(tempImg, imgType, new File(srcPath));// 保存在本地临时文件
			url = "photos/linshi/" + imgName + "." + imgType;

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(tempImg, imgType, baos);
			byte[] bytes = baos.toByteArray();
			BASE64Encoder encoder = new sun.misc.BASE64Encoder();
			base64 = encoder.encodeBuffer(bytes).trim();
			base64 = base64.replaceAll("\r", "");
			base64 = base64.replaceAll("\n", "");
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject jsonResult = new JSONObject();
		jsonResult.put("url", url);
		jsonResult.put("base64", base64);
		String json2return = jsonResult.toString();

		try {
			json2return = new String(json2return.getBytes("utf-8"),
					"iso-8859-1");
		} catch (UnsupportedEncodingException e) {

		}
		return json2return;
	}
	
}
