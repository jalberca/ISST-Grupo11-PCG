package es.upm.dit.isst.pcg.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.pcg.dao.ConversacionDAOImplementation;
import es.upm.dit.isst.pcg.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.pcg.model.Conversacion;
import es.upm.dit.isst.pcg.model.Usuario;

@WebServlet("/misChatsServlet")
public class misChatsServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Usuario user = (Usuario) req.getSession().getAttribute("user");
		List<Conversacion> conversaciones = ConversacionDAOImplementation.getInstance().readConversaciones();
		req.getSession().setAttribute("todasConversaciones", conversaciones);
		
		req.getSession().setAttribute("user", user);
		resp.sendRedirect(req.getContextPath()+"/MisChats.jsp");
		
		

	}
	
}
