import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'garage-ui';
  isAuthenticated = false;

  async logout(): Promise<void> {
    // todo
  }
}
