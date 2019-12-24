package jp.joyworks.servlet.blog;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserArticlesServlet
 */
@WebServlet("/UserArticlesServlet")
public class UserArticlesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserArticlesServlet() {
		super();
	}

//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		//JSPにフォワード
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/UserArticleList.jsp");
//		dispatcher.forward(request, response);
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//JSPにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/UserArticleList.jsp");
		dispatcher.forward(request, response);
	}

}
