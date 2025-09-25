export class AppConstant {
    static prodcuct_endpoint    = "http://localhost:8083/AllProduct";
    static category_endpoint    = "http://localhost:8083/product";
    static Allcategory_endpoint = "http://localhost:8083/category";
    static search_endpoint      = "http://localhost:8083/productByName";

    static login_endpoint = "http://customer-api:8081/login";
    static register_endpoint = "http://customer-api:8081/register";
    static reset_endpoint = "http://customer-api:8081/resetPwd";
    static forgot_endpoint = "http://customer-api:8081/forgotpwd";

     // Orders API
    static order_endpoint      = "http://orders-api:8082/createOrder";
    static Putorder_endpoint   = "http://orders-api:8082/updateOrder";

}
