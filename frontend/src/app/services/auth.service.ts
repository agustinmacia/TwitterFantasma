import { Injectable } from "@angular/core";
import { Credenciales } from "../model/credenciales";
import { Observable } from "rxjs/Observable";
import {HttpClient} from '@angular/common/http';




@Injectable()
export class AuthService{

    constructor(private http: HttpClient){ }

    loguear(credencial: Credenciales): Observable<void>{
        return this.http.post<void>('/api/rest/autorizacion',credencial);
    }
}