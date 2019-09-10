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

@WebServlet("/getUsuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		
		Usuario user = new UsuarioBO().get(req.getParameter("cpf"));
		req.setAttribute("user", user);
		
		
		req.getRequestDispatcher("/usuario.jsp").forward(req,resp);
	}


}
