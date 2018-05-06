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
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		String cargar = req.getParameter("cargar");
		Pensamiento pensamiento = PensamientoDAOImplementation.getInstance().readPensamiento(pensamientoID);
		Usuario user1 = pensamiento.getUser();
		int usuarioID = user1.getID();
		
		if(user.getReported() == null || user.getLiked().equals(null)) {
			user.addReported(usuarioID);
			
			UsuarioDAOImplementation.getInstance().updateUsuario(user);
			user1.reportsUP();
			UsuarioDAOImplementation.getInstance().updateUsuario(user1);
		} else {
			int noEsta=99;
			for(int i=0; i<user.getReported().length; i++) {
				if(user.getReported()[i].equals(usuarioID)) {
					noEsta = 0;
					continue;
				}
				else {
					noEsta = 1;
				}
			}
			
			if(noEsta==(1)) {
				
				user.addReported(usuarioID);
				
				UsuarioDAOImplementation.getInstance().updateUsuario(user);
				user1.reportsUP();
				UsuarioDAOImplementation.getInstance().updateUsuario(user1);
			}
		}
		
		req.getSession().setAttribute("cargar", cargar);
		
		resp.sendRedirect(req.getContextPath()+cargar);
		
	}

}