
# Ashokit Fullstack E-Commerce Application

This is a **full-stack e-commerce application** developed using **Angular** (frontend), **Spring Boot** (backend APIs), and **MySQL** (database). The application is dockerized and can be deployed on **AWS EC2**.

---

## **Project Overview**

- **Frontend:** Angular  
- **Backend APIs:** Spring Boot (Customer API, Orders API, Product API)  
- **Database:** MySQL  
- **Deployment:** Docker, Docker Compose, EC2  

---

## **Docker Compose Services**

```yaml
services:
  mysql-db:
    image: mysql:8
    container_name: mysql-db
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: sbms
    ports:
      - "3306:3306"

  customer-api:
    image: poojachaudhri/customer-api:latest
    container_name: customer-api
    ports:
      - "8081:8081"
    depends_on:
      - mysql-db

  orders-api:
    image: poojachaudhri/orders-api:latest
    container_name: orders-api
    ports:
      - "8082:8082"
    depends_on:
      - mysql-db

  product-api:
    image: poojachaudhri/product-api:latest
    container_name: product-api
    ports:
      - "8083:8083"
    depends_on:
      - mysql-db

  angular-frontend:
    image: poojachaudhri/angular-frontend:latest
    container_name: angular-frontend
    ports:
      - "4200:80"
    depends_on:
      - customer-api
      - orders-api
      - product-api
```

## **Accessing the Application on EC2**

- Angular Frontend: http://<EC2_PUBLIC_IP>:4200  
- Customer API: http://<EC2_PUBLIC_IP>:8081  
- Orders API: http://<EC2_PUBLIC_IP>:8082  
- Product API: http://<EC2_PUBLIC_IP>:8083  

Replace `<EC2_PUBLIC_IP>` with your EC2 instance’s public IP.

---

## **API Endpoints**

**Customer API**  
- POST /register - Register a new customer  
- POST /login - Customer login  
- POST /resetPwd - Reset password  
- GET /forgotpwd/{email} - Forgot password  

**Orders API**  
- POST /createOrder - Create an order  
- PUT /updateOrder - Update an order  

**Product API**  
- GET /AllProduct - List all products  
- GET /product - Get product details  
- GET /category - List all categories  
- GET /productByName - Search product by name  

---

## **Setup & Run**

Clone the repository:

```bash
git clone <YOUR_REPO_URL>
cd ashokit-fullstack-ecommerce
```

Run Docker Compose:

```bash
docker-compose up -d
```

Access the frontend and APIs using the EC2 public IP and exposed ports.

---

## **Technologies Used**

- Angular  
- Spring Boot, Spring Security, Spring Data JPA  
- MySQL  
- Docker, Docker Compose  
- AWS EC2  

---

## **Author**

Pooja Chaudhri  
[LinkedIn](https://www.linkedin.com/in/pooja-chaudhri)
