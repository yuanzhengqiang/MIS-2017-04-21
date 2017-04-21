package sbtj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class SQLserverUtils {
	private static SQLserverUtils sqlserver;
	private static Logger logger = Logger.getLogger(SQLserverUtils.class);

	/**
	 * 获取实例
	 * 
	 * @return
	 */
	public static SQLserverUtils getInstance() {
		if (sqlserver == null) {
			sqlserver = new SQLserverUtils();
		}
		return sqlserver;
	}

	public List<Map<String, Object>> selectBySQL(String sql) {
		logger.debug("SQL请求select消息： " + sql);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://10.7.20.202:1433; DatabaseName=KXT_Middleware";
			String user = "KXTdb";
			String password = "KXTsoft2010";
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData(); // 获得结果集结构信息,元数据
			int columnCount = md.getColumnCount(); // 获得列数
			while (rs.next()) {
				Map<String, Object> rowData = new HashMap<String, Object>();
				for (int i = 1; i <= columnCount; i++) {
					rowData.put(md.getColumnName(i), rs.getObject(i));
				}
				list.add(rowData);

			}
		} catch (Exception ex) {
		} finally {
			/**
			 * 关闭资源
			 */
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception ex1) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception ex1) {
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception ex1) {
				}
			}

		}
		logger.debug("SQL请求select返回消息： " + list.toString());
		return list;

	}

	public boolean updateBySQL(String sql) {
		logger.debug("SQL请求update消息： " + sql);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		boolean result = true;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://10.7.20.202:1433; DatabaseName=KXT_Middleware";
			String user = "KXTdb";
			String password = "KXTsoft2010";
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
			int num = stmt.executeUpdate(sql);
			if (num == 0) {
				result = false;
			}

		} catch (Exception ex) {
		} finally {
			/**
			 * 关闭资源
			 */
			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception ex1) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception ex1) {
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception ex1) {
				}
			}

		}
		logger.debug("SQL请求update返回消息： " + result);
		return result;
	}
}
