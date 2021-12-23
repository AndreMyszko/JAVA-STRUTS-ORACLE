package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dbutil.DBUtil;
import pojo.LoginInfo;

public class LoginDAO {
	public static boolean isUserValid(LoginInfo userDetails) {
		boolean validStatus = false;
		try {
			Connection conn = DBUtil.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM tb_login WHERE user_name = '"+userDetails.getUserName()+"' AND password= '"+userDetails.getPassword()+"'");
			while(rs.next()) {
				validStatus = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return validStatus;
	}
}
