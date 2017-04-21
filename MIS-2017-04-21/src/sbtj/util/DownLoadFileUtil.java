package sbtj.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

public class DownLoadFileUtil {
	private static DownLoadFileUtil downLoad;
	private static Logger logger = Logger.getLogger(DownLoadFileUtil.class);

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static DownLoadFileUtil getInstance() {
		if (downLoad == null) {
			downLoad = new DownLoadFileUtil();
		}
		return downLoad;
	}

	public void downLoadByUrl(String fileName, String netUrl, String savePath) {
		InputStream in = null;
		OutputStream out = null;
		HttpURLConnection conn = null;
		try {
			// 初始化连接
			URL url = new URL(netUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				// 读取数据
				byte[] buffer = new byte[1024];
				in = conn.getInputStream();
				// 写入本地
				out = new FileOutputStream(new File(savePath, fileName));
				int count = 0;
				while ((count = in.read(buffer)) != -1) {
					if (count != 0) {
						out.write(buffer, 0, count);
					}
				}
			}
		} catch (MalformedURLException e) {
			logger.debug("图片下载出错！" + e);
		} catch (IOException e) {
			logger.debug("图片下载出错！" + e);
		} finally {
			// 释放资源
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
