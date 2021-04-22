import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { AuthenticationService } from './authentication.service';
import '@cds/core/password/register.js';
import '@cds/core/input/register.js';
import '@cds/core/button/register.js';
import { FormControl, Validators } from '@angular/forms';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'guards-tutorial';
}
