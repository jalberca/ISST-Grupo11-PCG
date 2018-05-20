package es.upm.dit.isst.pcg.dao;

import java.util.List;

import es.upm.dit.isst.pcg.model.MensajeChat;
import es.upm.dit.isst.pcg.model.Conversacion;

public interface MensajeChatDAO {
	
	// Para leer los mensajes asociados a una conversacion
	public List<MensajeChat> readMensajes(Conversacion conversacion);
	
	// Para crear un mensaje asociado a una conversacion
	public void createMensaje(MensajeChat mensaje);
	
	// Lee todos los mensajes creados (necesario????)
	public List<MensajeChat> readMensajes();

}
