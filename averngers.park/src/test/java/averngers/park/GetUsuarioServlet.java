package averngers.park;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.averngers.park.beans.Usuario;
import br.com.fiap.averngers.park.dao.UsuarioDAO;

@WebServlet(urlPatterns="/GetUsuarioServlet")
public class GetUsuarioServlet extends HttpServlet {


	private static final long serialVersionUID = 5413315164496595276L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UsuarioDAO dao = null;
		PrintWriter out = resp.getWriter();

		try {
			String cpf = req.getParameter("cpf");

			dao = new UsuarioDAO();
			Usuario usuario = dao.get("13");
			
			req.setAttribute("usuario", usuario);
			
			out.println(usuario.getNome());
			RequestDispatcher rd = req.getRequestDispatcher("Usuario.jsp");
			rd.forward(req, resp);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}



	}
}
