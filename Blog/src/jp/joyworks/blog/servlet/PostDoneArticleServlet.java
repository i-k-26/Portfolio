package jp.joyworks.blog.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.joyworks.blog.dao.ArticleDAO;
import jp.joyworks.blog.dto.UserDTO;

/**
 * Servlet implementation class CompleteArticleServlet
 */
@WebServlet("/PostDoneArticleServlet")
public class PostDoneArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostDoneArticleServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//パラメータの取得
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("Title");
		String category = request.getParameter("Category");
		String article = request.getParameter("Article");

		//公開設定をboolean型に変換
		String status = request.getParameter("Status");
		if(status.equals("1")) {
			status = "true";
		}else {
			status = "false";
		}
		boolean bool = Boolean.valueOf(status);

		//投稿・編集の判定用
		String create = request.getParameter("Create");

		String edit = request.getParameter("Edit");
		String editarticleid = request.getParameter("ArticleID");

		//ユーザー情報の取得
		HttpSession session = request.getSession();
		UserDTO loginuser = (UserDTO) session.getAttribute("loginUser");

		//ifで新記事投稿と編集を分岐
		if (create != null && edit == null && loginuser != null) {
			request.setAttribute("create", create);

			String userid = loginuser.getId();
			String username = loginuser.getName();

			//投稿日時を取得
			Date date = new Date();
			long nowthetime = date.getTime();
			Timestamp postdate = new Timestamp(nowthetime);

			ArticleDAO articledao = new ArticleDAO();
			articledao.createArticle(userid, username, title, article, postdate, category, bool);

		} else if (edit != null && create == null && loginuser != null) {
			request.setAttribute("edit", edit);

			int editartid = Integer.parseInt(editarticleid);

			ArticleDAO articledao = new ArticleDAO();
			articledao.updateArticle(title, article, category, bool,editartid);

		} else {
			String Msg = null;
			Msg += "セッション内容が不明です。";
			request.setAttribute("error", Msg);
		}

		//結果画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/PostDone.jsp");
		dispatcher.forward(request, response);

		//		String Msg = "";
		//		if (create != null && edit == null) {
		//			Msg += "記事の投稿が完了しました。<br>";
		//		}else if (create == null && edit != null) {
		//			Msg += "記事の編集が完了しました。<br>";
		//		} else {
		//			Msg += "内容が不正です。<br>";
		//		}
		//		response.setContentType("text/html; charset = UTF-8");
		//		PrintWriter out = response.getWriter();
		//		out.println("<!DOCTYPE html>");
		//		out.println("<html>");
		//		out.println("<head>");
		//		out.println("<meta charset = \"UTF-8\">");
		//		out.println("<title>作業完了</title>");
		//		out.println("</head>");
		//		out.println("<body>");
		//		out.println("<P>" + Msg + "</P>");
		//		out.println("<P><a href=/Blog/MyPage.jsp>マイページ</a>へ</P>");
		//		out.println("<br>");
		//		out.println("<P>TOPは<a href=/Blog/TopPage.jsp>こちら</a></P>");
		//		out.println("</body>");
		//		out.println("</html>");
	}

}