package ar.edu.grupoesfera.cursospring.twitter.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value = {"new"})
public class Comentario extends AbstractPersistable<Long>{
	
	@Column
    private String mensaje;
	
    @JoinColumn
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario autor;
    
    public String getMensaje() {
    
        return mensaje;
    }
    
    public void setMensaje(String mensaje) {
    
        this.mensaje = mensaje;
    }
    
    public Usuario getAutor() {
    
        return autor;
    }
    
    public void setAutor(Usuario autor) {
    
        this.autor = autor;
    }
}
