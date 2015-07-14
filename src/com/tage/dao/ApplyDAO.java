package com.tage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tage.bean.Apply;
import com.tage.util.JdbcUtils;

public class ApplyDAO {

	/**
	 * 根据具体时间获取所有申请
	 * 
	 * @param apn
	 * @param day
	 * @param month
	 * @param year
	 * @return
	 */
	public static List<Apply> findApply(int apn, int day, int month, int year) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Apply> list = new ArrayList<Apply>();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from apply_info where hostapn = '" + apn
					+ "' and " + "hostday='" + day + "' and hostmonth='"
					+ month + "' and hostyear='" + year + "'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Apply apply = new Apply();
				apply.setApplyid(rs.getInt(1));
				apply.setUserid(rs.getInt(2));
				apply.setHostname(rs.getString(3));
				apply.setHostyear(rs.getInt(4));
				apply.setHostmonth(rs.getInt(5));
				apply.setHostday(rs.getInt(6));
				apply.setHostapn(rs.getInt(7));
				// apply.setAddtime(rs.getDate(7));这里直接写会使 json处理报错
				try {
					String time = rs.getString(8);
					Format f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = (Date) f.parseObject(time);
					apply.setAddtime(date);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				apply.setPlace(rs.getString(9));
				apply.setEventype(rs.getString(10));
				apply.setEventname(rs.getString(11));
				apply.setNumber(rs.getInt(12));
				apply.setDescribe(rs.getString(13));
				apply.setStatus(rs.getInt(14));
				apply.setRemark(rs.getString(15));
				list.add(apply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, ps, conn);
		}
		return list;
	}

	/**
	 * 根据年月获取申请
	 * 
	 * @param month
	 * @param year
	 * @return
	 */
	public static List<Apply> findApplyByYYMM(int month, int year) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Apply> list = new ArrayList<Apply>();
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select * from apply_info where hostmonth='" + month
					+ "' and hostyear='" + year + "'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Apply apply = new Apply();
				apply.setApplyid(rs.getInt(1));
				apply.setUserid(rs.getInt(2));
				apply.setHostname(rs.getString(3));
				apply.setHostyear(rs.getInt(4));
				apply.setHostmonth(rs.getInt(5));
				apply.setHostday(rs.getInt(6));
				apply.setHostapn(rs.getInt(7));
				try {
					String time = rs.getString(8);
					Format f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = (Date) f.parseObject(time);
					apply.setAddtime(date);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				apply.setPlace(rs.getString(9));
				apply.setEventype(rs.getString(10));
				apply.setEventname(rs.getString(11));
				apply.setNumber(rs.getInt(12));
				apply.setDescribe(rs.getString(13));
				apply.setStatus(rs.getInt(14));
				apply.setRemark(rs.getString(15));
				list.add(apply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, ps, conn);
		}
		return list;
	}

	/**
	 * 获得申请详情
	 * 
	 * @param month
	 * @param year
	 * @return
	 */
	public static Apply findApplyDetail(int apn, int day, int month, int year) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Apply apply = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select a.*,b.username from apply_info a,user_info b where hostapn = '"
					+ apn
					+ "' and "
					+ "hostday='"
					+ day
					+ "' and hostmonth='"
					+ month
					+ "' and hostyear='"
					+ year
					+ "' and status=1 and a.userid=b.userid";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				apply = new Apply();
				apply.setApplyid(rs.getInt(1));
				apply.setUserid(rs.getInt(2));
				apply.setHostname(rs.getString(3));
				apply.setHostyear(rs.getInt(4));
				apply.setHostmonth(rs.getInt(5));
				apply.setHostday(rs.getInt(6));
				apply.setHostapn(rs.getInt(7));
				// apply.setAddtime(rs.getDate(7));这里直接写会使 json处理报错
				try {
					String time = rs.getString(8);
					Format f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date date = (Date) f.parseObject(time);
					apply.setAddtime(date);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				apply.setPlace(rs.getString(9));
				apply.setEventype(rs.getString(10));
				apply.setEventname(rs.getString(11));
				apply.setNumber(rs.getInt(12));
				apply.setDescribe(rs.getString(13));
				apply.setStatus(rs.getInt(14));
				apply.setRemark(rs.getString(15));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, ps, conn);
		}
		return apply;
	}

	// 添加申请
	public static boolean addapply(Apply apply) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = true;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into apply_info(userid,hostyear,hostmonth,hostday,hostapn,addtime,place,eventype,eventname,number,`describe`,hostname) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, apply.getUserid());
			ps.setInt(2, apply.getHostyear());
			ps.setInt(3, apply.getHostmonth());
			ps.setInt(4, apply.getHostday());
			ps.setInt(5, apply.getHostapn());
			ps.setTimestamp(6, Timestamp.valueOf(new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss").format(new Date())));
			ps.setString(7, apply.getPlace());
			ps.setString(8, apply.getEventype());
			ps.setString(9, apply.getEventname());
			ps.setInt(10, apply.getNumber());
			ps.setString(11, apply.getDescribe());
			ps.setString(12, apply.getHostname());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, ps, conn);
		}
		return flag;
	}

	// 确认申请
	public static boolean passapply(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = true;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "update apply_info set status=1 where applyid = '"
					+ id + "'";
			ps = conn.prepareStatement(sql);
			ps.executeQuery();

			String sql2 = "select status from apply_info where applyid='" + id
					+ "'";
			ps = conn.prepareStatement(sql2);
			rs = ps.executeQuery();
			if (rs.getInt(1) == 1) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		} finally {
			JdbcUtils.close(rs, ps, conn);
		}
		return flag;
	}
}
