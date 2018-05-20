package es.upm.dit.isst.pcg.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.List;

import es.upm.dit.isst.pcg.dao.MensajeChatDAOImplementation;
import es.upm.dit.isst.pcg.dao.PensamientoDAOImplementation;
import es.upm.dit.isst.pcg.dao.UsuarioDAOImplementation;

import es.upm.dit.isst.pcg.model.Pensamiento;
import es.upm.dit.isst.pcg.model.Usuario;
import es.upm.dit.isst.pcg.model.MensajeChat;

@WebServlet("/ChatServlet")
@WebInitParam(name = "sala", value = "")
public class ChatServlet extends HttpServlet{
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		String msg = req.getParameter("msg");
		String sala = (String) getServletContext().getAttribute("sala");
		
		
		HttpSession session = req.getSession();
		String autorToken = (String) req.getParameter("autorToken");
		String userToken = (String) req.getParameter("userToken");
		int conversacionId;
		if(req.getParameter("conversacionId")==null) {
			conversacionId = (int) (req.getSession().getAttribute("conversacionId"));
		} else {
			conversacionId = Integer.parseInt(req.getParameter("conversacionId"));
		}
		
		
		List<MensajeChat> todosMensajes = MensajeChatDAOImplementation.getInstance().readMensajes();
		
		if ( sala == null) {
			sala = "";
		}
		
		if ((msg != null) && (msg.trim().length() > 0)) {
			
			
			// Fecha y hora de publicacion del mensaje
			String date = new SimpleDateFormat("dd/MM/yy - HH:mm").format(new Date());
			
			MensajeChat mensaje = new MensajeChat();
			mensaje.setConversacionId(conversacionId);
			mensaje.setToken(userToken);
			mensaje.setDate(date);
			mensaje.setText(msg);
			mensaje.setId(todosMensajes.size() + 1);
			
			MensajeChatDAOImplementation.getInstance().createMensaje(mensaje);
			
			todosMensajes = MensajeChatDAOImplementation.getInstance().readMensajes();
			System.out.println(mensaje);
			
			
		}
		req.getSession().setAttribute("user", user);
		req.getSession().setAttribute("mensajes", todosMensajes);
		req.getSession().setAttribute("conversacionId", conversacionId);
		String s = "ChatServlet?conversacionId="+conversacionId+"&tokenUser="+user.getToken();
		req.getSession().setAttribute("cargaChat", s);
		System.out.println(todosMensajes);
		getServletContext().setAttribute("sala", sala);
		resp.sendRedirect(req.getContextPath() + "/Chat.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
}