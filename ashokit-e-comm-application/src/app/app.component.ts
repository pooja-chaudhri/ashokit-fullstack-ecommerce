import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { ProductListComponent } from './components/product-list/product-list.component';
import { ProductCategoryMenuComponent } from './components/product-category-menu/product-category-menu.component';
import { SearchComponent } from './components/search/search.component';
import { CartStatusComponent } from './components/cart-status/cart-status.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { HeaderComponent } from './components/header/header.component';


@Component({
  selector: 'app-root',
  imports: [RouterModule,ProductCategoryMenuComponent,SearchComponent,CartStatusComponent ,FormsModule,LoginComponent,RegisterComponent,ForgotPasswordComponent,HeaderComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Ashokit_e-comm_application';

  searchQuery: string = '';

  search() {
    alert(`Searching for: ${this.searchQuery}`);
  }


}

