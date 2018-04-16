package es.upm.dit.isst.pcg.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario implements Serializable{
	
	@Id
	private int id;
	private String email;
	private String token;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER) //OJITO A ESTO QUE LO DE USER ME LO HE INVENTADO
	private List<Pensamiento> misPensamientos;
	
	public Usuario () {
		this.misPensamientos = new ArrayList<>();
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

}
