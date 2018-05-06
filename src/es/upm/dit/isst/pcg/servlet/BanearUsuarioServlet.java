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
import es.upm.dit.isst.pcg.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.pcg.model.Comentario;
import es.upm.dit.isst.pcg.model.Pensamiento;
import es.upm.dit.isst.pcg.model.Usuario;


@WebServlet("/BanearUsuarioServlet")
public class BanearUsuarioServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id1 = req.getParameter("id");
		int id = Integer.parseInt(id1);
		System.out.println(id);
		Usuario user = UsuarioDAOImplementation.getInstance().readUsuario(id);
		System.out.println("usuario: "+user);
		List<Pensamiento> borrar = PensamientoDAOImplementation.getInstance().readPensamientosUsuario(user);
		System.out.println("ey1"+borrar);
		borrarPensamientos(borrar);
		UsuarioDAOImplementation.getInstance().deleteUsuario(user);
		
		List<Usuario> todosUsuarios  = UsuarioDAOImplementation.getInstance().readReportedUsers();
		
		req.getSession().setAttribute("usuarios", todosUsuarios);
		
		resp.sendRedirect(req.getContextPath()+ "/AdminUsuarios.jsp");
	}
	
	private void borrarPensamientos(List<Pensamiento> todosPensamientos) {
		System.out.println("ey2");
		for(int i=0; i<todosPensamientos.size(); i++) {
			System.out.println("ey3"+todosPensamientos.get(i));
			PensamientoDAOImplementation.getInstance().deletePensamiento(todosPensamientos.get(i));
		}
	}
}