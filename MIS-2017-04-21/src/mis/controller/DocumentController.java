package mis.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mis.entity.MedicalReportEntity;
import mis.service.MedicalReportService;
import mis.utils.RandomNum;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.framework.system.util.FileUtil;

@RequestMapping("/document")
@Controller
public class DocumentController {

	private static Logger logger = Logger.getLogger(DocumentController.class);

	/**
	 * 上传文件
	 * 
	 * @param request
	 * @param medicalReportId
	 * @return
	 */
	@RequestMapping(params = "upload")
	@ResponseBody
	public String upload(HttpServletRequest request, String medicalReportId) {
		JSONObject msg = new JSONObject();
		String result = "failure";
		String des = "文件上传失败";
		String link = "";
		String separator = FileUtil.getFileSeparator();
		Integer mrid = Integer.valueOf(medicalReportId);
		MedicalReportEntity mre = MedicalReportService.getInstance().getById(
				mrid);
		if (mre == null) {
			result = "failure";
			;
			des = "文件上传失败";
			msg.put("result", result);
			msg.put("des", des);
			return msg.toString();
		} else {
			/** 如果已经上传过了体检报告，则删除原来的 */
			if (mre.getMedicalReportDownloadLink() != null
					&& mre.getMedicalReportDownloadLink().length() > 0) {
				String path = DocumentController.class.getResource(
						"DocumentController.class").toString();
				if ("file".equals(path.substring(0, 4))) {
					if ("\\".equals(separator))
						path = path.substring(6);
					else {
						path = path.substring(5);
					}
				}

				String filename = mre.getMedicalReportDownloadLink().substring(
						mre.getMedicalReportDownloadLink().lastIndexOf(
								separator),
						mre.getMedicalReportDownloadLink().length());
				String localPath = path.substring(0, path.indexOf("WEB-INF"))
						+ "doc" + filename;
				File file = new File(localPath);
				if (file.isFile()) {
					file.delete();
					file = null;
				}
			}
			// 创建一个通用的多部分解析器
			CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
					request.getSession().getServletContext());
			// 判断 request 是否有文件上传,即多部分请求
			if (multipartResolver.isMultipart(request)) {
				// 转换成多部分request
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
				// 取得request中的所有文件名
				Iterator<String> iter = multiRequest.getFileNames();
				String uploadFileName = "";
				while (iter.hasNext()) {
					try {
						// 取得上传文件
						MultipartFile file = multiRequest.getFile(iter.next()); // iter.next()
						if (file != null) {
							// 取得当前上传文件的文件名称
							uploadFileName = file.getOriginalFilename();
							int nfiletype = uploadFileName.lastIndexOf(".");
							String fileType = uploadFileName.substring(
									nfiletype, uploadFileName.length());
							/** 以体检报告的 ID 加上文件上传时的名字作为文件名，避免重复 */
							String fileWritePath = request.getSession()
									.getServletContext()
									.getRealPath(separator + "doc")
									+ separator
									+ medicalReportId
									+ "_"
									+ RandomNum.generateHexString(18)
									+ fileType;
							link = fileWritePath;
							mre.setMedicalReportDownloadLink(link);
							mre.setMedicalReportName(uploadFileName);
							System.out.println(link);
							BufferedInputStream bufferedInputStream = new BufferedInputStream(
									file.getInputStream());
							FileOutputStream outputStream = new FileOutputStream(
									fileWritePath);
							BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
									outputStream);
							if (uploadFileName.trim() != "") {
								try {
									final byte temp[] = new byte[1024];
									int readBytes = 0;
									while ((readBytes = bufferedInputStream
											.read(temp)) != -1) {
										bufferedOutputStream.write(temp, 0,
												readBytes);
									}
									bufferedOutputStream.flush();
								} catch (Exception e) {
									e.printStackTrace();
								} finally {
									if (bufferedOutputStream != null) {
										bufferedOutputStream.close();
									}
									if (bufferedInputStream != null) {
										bufferedInputStream.close();
									}
								}
							}
						} else {
							des = "文件获取失败";
						}

					} catch (Exception e) {
						System.out.println(e);
					}
				}
				MedicalReportService.getInstance().save(mre);
				result = "success";
				des = "文件上传成功";
			} else {
				des = "未上传文件";
			}
		}
		msg.put("result", result);
		msg.put("des", des);
		msg.put("link", link);
		return msg.toString();
	}

	/**
	 * 下载体检报告
	 * 
	 * @param request
	 * @param response
	 * @param filePath
	 */
	// @RequestMapping(params = "download")
	// @ResponseBody
	// public void download(HttpServletRequest request,
	// HttpServletResponse response, String medicalReportId, String filePath) {
	// response.setContentType("application/msword;charset=UTF-8");
	// response.setCharacterEncoding("UTF-8");
	// if (filePath != null && filePath.length() > 0) {
	// try {
	// // 读
	// File file = new File(filePath);
	// InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
	// //, "UTF-8"
	// BufferedReader br = new BufferedReader(isr);
	//
	// // 写
	// Integer _medicalReportId = Integer.valueOf(medicalReportId);
	// MedicalReportEntity _temp_ =
	// MedicalReportService.getInstance().getById(_medicalReportId);
	// String fileName = _temp_.getMedicalReportName();
	// PrintWriter pw = response.getWriter();
	// response.setHeader("Content-Disposition", "attachment; filename="
	// + URLEncoder.encode(fileName, "UTF-8"));
	// try {
	// if (!file.exists() || file.isDirectory()) {
	// throw new FileNotFoundException();
	// } else {
	// char[] bufread = new char[1024];
	// int nHasRead = br.read(bufread);
	// while (nHasRead != -1) {
	// pw.write(bufread);
	// nHasRead = br.read(bufread);
	// }
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// br.close();
	// isr.close();
	// file = null;
	// pw.flush();
	// pw.close();
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// logger.error(e);
	// }
	// }
	// }

	@RequestMapping(params = "download")
	@ResponseBody
	public void download(HttpServletRequest request,
			HttpServletResponse response, String medicalReportId,
			String filePath) {

		Integer _medicalReportId = Integer.valueOf(medicalReportId);
		MedicalReportEntity _temp_ = MedicalReportService.getInstance()
				.getById(_medicalReportId);
		String filename = _temp_.getMedicalReportName();

		try {
			OutputStream toClient = new BufferedOutputStream(
					response.getOutputStream());
			// path是指欲下载的文件的路径。
			File file = new File(filePath);
			// 以流的形式下载文件。
			InputStream fis = new BufferedInputStream(new FileInputStream(filePath));
			// 清空response
			response.reset();
			// 设置response的Header
			response.setContentType("application/msword;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8")); 
			response.addHeader("Content-Length", "" + file.length());
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			toClient.write(buffer);
			if (toClient != null) {
				toClient.flush();
				toClient.close();
			}
			if (fis != null) {
				fis.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
