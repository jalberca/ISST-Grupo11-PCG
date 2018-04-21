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

@WebServlet("/CreateUserServlet")
public class CreateUserServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String token = req.getParameter("token");
		
		List<Usuario> todosUsuarios = UsuarioDAOImplementation.getInstance().readAllUsers();
		
		Usuario user = new Usuario();
		user.setEmail(email);
		user.setToken(token);
		user.setTypeUser("user");
		user.setID(todosUsuarios.size()+1);
		UsuarioDAOImplementation.getInstance().createUsuario(user);
		
		resp.sendRedirect(req.getContextPath() +"/LoginInicial.jsp");
	}

}
