package jp.joyworks.servlet.blog;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CompleteArticleServlet
 */
@WebServlet("/CompleteArticleServlet")
public class CompleteArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompleteArticleServlet() {
        super();
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("Title");
		String category = request.getParameter("Category");
		String article = request.getParameter("Article");
		String status = request.getParameter("Status");
		String create = request.getParameter("Create");
		String edit = request.getParameter("Edit");

		request.setAttribute("create", create);
		request.setAttribute("edit", edit);

//		String Msg = "";
//		if (create != null && edit == null) {
//			Msg += "記事の投稿が完了しました。<br>";
//		}else if (create == null && edit != null) {
//			Msg += "記事の編集が完了しました。<br>";
//		} else {
//			Msg += "内容が不正です。<br>";
//		}

		//ログイン結果画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/CompleteArticle.jsp");
		dispatcher.forward(request, response);


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