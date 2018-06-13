import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Credenciales } from '../model/credenciales';
import { Router } from '@Angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent {

  credencial: Credenciales;
  @Output() loginExitoso = new EventEmitter<Credenciales>();

  constructor(public router: Router, private auth: AuthService) { 
    this.credencial = new Credenciales();
  }

  public submit(){
    //this.auth.loguear(this.credencial).subscribe(()=>{
    //this.router.navigate(['timeline']);
    //},()=>{
      //alert('El usuario o contraseña no son validos, por favor volver a ingresarlos')
    //});

    this.router.navigate(['timeline']);
  }
  


}
