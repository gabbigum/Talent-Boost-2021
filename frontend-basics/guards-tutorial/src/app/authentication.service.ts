import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Account } from './account';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  accUrl = 'http://localhost:4200/assets/accounts.json';

  accounts: BehaviorSubject<Account[]> = new BehaviorSubject([] as Account[]);

  authenticatedUser: Account | undefined;

  constructor(private http: HttpClient) { 
    this.getAccounts();
    const acc = localStorage.getItem("account");
    if(acc) {
      this.authenticatedUser = JSON.parse(acc);
    }
  }

  getAccounts() {
    this.http.get<Account[]>(this.accUrl).subscribe((accounts) => {
       this.accounts.next(accounts);
       console.log(this.accounts);
    });
  }
  
  authentication(name: string, password: string) : boolean {
    const acc: Account | undefined = this.accounts.value.find((account) => {
      return account.name == name && account.password == password;
    }
    );
    this.authenticatedUser = acc;
    localStorage.setItem("account", JSON.stringify(this.authenticatedUser));

    return this.authenticatedUser ? true : false;
  }
}
