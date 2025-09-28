export class AppConstant {
  // Product API
  static product_endpoint    = "http://localhost:8083/AllProduct";
  static category_endpoint   = "http://localhost:8083/product";
  static Allcategory_endpoint= "http://localhost:8083/category";
  static search_endpoint     = "http://localhost:8083/productByName";

  // Customer API
  static login_endpoint      = "http://localhost:8081/login"; 
  static register_endpoint   = "http://localhost:8081/register"; 
  static reset_endpoint      = "http://localhost:8081/resetPwd"; 
  static forgot_endpoint     = "http://localhost:8081/forgotpwd"; 

  // Orders API
  static order_endpoint      = "http://localhost:8082/createOrder"; 
  static Putorder_endpoint   = "http://localhost:8082/updateOrder"; 
}
