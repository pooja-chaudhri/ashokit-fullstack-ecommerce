export class Product {

    constructor(
     public productId:number,
	 public name:string,
	 public des:string,
	 public title:string,
	 public unit_price:number,
	 public image_url:string,
	 public unit_stock:number,
	 public active:boolean,
	 public dateCreated:Date,
	 public lastUpdated:Date
	
    ){

    }
}

