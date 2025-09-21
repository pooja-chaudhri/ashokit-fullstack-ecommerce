import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { CartService } from '../../services/cart.service';
import { CartItem } from '../../dto/cart-item';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-cart-details',
  imports: [CommonModule,RouterModule],
  templateUrl: './cart-details.component.html',
  styleUrl: './cart-details.component.css'
})
export class CartDetailsComponent implements OnInit{

  cartItems:CartItem[] = [];

  totalPrices:number = 0;
  totalQuantity :number = 0;

  ngOnInit(): void {
    this.listCartDetails();
  }

  constructor(private cartServices:CartService, private authServices:AuthService, private router : Router){}

  listCartDetails(){

    this.cartItems = this.cartServices.cartItems;

    // subscribe cart price
    this.cartServices.totalPrices.subscribe(
      data => this.totalPrices = data
    );

    // subscribe total-quantity
    this.cartServices.totalQuantity.subscribe(
      data=> this.totalQuantity = data
    );

    this.cartServices.computeCartTotals();

  }
    incrementQuantity(theCartItem: CartItem) {
      this.cartServices.addtoCart(theCartItem);
    }
  
    decrementQuantity(theCartItem:CartItem){
      this.cartServices.decrementQuantity(theCartItem);
    }
  
    removeItem(theCartItem: CartItem){
      this.cartServices.remove(theCartItem);
    }
  
  
    goToCheckout() {
        console.log("Button clicked!");

      this.router.navigate(['/checkout']);
    }
}
