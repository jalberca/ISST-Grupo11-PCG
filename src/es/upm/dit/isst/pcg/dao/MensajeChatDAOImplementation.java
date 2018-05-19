package es.upm.dit.isst.pcg.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.pcg.model.MensajeChat;
import es.upm.dit.isst.pcg.model.Pensamiento;
import es.upm.dit.isst.pcg.model.Comentario;
import es.upm.dit.isst.pcg.model.Conversacion;

public class MensajeChatDAOImplementation implements MensajeChatDAO {
	
public static MensajeChatDAOImplementation instance;
	
	private MensajeChatDAOImplementation() {
		// TODO Auto-generated constructor stub
	}
	
	public static MensajeChatDAOImplementation getInstance() {
		if (null == instance) {
			instance = new MensajeChatDAOImplementation();
			}
		return instance;
	}

	@Override
	public List<MensajeChat> readMensajes() {
		Session session = SessionFactoryService.get().openSession();
		List<MensajeChat> allMensajes = new ArrayList<>();
		try {
			session.beginTransaction();
			allMensajes.addAll(session.createQuery("select t from MensajeChat t").getResultList() );
			session.getTransaction().commit();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return allMensajes;
	}
	@Override
	public List<MensajeChat> readMensajes(Conversacion conversacion) {
		Session session = SessionFactoryService.get().openSession();
		List<MensajeChat> mensajes = new ArrayList<>();
		try {
			session.beginTransaction();
			mensajes.addAll(session.createQuery("select t from MensajeChat t  where t.conversacion = :id")
	        .setParameter("id", conversacion.getId())
	        .getResultList() );
			session.getTransaction().commit();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return mensajes;
	}

	@Override
	public void createMensaje(MensajeChat mensaje) {
		Session session = SessionFactoryService.get().openSession();
		System.out.println("y aquiii");

		try {
			session.beginTransaction();
			session.save(mensaje);
			System.out.println("guardando el mensaje");
			System.out.println(mensaje);
			session.getTransaction().commit();

		} catch (Exception e) {
		} finally {
			session.close();
		}	
	}

}
