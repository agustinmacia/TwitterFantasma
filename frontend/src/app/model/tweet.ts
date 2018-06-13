import { Usuario } from "./usuario";

export class Tweet{
    autor: Usuario;
    mensaje: string;
    fecha: Date;

    constructor(autor: Usuario, mensaje: string, fecha: Date){
        this.autor= autor;
        this.mensaje= mensaje;
        this.fecha = fecha;
    }
}