import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TodoItemComponent } from './todo-item/todo-item.component';
import { TodoContainerComponent } from './todo-container/todo-container.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    TodoItemComponent,
    TodoContainerComponent
  ],
  exports: [
     TodoContainerComponent
  ],
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class TodoModule { }
