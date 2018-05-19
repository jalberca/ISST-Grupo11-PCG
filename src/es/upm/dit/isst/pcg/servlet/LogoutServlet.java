package es.upm.dit.isst.pcg.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().removeAttribute("cargar");
		req.getSession().removeAttribute("pensamientos");
		req.getSession().removeAttribute("comentarios");
		req.getSession().removeAttribute("user");
		req.getSession().removeAttribute("usuarios");
		resp.sendRedirect(req.getContextPath() + "/Login.jsp");
	}
}