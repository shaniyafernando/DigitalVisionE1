import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AppComponent } from 'src/app/app.component';

@Component({
  selector: 'app-user-main-page',
  templateUrl: './user-main-page.component.html',
  styleUrls: ['./user-main-page.component.css']
})
export class UserMainPageComponent implements OnInit {

  constructor(private appComponent: AppComponent) { }

  ngOnInit(): void {
  }

  logout(){
    this.appComponent.showPublicDashboard= true;
    this.appComponent.showAdminDashboard = false;
    this.appComponent.showUserDashboard = false;
  }

  deleteAccount(){
    this.appComponent.showPublicDashboard= true;
    this.appComponent.showAdminDashboard = false;
    this.appComponent.showUserDashboard = false;
  }
}
