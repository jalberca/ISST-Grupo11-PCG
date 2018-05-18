package es.upm.dit.isst.pcg.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Usuario implements Serializable{
	
	@Id
	private int id;
	private String email;
	private String token;
	private String typeUser;
	private int reports;
	private Integer liked[] = new Integer[2];
	private Integer notLiked[] = new Integer[2];
	private Integer reported[] = new Integer[2];

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER) //OJITO A ESTO QUE LO DE USER ME LO HE INVENTADO
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Pensamiento> misPensamientos;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	@Fetch(value= FetchMode.SUBSELECT)
	private List<Conversacion> misConversaciones;
	
	public Usuario () {
		this.misPensamientos = new ArrayList<>();
		this.misConversaciones = new ArrayList<>();
		this.reports=0;
		liked[0]=0;
		liked[1]=0;
		notLiked[0]=0;
		notLiked[1]=0;
		reported[0]=0;
		reported[1]=0;
	}
	
	public int getID() {
		return this.id;
	}
	
	public void setID(int id) {
		this.id=id;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getToken() {
		return this.token;
	}
	
	public void setToken(String token) {
		this.token=token;
	}
	
	// ESPE: debemos añadir esto para saber si somos admin o no, nu?
	public String getTypeUser() {
		return this.typeUser;
	}
	
	public void setTypeUser(String typeUser) {
		this.typeUser=typeUser;
	}
	
	public List<Pensamiento> getMisPensamientos(){
		
		return this.misPensamientos;
	}
	
	public List<Conversacion> getMisConversaciones(){
		return this.misConversaciones;
	}
	
	public Integer[] getLiked(){
		return this.liked;
	}
	
	public void addLiked(int id) {
		List<Integer> miArrayList = new ArrayList<>();
		Collections.addAll(miArrayList,this.liked);
        miArrayList.add(id);
        Integer[] nuevoArray = new Integer[miArrayList.size()]; 
        //Aquí convertimos la lista a arreglo nuevamente
        this.liked = miArrayList.toArray(nuevoArray);
	}
	
	public Integer[] getNotLiked(){
		return this.notLiked;
	}
	
	public void addNotLiked(int id) {
		List<Integer> miArrayList = new ArrayList<>();
		Collections.addAll(miArrayList,this.notLiked);
        miArrayList.add(id);
        Integer[] nuevoArray = new Integer[miArrayList.size()]; 
        //Aquí convertimos la lista a arreglo nuevamente
        this.notLiked = miArrayList.toArray(nuevoArray);
	}
	
	public Integer[] getReported(){
		return this.reported;
	}
	
	public void addReported(int id) {
		List<Integer> miArrayList = new ArrayList<>();
		Collections.addAll(miArrayList,this.reported);
        miArrayList.add(id);
        Integer[] nuevoArray = new Integer[miArrayList.size()]; 
        //Aquí convertimos la lista a arreglo nuevamente
        this.reported = miArrayList.toArray(nuevoArray);
	}
	
	public void reportsUP() {
		this.reports++;
	}
	
	public int getReports() {
		return this.reports;
	}

}
