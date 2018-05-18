package es.upm.dit.isst.pcg.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.*;

@Entity
public class MensajeChat implements Serializable {
	
	@Id
	private int id;
	private int conversacion; // Conversacion a la que esta asociado el mensaje
	private String token; // Token del usuario que escribe
	private String date; // Fecha de publicacion
	private String text; // Contenido del mensaje
	
	public MensajeChat() {
		this.id = 0;
		this.conversacion = 0;
		this.token = "";
		this.date= null;
		this.text = "";
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getConversacion() {
		return this.conversacion;
	}
	public void setConversacionId(int conversacionId) {
		this.conversacion = conversacionId;
	}
	
	public String getToken() {
		return this.token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	

}
