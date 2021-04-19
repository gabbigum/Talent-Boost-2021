import { Component, Input, OnInit } from '@angular/core';
import { Todo, TodoService } from '../todo.service';

@Component({
  selector: 'app-todo-item',
  templateUrl: './todo-item.component.html',
  styleUrls: ['./todo-item.component.css']
})
export class TodoItemComponent implements OnInit {
 
  @Input()
  todo: Todo;

  isEditable: boolean = false;

  constructor(private todoService: TodoService) { }

  ngOnInit(): void {
  }

  deleteTodo() {
    this.todoService.deleteTodo(this.todo);
  }

  updateTodo(event :any) {
    if(event.target instanceof HTMLInputElement) {
      this.todoService.updateTodo(this.todo, event.target.value);
      this.toggleEdit();
    }
  }

  toggleEdit() {
    this.isEditable = !this.isEditable;
  }
}
