import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Digital Vision';

  showPublicDashboard: boolean = false;
  showUserDashboard: boolean = false;
  showAdminDashboard: boolean = true;
}
