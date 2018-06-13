import { Component, OnInit } from '@angular/core';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../services/usuario.service';
import { Router } from '@Angular/router';

@Component({
  selector: 'app-abm-usuario',
  templateUrl: './abm-usuario.component.html',
  styleUrls: ['./abm-usuario.component.css']
})
export class AbmUsuarioComponent{

  usuarios: Array<Usuario>;

  constructor(public usuarioService: UsuarioService, public router: Router) {
    usuarioService.conseguirUsuarios()
      .subscribe((usuarios) =>{

        this.usuarios = usuarios;
    })
   }

   public crearUsuario():void{
     this.router.navigate(['abmusuarios', 'crearUsuario']);
   }

   public modificarUsuario(id:number): void {
     this.router.navigate(['abmusuarios', id]);
   }

   public eliminarUsuario(id:number):void{
    this.usuarioService.eliminarUsuario(id).subscribe();
   }
}
