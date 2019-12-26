package jp.joyworks.blog.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.joyworks.blog.dao.ArticleDAO;
import jp.joyworks.blog.dto.ArticleDTO;

/**
 * Servlet implementation class ArticleServlet
 */
@WebServlet("/ArticleServlet")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ArticleServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String readarticleid = request.getParameter("ArticleID");
		int readid = Integer.parseInt(readarticleid);

		ArticleDAO articledao = new ArticleDAO();
		ArticleDTO articledto = new ArticleDTO();

		articledto = articledao.readArticle(readid);
		request.setAttribute("ReadArticle",articledto);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/Article.jsp");
		dispatcher.forward(request, response);
	}

}
