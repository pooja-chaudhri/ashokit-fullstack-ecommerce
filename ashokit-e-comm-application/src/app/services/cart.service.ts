import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';
import { CartItem } from '../dto/cart-item';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  totalPrices:Subject<number> = new BehaviorSubject<number>(0);
  totalQuantity:Subject<number> = new BehaviorSubject<number>(0);

  cartItems :CartItem[] = [];

  constructor() { }

  addtoCart(thecartItem : CartItem){

    let alereadyExistInCart : boolean = false;
    let existingCartItem! : CartItem;

    if (this.cartItems.length > 0) {
      // check item presence is cart based on item id
      for (let tempCartItem of this.cartItems) {
        if (tempCartItem.productId === thecartItem.productId) {
          existingCartItem = tempCartItem;
          alereadyExistInCart = true;
          break;
        }
      }
    }

    if (alereadyExistInCart) {
      existingCartItem.quantity++;
    } else {
      this.cartItems.push(thecartItem);
      console.log("cart item in services " + JSON.stringify(this.cartItems));
    }

    //compute cart values

    this.computeCartTotals();
  }
  computeCartTotals(){

    let totalPricesValue : number = 0;
    let totalQuantityValue : number = 0;

    for(let currentCartItem of this.cartItems){
      totalPricesValue += currentCartItem.quantity * currentCartItem.unit_price;
      totalQuantityValue += currentCartItem.quantity;

      // publish new value for all subscribers

      this.totalPrices.next(totalPricesValue);
      this.totalQuantity.next(totalQuantityValue);
    }
  }

  decrementQuantity(theCartItem: CartItem) {
    theCartItem.quantity--;
    if (theCartItem.quantity == 0) {
      this.remove(theCartItem);
    } else {
      this.computeCartTotals();
    }
  }
  
  remove(theCartItem: CartItem) {
    // get index of item in the array
    const itemIndex = this.cartItems.findIndex(tempCartItem => tempCartItem.productId === theCartItem.productId);
    if(itemIndex > -1){
      this.cartItems.splice(itemIndex, 1);
      this.computeCartTotals();
    }
  }
  clearCart(){
    this.cartItems = [];
    this.totalPrices.next(0); // Reset total price
    this.totalQuantity.next(0); // Reset total quantity
    this.computeCartTotals();
  }
}

