import { Component, OnInit } from '@angular/core';
import { CartService } from '../../services/cart.service';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cart-status',
  imports: [RouterModule,CommonModule],
  templateUrl: './cart-status.component.html',
  styleUrl: './cart-status.component.css'
})
export class CartStatusComponent implements OnInit{

  totalPrices: number = 0;
  totalQuantity: number = 0;

  constructor(private cartService: CartService) { }

  ngOnInit(): void {
    this.updateCartStatus();
  }

  updateCartStatus() {
    this.cartService.totalPrices.subscribe(
      data => this.totalPrices = data
    );
    this.cartService.totalQuantity.subscribe(
      data => this.totalQuantity = data
    );
  }
}
