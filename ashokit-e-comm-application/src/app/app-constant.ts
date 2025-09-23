export class AppConstant {

    static prodcuct_endpoint = "http://product-api:8081/AllProduct";
    static category_endpoint = "http://product-api:8081/product";
    static Allcategory_endpoint = "http://product-api:8081/category";
    static search_endpoint = "http://product-api:8081/productByName";

    static order_endpoint = "http://orders-api:8081/createOrder";
    static Putorder_endpoint = "http://orders-api:8081/updateOrder";

    static login_endpoint = "http://customer-api:8081/login";
    static register_endpoint = "http://customer-api:8081/register";
    static reset_endpoint = "http://customer-api:8081/resetPwd";
    static forgot_endpoint = "http://customer-api:8081/forgotpwd";
}
