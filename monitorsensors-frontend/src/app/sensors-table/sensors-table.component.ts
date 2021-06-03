import { Component, OnInit, } from '@angular/core';
import { Sensor } from '../sensor'; 
import { SensorService } from '../sensor.service'
@Component({
  selector: 'app-sensors-table',
  templateUrl: './sensors-table.component.html',
  styleUrls: ['./sensors-table.component.css']
})
export class SensorsTableComponent implements OnInit {
	sensors: Sensor[] = [];
  status: any;
  constructor(private sensorService: SensorService) { 
  	}

  ngOnInit(): void {
  	this.getSensors();
  }

  getSensors(): void{
  	this.sensorService.getSensors().subscribe(sensors => this.sensors = sensors);
  }

  deleteSensor(id: number): void {
    console.log(id);
    this.sensorService.deleteSensor(id).subscribe(status => this.status = status);
  }

}
