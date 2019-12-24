package jp.joyworks.dao.blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jp.joyworks.dto.blog.UserDTO;

public class UserDAO {

	private final String JDBC_URL = "jdbc:mysql://localhost:3306/blog_db?serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "admin";

	//ログイン機能
	public UserDTO login(String user_id, String user_pass) {
		UserDTO record = new UserDTO();

		Connection conn = null;

		String sql = "SELECT * FROM blog_db.user where id = ? and pass = ?";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user_id);
			ps.setString(2, user_pass);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				record.setId(rs.getString("id"));
				record.setPass(rs.getString("pass"));
				record.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return record;
	}

}
