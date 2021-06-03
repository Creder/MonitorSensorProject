import { Component, Input, OnInit } from '@angular/core'; 
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { SensorService } from '../sensor.service';
import { Sensor } from '../sensor';
import { SensorType } from '../sensortype';
import { SensorUnit } from '../sensorunit';

@Component({
  selector: 'app-sensor-add',
  templateUrl: './sensor-add.component.html',
  styleUrls: ['./sensor-add.component.css']
})
export class SensorAddComponent implements OnInit {

 
  sensorUnits: SensorUnit[] = [];

  sensorTypes: SensorType[] = [];
    sensor: Sensor | undefined;
    
    status: any;

  constructor(private sensorService: SensorService , private route: ActivatedRoute,  private location: Location   
  ) { 
    this.getSensor();
  }

  ngOnInit(): void {
    this.getSensorTypes();
    this.getSensorUnits();
  }

  getSensor(){
    const id = Number(this.route.snapshot.paramMap.get('id'));
    if(id === 0){
      this.sensor = {
        id: 0,
        name: '',
        model: '',
        type: {id: 0, typeName: ''},
        unit: {id: 0, unitName: ''},
        rangeFrom: 0,
        rangeTo: 0,
        location: '',
        description: ''
      }
    }
    else{ this.sensorService.getOneSensor(id).subscribe((sensor) => this.sensor = sensor);}
  }

  addSensor(): void{
    if(this.sensor !== undefined){
    this.sensorService.addSensor(this.sensor).subscribe((data) => this.status = data);  
    } 
    this.location.back();
  }

  editSensor(){
    if(this.sensor !== undefined){
      this.sensorService.editSensor(this.sensor).subscribe((data) => this.status = data); 
    }  
    this.location.back(); 
  }

  getSensorTypes(): void{
  	this.sensorService.getSensorUnits().subscribe(sensorUnits => this.sensorUnits = sensorUnits);
  }
  getSensorUnits(): void{
  	this.sensorService.getSensorTypes().subscribe(sensorTypes => this.sensorTypes = sensorTypes);
  }


}
