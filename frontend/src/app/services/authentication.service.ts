import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }

  // public signIn(userData: User){
  //   localStorage.setItem('ACCESS_TOKEN', "access_token");
  // }
  // public isLoggedIn(){
  //   return localStorage.getItem('ACCESS_TOKEN') !== null;
  // }
  // public logout(){
  //   localStorage.removeItem('ACCESS_TOKEN');
  // }
}
