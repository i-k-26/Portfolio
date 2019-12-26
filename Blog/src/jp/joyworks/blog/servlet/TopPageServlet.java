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

/**
 * Servlet implementation class TopPageServlet
 */
@WebServlet("/TopPageServlet")
public class TopPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TopPageServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		ArticleDAO articledao = new ArticleDAO();
		List<ArticleDTO> articledto = new ArrayList<ArticleDTO>();

		articledto = articledao.recentlyArticles();

		HttpSession session = request.getSession();
		session.setAttribute("recentlyArticles", articledto);

		//JSPにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/TopPage.jsp");
		dispatcher.forward(request, response);;

	}

}
