package es.upm.dit.isst.pcg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.realm.UserDatabaseRealm;

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
		String admin = "2javier.alberca27@gmail.com";
		
		Usuario user = UsuarioDAOImplementation.getInstance().loginUser(email, token);
		if(null != user) {
			
			req.getSession().setAttribute("user", user);
			
			if(user.getTypeUser().equals("admian")) {
				resp.sendRedirect(req.getContextPath() + "/VistaAdmin.jsp");
			}else {
				resp.sendRedirect(req.getContextPath() + "/MisPensamientos.jsp");
			}
		} else {
			
			List<Usuario> todosUsuarios = UsuarioDAOImplementation.getInstance().readAllUsers();
			
			user = new Usuario();
			user.setEmail(email);
			System.out.println(user.getEmail());
			user.setToken(token);
			
			user.setID(todosUsuarios.size()+1);
			if(user.getEmail().equals(admin)) {
				user.setTypeUser("admin");
			} else {
				user.setTypeUser("user");
			}
			System.out.println(user.getTypeUser());
			UsuarioDAOImplementation.getInstance().createUsuario(user);
			UsuarioDAOImplementation.getInstance().updateUsuario(user);
			
			req.getSession().setAttribute("user", user);
			if(user.getTypeUser().equals("admin")) {
				resp.sendRedirect(req.getContextPath() + "/VistaAdmin.jsp");
			}else {
				resp.sendRedirect(req.getContextPath() + "/MisPensamientos.jsp");
			}
			
		}
		
	}

}
