// AppConstant.ts (Inside your Angular source code)

const EC2_HOST = "http://43.204.115.141"; // Your Public IP

export class AppConstant {
    // Product API (Using Public IP and exposed port 8083)
    static prodcuct_endpoint    = EC2_HOST + ":8083/AllProduct";
    static category_endpoint    = EC2_HOST + ":8083/product";
    static Allcategory_endpoint = EC2_HOST + ":8083/category";
    static search_endpoint      = EC2_HOST + ":8083/productByName";

    // Customer API (Using Public IP and exposed port 8081)
    static login_endpoint       = EC2_HOST + ":8081/login"; 
    static register_endpoint    = EC2_HOST + ":8081/register"; 
    static reset_endpoint       = EC2_HOST + ":8081/resetPwd"; 
    static forgot_endpoint      = EC2_HOST + ":8081/forgotpwd"; 

    // Orders API (Using Public IP and exposed port 8082)
    static order_endpoint       = EC2_HOST + ":8082/createOrder"; 
    static Putorder_endpoint    = EC2_HOST + ":8082/updateOrder"; 
}
