import { NgModule, Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes} from '@Angular/router';
import { TimelineComponent } from '../timeline/timeline.component';
import { LoginFormComponent } from '../login-form/login-form.component';
import { AbmUsuarioComponent } from '../abm-usuario/abm-usuario.component';
import { AbmModificarUsuarioComponent } from '../abm-modificar-usuario/abm-modificar-usuario.component';
import { AbmCrearUsuarioComponent } from '../abm-crear-usuario/abm-crear-usuario.component';

const appRoutes: Routes = [
  {path: 'timeline', component: TimelineComponent},
  {path: 'login', component: LoginFormComponent},
  {path: 'abmusuarios', component: AbmUsuarioComponent,children:[
  {path: 'crearUsuario', component: AbmCrearUsuarioComponent},
  {path: ':id', component: AbmModificarUsuarioComponent}
  ]},
  {path: '**', redirectTo: 'login'}
]

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(appRoutes)
  ],
  declarations: [],

  exports:[
    RouterModule
  ]


})
export class RoutingModule { }
