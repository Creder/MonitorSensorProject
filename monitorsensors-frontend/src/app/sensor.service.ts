import { Injectable } from '@angular/core';
import { Sensor } from './sensor';
import { SensorType } from './sensortype';
import { SensorUnit } from './sensorunit';
import { from, Observable, of} from 'rxjs';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { catchError, map, tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SensorService {
	private sensorsUrl = 'http://localhost:8080/MonitorSensors_war/';
	httpOptions = {
		headers: new HttpHeaders({'Content-Type' : 'application/json'})
	}
  constructor(
  	private http: HttpClient) { 
  	}

getSensors(): Observable<Sensor[]>{
  	return this.http.get<Sensor[]>(this.sensorsUrl+"sensors").pipe(catchError(this.handleError<Sensor[]>('getSensors', [])))
}

getOneSensor(id: number): Observable<Sensor>{
	return this.http.get<Sensor>(this.sensorsUrl+"sensors/"+id).pipe(catchError(this.handleError<Sensor>(`getSensor id=${id}`)));
}

addSensor(sensor: Sensor): Observable<Boolean>{
	return this.http.post<Boolean>(this.sensorsUrl+"sensors/create", sensor, {responseType: 'text' as 'json'}).pipe(catchError(this.handleError<Boolean>(`addSensor`)));
}

editSensor(sensor: Sensor): Observable<Boolean>{
  	return this.http.put<Boolean>(this.sensorsUrl+"sensors/"+sensor.id+"/edit", sensor, {responseType: 'text' as 'json'}).pipe(catchError(this.handleError<Boolean>(`editSensor id=${sensor.id}`)));
}

deleteSensor(id: number): Observable<Sensor>{
	return this.http.delete<Sensor>(this.sensorsUrl+"sensors/"+id+"/delete", {responseType: 'text' as 'json'}).pipe(catchError(this.handleError<Sensor>(`deleteSensor id=${id}`)));
}

getSensorTypes(): Observable<SensorType[]>{	
	return this.http.get<SensorType[]>(this.sensorsUrl+"types").pipe(catchError(this.handleError<SensorType[]>('getSensorTypes', [])))
}

getSensorUnits(): Observable<SensorUnit[]>{
	return this.http.get<SensorUnit[]>(this.sensorsUrl+"units").pipe(catchError(this.handleError<SensorUnit[]>('getSensorUnits', [])))
}

  private handleError<T>(operation = 'operation', result?: T){
	  return(error: any): Observable<T> => {
		  console.error(error);
		  return of(result as T);
	  }
  }

}
