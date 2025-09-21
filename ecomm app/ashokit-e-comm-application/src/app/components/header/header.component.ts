import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { CartStatusComponent } from '../cart-status/cart-status.component';
import { Observable } from 'rxjs';
import { AuthService } from '../../services/auth.service';
import { SearchComponent } from '../search/search.component';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-header',
  imports: [CommonModule, CartStatusComponent,SearchComponent,RouterModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent implements OnInit {

  isLoggedIn$!: Observable<boolean>;

  constructor(private authService: AuthService) {}

  ngOnInit(): void {
    this.isLoggedIn$ = this.authService.isLoggedIn$;
  }

  logout() {
    this.authService.logout();
  }
}
