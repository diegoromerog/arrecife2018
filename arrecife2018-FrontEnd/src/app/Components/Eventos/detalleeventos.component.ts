import { Component, OnInit } from '@angular/core';
import { Evento } from '../../Models/evento';
import { EventosService } from '../../Services/eventos.service';
import { Http } from '@angular/http';
import { ActivatedRoute } from '@angular/router';
import { RegistroUsuario } from '../../Models/RegistroUsuario';

@Component({
  selector: 'app-detalleeventos',
  templateUrl: './detalleeventos.component.html'
})
export class DetalleEventosComponent implements OnInit {
  
  // Definición de variables
  public registros : RegistroUsuario[]
  public evento : Evento;
  public txtNombreEvento;
  public idevento;

  // Definición de metodos

  // Metodo de Inicio
  ngOnInit(): void {
    
  }
  
  // Constructor
  constructor(private route: ActivatedRoute, private servicio: EventosService){
    this.idevento = route.snapshot.params["id"];

    servicio.getEvento(this.idevento).subscribe(res => 
      { 
        this.evento = res.json(); 
        this.txtNombreEvento = this.evento.nombre;
      }); 

    servicio.getRegistrosByEvento().subscribe(res => 
      { 
        this.registros = res.json(); 
      }); 
  }

}
