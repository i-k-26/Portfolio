package jp.joyworks.blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jp.joyworks.blog.dto.ArticleDTO;

public class ArticleDAO {

	private final String JDBC_URL = "jdbc:mysql://localhost:3306/sampledb?serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "admin";

	//ログインユーザーの記事作成機能　〇
	public void createArticle(String user_id, String user_name, String title, String article,
			Timestamp post_date, String category, Boolean status) {

		Connection conn = null;

		String sql = "INSERT INTO blog_db.article(user_id,user_name,title,article,category,post_date,status) "
				+ "VALUE(?,?,?,?,?,?,?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user_id);
			ps.setString(2, user_name);
			ps.setString(3, title);
			ps.setString(4, article);
			ps.setString(5, category);
			ps.setTimestamp(6, post_date);
			ps.setBoolean(7, status);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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

	//ログインユーザーの記事リスト作成機能 ○
	public List<ArticleDTO> getArticles(String user_id) {
		List<ArticleDTO> articledto = new ArrayList<ArticleDTO>();

		Connection conn = null;

		String sql = "SELECT id,title,category,post_date,status FROM blog_db.article where user_id=?"
				+ " and delete_flag is not true order by post_date desc";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				var record = new ArticleDTO();
				record.setId(rs.getInt("id"));
				record.setTitle(rs.getString("title"));
				record.setCategory(rs.getString("category"));
				record.setPost_date(rs.getTimestamp("post_date"));
				record.setStatus(rs.getBoolean("status"));
				articledto.add(record);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
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

	//ログインユーザーの編集記事選択　〇
	public ArticleDTO getArticle(int id) {
		ArticleDTO record = new ArticleDTO();

		Connection conn = null;

		String sql = "SELECT id,title,article,category FROM blog_db.article where id = ?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			//			ps.setString(2, title);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				//				var record = new ArticleDto();
				record.setId(rs.getInt("id"));
				record.setTitle(rs.getString("title"));
				record.setArticle(rs.getString("article"));
				record.setCategory(rs.getString("category"));
				//				record.setStatus(rs.getBoolean("status"));
				//				articledto.add(record);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
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
	public List<ArticleDTO> searchArticles(String searchword) {
		List<ArticleDTO> articledto = new ArrayList<ArticleDTO>();

		Connection conn = null;

		String sql = "SELECT id,title,post_date,category,user_name FROM blog_db.article where user_name like '%?%' or "
				+ "title like '%?%' AND status='1' order by post_date desc";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, searchword);
			ps.setString(2, searchword);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				var record = new ArticleDTO();
				record.setId(rs.getInt("id"));
				record.setTitle(rs.getString("title"));
				record.setCategory(rs.getString("category"));
				record.setPost_date(rs.getTimestamp("post_date"));
				record.setUser_name(rs.getString("user_name"));
				articledto.add(record);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
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

	//ログインユーザーの記事削除機能　〇
	public void deleteArticle(int id) {
		Connection conn = null;

		String sql = "UPDATE blog_db.article SET delete_flag = true where id = ? ";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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

	//ログインユーザーの記事編集機能　〇
	public void updateArticle(String title, String article, String category, Boolean status, int id) {
		Connection conn = null;

		String sql = "UPDATE blog_db.article SET title = ?,article = ?,category = ?,status = ? where id = ? ";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, title);
			ps.setString(2, article);
			ps.setString(3, category);
			ps.setBoolean(4, status);
			ps.setInt(5, id);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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

	//トップぺージの新着記事リスト作成機能 ○
		public List<ArticleDTO> recentlyArticles() {
			List<ArticleDTO> articledto = new ArrayList<ArticleDTO>();

			Connection conn = null;

			String sql = "SELECT id,title,category,post_date,user_name FROM blog_db.article where "
					+ "status is true and delete_flag is not true order by post_date desc";

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

				PreparedStatement ps = conn.prepareStatement(sql);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					var record = new ArticleDTO();
					record.setId(rs.getInt("id"));
					record.setTitle(rs.getString("title"));
					record.setCategory(rs.getString("category"));
					record.setPost_date(rs.getTimestamp("post_date"));
					record.setUser_name(rs.getString("user_name"));
					articledto.add(record);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} catch (ClassNotFoundException e) {
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

		//一般ユーザーの記事選択機能　〇
		public ArticleDTO readArticle(int id) {
			ArticleDTO record = new ArticleDTO();

			Connection conn = null;

			String sql = "SELECT title,article,category,post_date,user_name FROM blog_db.article where id = ?";

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setInt(1, id);
				//			ps.setString(2, title);

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					record.setTitle(rs.getString("title"));
					record.setArticle(rs.getString("article"));
					record.setCategory(rs.getString("category"));
					record.setPost_date(rs.getTimestamp("post_date"));
					record.setUser_name(rs.getString("user_name"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} catch (ClassNotFoundException e) {
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

}
