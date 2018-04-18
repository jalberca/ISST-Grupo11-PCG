package es.upm.dit.isst.pcg.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Pensamiento implements Serializable{
	
	@Id
	private int id;
	@ManyToOne
	private Usuario user;
	private double latitud;
	private double longitud;
	private String date;
	private int votosPositivo;
	private int votosNegativo;
	
	public Pensamiento() {
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
	
	public int getPositivos() {
		return this.votosPositivo;
	}
	public int getNegativos() {
		return this.votosNegativo;
	}
	public void voteUP() {
		this.votosPositivo++;
	}
	public void voteDOWN() {
		this.votosNegativo++;
	}
}
