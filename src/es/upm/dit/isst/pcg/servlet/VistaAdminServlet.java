package es.upm.dit.isst.pcg.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.pcg.dao.ComentarioDAOImplementation;
import es.upm.dit.isst.pcg.dao.PensamientoDAOImplementation;
import es.upm.dit.isst.pcg.model.Comentario;
import es.upm.dit.isst.pcg.model.Pensamiento;


@WebServlet("/VistaAdminServlet")
public class VistaAdminServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Pensamiento> todosPensamientos  = PensamientoDAOImplementation.getInstance().readPensamientos();
		System.out.println(todosPensamientos);
		req.getSession().setAttribute("pensamientos", todosPensamientos);
		
		resp.sendRedirect(req.getContextPath()+ "/VistaAdmin.jsp");
	}
}






