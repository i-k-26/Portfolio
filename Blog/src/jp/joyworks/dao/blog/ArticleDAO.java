package jp.joyworks.dao.blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.joyworks.dto.blog.ArticleDTO;

public class ArticleDAO {

	private final String JDBC_URL = "jdbc:mysql://localhost:3306/sampledb?serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "admin";

	//ログインユーザーの記事作成機能
	public void createArticle(String user_id, String user_name, String title, String article,
			java.sql.Date post_date, String category, Boolean status) {

		Connection conn = null;

		String sql = "INSERT INTO blog_db.article(user_id,user_name,title,article,category,post_date,status) "
				+ "VALUE(?,?,?,?,?,?,?)";

		try {
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user_id);
			ps.setString(2, user_name);
			ps.setString(3, title);
			ps.setString(4, article);
			ps.setString(5, category);
			ps.setDate(6, post_date);
			ps.setBoolean(7, status);

			int result = ps.executeUpdate();
			System.out.println("記事が" + result + "件、追加されました。");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	//ログインユーザーの記事リスト作成機能
	public List<ArticleDTO> getArticles(String user_id) {
		List<ArticleDTO> articledto = new ArrayList<ArticleDTO>();

		Connection conn = null;

		String sql = "SELECT id,title,category,post_date,status FROM blog_db.article where user_id = ? "
				+ "order by post_date desc";

		try {
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				var record = new ArticleDTO();
				record.setId(rs.getInt("id"));
				record.setTitle(rs.getString("title"));
				record.setCategory(rs.getString("category"));
				record.setPost_date(rs.getDate("post_date"));
				record.setStatus(rs.getBoolean("status"));
				articledto.add(record);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return articledto;
	}

	//ログインユーザーの編集記事選択
	public ArticleDTO getArticle(int id) {
		ArticleDTO record = new ArticleDTO();

		Connection conn = null;

		String sql = "SELECT title,article,category,status FROM blog_db.article where id = ? user_id = ? ";

		try {
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			//			ps.setString(2, user_id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				//				var record = new ArticleDto();
				record.setTitle(rs.getString("title"));
				record.setArticle(rs.getString("article"));
				record.setCategory(rs.getString("category"));
				record.setStatus(rs.getBoolean("status"));
				//				articledto.add(record);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return record;
	}

	//一般ユーザーの記事検索機能
	public List<ArticleDTO> searchArticles(String user_name) {
		List<ArticleDTO> articledto = new ArrayList<ArticleDTO>();

		Connection conn = null;

		String sql = "SELECT id,title,post_date,category FROM blog_db.article where user_name = ? "
				+ "AND status='1' order by post_date desc";

		try {
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user_name);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				var record = new ArticleDTO();
				record.setId(rs.getInt("id"));
				record.setTitle(rs.getString("title"));
				record.setCategory(rs.getString("category"));
				record.setPost_date(rs.getDate("post_date"));
				articledto.add(record);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return articledto;
	}

	//ログインユーザーの記事削除機能
	public void deleteArticle(int id) {
		Connection conn = null;

		String sql = "UPDATE blog_db.article SET delete_flag = '1' where id = ? ";

		try {
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			int result = ps.executeUpdate();
			System.out.println("記事が" + result + "件、削除されました。");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	//ログインユーザーの記事編集機能
	public void updateArticle(String title, String article, String category, Boolean status, int id) {
		Connection conn = null;

		String sql = "UPDATE blog_db.article SET title = ? , article = ? , category = ? , status = ? where id = ? ";

		try {
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, title);
			ps.setString(2, article);
			ps.setString(3, category);
			ps.setBoolean(4, status);
			ps.setInt(5, id);

			int result = ps.executeUpdate();
			System.out.println("記事が" + result + "件、編集されました。");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
