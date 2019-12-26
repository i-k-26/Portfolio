package jp.joyworks.blog.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeletePreparationServlet
 */
@WebServlet("/DeletePreparationServlet")
public class DeletePreparationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePreparationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String deletearticletitle = request.getParameter("deleteTitle");
		String deletearticleid = request.getParameter("deleteArticleID");

		HttpSession session = request.getSession();
		session.setAttribute("deleteArticleTitle",deletearticletitle);
		session.setAttribute("deleteArticleId", deletearticleid);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/DeleteArticle.jsp");
		dispatcher.forward(request, response);

	}

}