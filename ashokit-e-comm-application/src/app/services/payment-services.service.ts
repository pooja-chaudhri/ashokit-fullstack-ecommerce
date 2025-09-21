import { Injectable } from '@angular/core';
import { PaymentCallback } from '../dto/payment-callback';
import { HttpClient } from '@angular/common/http';
import { AppConstant } from '../app-constant';
import { CartService } from './cart.service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class PaymentServicesService {

  private RAZORPAY_KEY = 'rzp_test_WtD3p4GzZ9Dwd5';
  
  constructor(private httpClient :  HttpClient,
              private cartServices : CartService,
              private router : Router
  ) { }

  processPayment(orderId: string, amount: number): void {

    console.log("🚀 Order ID Before Initializing Razorpay:", orderId); // Debugging log
    const options: any = {
      key: this.RAZORPAY_KEY,
      amount: Math.round(amount * 100),
      currency: 'INR',
      name: 'Ashok IT',
      description: 'Ecommerce order',
      order_id: orderId,
      handler: (Response:any) =>{

        console.log("Razorpay Response:", Response); // Debugging log


        if(Response && Response.razorpay_payment_id){
          const paymentPayload ={
            razorpayOrderId: Response.razorpay_order_id, // FIXED: Use correct key from Razorpay response
            razorpayPaymentId: Response.razorpay_payment_id,
            razorpaySignature: Response.razorpay_signature 
          };
          this.paymentCallback(paymentPayload);
          this.cartServices.clearCart();
          this.router.navigateByUrl('/order-confirm');
        }
      },
      prefill: {
        name: 'pooja',
        email: 'pschaudhri2003@gmail.com',
        contact: '9797979'
      },
      notes: {
        addres: 'Customer Address'

      },
      theme: {
        "color": "#3399cc"
      }
    };

    const rzp1 = new Razorpay(options);
    rzp1.open();

  }
  paymentCallback(paymentCallback:PaymentCallback):void{
    this.httpClient.put<PaymentCallback>(AppConstant.Putorder_endpoint,paymentCallback)
    .subscribe({
      next:(Response) => console.log("payment callback sucess : ",Response),
      error: (error) => console.log("payment callback failed : ",error)
      
    })
  }
}
