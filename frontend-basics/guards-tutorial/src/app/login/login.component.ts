import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  name: FormControl = new FormControl('', [Validators.required]);

  password: FormControl = new FormControl('', [Validators.required, Validators.minLength(6)]);

  subscription: Subscription = new Subscription();

  constructor(public authService: AuthenticationService,
    public router: Router) { }

  ngOnInit() {
    
  }

  authenticate() {
    event?.preventDefault();
    if(this.authService.authentication(this.name.value, this.password.value)) {
      this.router.navigate(['home']);
    } else {
      console.log('Wrong credentials.')
    }
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }
}
