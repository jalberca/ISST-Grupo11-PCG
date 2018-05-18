package es.upm.dit.isst.pcg.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.upm.dit.isst.pcg.dao.PensamientoDAOImplementation;
import es.upm.dit.isst.pcg.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.pcg.model.Pensamiento;
import es.upm.dit.isst.pcg.model.Usuario;

@WebServlet("/ChatServlet")
@WebInitParam(name = "sala", value = "")
public class ChatServlet extends HttpServlet{
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String msg = req.getParameter("msg");
		String sala = (String) getServletContext().getAttribute("sala");
		if ( sala == null) {
			sala = "";
		}
		
		if ((msg != null) && (msg.trim().length() > 0)) {
			HttpSession session = req.getSession();
			String autorToken = (String) session.getAttribute("autorToken");
			String userToken = (String) session.getAttribute("userToken");
			
			sala += "<span>" + userToken + "</span>" + ": " + msg + "<br/>";
			
		}
		
		getServletContext().setAttribute("sala", sala);
		resp.sendRedirect(req.getContextPath() + "/Chat.jsp");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
}