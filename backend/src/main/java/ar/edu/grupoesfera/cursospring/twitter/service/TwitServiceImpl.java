package ar.edu.grupoesfera.cursospring.twitter.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.grupoesfera.cursospring.twitter.modelo.Twit;
import ar.edu.grupoesfera.cursospring.twitter.modelo.Usuario;
import ar.edu.grupoesfera.cursospring.twitter.repository.TwitRepository;
import ar.edu.grupoesfera.cursospring.twitter.repository.UsuarioRepository;

@Service
public class TwitServiceImpl implements TwitService {

	@Autowired
	private TwitRepository repository;
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Autowired
	private SecurityService securityService;

	@Override
	public void twittear(Twit twit) {
		twit.setAutor(securityService.getLogeado());
		twit.setFechaCreacion(LocalDateTime.now());
		
		repository.save(twit);
	}
	
	public void twittear(Twit twit, Usuario user) {
		twit.setAutor(user);
		twit.setFechaCreacion(LocalDateTime.now());
		
		repository.save(twit);
	}

	@Override
	public List<Twit> perfil() {
		return repository.getTwitsByUsuario(securityService.getLogeado());
	}

	@Override
	public Optional<Twit> getTwit(Long id) {
		return Optional.ofNullable(repository.findOne(id));
	}

	@Override
	public List<Twit> getTwitsByUsuario(Long usuarioId) {
		return repository.getTwitsByUsuario( userRepository.findOne(usuarioId));
	}

	@Override
	public List<Twit> getMyTimeline(){
		Usuario yo = securityService.getLogeado();
		
		return yo.getSeguidos().stream().flatMap((Usuario u)-> getTwitsByUsuario(u.getId()).stream()).collect(Collectors.toList());
	}
	
	

}
