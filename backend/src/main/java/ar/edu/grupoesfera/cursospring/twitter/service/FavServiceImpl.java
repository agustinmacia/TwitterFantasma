package ar.edu.grupoesfera.cursospring.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.grupoesfera.cursospring.twitter.exception.YaEstaFaveadoException;
import ar.edu.grupoesfera.cursospring.twitter.modelo.Favorito;
import ar.edu.grupoesfera.cursospring.twitter.modelo.Twit;
import ar.edu.grupoesfera.cursospring.twitter.modelo.Usuario;
import ar.edu.grupoesfera.cursospring.twitter.repository.FavRepository;

@Service
public class FavServiceImpl implements FavService {

	@Autowired
	FavRepository repository;
	
	@Autowired
	SecurityService securityService;
	
	@Override
	public void favear(Twit twit) throws YaEstaFaveadoException {
		Usuario logeado = securityService.getLogeado();
		if(repository.existeFav(twit, logeado) != null) {
			Favorito fav = new Favorito(twit, logeado);		
			repository.save(fav);			
		}else {
			throw new YaEstaFaveadoException("Ya esta faveado");
		}
	}

	@Override
	public void desfavear(Twit twit) {
		// Precond existe el fav.
		Favorito fav = repository.existeFav(twit, securityService.getLogeado());
		repository.delete(fav);
		
	}
		
	
}
