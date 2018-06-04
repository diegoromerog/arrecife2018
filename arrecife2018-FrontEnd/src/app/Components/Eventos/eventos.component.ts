import { Component, OnInit } from '@angular/core';
import { Evento } from '../../Models/evento';
import { EventosService } from '../../Services/eventos.service';
import { Http } from '@angular/http';

@Component({
  selector: 'app-eventos',
  templateUrl: './eventos.component.html'
})
export class EventosComponent implements OnInit {
  
  // Definición de variables
  public eventos : Evento[];

  // Definición de metodos

  // Metodo de Inicio
  ngOnInit(): void {
    
  }
  
  // Constructor
  constructor(private servicio: EventosService){
    
    servicio.getEventos().subscribe(res => {
      this.eventos = res.json();
    });

  }

  

}