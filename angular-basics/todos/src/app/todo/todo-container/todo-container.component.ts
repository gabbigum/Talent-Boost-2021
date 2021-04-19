import { Component, OnInit } from '@angular/core';
import { Todo, TodoService } from '../todo.service';


@Component({
  selector: 'app-todo-container',
  templateUrl: './todo-container.component.html',
  styleUrls: ['./todo-container.component.css']
})
export class TodoContainerComponent implements OnInit {
  
  todo: string;
  

  constructor(public todoService: TodoService) { }

  ngOnInit(): void {
  }
  
  addTodo(todo: string) {
    this.todoService.addTodo(todo);
  }

  saveChanges() {
    this.todoService.saveChanges();
  }
  
  get todos(): Todo[] {
    return this.todoService.items;
  }

}
