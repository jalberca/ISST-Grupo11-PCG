package es.upm.dit.isst.pcg.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.pcg.dao.PensamientoDAOImplementation;
import es.upm.dit.isst.pcg.dao.UsuarioDAOImplementation;
import es.upm.dit.isst.pcg.model.Pensamiento;
import es.upm.dit.isst.pcg.model.Usuario;

@WebServlet("/VotarNegativo")
public class VotarNegativo extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int pensamientoID = Integer.parseInt(req.getParameter("pensamientoID"));
		String cargar = req.getParameter("cargar");
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		
		if(user.getNotLiked() == null || user.getNotLiked().equals(null)) {
			user.addNotLiked(pensamientoID);
			
			UsuarioDAOImplementation.getInstance().updateUsuario(user);
			Pensamiento pensamiento = PensamientoDAOImplementation.getInstance().readPensamiento(pensamientoID);
			pensamiento.voteDOWN();
			PensamientoDAOImplementation.getInstance().updatePensamiento(pensamiento);
		} else {
			int noEsta=99;
			for(int i=0; i<user.getNotLiked().length; i++) {
				if(user.getNotLiked()[i].equals(pensamientoID)) {
					noEsta = 0;
					continue;
				}
				else {
					noEsta = 1;
				}
			}
			
			if(noEsta==(1)) {
				
				user.addNotLiked(pensamientoID);
				
				UsuarioDAOImplementation.getInstance().updateUsuario(user);
				Pensamiento pensamiento = PensamientoDAOImplementation.getInstance().readPensamiento(pensamientoID);
				
				pensamiento.voteDOWN();
				PensamientoDAOImplementation.getInstance().updatePensamiento(pensamiento);
				System.out.println(pensamiento.getVotosNegativo());
				System.out.println(PensamientoDAOImplementation.getInstance().votosNegativos(pensamiento));
			}

		}
		req.getSession().setAttribute("cargar", cargar);
		
		resp.sendRedirect(req.getContextPath()+cargar);
		
	}

}