import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { CartService } from '../../services/cart.service';
import { CheckoutService } from '../../services/checkout.service';
import { Order } from '../../dto/order';

import { Purchaseorder } from '../../dto/purchaseorder';
import { Orderitems } from '../../dto/orderItems';
import { PaymentServicesService } from '../../services/payment-services.service';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-checkout',
  standalone: true,
  imports: [ CommonModule, RouterModule, FormsModule, ReactiveFormsModule],
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  totalPrices: number = 0;
  totalQuantity: number = 0;

  checkoutFormGroup!: FormGroup;

  razorpayOrderId: string ="";
 

  constructor(private frombuilder : FormBuilder,
    private cartService: CartService,
    private checkoutService: CheckoutService,
    private paymentServices: PaymentServicesService,
    private router : Router
  ){}

  ngOnInit(): void {

    this.reviewCartDetails();
    this.checkoutFormGroup = this.frombuilder.group({
      
      customer: this.frombuilder.group({
        name: [''],
        email: [''],
        phno: ['']
      }),

      
      address: this.frombuilder.group({
        street: [''],
        city: [''],
        state: [''],
        houseNum: [''],
        zipcode: ['']
      }),
    })   
  }

  get getName() { return this.checkoutFormGroup.get('customer.name'); }
  get email() { return this.checkoutFormGroup.get('customer.email'); }
  get phno() { return this.checkoutFormGroup.get('customer.phno'); }

  get AddressStreet() { return this.checkoutFormGroup.get('address.street'); }
  get AddressCity() { return this.checkoutFormGroup.get('address.city'); }
  get AddressState() { return this.checkoutFormGroup.get('address.state'); }
  get AddressZipcode() { return this.checkoutFormGroup.get('address.zipcode'); }
  get AddressHouseNum() { return this.checkoutFormGroup.get('address.houseNum'); }


  onSubmit() {

    // setup order
    let order = new Order(this.totalQuantity, this.totalPrices);


    // setup order items
    const cartItems = this.cartService.cartItems;
    console.log("Cart Items after  mapping:", cartItems);
    let orderItem: Orderitems[] = cartItems.map(tempCartItem => new Orderitems(tempCartItem.image_url!, tempCartItem.name, tempCartItem.unit_price!, tempCartItem.quantity, tempCartItem.productId!));


    // setup purchase  order
    let purchase = new Purchaseorder();

    // set customer data to purchase order
    purchase.customer = this.checkoutFormGroup.controls['customer'].value;

    // set address data to purchase order
    purchase.address = this.checkoutFormGroup.controls['address'].value;

    // set order
    purchase.order = order;

    // set order items 
    purchase.orderItems = orderItem;
    console.log("Cart Items before mapping:", cartItems);

    // make backend api call


    this.checkoutService.placeOrder(purchase).subscribe(response => {

      console.log("📦 Backend Response in Component:", JSON.stringify(response));
      const responseData = response.data;
      console.log("component response :"+JSON.stringify(response));
      this.razorpayOrderId =  responseData.razorPayOrderId;
      console.log("Extracted Order ID:", this.razorpayOrderId);
      this.paymentServices.processPayment(responseData.razorPayOrderId, this.totalPrices);

      
    })
    
  }

  reviewCartDetails() {

    // subscribe to cartService.totalQuantity
    this.cartService.totalPrices.subscribe(
      data => this.totalPrices = data
    );

    // subscribe to cartService.totalPrice
    this.cartService.totalQuantity.subscribe(
      data => this.totalQuantity = data
    );

    
  }
}
