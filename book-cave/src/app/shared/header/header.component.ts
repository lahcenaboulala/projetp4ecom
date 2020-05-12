import { Component, OnInit, Input } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  @Input() pageTitle: string;
  constructor(private authservice: AuthenticationService, private router: Router) { }

  ngOnInit() {
  }

  logout() {
    this.authservice.logout();
    this.router.navigate(['/login']);
  }

}
