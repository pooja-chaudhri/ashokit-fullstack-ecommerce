import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-order-confirmation',
  imports: [],
  templateUrl: './order-confirmation.component.html',
  styleUrl: './order-confirmation.component.css'
})
export class OrderConfirmationComponent {

  productId: number = 1; // Default product ID, replace dynamically if needed

  constructor(private router: Router) {}

  ngOnInit(): void {
    // If you want to set a dynamic product ID, fetch it here
  }

  goToProduct() {
    this.router.navigate(['/product', this.productId]);  // Redirect to `/product/1`
  }
}