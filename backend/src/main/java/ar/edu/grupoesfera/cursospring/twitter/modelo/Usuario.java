package ar.edu.grupoesfera.cursospring.twitter.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = {"new"})
public class Usuario extends AbstractPersistable<Long>{


	private static final long serialVersionUID = -8844938167694289807L;

	@Column
	private String nombre;

	@Column
	private String email;
	
	@Column
	private boolean esAdmin;
	
	@Column
	private String contraseña;

	@ManyToMany(fetch=FetchType.EAGER)
	@JsonIgnore
	private List<Usuario> seguidos = new ArrayList<Usuario>();
	
	public Usuario() {
		
	}

	public boolean isEsAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}

	
	public void agregarSeguido(Usuario usuario) {
		seguidos.add(usuario);
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {

		return nombre;
	}

	public void setNombre(String nombre) {

		this.nombre = nombre;
	}

	public List<Usuario> getSeguidos() {

		return seguidos;
	}

	public void setSeguidos(List<Usuario> seguidos) {

		this.seguidos = seguidos;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
}
