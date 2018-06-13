package ar.edu.grupoesfera.cursospring.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.grupoesfera.cursospring.twitter.modelo.Comentario;
import ar.edu.grupoesfera.cursospring.twitter.modelo.Twit;
import ar.edu.grupoesfera.cursospring.twitter.repository.ComentarioRepository;
import ar.edu.grupoesfera.cursospring.twitter.repository.TwitRepository;

@Service
public class ComentarioService implements ComentariosService {

	@Autowired
	private ComentarioRepository repository;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private TwitRepository twitRepository;
	
	@Override
	public void comentar(Comentario comentario, Long idTwit) {
		comentario.setAutor(securityService.getLogeado());
		repository.save(comentario);
		
		Twit tw = twitRepository.findOne(idTwit);
		tw.getComentarios().add(comentario);
		twitRepository.save(tw);
								
	}

}
