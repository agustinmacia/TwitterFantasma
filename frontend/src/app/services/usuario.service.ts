import { Injectable } from "@angular/core";
import {HttpClient} from '@angular/common/http';
import { Observable } from "rxjs/Observable";
import { Usuario } from "../model/usuario";
import 'rxjs/add/operator/map';

@Injectable()
export class UsuarioService{

    constructor(public httpClient: HttpClient){

    }

    public conseguirUsuarios(): Observable<Array<Usuario>>{
        return this.httpClient
            .get<Array<Usuario>>('/api/rest/usuarios')
            .map(respuesta => respuesta.map(usuario => Usuario.crearDesdeJson(usuario)))
    }

    public buscarPorId(id: number): Observable<Usuario>{
        return this.httpClient.get(`/api/rest/usuarios/${id}`)
        .map(usuario => Usuario.crearDesdeJson(usuario));
    }

    public insertar(usuario :Usuario): Observable<any>{
        return this.httpClient.post('api/rest/usuarios', usuario)
    }

    public modificar(usuario: Usuario): Observable<any>{
        return this.httpClient.put(`api/rest/usuarios/${usuario.id}`, usuario);

    }

    public eliminarUsuario(id :number): Observable<void>{
        const body = {body:{id:id}};
        return this.httpClient.request<any>('delete','api/rest/usuarios/', body);
    }

    public usuarioLogueado(): Observable<Usuario>{
    return this.httpClient.get('/api/rest/yo')
      .map(usuario => Usuario.crearDesdeJson(usuario));
  }

}
