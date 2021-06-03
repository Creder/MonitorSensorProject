import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User;

  constructor(private userService:UserService) { 
  	this.user = {
  		id: 0,
  		username: '',
  		password: '',
  		role: 'guest'
  	};
    
  }
  ngOnInit(): void {
  }

  login(){
    this.userService.login(this.user).subscribe((responce) => this.user = responce);  
  }

}
