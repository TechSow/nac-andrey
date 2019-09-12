package br.com.fiap.averngers.park.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.averngers.park.beans.Usuario;
import br.com.fiap.averngers.park.bo.UsuarioBO;
import oracle.jdbc.OracleDriver;
/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/getUsuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		Usuario user = null; 
		try {
			user = new UsuarioBO().get(request.getParameter("cpf"));			
		}catch(Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("user", user);
			
		
		request.getRequestDispatcher("/usuario.jsp").forward(request,response);
	}


}
