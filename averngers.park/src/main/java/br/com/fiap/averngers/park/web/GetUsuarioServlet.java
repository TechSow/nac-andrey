package br.com.fiap.averngers.park.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.averngers.park.beans.Usuario;


@WebServlet(urlPatterns = "/usuario")
public class GetUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 5413315164496595276L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//UsuarioDAO dao = null;
		PrintWriter out = resp.getWriter();

		String cpf = req.getParameter("cpf");

		//dao = new UsuarioDAO();
		//Usuario usuario = dao.get(cpf);

		//req.setAttribute("usuario", usuario);

		// out.println(usuario.getNome());

		//dao.close();

		req.getRequestDispatcher("Usuario.jsp").forward(req, resp);

	}
}
