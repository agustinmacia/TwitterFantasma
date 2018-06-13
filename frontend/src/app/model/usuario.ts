export class Usuario{
    id : number;
    nombre: string;
    email: string;
    esAdmin: boolean;

    constructor(id: number, nombre: string, email: string, esAdmin:boolean){
        this.id= id;
        this.nombre= nombre;
        this.email= email;
        this.esAdmin= esAdmin;
    }

    static crearDesdeJson(json: any): Usuario{
        const usuario = new Usuario(json.id, json.nombre, json.email, json.esAdmin)
        return usuario;
    }
}