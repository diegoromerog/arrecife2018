import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule} from '@angular/forms';

import { AppComponent } from '../Components/App/app.component';
import { CrearEventoComponent } from '../Components/CrearEvento/crearEvento.component';
import { EventosComponent } from '../Components/Eventos/eventos.component';
import { EventosService } from '../Services/eventos.service';
import { HttpModule } from '@angular/http';
import { DetalleEventosComponent } from '../Components/Eventos/detalleeventos.component';

const appRoutes: Routes = [
  {path: '', component: EventosComponent},
  {path: 'Eventos', component: EventosComponent},
  {path: 'DetalleEvento/:id', component: DetalleEventosComponent},
  {path: 'CrearEvento', component: CrearEventoComponent}
] 

@NgModule({
  declarations: [
    AppComponent,
    EventosComponent,
    DetalleEventosComponent,
    CrearEventoComponent
  ],
  imports: [
    HttpModule,
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [EventosService],
  bootstrap: [AppComponent]
})
export class AppModule { }
