package br.com.fiap.averngers.park.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.averngers.park.dao.UsuarioDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = -3818762630165473708L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
		
		String email = req.getParameter("email");
		String senha = req.getParameter("senha_login");
		
		UsuarioDAO dao = null;
		
		try {
			dao = new UsuarioDAO();
			if(dao.login(email, senha) == 1 ) {
				
				
				
				
			}
			
			
		} catch (Exception e) {


		}
		
		
		
	}
}
