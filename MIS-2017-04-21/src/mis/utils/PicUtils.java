package mis.utils;

import java.io.File;
import java.net.URLDecoder;

import javax.imageio.stream.FileImageOutputStream;

import org.apache.log4j.Logger;

import sbtj.init.SystemInit;

import com.framework.system.util.FileUtil;

public class PicUtils {
	
	private static Logger logger = Logger.getLogger(PicUtils.class);
	
	public static final String HEXALLCHAR = "0123456789abcdefABCDEF";

	
	public static String savePhoto(String photo, String folder, String fileName) {
		String returnPath = null;
		try {
			photo = photo.replaceAll("\n", "");
			byte[] photobyte = Base64Utils.decode(photo);

			String path = PicUtils.class.getResource("PicUtils.class").toString();
			String separator = FileUtil.getFileSeparator();
			if ("file".equals(path.substring(0, 4))) {
				if ("\\".equals(separator))
					path = path.substring(6);
				else {
					path = path.substring(5);
				}
			}
			String localPath = path.substring(0, path.indexOf("WEB-INF")) + "photos" + separator + folder + separator + fileName;
			localPath = URLDecoder.decode(localPath);
			localPath = localPath.replace("/", separator);
			localPath = localPath.replace("\\", separator);

			returnPath = SystemInit.photourl + "/photos/" + folder + "/" + fileName;

			byte2image(photobyte, localPath);
		} catch (Exception e) {
			logger.error(e.toString());
		}
		return returnPath;
	}
	
	

	public static void byte2image(byte[] data, String path) {
		if ((data.length < 3) || (path.equals("")))
			return;
		try {
			FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
			imageOutput.write(data, 0, data.length);
			imageOutput.close();
			System.out.println("Make Picture success,Please find image in " + path);
		} catch (Exception ex) {
			System.out.println("Exception: " + ex);
			ex.printStackTrace();
		}
	}
}
