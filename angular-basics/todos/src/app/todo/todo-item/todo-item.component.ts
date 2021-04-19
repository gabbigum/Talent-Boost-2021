import { Component, Input, OnInit } from '@angular/core';
import { Todo, TodoService } from '../todo.service';

@Component({
  selector: 'app-todo-item',
  templateUrl: './todo-item.component.html',
  styleUrls: ['./todo-item.component.css']
})
export class TodoItemComponent implements OnInit {
 
  @Input()
  task: Todo;

  isEditable: boolean = false;

  constructor(private todoService: TodoService) { }

  ngOnInit(): void {
  }

  deleteTodo() {
    this.todoService.deleteTodo(this.task);
  }

}
