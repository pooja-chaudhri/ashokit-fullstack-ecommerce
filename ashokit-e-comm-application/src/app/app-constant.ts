export class AppConstant {
  // Product API
  static product_endpoint    = "http://43.204.220.254:8083/AllProduct";
  static category_endpoint   = "http://43.204.220.254:8083/product";
  static Allcategory_endpoint= "http://43.204.220.254:8083/category";
  static search_endpoint     = "http://43.204.220.254:8083/productByName";

  // Customer API
  static login_endpoint      = "http://43.204.220.254:8081/login"; 
  static register_endpoint   = "http://43.204.220.254:8081/register"; 
  static reset_endpoint      = "http://43.204.220.254:8081/resetPwd"; 
  static forgot_endpoint     = "http://43.204.220.254:8081/forgotpwd"; 

  // Orders API
  static order_endpoint      = "http://43.204.220.254:8082/createOrder"; 
  static Putorder_endpoint   = "http://43.204.220.254:8082/updateOrder"; 
}
