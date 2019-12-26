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
 * Servlet implementation class DeleteArticleServlet
 */
@WebServlet("/DeleteArticleServlet")
public class DeleteArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteArticleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String deleteflg = request.getParameter("deleteFlg");


		if (deleteflg != null) {
			HttpSession session = request.getSession();
			String deletearticleid = (String) session.getAttribute("deleteArticleId");
			int deleteArtID = Integer.parseInt(deletearticleid);

			ArticleDAO articledao = new ArticleDAO();

			//指定された記事を記事IDから検索して削除
			articledao.deleteArticle(deleteArtID);

			//UserArticleListに削除結果を反映してそのページに戻るための処理
			UserDTO loginuser = (UserDTO)session.getAttribute("loginUser");

			String userId = loginuser.getId();
			List<ArticleDTO> articledto = new ArrayList<ArticleDTO>();

			//最新の状態へセッションスコープを上書き
			articledto = articledao.getArticles(userId);
			session.setAttribute("articleList", articledto);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/UserArticleList.jsp");
			dispatcher.forward(request, response);

//			ArticleDTO articledto = new ArticleDTO();
//			boolean bool = Boolean.valueOf(deleteflg);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/UserArticleList.jsp");
			dispatcher.forward(request, response);
		}
	}

}
