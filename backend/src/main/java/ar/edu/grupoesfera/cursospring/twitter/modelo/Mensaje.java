package ar.edu.grupoesfera.cursospring.twitter.modelo;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ar.edu.grupoesfera.cursospring.twitter.utils.MiLocalDateSerializer;

public class Mensaje {
	String msj;
	
	@JsonSerialize(using= MiLocalDateSerializer.class)
	LocalDate date;
	public String getMsj() {
		return msj;
	}
	public void setMsj(String msj) {
		this.msj = msj;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
}
