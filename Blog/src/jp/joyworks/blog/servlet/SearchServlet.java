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
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String searchArticle = request.getParameter("Search");

		ArticleDAO articledao = new ArticleDAO();
		List<ArticleDTO> articledto = new ArrayList<ArticleDTO>();

		articledto = articledao.searchArticles(searchArticle);

		HttpSession session = request.getSession();
		session.setAttribute("SearchArticle", articledto);

		//JSPにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/SearchArticle.jsp");
		dispatcher.forward(request, response);
	}

}