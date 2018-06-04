import { Component, OnInit } from '@angular/core';
import { Evento } from '../../Models/evento';
import { EventosService } from '../../Services/eventos.service';
import { Http } from '@angular/http';
import { RouterLink, Router } from '@angular/router';

@Component({
  selector: 'app-crearevento',
  templateUrl: './crearEvento.component.html'
})
export class CrearEventoComponent {
  
  // Definición de variables
  
  public evento : Evento;
  public txtNombre='';
  public txtCuando='';
  public txtDonde='';

  constructor(private servicio: EventosService, public router: Router){
  }

  // Definición de metodos
  crearEvento(){
    
    this.evento = new Evento();
    this.evento.idevento = 0;
    this.evento.nombre = this.txtNombre;
    this.evento.cuando = this.txtCuando;
    this.evento.donde = this.txtDonde;
    this.evento.estado = '1';
    this.servicio.guardarEvento(this.evento).subscribe(
      res => {
        this.txtNombre ="";
        this.txtCuando="";
        this.txtDonde="";
        this.router.navigate(['/Eventos']);
      },
      error => {
        console.log(error);
      },
      () => {
        console.log("Registro creado");
      }
    );

  }

}