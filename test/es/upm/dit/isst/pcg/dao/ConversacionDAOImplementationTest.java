package es.upm.dit.isst.pcg.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.upm.dit.isst.pcg.model.Conversacion;
import es.upm.dit.isst.pcg.model.Usuario;
import es.upm.dit.isst.pcg.dao.ConversacionDAO;
import es.upm.dit.isst.pcg.dao.UsuarioDAO;
import es.upm.dit.isst.pcg.dao.ConversacionDAOImplementation;
import es.upm.dit.isst.pcg.dao.UsuarioDAOImplementation;

public class ConversacionDAOImplementationTest {
	
	Conversacion conversacion;
	Usuario usuario;
	
	@Before
	public void setUp() throws Exception {
		usuario = new Usuario();
		usuario.setToken("usuario1");
		usuario.setID(1);
		
		conversacion = new Conversacion();
		conversacion.setId(1);
		conversacion.setUser(usuario);
		conversacion.setToken("usuarioConversacion1");
		ConversacionDAOImplementation.getInstance().createConversacion(conversacion);
	}
	
	@After
	public void tearDown() throws Exception {
		ConversacionDAOImplementation.getInstance().deleteConversacion(conversacion);
		UsuarioDAOImplementation.getInstance().deleteUsuario(usuario);
		conversacion = null;
		usuario = null;		
	}
	
	


	@Test
	public void testGetUser() {
		ConversacionDAO dao = ConversacionDAOImplementation.getInstance();
		Conversacion conversacion2 = new Conversacion();
		Usuario usuario2 = new Usuario();
		usuario2.setToken("usuario2");
		
		conversacion2.setUser(usuario2);		
		
		assertEquals(conversacion2.getUser(),usuario2);
	}

	@Test
	public void testReadConversaciones() {
		
		List<Conversacion> conversaciones_list = ConversacionDAOImplementation.getInstance().readConversaciones();
		
		Conversacion conversacion3 = conversaciones_list.get(0);
		
		assertEquals(conversacion.getToken(), conversacion3.getToken());
	}

	@Test
	public void testReadConversacionesUsuario() {
		ConversacionDAO dao = ConversacionDAOImplementation.getInstance();
		List<Conversacion> conversaciones_list = dao.readConversacionesUsuario(usuario);
		
		Conversacion conversacion3 = conversaciones_list.get(0);
		
		
		assertEquals(conversacion.getToken(), conversacion3.getToken());
	}

	@Test
	public void testCreateConversacion() {
		ConversacionDAO dao = ConversacionDAOImplementation.getInstance();
				
		List<Conversacion> conversaciones_list = ConversacionDAOImplementation.getInstance().readConversaciones();
		Conversacion conversacion3 = conversaciones_list.get(0);
		
		assertEquals(conversacion.getToken(), conversacion3.getToken());
	}

	@Test
	public void testDeleteConversacion() {
		ConversacionDAO dao = ConversacionDAOImplementation.getInstance();
		Conversacion conversacion2 = new Conversacion();
		Usuario usuario2 = new Usuario();
		usuario2.setToken("usuario2");
		
		conversacion2.setUser(usuario2);
		conversacion2.setToken("usuarioConversacion2");
		conversacion2.setId(2);
		
		dao.createConversacion(conversacion2);
		dao.deleteConversacion(conversacion2);
		
		Conversacion conversacion3 = dao.readConversacion(2);
	
		
		assertNull(conversacion3);
	}

	@Test
	public void testReadConversacion() {
		ConversacionDAO dao = ConversacionDAOImplementation.getInstance();
		Conversacion conversacion2 = new Conversacion();
		Usuario usuario2 = new Usuario();
		usuario2.setToken("usuario2");
		
		conversacion2.setUser(usuario2);
		conversacion2.setToken("usuarioConversacion2");
		conversacion2.setId(2);
		
		dao.createConversacion(conversacion2);
		
		Conversacion conversacion3 = dao.readConversacion(1);
		
		assertEquals(conversacion.getToken(), conversacion3.getToken());
	}

}
