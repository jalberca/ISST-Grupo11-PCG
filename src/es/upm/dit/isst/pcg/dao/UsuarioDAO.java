package es.upm.dit.isst.pcg.dao;

import java.util.List;

import es.upm.dit.isst.pcg.model.Usuario;

public interface UsuarioDAO {
	// lógicamente necesitamos un método para que se logeen
	public Usuario loginUser( String email, String password );

	// Necesitamos leer todos los usuarios en algún momento????
	public List<Usuario> readAllUsers( );

	// Métodos también lógicos
	public void createUsuario( Usuario user );
	public Usuario readUsuario( String email );
	public void updateUsuario( Usuario user );
	public void deleteUsuario( Usuario user );
	
	// Para saber qué tipo de usuario es (de cara a poder borrar pensamientos)
	public String typeUser( Usuario user);
	
	// En un futuro necesitaremos también obtener el email (para ponerlos en contacto)
	public String userEmail( Usuario user);
	
	// No sé bien cómo va lo del token pero seguramente se necesite algo aquí jejejej
	
	//Javi: sacar reportes dado el usuario
	public int reportes(Usuario user);
	
}
