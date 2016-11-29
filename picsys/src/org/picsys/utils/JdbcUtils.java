package org.picsys.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 数据库帮助类
 * 
 * @desc: TODO
 * @author songzhantao
 * @date 2016年8月11日 下午3:18:17
 */
public class JdbcUtils {

	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@192.168.8.3:1521:orcl";
	public static final String USER_NAME = "scott";
	public static final String PASS_WORD = "admin";

	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	// 静态块 加载驱动
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败");
			e.printStackTrace();
		}

	}

	/**
	 * 获取连接
	 * 
	 * @return
	 */
	public Connection getConnection() {
		Connection conn = null;
		try {
			if (null == conn || conn.isClosed()) {
				try {
					conn = DriverManager
							.getConnection(URL,
									USER_NAME,PASS_WORD);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

	/**
	 * 查询
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
//	public ResultSet executeQuery(String sql, Object[] params)
//			throws SQLException {
//		conn = getConnection();
//		pst = conn.prepareStatement(sql);
//		for (int i = 0; params !=null && i < params.length; i++) {
//			pst.setObject(i + 1, params[i]);
//		}
//		rs = pst.executeQuery();
//		return rs;
//
//	}

	/**
	 * 通用查询 返回List
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<HashMap> executeQuery2(String sql, Object[] params)
			throws SQLException {
		conn = getConnection();
		pst = conn.prepareStatement(sql);
		for (int i = 0;params!=null  && i < params.length; i++) {
			pst.setObject(i + 1, params[i]);
		}
		ResultSet rs = pst.executeQuery();
		//获取查询语句的元数据 
		ResultSetMetaData rsmd = rs.getMetaData();
		//获取列的数量
		int count = rsmd.getColumnCount();
		ArrayList<HashMap> list = new ArrayList<HashMap>();
		while (rs.next()) {
			HashMap map = new HashMap();
			for (int i = 0; i < count; i++) {
				//获取列名
				String columnName = rsmd.getColumnName(i+1);
				//根据列名  获取每行的值
				String value = rs.getString(columnName);
				map.put(columnName.toLowerCase(), value);
			}
			list.add(map);

		}
		//关闭链接
		close();
		return list;

	}

	/**
	 * 执行更新
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public int executeUpdate(String sql, Object[] params) throws SQLException {
		conn = getConnection();
		pst = conn.prepareStatement(sql);
		for (int i = 0;params!=null&&i< params.length; i++) {
			pst.setObject(i + 1, params[i]);
		}
		int i = pst.executeUpdate();
		return i;
	}

	/**
	 * 关闭方法
	 */
	public void close() {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (pst != null) {
			try {
				pst.close();
				pst = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
