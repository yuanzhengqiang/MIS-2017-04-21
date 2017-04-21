package sbtj.thread;

import org.apache.log4j.Logger;

import sbtj.init.SystemInit;
import weixin.tools.SignUtil;

public class GetAccessTokenThread extends Thread {
	private static Logger logger = Logger.getLogger(GetAccessTokenThread.class);

	public void run() {
		logger.debug("定时获取微信access_token线程开启.....");
		while (true) {
			try {
				int count = 0;// 计数器
				// 新建临时的token
				String tempAccess_token = SignUtil.getAccess_token();
				// 请求失败,继续请求
				while ("failure".equals(tempAccess_token)) {
					logger.debug("access_tokenq请求失败，再次请求....");
					tempAccess_token = SignUtil.getAccess_token();
				}
				SystemInit.access_token = tempAccess_token;
				// 新建临时的jsapi_ticket
				String tempJsapi_ticket = SignUtil.getTicket(tempAccess_token);
				// 请求失败，继续请求
				while ("failure".equals(tempJsapi_ticket)) {
					logger.debug("jsapi_ticket请求失败，再次请求....");
					tempJsapi_ticket = SignUtil.getTicket(tempAccess_token);
					// 十次获取失败则跳出
					count++;
					if (count == 10) {
						break;
					}
				}
				// 更新
				
				if (count != 10) {
					SystemInit.jsapi_ticket = tempJsapi_ticket;
				}

				Thread.sleep(60 * 60 * 1000);// 每十分钟更新一次
			} catch (Exception e) {
				logger.debug("获取微信access_token失败！");
			}
		}

	}
}
