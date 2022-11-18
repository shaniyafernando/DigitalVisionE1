import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  hide = true;

  email = new FormControl('',[Validators.email,Validators.required]);
  username = new FormControl('',[Validators.required]);
  password  = new FormControl('',[Validators.required,Validators.minLength(8)]);

  loginForm!: FormGroup 

  get formControls() { return this.loginForm.controls; }

  constructor(private fb : FormBuilder, private router: Router) { }

  ngOnInit(): void {
    this.buildLoginForm();
  }

  buildLoginForm(){
    this.fb.group({
      email: this.email,
      username: this.username,
      password: this.password
    });
  }

  navigateToLogin(){
    this.router.navigate(['/login']);
  }

}
