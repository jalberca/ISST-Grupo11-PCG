package es.upm.dit.isst.pcg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.pcg.dao.PensamientoDAOImplementation;
import es.upm.dit.isst.pcg.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.pcg.model.Pensamiento;
import es.upm.dit.isst.pcg.model.Usuario;

@WebServlet("/LoginOAuth")
public class LoginOAuth extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String token = req.getParameter("token");
		
		Usuario user = UsuarioDAOImplementation.getInstance().loginUser(email, token);
		if(null != user) {
		//se podria hacer un if para ver si es un administrador
		req.getSession().setAttribute("user", user);
		//req.getSession().setAttribute(arg0, arg1);
		
		resp.sendRedirect(req.getContextPath() + "/MisPensamientos.jsp");
		} else {
			
			List<Usuario> todosUsuarios = UsuarioDAOImplementation.getInstance().readAllUsers();
			
			user = new Usuario();
			user.setEmail(email);
			user.setToken(token);
			user.setTypeUser("user");
			user.setID(todosUsuarios.size()+1);
			UsuarioDAOImplementation.getInstance().createUsuario(user);
			
			req.getSession().setAttribute("user", user);
			resp.sendRedirect(req.getContextPath() + "/MisPensamientos.jsp");
			
		}
		
	}

}
