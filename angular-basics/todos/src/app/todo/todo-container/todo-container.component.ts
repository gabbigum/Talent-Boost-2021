import { Component, OnInit } from '@angular/core';
import { Todo, TodoService } from '../todo.service';


@Component({
  selector: 'app-todo-container',
  templateUrl: './todo-container.component.html',
  styleUrls: ['./todo-container.component.css']
})
export class TodoContainerComponent implements OnInit {

  constructor(public todoService: TodoService) { }

  isTodoItemClicked: boolean = false;

  ngOnInit(): void {
  }
  
  addTodo(todo: string) {
    
  }
  
  get todos(): Todo[] {
    return this.todoService.items;
  }

  submitForm(event :any) {
    // const todo = event.target.todo.value;
    if(event.target && event.target.todo) {
      this.todoService.addTodo(event.target.todo.value);
    }
  }

}
