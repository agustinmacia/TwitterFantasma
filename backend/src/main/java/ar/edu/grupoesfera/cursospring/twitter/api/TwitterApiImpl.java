package ar.edu.grupoesfera.cursospring.twitter.api;

import java.net.URI;
import java.time.LocalDate;
import java.util.Optional;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ar.edu.grupoesfera.cursospring.twitter.modelo.Comentario;
import ar.edu.grupoesfera.cursospring.twitter.modelo.Mensaje;
import ar.edu.grupoesfera.cursospring.twitter.modelo.Twit;
import ar.edu.grupoesfera.cursospring.twitter.modelo.Usuario;
import ar.edu.grupoesfera.cursospring.twitter.service.ComentarioService;
import ar.edu.grupoesfera.cursospring.twitter.service.FavService;
import ar.edu.grupoesfera.cursospring.twitter.service.SecurityService;
import ar.edu.grupoesfera.cursospring.twitter.service.TwitService;
import ar.edu.grupoesfera.cursospring.twitter.service.UsuarioService;

@Service
public class TwitterApiImpl implements TwitterApi {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private TwitService	twitService;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private FavService favService;
	
	@Autowired
	private ComentarioService comentarioService;

    @Override
    public Response isAlive() {
        return Response.ok().build();
    }

	@Override
	public Response hola() {
		return Response.ok("hello").build();
	}

	@Override
	public Response mensaje() {
		Mensaje msj = new Mensaje();
		msj.setMsj("Cuerpo del mensaje");
		msj.setDate(LocalDate.now());
		
		return Response.ok(msj).build();
	}

	@Override
	public Response getUsuarios() {
		return Response.ok(usuarioService.getUsuarios()).build();
	}

	@Override
	// Manejar error cuando no encuentra.
	public Response getUsuarioById(Long id) {
		Optional<Usuario> usuario = usuarioService.getUsuarioById(id);
		
		if(usuario.isPresent()) {
			return Response.ok(usuario.get()).build();
		}else {
			return Response.status(404).build();			
		}
	}

	@Override
	public Response insertUsuario(Usuario usuario) {
		usuarioService.insertUsuario(usuario);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
							.path("/{id}")
							.buildAndExpand(usuario.getId()).toUri();
							
		return Response.created(location).build();
	}

	@Override
	public Response modificarUsuario(Usuario usuario) {
		usuarioService.modificarUsuario(usuario);
		return Response.ok().build();
	}
	
	@Override
	public Response borrarUsuario(Usuario usuario) {
		usuarioService.borrarUsuario(usuario);
		return Response.ok().build();
	}

	@Override
	public Response yo() {
		return Response.ok(securityService.getLogeado()).build();
	}

	@Override
	public Response seguidos() {
		return Response.ok(usuarioService.getSeguidos()).build();
	}

	@Override
	public Response seguir(Usuario usuario) {
		usuarioService.seguir(usuario);
		return Response.ok().build();
	}

	@Override
	public Response seguidores(Long id) {
		return Response.ok(usuarioService.getSeguidores(id)).build();
	}

	@Override
	public Response twittear(Twit twit) {
		twitService.twittear(twit);
		return Response.ok().build();
	}
	
	@Override
	public Response getTwit(Long id) {
		Optional<Twit> twit = twitService.getTwit(id);
		
		if(twit.isPresent()) {
			return Response.ok(twit.get()).build();
		}else {
			return Response.status(404).build();			
		}
	}

	@Override
	public Response misTwits() {
		return Response.ok(twitService.perfil()).build();
	}

	@Override
	public Response getTwitByUsuario(Long usuarioId) {
		return Response.ok(twitService.getTwitsByUsuario(usuarioId)).build();
	}

	@Override
	public Response getMyTimeline() {
		return Response.ok(twitService.getMyTimeline()).build();
	}

	@Override
	public Response favear(Twit twit) {
		try {
			favService.favear(twit);
			return Response.ok().build();
		}catch (Exception e){
			return Response.status(500).build();
		}
	}

	@Override
	public Response desfavear(Twit twit) {
		favService.desfavear(twit);
		return Response.ok().build();
	}

	@Override
	public Response comentar(Long id, Comentario comentario) {
		comentarioService.comentar(comentario, id);
		return Response.ok().build();
	}

	@Override
	public Response autorizacion(Usuario usuario) {
		return Response.ok().build();
	}


  
}
