import { Component, EventEmitter, OnInit, Input, Output } from '@angular/core';

@Component({
  selector: 'app-lista-dinamica',
  templateUrl: './lista-dinamica.component.html',
  styleUrls: ['./lista-dinamica.component.css']
})
export class ListaDinamicaComponent{

  constructor() { }

  @Input() personas = ["gaspar", "matute", "diegote"];
  @Output() personaAgregada = new EventEmitter<string>();
  personaNueva : string;
  

  public agregarPersona():void{
    if(this.personaNueva != "") this.personas.push(this.personaNueva);
    this.personaAgregada.emit(this.personaNueva);
    this.personaNueva ="";

  }
}
