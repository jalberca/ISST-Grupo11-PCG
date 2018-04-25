package es.upm.dit.isst.pcg.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.pcg.model.Pensamiento;
import es.upm.dit.isst.pcg.model.Usuario;
import es.upm.dit.isst.pcg.dao.SessionFactoryService;


public class UsuarioDAOImplementation implements UsuarioDAO {
	
	public static UsuarioDAOImplementation instance;
	private UsuarioDAOImplementation() { }
	public static UsuarioDAOImplementation getInstance() {
		if ( null == instance )
			instance = new UsuarioDAOImplementation();
		return instance;
	}

	// SIENDO SINCERA NO TENGO NI IDEA DE SI ESTO ESTÁ BIEN 
	// De hecho estoy casi segura de que está mal, porque usaremos el Oauth y eso saes
	// pero lo dejo aquí para modificarlo cuando toque
	@Override
	public Usuario loginUser(String email, String token) {
		Session session = SessionFactoryService.get().openSession();
		Usuario user = null;
		try {
			user = (Usuario) session
			        .createQuery("select p from Usuario p where p.email= :email and p.token = :token")
			        .setParameter("email", email)
			        .setParameter("token", token)
			        .uniqueResult();		
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return user;
	}
	
	
	// Necesitamos leer todos los users en algún momentoo?????!?
	@Override
	public List<Usuario> readAllUsers() {
		Session session = SessionFactoryService.get().openSession();
		List<Usuario> users = new ArrayList<>();
		try {
			session.beginTransaction();
			users.addAll(session.createQuery("select t from Usuario t").getResultList() );
			session.getTransaction().commit();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return users;
	}

	@Override
	public void createUsuario(Usuario user) {
		Session session = SessionFactoryService.get().openSession();

		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();

		} catch (Exception e) {
		} finally {
			session.close();
		}			
	}

	// ESTO NO SÉ CÓMO ES PERO NECESITAREMOS ALGO SIMILAR CUANDO SEPAMOS CÓMO VA EL OAUTH
	// y tal para el login nuuuuu!?!¿?
	@Override
	public Usuario readUsuario(String email) {
		Session session = SessionFactoryService.get().openSession();
		Usuario user = null;
		try {
			user = session.get(Usuario.class, email);
		} catch (Exception e) {
		} finally {
			session.close();

		}
		return user;
	}

	@Override
	public void updateUsuario(Usuario user) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(user);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}	
	}

	@Override
	public void deleteUsuario(Usuario user) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();

		} catch (Exception e) {

		} finally {

			session.close();
		}
	}

	@Override
	public String typeUser(Usuario user) {
		Session session = SessionFactoryService.get().openSession();
		String typeUser = null;
		try {
			typeUser = (String) session.createQuery("select t.typeUser from Usuario t where t.id = :id")
			.setParameter("id", user.getID() )
			.uniqueResult();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return typeUser;
	}

	@Override
	public String userEmail(Usuario user) {
		Session session = SessionFactoryService.get().openSession();
		String userEmail = null;
		try {
			userEmail = (String) session.createQuery("select t.email from Usuario t where t.id = :id")
			.setParameter("id", user.getID() )
			.uniqueResult();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return userEmail;
	}
	
	@Override
	public int reportes (Usuario user) {
		Session session = SessionFactoryService.get().openSession();
		int reportes = 0;
		try {
			reportes = (int) session.createQuery("select t.reports from Usuario t where t.id = :id")
			.setParameter("id", user.getID())
			.uniqueResult();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return reportes;
	}

}
