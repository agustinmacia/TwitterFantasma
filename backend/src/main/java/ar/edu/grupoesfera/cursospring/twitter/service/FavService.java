package ar.edu.grupoesfera.cursospring.twitter.service;

import ar.edu.grupoesfera.cursospring.twitter.exception.YaEstaFaveadoException;
import ar.edu.grupoesfera.cursospring.twitter.modelo.Twit;
import ar.edu.grupoesfera.cursospring.twitter.modelo.Usuario;

public interface FavService {

	public void favear(Twit twit)throws YaEstaFaveadoException;

	public void desfavear(Twit twit);

}
