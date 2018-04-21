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
import es.upm.dit.isst.pcg.model.Usuario;

@WebServlet("/NuevoPensamientoServlet")
public class NuevoPensamientoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		String text = req.getParameter("text");
		String statusLoc = req.getParameter("status");
		float latitud = Float.parseFloat(req.getParameter("latitud"));
		float longitud = Float.parseFloat(req.getParameter("longitud"));
		
		if(statusLoc == "1" || statusLoc == "2") {
			return;
		}
		
		List<Pensamiento> todosPensamientos = PensamientoDAOImplementation.getInstance().readPensamientos();
		

		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		
		Pensamiento pensamiento = new Pensamiento();
		pensamiento.setDate(date);
		pensamiento.setId(todosPensamientos.size()+1);
		pensamiento.setLatitud(latitud);
		pensamiento.setLongitud(longitud);
		pensamiento.setText(text);
		pensamiento.setUser(user);
		
		PensamientoDAOImplementation.getInstance().createPensamiento(pensamiento);
		resp.sendRedirect(req.getContextPath()+ "/MisPensamientos.jsp");
	}
	
}
