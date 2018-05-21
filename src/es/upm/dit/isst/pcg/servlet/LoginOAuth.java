package es.upm.dit.isst.pcg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.realm.UserDatabaseRealm;

import es.upm.dit.isst.pcg.dao.ComentarioDAOImplementation;
import es.upm.dit.isst.pcg.dao.ConversacionDAOImplementation;
import es.upm.dit.isst.pcg.dao.PensamientoDAOImplementation;
import es.upm.dit.isst.pcg.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.pcg.model.Pensamiento;
import es.upm.dit.isst.pcg.model.Usuario;
import es.upm.dit.isst.pcg.model.Conversacion;

@WebServlet("/LoginOAuth")
public class LoginOAuth extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String token = req.getParameter("token");
		String admin = "nachovv96@gmail.com";
		
		List<Conversacion> conversaciones = ConversacionDAOImplementation.getInstance().readConversaciones();
		req.getSession().setAttribute("todasConversaciones", conversaciones);
		
		Usuario user = UsuarioDAOImplementation.getInstance().loginUser(email, token);
		if(null != user) {			
			req.getSession().setAttribute("user", user);
			if(user.getTypeUser().equals("admin")) {
				List<Pensamiento> todosPensamientos  = PensamientoDAOImplementation.getInstance().readPensamientosPorVotos();
				req.getSession().setAttribute("pensamientos", todosPensamientos);
				List<Usuario> usuarios = UsuarioDAOImplementation.getInstance().readReportedUsers();
				req.getSession().setAttribute("usuarios", usuarios);
				resp.sendRedirect(req.getContextPath() + "/VistaAdmin.jsp");
			}else {
				String s = "LoginOAuth?email="+user.getEmail()+"&token="+user.getToken();
				req.getSession().setAttribute("cargaMisP", s);
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
				List<Pensamiento> todosPensamientos  = PensamientoDAOImplementation.getInstance().readPensamientosPorVotos();
				req.getSession().setAttribute("pensamientos", todosPensamientos);
				List<Usuario> usuarios = UsuarioDAOImplementation.getInstance().readReportedUsers();
				req.getSession().setAttribute("usuarios", usuarios);
				resp.sendRedirect(req.getContextPath() + "/VistaAdmin.jsp");
			}else {
				String s = "LoginOAuth?email="+user.getEmail()+"&token="+user.getToken();
				req.getSession().setAttribute("cargaMisP", s);
				resp.sendRedirect(req.getContextPath() + "/MisPensamientos.jsp");
			}
			
		}
		
	}

}
 