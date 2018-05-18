package es.upm.dit.isst.pcg.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.pcg.model.Conversacion;
import es.upm.dit.isst.pcg.model.Pensamiento;
import es.upm.dit.isst.pcg.model.Usuario;
import es.upm.dit.isst.pcg.dao.SessionFactoryService;

public class ConversacionDAOImplementation implements ConversacionDAO {
	
		public static ConversacionDAOImplementation instance;
		
		private ConversacionDAOImplementation() {
			// TODO Auto-generated constructor stub
		}
		
		public static ConversacionDAOImplementation getInstance() {
			if (null == instance) {
				instance = new ConversacionDAOImplementation();
			}
			return instance;
		}


		@Override
		public Usuario getUser(Conversacion conversacion) {
			Session session = SessionFactoryService.get().openSession();
			Usuario user = null;
			try {
				user = (Usuario) session
				        .createQuery("select p from Usuario p where p.conversacion= :conversacion")
				        .setParameter("conversacion", conversacion)
				        .uniqueResult();		
			}catch(Exception e) {
				
			}finally {
				session.close();
			}
			return user;
		}

		@Override
		public List<Conversacion> readConversaciones() {
			Session session = SessionFactoryService.get().openSession();
			List<Conversacion> conversaciones = new ArrayList<>();
			try {
				session.beginTransaction();
				conversaciones.addAll(session.createQuery("select t from Conversacion t").getResultList() );
				session.getTransaction().commit();
			}catch(Exception e) {
				
			}finally {
				session.close();
			}
			return conversaciones;
		}
		
		@Override
		public List<Conversacion> readConversacionesUsuario(Usuario user) {
			Session session = SessionFactoryService.get().openSession();
			List<Conversacion> conversaciones = new ArrayList<>();
			try {
				session.beginTransaction();
				conversaciones.addAll(session.createQuery("select t from Conversacion t  where t.user = :user")
		        .setParameter("user", user)
		        .getResultList() );
				session.getTransaction().commit();
			}catch(Exception e) {
				
			}finally {
				session.close();
			}
			return conversaciones;
		}
		

		@Override
		public void createConversacion(Conversacion conversacion) {
			Session session = SessionFactoryService.get().openSession();

			try {
				session.beginTransaction();
				session.save(conversacion);
				session.getTransaction().commit();

			} catch (Exception e) {
			} finally {
				session.close();
			}				
		}

		@Override
		public void deleteConversacion(Conversacion conversacion) {
			Session session = SessionFactoryService.get().openSession();
			try {
				session.beginTransaction();
				session.delete(conversacion);
				session.getTransaction().commit();

			} catch (Exception e) {

			} finally {

				session.close();
			}
		}
		
		@Override
		public Conversacion readConversacion(int id) {
			Session session = SessionFactoryService.get().openSession();
			Conversacion conversacion = null;
			try {
				conversacion = session.get(Conversacion.class, id);
			} catch (Exception e) {
			} finally {
				session.close();

			}
			return conversacion;
		}
	
}
