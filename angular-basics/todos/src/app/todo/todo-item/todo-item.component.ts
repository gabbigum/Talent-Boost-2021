import { Component, ElementRef, HostListener, Input, OnInit } from '@angular/core';
import { Todo, TodoService } from '../todo.service';

@Component({
  selector: 'app-todo-item',
  templateUrl: './todo-item.component.html',
  styleUrls: ['./todo-item.component.css']
})
export class TodoItemComponent implements OnInit {
 
  @HostListener(
    "todoItemWasClicked",
    ["$event"]
  )
  clickedOutside(event: MouseEvent) {
    if(this.element.nativeElement !== event.target && this.isEditable) {
      this.toggleEdit();
    }
  
    /*
    const el = findChild(this.element.nativeElement, event.target as any);
    console.log(el, ' asdfasdf');
    console.log(event.target);
    if(!el && this.isEditable && this.element.nativeElement !== event.target) {
      this.toggleEdit();
    }
    return true;*/
  }

  @Input()
  todo: Todo;

  isEditable: boolean = false;

  constructor(private todoService: TodoService, 
              private element: ElementRef) {
                

  }

  ngOnInit(): void {
  }

  clickedInput() {
    this.element.nativeElement.dispatchEvent(new Event("todoItemWasClicked", {}));
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
    console.log('asdf')
  }
}

const findChild = (node: HTMLElement, childNode: HTMLElement) => {
  
  if(node && node.children.length) {
    const children = Object.values(node.children);
    let el: any = children.find(node => node === childNode);
    console.log(el);
    
    if(!el) {
      el = children.reduce((_, curr) => {
        return findChild(curr as any, childNode);
      });
    } 
    return el;
  }
  return null;
}

