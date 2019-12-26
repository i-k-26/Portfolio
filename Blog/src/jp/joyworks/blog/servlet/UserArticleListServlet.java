package jp.joyworks.blog.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.joyworks.blog.dao.ArticleDAO;
import jp.joyworks.blog.dto.ArticleDTO;
import jp.joyworks.blog.dto.UserDTO;

/**
 * Servlet implementation class UserArticlesServlet
 */
@WebServlet("/UserArticleListServlet")
public class UserArticleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserArticleListServlet() {
		super();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserDTO loginuser = (UserDTO)session.getAttribute("loginUser");

		if(loginuser != null) {
			String userId = loginuser.getId();
			ArticleDAO articledao = new ArticleDAO();
			List<ArticleDTO> articledto = new ArrayList<ArticleDTO>();

			articledto = articledao.getArticles(userId);
			session.setAttribute("articleList", articledto);

			//過去記事一覧に遷移
			RequestDispatcher dispatcher = request.getRequestDispatcher("/UserArticleList.jsp");
			dispatcher.forward(request, response);
		}else {

		//JSPにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/UserArticleList.jsp");
		dispatcher.forward(request, response);
		}

	}
}