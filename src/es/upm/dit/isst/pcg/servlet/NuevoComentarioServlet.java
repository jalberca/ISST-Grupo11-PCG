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

import es.upm.dit.isst.pcg.dao.ComentarioDAOImplementation;
import es.upm.dit.isst.pcg.dao.PensamientoDAOImplementation;
import es.upm.dit.isst.pcg.model.Comentario;
import es.upm.dit.isst.pcg.model.Pensamiento;
import es.upm.dit.isst.pcg.model.Usuario;

@WebServlet("/NuevoComentarioServlet")
public class NuevoComentarioServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		Usuario pensamiento = (Usuario) req.getSession().getAttribute("pensamiento");
		String text = req.getParameter("text");
		String statusView = req.getParameter("view");
		
/*		System.out.print("Hola:"+statusLoc);
		if(statusLoc == "1" || statusLoc == "2" || statusLoc == "") {
			resp.sendRedirect(req.getContextPath()+ "/LoginOAuth?email="+user.getEmail()+"&token="+user.getToken());
		} else if (statusLoc != "") {
*/
			
			String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			
			Comentario comentario = new Comentario();
			comentario.setPensamientoId(pensamiento.getID());
			comentario.setText(text);
			comentario.setDate(date);
			
			ComentarioDAOImplementation.getInstance().createComentario(comentario);
		
			req.getSession().setAttribute("user", user);
			// Aquí tengo que hacer que según un atributo redirección a un lugar o a otro
			// Según si estoy en MisPensamientos o en PensamientosFiltrados
			// si estoy en MisPensamientos:
			// resp.sendRedirect(req.getContextPath()+ "/LoginOAuth?email="+user.getEmail()+"&token="+user.getToken());
			// y si estoy en PensamientosFiltrados????? porque se me tiene que cargar el nuevo...
			// resp.sendRedirect(req.getContextPath()+ "/PensamientosFiltrados;
			if(statusView == "misPensamientos" ) {
				resp.sendRedirect(req.getContextPath()+ "/LoginOAuth?email="+user.getEmail()+"&token="+user.getToken());
			} else if (statusView == "pensamientosFiltrados") {
				resp.sendRedirect(req.getContextPath() + "/PensamientosFiltrados");
		}
	}
	
}
