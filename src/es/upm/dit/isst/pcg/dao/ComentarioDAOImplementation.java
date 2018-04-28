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
			System.out.println("aqui si");
			}
		return instance;
	}

	@Override
	public List<Comentario> readComentarios() {
		Session session = SessionFactoryService.get().openSession();
		List<Comentario> comentarios = new ArrayList<>();
		try {
			session.beginTransaction();
			comentarios.addAll(session.createQuery("select t from Comentario t").getResultList() );
			session.getTransaction().commit();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return comentarios;
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

	@Override
	public void createComentario(Comentario comentario) {
		Session session = SessionFactoryService.get().openSession();
		System.out.println("y aquiii");

		try {
			session.beginTransaction();
			session.save(comentario);
			System.out.println("guardando el comenttt");
			System.out.println(comentario);
			session.getTransaction().commit();

		} catch (Exception e) {
		} finally {
			session.close();
		}	
	}
}
