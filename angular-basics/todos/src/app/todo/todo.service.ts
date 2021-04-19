import { Injectable } from '@angular/core';

export interface Todo {
  label: string;
}

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  items: Todo[] = [];

  constructor() { }


  addTodo(todo: string) {
    if(!todo) {
      return;
    }

    this.items.push({label: todo});
  }

  // delete method
  deleteTodo(todo: Todo) {
    this.items = this.items.filter((item) => todo !== item)
  }

  saveChanges() {
    // do nothing
  }
}
