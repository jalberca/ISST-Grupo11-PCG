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
		String email = req.getParameter("correo");
		Usuario user = UsuarioDAOImplementation.getInstance().readUsuario(email);
		
		UsuarioDAOImplementation.getInstance().deleteUsuario(user);
		
		List<Usuario> todosUsuarios  = UsuarioDAOImplementation.getInstance().readReportedUsers();
		req.getSession().setAttribute("usuarios", todosUsuarios);
		
		resp.sendRedirect(req.getContextPath()+ "/AdminUsuarios.jsp");
	}
}