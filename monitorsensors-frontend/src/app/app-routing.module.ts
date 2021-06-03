import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SensorsTableComponent} from './sensors-table/sensors-table.component'
import { LoginComponent} from './login/login.component'
import { SensorAddComponent } from './sensor-add/sensor-add.component';

const routes: Routes = [
	{path: '', component: LoginComponent},
	{path: 'sensors', component: SensorsTableComponent},
	{path: 'create', component: SensorAddComponent },
  	{path: 'edit/:id', component: SensorAddComponent }
	];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
