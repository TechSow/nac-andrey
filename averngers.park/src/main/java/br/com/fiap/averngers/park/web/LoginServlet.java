package br.com.fiap.averngers.park.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.averngers.park.bo.UsuarioBO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = -3818762630165473708L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		
		
		 String email = req.getParameter("email"); 
		 String senha = req.getParameter("senha_login");
		 

		
		UsuarioBO bo = null;
		
		try {

			bo = new UsuarioBO();
			if(bo.login(email, senha) == 1 ) {
				
				//Pega a session da req e invalida ela
				HttpSession oldSession = req.getSession(false);
	            if (oldSession != null) {
	                oldSession.invalidate();
	            }
	            //Cria nova sessao
	            HttpSession newSession = req.getSession(true);

	            //Cria um limite de tempo para a sessao
	            newSession.setMaxInactiveInterval(1*60);
	            String validado = "sim";
	            newSession.setAttribute("validado", validado);

				/*
				 * Cookie message = new Cookie("message", "Welcome");
				 * resp.addCookie(message);
				 */
	            
	            
	            
	            resp.sendRedirect("principal.jsp");
	        } else {
	            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.html");
	            PrintWriter out = resp.getWriter();
	            out.println("<font color=white>Usuario ou senha errado. Tente novamente.</font>");
	            rd.include(req, resp);
	        }
						
		} catch (Exception e) {


		}
		
		
		
	}
}
