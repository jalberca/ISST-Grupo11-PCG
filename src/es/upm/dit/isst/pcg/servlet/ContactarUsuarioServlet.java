package es.upm.dit.isst.pcg.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.upm.dit.isst.pcg.dao.ConversacionDAOImplementation;
import es.upm.dit.isst.pcg.dao.PensamientoDAOImplementation;
import es.upm.dit.isst.pcg.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.pcg.model.Pensamiento;
import es.upm.dit.isst.pcg.model.Usuario;
import es.upm.dit.isst.pcg.model.Conversacion;

import java.util.List;

@WebServlet("/ContactarUsuarioServlet")
public class ContactarUsuarioServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		//String pensamientoId = req.getParameter("pensamientoId");
		int userId = Integer.parseInt(req.getParameter("pensamientoId"));
		
		String userToken = req.getParameter("userToken"); // Persona que quiere contactar
		
		Pensamiento pensamiento = PensamientoDAOImplementation.getInstance().readPensamiento(userId);
		
		List<Conversacion> todasConversaciones = ConversacionDAOImplementation.getInstance().readConversaciones();
		
		Usuario autor = pensamiento.getUser();
		
		Conversacion conversacion = new Conversacion();
		conversacion.setUser(autor);
		conversacion.setNombre(pensamiento.getText());
		conversacion.setToken(userToken);
		conversacion.setIdContactado(autor.getID());
		conversacion.setId(todasConversaciones.size() + 1);
		
		ConversacionDAOImplementation.getInstance().createConversacion(conversacion);
		
		req.getSession().setAttribute("user", user);
		
		
		HttpSession session = req.getSession();
		session.setAttribute("autorToken", autor.getToken());
		session.setAttribute("userToken", userToken);
		session.setAttribute("conversacionId", conversacion.getId());
		String s = "ChatServlet?conversacionId="+conversacion.getId()+"&tokenUser="+autor.getToken();
		session.setAttribute("cargaChat", s);
		resp.sendRedirect("ChatServlet?conversacionId="+conversacion.getId()+"&tokenUser="+autor.getToken());
		
	}

}