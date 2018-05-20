package es.upm.dit.isst.pcg.dao;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.upm.dit.isst.pcg.model.Pensamiento;
import es.upm.dit.isst.pcg.model.Usuario;

public class PensamientoDAOImplementationTest {

	
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
		
		pensamiento = new Pensamiento();
		pensamiento.setDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		pensamiento.setId(1);
		pensamiento.setLatitud(1);
		pensamiento.setLongitud(1);
		pensamiento.setUser(user);
		pensamiento.setText("hola");
		PensamientoDAOImplementation.getInstance().createPensamiento(pensamiento);
	}
	
	@Test
	public void testGetUser() {
		PensamientoDAO dao = PensamientoDAOImplementation.getInstance();
		UsuarioDAO dao1 = UsuarioDAOImplementation.getInstance();
		dao.createPensamiento(pensamiento);
		Usuario user1 = dao.getUser(pensamiento);
		assertEquals(user1.getEmail(), "user@user");
	}

	@Test
	public void testReadPensamientos() {
		Pensamiento pensamiento1 = new Pensamiento();
		pensamiento1.setDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		pensamiento1.setId(1);
		pensamiento1.setLatitud(1);
		pensamiento1.setLongitud(1);
		pensamiento1.setUser(user);
		pensamiento1.setText("hola1");
		PensamientoDAOImplementation.getInstance().createPensamiento(pensamiento1);
		
		List<Pensamiento> ps = PensamientoDAOImplementation.getInstance().readPensamientos();
		
		assertEquals("hola", ps.get(1).getText());
		assertEquals("hola1", ps.get(2).getText());
		PensamientoDAOImplementation.getInstance().deletePensamiento(pensamiento1);
	}


	@Test
	public void testVotosPositivos() {
		Pensamiento p1 = PensamientoDAOImplementation.getInstance().readPensamiento(1);
		p1.voteUP();
		PensamientoDAOImplementation.getInstance().updatePensamiento(p1);
		assertEquals(PensamientoDAOImplementation.getInstance().votosPositivos(p1), 1);
	}

	@Test
	public void testVotosNegativos() {
		Pensamiento p1 = PensamientoDAOImplementation.getInstance().readPensamiento(1);
		p1.voteDOWN();
		PensamientoDAOImplementation.getInstance().updatePensamiento(p1);
		assertEquals(PensamientoDAOImplementation.getInstance().votosNegativos(p1), 1);
	}

	@Test
	public void testReadPensamiento() {
		Pensamiento p1 = PensamientoDAOImplementation.getInstance().readPensamiento(1);
		assertEquals(p1.getText(), "hola");
	}

}
