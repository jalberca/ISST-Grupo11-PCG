package es.upm.dit.isst.pcg.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

@WebServlet("/PensamientosFiltradosServlet")
public class PensamientosFiltradosServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String r = req.getParameter("radio");
		String lat = req.getParameter("latitud");
		String lon = req.getParameter("longitud");
		String cp = req.getParameter("cp");
		if(r=="" || lat=="" || lon=="") {
				resp.sendRedirect(req.getContextPath()+ "/PensamientosFiltrados.jsp");
		} else {
			float radio = Float.parseFloat(r);
			float latitud = Float.parseFloat(lat);
			float longitud = Float.parseFloat(lon);
			
			List<Pensamiento> todosPensamientos  = PensamientoDAOImplementation.getInstance().readPensamientos();
			
			List<Pensamiento> pensamientosElegidos = pensamientosFiltrados(todosPensamientos, latitud, longitud, radio);
	
			
			req.getSession().setAttribute("pensamientos", pensamientosElegidos);
		
			String cargar="/PensamientosFiltradosServlet?latitud="+latitud+"&longitud="+longitud+"&CP="+cp+"&radio="+r;
			req.getSession().setAttribute("cargar", cargar);
			resp.sendRedirect(req.getContextPath()+ "/PensamientosFiltrados.jsp");
		}
	}
	
	private List<Pensamiento> pensamientosFiltrados(List<Pensamiento> todosPensamientos, float latUser, float longUser, float radio) {
		List<Pensamiento> pensamientosFILTRAICOS = new ArrayList<Pensamiento>();
		
		for(int i=0; i<todosPensamientos.size(); i++) {
			double latPensamiento = todosPensamientos.get(i).getLatitud();
			double longPensamiento = todosPensamientos.get(i).getLongitud();
			double distanciaEntrePensamientos = distanciaCoord(latUser, longUser, latPensamiento, longPensamiento);
			System.out.println(distanciaEntrePensamientos);
			if(distanciaEntrePensamientos <= radio) {
				pensamientosFILTRAICOS.add(todosPensamientos.get(i));
			}
			
		}
		
		return pensamientosFILTRAICOS;
	}
	
	private static double distanciaCoord(double lat1, double lon1, double lat2, double lon2) {  
        
		 final int R = 6371; // Radius of the earth

		    double latDistance = Math.toRadians(lat2 - lat1);
		    double lonDistance = Math.toRadians(lon2 - lon1);
		    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
		            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
		            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		    double distance = R * c * 1000; // convert to meters


		    return distance;
    }
	
}