package es.upm.dit.isst.pcg.model;

import java.io.Serializable;

import javax.persistence.*;
//Esta clase representa la entidad Pensamiento que puede escribir cada usuario.
@Entity
public class PensamientoDist implements Serializable{
	
	@Id
	private int id;
	@ManyToOne
	private Usuario user;
	private double latitud;
	private double longitud;
	private String date;
	private String text;
	private int votosPositivo;
	private int votosNegativo;
	
	public PensamientoDist() {
		this.votosNegativo=0;
		this.votosPositivo=0;
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id=id;
	}
	
	public double getLatitud() {
		return this.latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud=latitud;
	}
	
	public double getLongitud() {
		return this.longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud=longitud;
	}
	
	public String getDate() {
		return this.date;
	}
	public void setDate(String date) {
		this.date=date;
	}
	
	public Usuario getUser() {
		return this.user;
	}
	public void setUser(Usuario user) {
		this.user=user;
	}
	
	public String getText() {
		return this.text;
	}
	public void setText(String texto) {
		this.text=texto;
	}
	
	public int getVotosPositivo() {
		return this.votosPositivo;
	}
	public int getVotosNegativo() {
		return this.votosNegativo;
	}
	public void voteUP() {
		this.votosPositivo++;
	}
	public void voteDOWN() {
		this.votosNegativo++;
	}
}
