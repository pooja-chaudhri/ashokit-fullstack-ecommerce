import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Purchaseorder } from '../dto/purchaseorder';
import { Observable } from 'rxjs';
import { AppConstant } from '../app-constant';

@Injectable({
  providedIn: 'root'
})
export class CheckoutService {

  constructor(private httpClient :  HttpClient) { }

  placeOrder(purchase: Purchaseorder): Observable<any> {
    return this.httpClient.post<Purchaseorder>(AppConstant.order_endpoint,purchase);
  }

}
