package monitor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.framework.system.db.manager.DBManager;
/**
 * 数据库测试服务
 * @author Administrator
 *
 */
public class DBMonitorServlet extends HttpServlet
{
  private static Logger logger = Logger.getLogger(DBMonitorServlet.class);
  private DBManager dbManager = DBManager.getInstance();

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doPost(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {   
	  logger.debug("数据库校验");
	  try {
		  dbManager.doSql("select 1 from mysql.user");
	  } catch (Exception e) {		  
		  logger.error("数据库校验失败");
		  //返回500
		  response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	  }
	  
  }
  
 
}