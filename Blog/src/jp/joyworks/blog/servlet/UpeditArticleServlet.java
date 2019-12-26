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
 * Servlet implementation class UpeditArticleServlet
 */
@WebServlet("/UpeditArticleServlet")
public class UpeditArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpeditArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		String editarticletitle = request.getParameter("editTitle");
		String editarticleid = request.getParameter("editArticleID");

		int editArtID = Integer.parseInt(editarticleid);

		ArticleDAO articledao = new ArticleDAO();
		ArticleDTO articledto = new ArticleDTO();

		articledto = articledao.getArticle(editArtID);
		request.setAttribute("articleLog",articledto);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/UpeditArticle.jsp");
		dispatcher.forward(request, response);
	}
}
