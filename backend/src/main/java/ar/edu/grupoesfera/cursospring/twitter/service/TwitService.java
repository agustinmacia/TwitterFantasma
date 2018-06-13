package ar.edu.grupoesfera.cursospring.twitter.service;

import java.util.List;
import java.util.Optional;

import ar.edu.grupoesfera.cursospring.twitter.modelo.Twit;
import ar.edu.grupoesfera.cursospring.twitter.modelo.Usuario;

public interface TwitService {

	public void twittear(Twit twit);
	public void twittear(Twit twit, Usuario user);

	public List<Twit> perfil();

	public Optional<Twit> getTwit(Long id);

	public List<Twit> getTwitsByUsuario(Long usuarioId);
	
	public List<Twit> getMyTimeline();
}
