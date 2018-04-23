package es.upm.dit.isst.pcg.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.isst.pcg.model.Pensamiento;
import es.upm.dit.isst.pcg.model.PensamientoDist;
import es.upm.dit.isst.pcg.model.Usuario;
import es.upm.dit.isst.pcg.dao.SessionFactoryService;

public class PensamientoDAOImplementation implements PensamientoDAO{

	public static PensamientoDAOImplementation instance;
	
	private PensamientoDAOImplementation() {
	
	}
	
	public static PensamientoDAOImplementation getInstance() {
		if (null == instance) {
			instance = new PensamientoDAOImplementation();
		}
		return instance;
	}


	@Override
	public Usuario getUser(Pensamiento pensamiento) {
		Session session = SessionFactoryService.get().openSession();
		Usuario user = null;
		try {
			user = (Usuario) session
			        .createQuery("select p from Usuario p where p.pensamiento= :pensamiento")
			        .setParameter("pensamiento", pensamiento)
			        .uniqueResult();		
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return user;
	}

	@Override
	public List<Pensamiento> readPensamientos() {
		Session session = SessionFactoryService.get().openSession();
		List<Pensamiento> pensamientos = new ArrayList<>();
		try {
			session.beginTransaction();
			pensamientos.addAll(session.createQuery("select t from Pensamiento t").getResultList() );
			session.getTransaction().commit();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return pensamientos;
	}

	@Override
	public List<Pensamiento> readPensamientosUsuario(Usuario user) {
		Session session = SessionFactoryService.get().openSession();
		List<Pensamiento> pensamientos = new ArrayList<>();
		try {
			session.beginTransaction();
			pensamientos.addAll(session.createQuery("select t from Pensamiento t  where p.user = :user")
	        .setParameter("user", user)
	        .getResultList() );
			session.getTransaction().commit();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return pensamientos;
	}
	
	@Override
	public List<PensamientoDist> readPensamientosPositionRadio(float radio, float lat, float lon){
		Session session = SessionFactoryService.get().openSession();
		List<PensamientoDist> pensamientos = new ArrayList<>();
		try {

			session.beginTransaction();
			pensamientos.addAll(session.createQuery("SELECT *, "
					+ "(6371 * ACOS(SIN(RADIANS(latitud)) * SIN(RADIANS(:long)) "
					+ "+ COS(RADIANS(longitud - :lat)) * COS(RADIANS(latitud)) "
					+ "* COS(RADIANS(4.6665578)) "
					+ ")) AS distance from Pensamiento having distance < :radio order by distance")
					.setParameter("radio", radio)
					.setParameter("lat", lat)
					.setParameter("long", lon)
					.getResultList() );
			session.getTransaction().commit();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return pensamientos;
	}

	@Override
	public void createPensamiento(Pensamiento pensamiento) {
		Session session = SessionFactoryService.get().openSession();

		try {
			session.beginTransaction();
			session.save(pensamiento);
			session.getTransaction().commit();

		} catch (Exception e) {
		} finally {
			session.close();
		}				
	}

	@Override
	public void updatePensamiento(Pensamiento pensamiento) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(pensamiento);
			session.getTransaction().commit();
		} catch (Exception e) {
		} finally {
			session.close();
		}		
	}

	@Override
	public void deletePensamiento(Pensamiento pensamiento) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(pensamiento);
			session.getTransaction().commit();

		} catch (Exception e) {

		} finally {

			session.close();
		}
	}

	@Override
	public int votosPositivos(Pensamiento pensamiento) {
		Session session = SessionFactoryService.get().openSession();
		int votosPositivos = 0;
		try {
			votosPositivos = (int) session.createQuery("select t.votosPositivo from Pensamiento t where t.id = :id")
			.setParameter("id", pensamiento.getId())
			.uniqueResult();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return votosPositivos;
	}

	@Override
	public int votosNegativos(Pensamiento pensamiento) {
		Session session = SessionFactoryService.get().openSession();
		int votosNegativos = 0;
		try {
			votosNegativos = (int) session.createQuery("select t.votosNegativo from Pensamiento t where t.id = :id")
			.setParameter("id", pensamiento.getId())
			.uniqueResult();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return votosNegativos;
	}

	@Override
	public String fechaPensamiento(Pensamiento pensamiento) {
		Session session = SessionFactoryService.get().openSession();
		String fecha = null;
		try {
			fecha = (String) session.createQuery("select t.fecha from Pensamiento t where t.id = :id")
			.setParameter("id", pensamiento.getDate())
			.uniqueResult();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return fecha;
	}
	
	@Override
	public String textoPensamiento(Pensamiento pensamiento) {
		Session session = SessionFactoryService.get().openSession();
		String texto = null;
		try {
			texto = (String) session.createQuery("select t.texto from Pensamiento t where t.id = :id")
			.setParameter("id", pensamiento.getDate())
			.uniqueResult();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return texto;
	}
}
