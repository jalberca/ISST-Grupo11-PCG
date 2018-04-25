package es.upm.dit.isst.pcg.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.pcg.model.Comentario;
import es.upm.dit.isst.pcg.model.Pensamiento;

public class ComentarioDAOImplementation implements ComentarioDAO{

	public static ComentarioDAOImplementation instance;
	
	private ComentarioDAOImplementation() {
	
	}
	
	public static ComentarioDAOImplementation getInstance() {
		if (null == instance) {
			instance = new ComentarioDAOImplementation();
		}
		return instance;
	}

	@Override
	public List<Comentario> readComentarios(Pensamiento pensamiento) {
		Session session = SessionFactoryService.get().openSession();
		List<Comentario> comentarios = new ArrayList<>();
		try {
			session.beginTransaction();
			comentarios.addAll(session.createQuery("select t from Comentario t  where t.pensamiento_id = :id")
	        .setParameter("id", pensamiento.getId())
	        .getResultList() );
			session.getTransaction().commit();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return comentarios;
	}

	public void createComentario(Comentario comentario) {
		Session session = SessionFactoryService.get().openSession();

		try {
			session.beginTransaction();
			session.save(comentario);
			session.getTransaction().commit();

		} catch (Exception e) {
		} finally {
			session.close();
		}	
	}
}
