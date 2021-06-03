import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule} from '@angular/forms';
import { HttpClientModule} from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SensorsTableComponent } from './sensors-table/sensors-table.component';
import { LoginComponent } from './login/login.component';
import { SensorAddComponent } from './sensor-add/sensor-add.component';

@NgModule({
  declarations: [
    AppComponent,
    SensorsTableComponent,
    LoginComponent,
    SensorAddComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
