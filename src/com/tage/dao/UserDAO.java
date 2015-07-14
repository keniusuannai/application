package com.tage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.tage.bean.User;
import com.tage.util.JdbcUtils;

public class UserDAO {

	/**
	 * 用户登录,成功则返回用户id
	 * 
	 * @param username
	 * @param userpwd
	 * @return
	 */
	public static User findUser(String username, String userpwd) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from user_info where username = '"
					+ username + "' and " + "password='" + userpwd + "'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserid(rs.getInt(1));
				user.setOrganize(rs.getString(5));
				user.setRight(rs.getInt(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, ps, conn);
		}
		return user;
	}

	/**
	 * 判断用户名是否已经被使用
	 * 
	 * @param username
	 * @return
	 */
	public static boolean checkUsername(String username) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = true;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select userid from user_info where username = '"
					+ username + "'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				flag = true;
			} else {
				flag = false;
			}
			// ps.setDate(5, new java.sql.Date(new java.util.Date().getDate()));
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, ps, conn);
		}
		return flag;
	}

	public static Map<String, String> check(int userid) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String,String>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from user_info where userid = '"
					+ userid+"'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				map.put("organize",rs.getString(5));
				map.put("right", String.valueOf(rs.getInt(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, ps, conn);
		}
		return map;
	}

}
