import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-contador',
  templateUrl: './contador.component.html',
  styleUrls: ['./contador.component.css']
})
export class ContadorComponent {

  constructor() { }

  @Input() contador : number;
  @Output() nuevoNumero = new EventEmitter<number>();
  
  public aumentar():void{
    this.contador ++; 
    this.nuevoNumero.emit(this.contador);
  }
  
}
