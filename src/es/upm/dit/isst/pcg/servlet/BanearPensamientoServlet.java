package es.upm.dit.isst.pcg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.pcg.dao.PensamientoDAOImplementation;
import es.upm.dit.isst.pcg.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.pcg.model.Pensamiento;
import es.upm.dit.isst.pcg.model.Usuario;


@WebServlet("/BanearPensamientoServlet")
public class BanearPensamientoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id1 = req.getParameter("id");
		int id = Integer.parseInt(id1);
		Pensamiento pens = PensamientoDAOImplementation.getInstance().readPensamiento(id);
		PensamientoDAOImplementation.getInstance().deletePensamiento(pens);
		List<Pensamiento> todosPensamientos  = PensamientoDAOImplementation.getInstance().readPensamientosPorVotos();
		req.getSession().setAttribute("pensamientos", todosPensamientos);
		resp.sendRedirect(req.getContextPath()+ "/VistaAdmin.jsp");
	}
}









