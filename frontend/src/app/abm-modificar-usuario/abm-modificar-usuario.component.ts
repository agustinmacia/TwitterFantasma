import { Component, OnInit } from '@angular/core';
import { Usuario } from '../model/usuario';
import { UsuarioService } from '../services/usuario.service';
import { ActivatedRoute } from '@Angular/router';
import 'rxjs/add/operator/switchMap';

@Component({
  selector: 'app-abm-modificar-usuario',
  templateUrl: './abm-modificar-usuario.component.html',
  styleUrls: ['./abm-modificar-usuario.component.css']
})
export class AbmModificarUsuarioComponent implements OnInit{

  usuario: Usuario = new Usuario(null, null, null, null);

  constructor(private usuarioService: UsuarioService, private ruta: ActivatedRoute) {
  }

  ngOnInit(){
    this.ruta.paramMap
      .switchMap( paramMap => this.usuarioService.buscarPorId(+paramMap.get('id')))
      .subscribe(usuario => this.usuario = usuario);
  }

  public modificar(): void{
    this.usuarioService.modificar(this.usuario).subscribe();
  }
}
