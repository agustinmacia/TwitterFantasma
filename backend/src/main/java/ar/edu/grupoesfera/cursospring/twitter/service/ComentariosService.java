package ar.edu.grupoesfera.cursospring.twitter.service;

import ar.edu.grupoesfera.cursospring.twitter.modelo.Comentario;

public interface ComentariosService {

	public void comentar(Comentario comentario, Long id);
}
