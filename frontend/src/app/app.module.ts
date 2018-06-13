import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {FormsModule} from '@angular/forms';
import { ListaDinamicaComponent } from './lista-dinamica/lista-dinamica.component';
import { ContadorComponent } from './contador/contador.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { TimelineComponent } from './timeline/timeline.component';
import { TimelineService } from './services/timeline.service';
import { RoutingModule } from './routing/routing.module';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { AbmUsuarioComponent } from './abm-usuario/abm-usuario.component';
import { UsuarioService } from './services/usuario.service';
import { AbmModificarUsuarioComponent } from './abm-modificar-usuario/abm-modificar-usuario.component';
import { AbmCrearUsuarioComponent } from './abm-crear-usuario/abm-crear-usuario.component';
import { AuthService } from './services/auth.service';
import { TwittearComponent } from './twittear/twittear.component';
import { PerfilComponent } from './perfil/perfil.component';


@NgModule({
  declarations: [
    AppComponent,
    ListaDinamicaComponent,
    ContadorComponent,
    LoginFormComponent,
    TimelineComponent,
    AbmUsuarioComponent,
    AbmModificarUsuarioComponent,
    AbmCrearUsuarioComponent,
    TwittearComponent,
    PerfilComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RoutingModule,
    HttpClientModule
  ],
  providers: [
    TimelineService,
    UsuarioService,
    AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
