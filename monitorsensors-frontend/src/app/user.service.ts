import { Injectable } from '@angular/core';
import { User} from './user';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class UserService {
  private url = 'http://localhost:8080/MonitorSensors_war/';
	httpOptions = {
		headers: new HttpHeaders({'Content-Type' : 'application/json'})
	}
  constructor(private http: HttpClient) { }

  login(user: User): Observable<User>{
    return this.http.post<User>(this.url+"login", user).pipe(catchError(this.handleError<User>(`getUser `)));
  }
  
  private handleError<T>(operation = 'operation', result?: T){
	  return(error: any): Observable<T> => {
		  console.error(error);
		  return of(result as T);
	  }
  }
}
