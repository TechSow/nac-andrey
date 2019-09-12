package br.com.fiap.averngers.park.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.averngers.park.bo.ProprietarioBO;
import br.com.fiap.averngers.park.bo.UsuarioBO;
import br.com.fiap.averngers.park.bo.VeiculoBO;

@WebServlet("/CadastrarVeiculo")
public class CadastrarVeiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");

		String marca = req.getParameter("marca_cad");
		String placa = req.getParameter("placa_cad");
		String cpf = req.getParameter("cpf_cad");
		String email = req.getParameter("email_cad");
		String nome = req.getParameter("nome_cad");


		
		VeiculoBO bo = null;
		ProprietarioBO propBO = null;
		try {
			
			
			propBO.add(cpf, nome, email);
			
			bo = new VeiculoBO();
			String resultado = bo.add(placa, marca, cpf);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/veiculo.html");
			PrintWriter out = resp.getWriter();
	        out.println("<font color=white>" + resultado +"</font>");
	        rd.include(req, resp);
			
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		
	}

}
