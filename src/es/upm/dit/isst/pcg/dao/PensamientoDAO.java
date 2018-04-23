package es.upm.dit.isst.pcg.dao;

import java.util.List;

import es.upm.dit.isst.pcg.model.Pensamiento;
import es.upm.dit.isst.pcg.model.Usuario;

public interface PensamientoDAO {
	
	// Cuando queramos ponerlos en contactos necesitaremos obtener el usuario (y de ahí su email)
	public Usuario getUser( Pensamiento pensamiento );

	// Necesitamos leer todos los pensamientos, los de un user y leer aquellos con una posición exacta
	public List<Pensamiento> readPensamientos();
	public List<Pensamiento> readPensamientosUsuario(Usuario user);
	
	// Necesitamos obtener la posición de un pensamiento CON UNA CLASE POSICIÓN? 
	// O hacer dos métodos para obtener latitud y longitud pero veo mejor POSITION
	//public Position position( Pensamiento pensamiento );

	// Métodos también lógicos
	public void createPensamiento( Pensamiento pensamiento );
	
	// DEJAMOS MODIFICAR PENSAMIENTOS????? NO, NO?
	public void updatePensamiento( Pensamiento pensamiento);
	public void deletePensamiento( Pensamiento pensamiento );
	
	// Para obtener su puntuación
	public int votosPositivos( Pensamiento pensamiento);
	public int votosNegativos( Pensamiento pensamiento);
	
	// Para obtener la fecha jeje
	public String fechaPensamiento( Pensamiento pensamiento);
	
	//Para obtener el texto
	public String textoPensamiento(Pensamiento pensamiento);

	
}
