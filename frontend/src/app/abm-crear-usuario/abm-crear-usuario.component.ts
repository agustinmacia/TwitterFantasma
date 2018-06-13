import { Component, OnInit } from '@angular/core';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../services/usuario.service';

@Component({
  selector: 'app-abm-crear-usuario',
  templateUrl: './abm-crear-usuario.component.html',
  styleUrls: ['./abm-crear-usuario.component.css']
})
export class AbmCrearUsuarioComponent {

  usuario : Usuario = new Usuario(null, null, null, null);

  constructor(public usuarioService: UsuarioService) {
   }

   public insertar() :void{
    this.usuarioService.insertar(this.usuario).subscribe(usuario => this.usuario = usuario);

   }
}
