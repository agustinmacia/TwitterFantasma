package ar.edu.grupoesfera.cursospring.twitter.modelo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ar.edu.grupoesfera.cursospring.twitter.utils.MiLocalDateSerializer;

@Entity
@JsonIgnoreProperties(value = {"new"})
public class Twit extends AbstractPersistable<Long>{

	@Column
    private String mensaje;
    
    @Column
    @JsonSerialize(using= MiLocalDateSerializer.class)
    private LocalDateTime fechaCreacion;
    
    @JoinColumn(name="autor")
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario autor;
    
    @Transient
    @JsonIgnore
    private List<Comentario> comentarios;
    
    public Twit() {}; 
    
    public Twit(Usuario autor, String mensaje, LocalDateTime fecha) {
    	
    	this.mensaje= mensaje;
    	this.autor= autor;
    	this.fechaCreacion= fecha;
    	
    }
    
    public String getMensaje() {
    
        return mensaje;
    }
    
    public void setMensaje(String mensaje) {
    
        this.mensaje = mensaje;
    }

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Usuario getAutor() {
    
        return autor;
    }

    public void setAutor(Usuario autor) {
    
        this.autor = autor;
    }

    public List<Comentario> getComentarios() {
    
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
    
        this.comentarios = comentarios;
    }
}
