package es.upm.dit.isst.pcg.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.pcg.dao.PensamientoDAOImplementation;
import es.upm.dit.isst.pcg.model.Pensamiento;
import es.upm.dit.isst.pcg.model.Usuario;

@WebServlet("/NuevoPensamientoServlet")
public class NuevoPensamientoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		String text = req.getParameter("text");

		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		
		Pensamiento pensamiento = new Pensamiento();
		pensamiento.setDate(date);
		pensamiento.setId(5);
		pensamiento.setLatitud(40.4893538);
		pensamiento.setLongitud(-3.6827461);
		pensamiento.setText(text);
		pensamiento.setUser(user);
		
		PensamientoDAOImplementation.getInstance().createPensamiento(pensamiento);
		resp.sendRedirect(req.getContextPath()+ "/MisPensamientos.jsp");
	}
	
}
