package ar.edu.grupoesfera.cursospring.twitter.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = {"new"})
public class Favorito extends AbstractPersistable<Long>{
	
	private static final long serialVersionUID = 1L;

	@JoinColumn
	@ManyToOne(fetch = FetchType.EAGER)
    private Twit twit;
    
	@JoinColumn
	@ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

	public Favorito() {
		
	}
	
	public Favorito(Twit tw, Usuario usuario) {
		this.twit = tw;
		this.usuario = usuario;
	}

	public Twit getTwit() {
		return twit;
	}

	public void setTwit(Twit twit) {
		this.twit = twit;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


    
}
