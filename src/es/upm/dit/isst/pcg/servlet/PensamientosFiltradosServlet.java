package es.upm.dit.isst.pcg.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.pcg.dao.PensamientoDAOImplementation;
import es.upm.dit.isst.pcg.model.Pensamiento;
import es.upm.dit.isst.pcg.model.PensamientoDist;
import es.upm.dit.isst.pcg.model.Usuario;

@WebServlet("/PensamientosFiltradosServlet")
public class PensamientosFiltradosServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		float radio = Float.parseFloat(req.getParameter("radio"));
		float latitud = Float.parseFloat(req.getParameter("latitud"));
		float longitud = Float.parseFloat(req.getParameter("longitud"));
		
		List<PensamientoDist> todosPensamientos  = PensamientoDAOImplementation.getInstance().readPensamientosPositionRadio(radio,latitud,longitud);
		PensamientoDist pensamiento = new PensamientoDist();
		pensamiento.setPensamientosFiltrados(todosPensamientos);
		
		req.getSession().setAttribute("pensamientos", todosPensamientos);
		resp.sendRedirect(req.getContextPath()+ "/PensamientosFiltrados.jsp");
	}
	
}