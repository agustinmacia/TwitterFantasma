package ar.edu.grupoesfera.cursospring.twitter.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import ar.edu.grupoesfera.cursospring.twitter.modelo.Comentario;
import ar.edu.grupoesfera.cursospring.twitter.modelo.Twit;
import ar.edu.grupoesfera.cursospring.twitter.modelo.Usuario;

@Path("/rest")
@CrossOriginResourceSharing(allowAllOrigins = true)
public interface TwitterApi {
    
    @GET
    @Path("/isAlive")
    Response isAlive();
    
    
    @GET
    @Path("/hola")
    Response hola();
    
    @POST
    @Path("/autorizacion")
    @Produces(MediaType.APPLICATION_JSON)
    Response autorizacion(Usuario usuario);
    
    @GET
    @Path("/mensaje/")
    @Produces(MediaType.APPLICATION_JSON)
    Response mensaje();
    
    @GET
    @Path("/usuarios")
    @Produces(MediaType.APPLICATION_JSON)
    Response getUsuarios();
    
    @POST
    @Path("/usuarios")
    @Produces(MediaType.APPLICATION_JSON)
    Response insertUsuario(Usuario usuario);
    
    @PUT
    @Path("/usuarios")
    @Produces(MediaType.APPLICATION_JSON)
    Response modificarUsuario(Usuario usuario);
    
    @DELETE
    @Path("/usuarios")
    @Produces(MediaType.APPLICATION_JSON)
    Response borrarUsuario(Usuario usuario);
    
    @GET
    @Path("/usuarios/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getUsuarioById(@PathParam("id") Long id);
    
    @GET
    @Path("/yo")
    @Produces(MediaType.APPLICATION_JSON)
    Response yo();
   
    // /usuario/id/seguidos
    @GET
    @Path("/seguidos")
    @Produces(MediaType.APPLICATION_JSON)
    Response seguidos();
    
    @POST
    @Path("/seguidos")
    @Produces(MediaType.APPLICATION_JSON)
    Response seguir(Usuario usuario);
    
    
    @GET
    @Path("/usuarios/{id}/seguidores")
    @Produces(MediaType.APPLICATION_JSON)
    Response seguidores(@PathParam("id") Long id);
    
    
    @POST
    @Path("/twits")
    @Produces(MediaType.APPLICATION_JSON)
    Response twittear(Twit twit);
    
    @GET
    @Path("/usuarios/{id}/twits")
    @Produces(MediaType.APPLICATION_JSON)
    Response getTwitByUsuario(@PathParam("id") Long id);

    @GET
    @Path("/twits/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response getTwit(@PathParam("id") Long id);
    
    @GET
    @Path("/perfil")
    @Produces(MediaType.APPLICATION_JSON)
    Response misTwits();
    
    @GET
    @Path("/timeline")
    @Produces(MediaType.APPLICATION_JSON)
    Response getMyTimeline();
      
    //Dejar de seguir
   
    @POST
    @Path("/favoritos")
    @Produces(MediaType.APPLICATION_JSON)
    Response favear(Twit twit);
    
    @DELETE
    @Path("/favoritos")
    @Produces(MediaType.APPLICATION_JSON)
    Response desfavear(Twit twit);
    
    @POST
    @Path("/twits/{id}/comentarios")
    @Produces(MediaType.APPLICATION_JSON)
    Response comentar(@PathParam("id") Long id, Comentario comentario);
    
    
    //ver los favs de un tw    
    
    // ver los comentarios de un tw
    
}


