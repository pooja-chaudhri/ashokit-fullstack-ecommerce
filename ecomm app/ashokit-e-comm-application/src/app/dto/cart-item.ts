import { Product } from "./product";

export class CartItem {

    productId: number;
    name: string;
    image_url: string;
    unit_price: number;
    quantity: number;

    constructor(product: Product) {
        this.productId = product.productId;
        this.name = product.name;
        this.image_url = product.image_url;
        this.unit_price = product.unit_price;
        this.quantity = 1;
    }
}
