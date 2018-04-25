package es.upm.dit.isst.pcg.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.pcg.dao.PensamientoDAOImplementation;
import es.upm.dit.isst.pcg.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.pcg.model.Pensamiento;
import es.upm.dit.isst.pcg.model.Usuario;

@WebServlet("/ReportarServlet")
public class ReportarServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int pensamientoID = Integer.parseInt(req.getParameter("pensamientoID"));
		String cargar = req.getParameter("cargar");
		
		Pensamiento pensamiento = PensamientoDAOImplementation.getInstance().readPensamiento(pensamientoID);
		Usuario user = pensamiento.getUser();
		user.reportsUP();
		UsuarioDAOImplementation.getInstance().updateUsuario(user);
		
		
		req.getSession().setAttribute("cargar", cargar);
		
		resp.sendRedirect(req.getContextPath()+cargar);
		
	}

}