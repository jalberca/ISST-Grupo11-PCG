package es.upm.dit.isst.pcg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import es.upm.dit.isst.pcg.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.pcg.model.Usuario;


@WebServlet("/AdminUsuariosServlet")
public class AdminUsuariosServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Usuario> todosUsuarios  = UsuarioDAOImplementation.getInstance().readReportedUsers();
		req.getSession().setAttribute("usuarios", todosUsuarios);
		resp.sendRedirect(req.getContextPath()+ "/AdminUsuarios.jsp");
	}
}