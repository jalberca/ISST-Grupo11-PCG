package es.upm.dit.isst.pcg.dao;

import java.util.List;

import es.upm.dit.isst.pcg.model.Comentario;
import es.upm.dit.isst.pcg.model.Pensamiento;


public interface ComentarioDAO {
	
	// Para obtener todos los comentarios de un pensamiento
	public List<Comentario> readComentarios(Pensamiento pensamiento);

	public void createComentario(Comentario comentario);
	
	public List<Comentario> readComentarios();

}
