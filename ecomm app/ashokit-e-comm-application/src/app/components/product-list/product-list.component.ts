import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { CommonModule } from '@angular/common';
import { Product } from '../../dto/product';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { CartItem } from '../../dto/cart-item';
import { CartService } from '../../services/cart.service';


@Component({
  selector: 'app-product-list',
  imports: [CommonModule,RouterModule],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent implements OnInit {

  products: Product[] = [];
  currentCategoryId = 1;
  searchMode: boolean = false;

  constructor(private productService: ProductService,
    private route: ActivatedRoute,private cartServices : CartService
  ) { }

  ngOnInit(): void {

    this.route.paramMap.subscribe(() => {
      this.listProducts();
    })

  }
  listProducts(){
    this.searchMode = this.route.snapshot.paramMap.has("keyword");
    if(this.searchMode){
      this.handelSerchProduct();
    }else{
      this. getAllProduct();
    }
  }

  getAllProduct() {

    // check if "id" param is available

    const hasCategoryId: boolean = this.route.snapshot.paramMap.has("id");

    if (hasCategoryId) {
      this.currentCategoryId = +this.route.snapshot.paramMap.get("id")!;
    } else {
      this.currentCategoryId = 1;
    }

    if (this.currentCategoryId === 1) {

      this.productService.getAllProduct().subscribe(res =>{
        this.products = res .data;
      })
    }
    else{

    this.productService.getProductsByCategoryId(this.currentCategoryId).subscribe(res => {
      this.products = res.data;
    })
  }
  }

  handelSerchProduct(){
    const theKeyword:string = this.route.snapshot.paramMap.get("keyword")!;
    this.productService.searchProduct(theKeyword).subscribe(res => {
      this.products = res.data;
    })
  }


  addToCart(theProduct : Product){
    console.log(`adding to cart :${theProduct.name},${theProduct.unit_price}`);

    const thecartItem = new CartItem(theProduct);

    this.cartServices.addtoCart(thecartItem);
  }
}




  
    
  
 
