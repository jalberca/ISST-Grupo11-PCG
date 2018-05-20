package es.upm.dit.isst.pcg.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.upm.dit.isst.pcg.model.Pensamiento;
import es.upm.dit.isst.pcg.model.Usuario;

public class UsuarioDAOImplementationTest {
	
	Usuario user;
	Pensamiento pensamiento;
	
	@Before
	public void setUp() throws Exception {
		user = new Usuario();
		user.setEmail("user@user");
		user.setID(1);
		user.setToken("AAAAA");
		user.setTypeUser("user");
		UsuarioDAOImplementation.getInstance().createUsuario(user);
	}

	@Test
	public void testLoginUser() {
		UsuarioDAO dao = UsuarioDAOImplementation.getInstance();
		Usuario usuario = dao.loginUser("user@user", "AAAAA");
		assertEquals(usuario.getEmail(), "user@user");
	}

	@Test
	public void testReadAllUsers() {
		Usuario user1 = new Usuario();
		user1.setEmail("user1@user");
		user1.setID(2);
		user1.setToken("AAAAA");
		user1.setTypeUser("user");
		UsuarioDAOImplementation.getInstance().createUsuario(user);
		UsuarioDAO dao = UsuarioDAOImplementation.getInstance();
		List<Usuario> lista = dao.readAllUsers();
		assertEquals("user@user", lista.get(1).getEmail());
		assertEquals("user1@user", lista.get(2).getEmail());
	}

	@Test
	public void testCreateUsuario() {
		Usuario user1 = new Usuario();
		user1.setEmail("user1@user");
		user1.setID(2);
		user1.setToken("AAAAA");
		user1.setTypeUser("user");
		UsuarioDAOImplementation.getInstance().createUsuario(user);
		UsuarioDAO dao = UsuarioDAOImplementation.getInstance();
		Usuario user2 = dao.readUsuario(2);
		assertEquals(user2.getEmail(), "user1@user");
		dao.deleteUsuario(user1);
		
	}

	@Test
	public void testReadUsuario() {
		UsuarioDAO dao = UsuarioDAOImplementation.getInstance();
		Usuario user2 = dao.readUsuario(1);
		assertEquals(user2.getEmail(), "user@user");
	}

	@Test
	public void testUpdateUsuario() {
		Usuario user1 = new Usuario();
		user1.setEmail("user1@user");
		user1.setID(2);
		user1.setToken("AAAAA");
		user1.setTypeUser("user");
		UsuarioDAOImplementation.getInstance().createUsuario(user);
		UsuarioDAO dao = UsuarioDAOImplementation.getInstance();
		Usuario user2 = dao.readUsuario(2);
		assertEquals(user2.getEmail(), "user1@user");
		user2.setEmail("nuevo");
		dao.updateUsuario(user2);
		user2 = dao.readUsuario(2);
		assertEquals(user2.getEmail(), "nuevo");
		dao.deleteUsuario(user1);
	}

	@Test
	public void testDeleteUsuario() {
		Usuario user1 = new Usuario();
		user1.setEmail("user1@user");
		user1.setID(2);
		user1.setToken("AAAAA");
		user1.setTypeUser("user");
		UsuarioDAOImplementation.getInstance().createUsuario(user);
		UsuarioDAO dao = UsuarioDAOImplementation.getInstance();
		Usuario user2 = dao.readUsuario(2);
		assertEquals(user2.getEmail(), "user1@user");
		dao.deleteUsuario(user2);
		assertNull(dao.readUsuario(2));
		
	}

	@Test
	public void testTypeUser() {
		UsuarioDAO dao = UsuarioDAOImplementation.getInstance();
		Usuario user1 = dao.readUsuario(1);
		assertEquals(dao.typeUser(user1), "user");
	}

	@Test
	public void testUserEmail() {
		UsuarioDAO dao = UsuarioDAOImplementation.getInstance();
		Usuario user1 = dao.readUsuario(1);
		assertEquals(dao.userEmail(user1), user1.getEmail());
	}

	@Test
	public void testReportes() {
		UsuarioDAO dao = UsuarioDAOImplementation.getInstance();
		Usuario user1 = dao.readUsuario(1);
		assertEquals(dao.reportes(user1), user1.getReports());
	}
	
	@After
	public void tearDown() throws Exception {
		UsuarioDAOImplementation.getInstance().deleteUsuario(user);
		user = null;
	}

	

}
