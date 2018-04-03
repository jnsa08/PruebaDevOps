import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LocalComponent }  from './local/local.component';
import { RemotoComponent } from './remoto/remoto.component';

const routes: Routes = [
  { path: '', redirectTo: '/local', pathMatch: 'full' },
  { path: 'local', component: LocalComponent },
  { path: 'remoto', component: RemotoComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})


export class AppRoutingModule { }
