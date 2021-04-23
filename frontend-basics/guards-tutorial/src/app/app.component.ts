import { Component, OnInit } from '@angular/core';
import '@cds/core/password/register.js';
import '@cds/core/input/register.js';
import '@cds/core/button/register.js';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'guards-tutorial';
}
