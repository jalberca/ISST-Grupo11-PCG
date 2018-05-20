package es.upm.dit.isst.pcg.dao;

import java.util.List;

import es.upm.dit.isst.pcg.model.Conversacion;
import es.upm.dit.isst.pcg.model.Usuario;

public interface ConversacionDAO {
		
		// Cuando queramos ponerlos en contactos necesitaremos obtener el usuario (y de ahí su email)
		public Usuario getUser( Conversacion conversacion);

		public List<Conversacion> readConversaciones();
		public List<Conversacion> readConversacionesUsuario(Usuario user);
		
		// Necesitamos obtener la posición de un pensamiento CON UNA CLASE POSICIÓN? 
		// O hacer dos métodos para obtener latitud y longitud pero veo mejor POSITION
		//public Position position( Pensamiento pensamiento );

		// Métodos también lógicos
		public void createConversacion( Conversacion conversacion );
		public void deleteConversacion( Conversacion conversacion );
		
		public Conversacion readConversacion(int id);
	
	
}
