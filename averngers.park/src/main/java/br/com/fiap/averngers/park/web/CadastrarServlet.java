package br.com.fiap.averngers.park.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.averngers.park.bo.UsuarioBO;

@WebServlet("/cadastro")
public class CadastrarServlet extends HttpServlet{

	
	private static final long serialVersionUID = 8514841450603379549L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		
		String nome = req.getParameter("nome_cad");
		String email = req.getParameter("email_cad");
		String cpf = req.getParameter("cpf_cad");
		String senha = req.getParameter("senha_cad");
		String confirma_senha_cad = req.getParameter("confirma_senha_cad");
		
		
		if(senha == confirma_senha_cad) {
			
			 RequestDispatcher rd = getServletContext().getRequestDispatcher("/cadastro.html");
	         PrintWriter out = resp.getWriter();
	         out.println("<font color=white>As senhas não coincidem, tente novamente.</font>");
	         rd.include(req, resp);
			
		}else {
			
			UsuarioBO bo = null;
			try {
				bo = new UsuarioBO();
								
				if (bo.cadastro(cpf, confirma_senha_cad, email, nome) ==1 ) {
					
					 PrintWriter out = resp.getWriter();
			         out.println("<font color=Green>Novo usuario cadastrado com sucesso.</font>");
					
				}
			} catch (Exception e) {

			}				 		
			
		}
		
		
	}
	
	
}
