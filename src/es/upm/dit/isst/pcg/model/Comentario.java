package es.upm.dit.isst.pcg.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comentario implements Serializable{
	
	@Id
	private int id;
	private String text;
	private int pensamiento;
	private String date;

	
	public Comentario() {
		this.id=0;
		this.text="";
		this.pensamiento=0;
		this.date=null;
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id=id;
	}
	
	public String getText() {
		return this.text;
	}
	public void setText(String texto) {
		this.text=texto;
	}

	public int getPensamientoId() {
		return pensamiento;
	}

	public void setPensamientoId(int pensamientoID) {
		this.pensamiento = pensamientoID;
	}

	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
}
