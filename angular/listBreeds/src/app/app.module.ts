import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule} from '@angular/http';


import { AppComponent } from './app.component';
import { LocalComponent } from './local/local.component';
import { RemotoComponent } from './remoto/remoto.component';
import { RazasService } from './razas.service';
import { AppRoutingModule } from './/app-routing.module';
import { ImageDetailBreedComponent } from './image-detail-breed/image-detail-breed.component';


@NgModule({
  declarations: [
    AppComponent,
    LocalComponent,
    RemotoComponent,
    ImageDetailBreedComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpModule
  ],
  providers: [RazasService],
  bootstrap: [AppComponent]
})
export class AppModule { }
