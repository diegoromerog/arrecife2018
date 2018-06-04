import { Injectable } from "@angular/core";
import { Http, Headers, ConnectionBackend, RequestOptions } from "@angular/http";
import { Evento } from "../Models/evento";

@Injectable()
export class EventosService{

    API_ENDPOINT = "http://172.17.0.18:9096/v1";

    private eventos: Evento[];

    constructor(private http: Http){
    }

    public guardarEvento(evento: Evento){
        const headers = new Headers({"Content-Type": "application/json"});
        return this.http.post(this.API_ENDPOINT + '/eventos', evento, {headers: headers});
    }

    public getEventos(){
        const headers = new Headers({"Content-Type": "application/json"});
        return this.http.get(this.API_ENDPOINT + '/eventos', {headers: headers});
    }

    public getEvento(id: number){
        const headers = new Headers({"Content-Type": "application/json"});
        return this.http.get(this.API_ENDPOINT + '/eventos/' + id, {headers: headers});
    }

    public getRegistrosByEvento(){
        const headers = new Headers({"Content-Type": "application/json"});
        return this.http.get(this.API_ENDPOINT + '/registrousuarios', {headers: headers});
    }
    

}