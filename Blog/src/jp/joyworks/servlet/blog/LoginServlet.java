package jp.joyworks.servlet.blog;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.joyworks.dao.blog.UserDAO;
import jp.joyworks.dto.blog.UserDTO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("User_ID");
		String pass = request.getParameter("PASS");

		UserDTO userdto = new UserDTO();
		UserDAO userdao = new UserDAO();

		userdto = userdao.login(id, pass);

//		ログイン認証処理
//		boolean isLogin = (pass.equals("admin"));

		//ログイン成功時の処理
		if (pass.equals(userdto.getPass())) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", userdto);

			//MyPageに遷移
			RequestDispatcher dispatcher = request.getRequestDispatcher("/MyPage.jsp");
			dispatcher.forward(request, response);
		}
		//失敗時の処理
		else {
			request.setAttribute("errorMsg","入力情報に誤りがあります。");

			//エラーメッセージをsetしてLogin画面に戻る
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
			dispatcher.forward(request, response);

		}

//		//ログイン結果画面にフォワード
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/MyPage.jsp");
//		dispatcher.forward(request, response);

	}

}
