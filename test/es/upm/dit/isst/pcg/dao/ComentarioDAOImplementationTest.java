package es.upm.dit.isst.pcg.dao;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.upm.dit.isst.pcg.model.Comentario;
import es.upm.dit.isst.pcg.model.Pensamiento;
import es.upm.dit.isst.pcg.model.Usuario;

public class ComentarioDAOImplementationTest {

	
	Usuario user;
	Pensamiento pensamiento;
	Comentario comentario;
	String datePens;
	String dateComent;
	
	@Before
	public void setUp() throws Exception {
		user = new Usuario();
		user.setEmail("user@user");
		user.setID(1);
		user.setToken("AAAAA");
		user.setTypeUser("user");
		UsuarioDAOImplementation.getInstance().createUsuario(user);
		
		datePens = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		pensamiento = new Pensamiento();
		pensamiento.setDate(datePens);
		pensamiento.setId(1);
		pensamiento.setLatitud(1);
		pensamiento.setLongitud(1);
		pensamiento.setUser(user);
		pensamiento.setText("hola");
		PensamientoDAOImplementation.getInstance().createPensamiento(pensamiento);
		
		comentario = new Comentario();
		comentario.setId(1);
		comentario.setText("Comentario de prueba");
		comentario.setPensamientoId(pensamiento.getId());
		dateComent = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		comentario.setDate(dateComent);
		ComentarioDAOImplementation.getInstance().createComentario(comentario);

	}
	@Test
	public void testReadComentarios() {
		Comentario comentario1 = new Comentario();
		comentario1.setId(1);
		comentario1.setText("Comentario de prueba1");
		comentario1.setPensamientoId(pensamiento.getId());
		dateComent = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		comentario1.setDate(dateComent);
		ComentarioDAOImplementation.getInstance().createComentario(comentario1);
		
		List<Comentario> cs = ComentarioDAOImplementation.getInstance().readComentarios();
		
		assertEquals("Comentario de prueba", cs.get(0).getText());
		assertEquals("Comentario de prueba1", cs.get(1).getText());
	}

	@Test
	public void testReadComentariosPensamiento() {
		Comentario comentario1 = new Comentario();
		comentario1.setId(1);
		comentario1.setText("Comentario de prueba1");
		comentario1.setPensamientoId(pensamiento.getId());
		dateComent = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		comentario1.setDate(dateComent);
		ComentarioDAOImplementation.getInstance().createComentario(comentario1);
		
		List<Comentario> cs = ComentarioDAOImplementation.getInstance().readComentarios(pensamiento);
		
		assertEquals("Comentario de prueba", cs.get(0).getText());
		assertEquals("Comentario de prueba1", cs.get(1).getText());	}

	@Test
	public void testCreateComentario() {
		Comentario comentario3 = new Comentario();
		comentario3.setId(3);
		comentario3.setText("Comentario de prueba1");
		comentario3.setPensamientoId(pensamiento.getId());
		dateComent = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		comentario3.setDate(dateComent);
		ComentarioDAOImplementation.getInstance().createComentario(comentario3);
		
		List<Comentario> cs = ComentarioDAOImplementation.getInstance().readComentarios(pensamiento);
		
		assertEquals("Comentario de prueba", cs.get(2).getText());
	}
}
