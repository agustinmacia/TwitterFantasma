package ar.edu.grupoesfera.cursospring.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.grupoesfera.cursospring.twitter.modelo.Usuario;
import ar.edu.grupoesfera.cursospring.twitter.repository.UsuarioRepository;

@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public Usuario getLogeado() {
		return usuarioRepository.findOne(1L);
	}
	

	
}
