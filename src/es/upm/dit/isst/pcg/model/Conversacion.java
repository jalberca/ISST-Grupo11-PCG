package es.upm.dit.isst.pcg.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity implementation class for Entity: Conversacion
 *
 */
@Entity

public class Conversacion implements Serializable {

	@Id
	private int id;
	@ManyToOne
	private Usuario user; // Usuario que ha sido contactado
	private String token; // Usuario que contacta
	//private List<String> tokenMsg; // Para identificar quien ha escrito cada mensaje.
	//private List<String> listMsg; // Lista de mensajes de la conversación.

	public Conversacion() {
		//this.tokenMsg = new ArrayList<>();
		//this.listMsg = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Usuario getUser() {
		return user;
	}
	
	public void setUser(Usuario user) {
		this.user = user;
	}
	
	public String getToken() {
		return this.token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}

   
}
