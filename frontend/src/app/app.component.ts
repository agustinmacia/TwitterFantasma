import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'TwitterFantasma';
  
  hayUsuarioLogueado = false;

  public loguearUsuario(){
    this.hayUsuarioLogueado = true;
  }

  public alertConNombre(nombre: string): void{
    alert(nombre);
  }

}
