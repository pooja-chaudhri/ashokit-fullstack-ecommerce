
# 🛒 Full Stack E-Commerce Application

This project is a **Full Stack E-Commerce Application** built with:
- **Backend**: Java, Spring Boot, Microservices, REST APIs, JPA
- **Frontend**: Angular
- **Database**: MySQL (with preloaded schema & data)
- **Containerization**: Docker & Docker Compose

---

## ⚙️ Prerequisites

- **AWS EC2 instance** (Ubuntu recommended)
- **Docker** & **Docker Compose** installed
- **Git** installed

---

## ✨ Features

- 👤 **User Authentication**: Login & Registration functionality
- 🛍 **Product Catalog**: Browse all available products
- 🔎 **Search**: Quickly find products by name
- 🗂 **Filter by Category**: View products based on selected categories
- 🛒 **Order Booking**: Add products to cart and place an order
- 📦 **Order Management**: Manage placed orders

---

## 🎬 Demo Video

You can **download or watch the demo video** here:
[Demo Video](https://github.com/pooja-chaudhri/ashokit-fullstack-ecommerce/blob/main/ashokit-e-comm-application/public/Demo%20Link.mp4)

---

## 💻 Run on EC2

I have successfully deployed and run this application on an **AWS EC2 instance**. Anyone can also deploy it on their **own EC2 instance** using the steps below:

```bash
# SSH into your EC2 instance
ssh -i your-key.pem ubuntu@<EC2-IP>

# Install Docker & Docker Compose
sudo apt update -y
sudo apt install -y docker.io docker-compose git -y
sudo systemctl enable docker
sudo systemctl start docker

# Clone the repository
git clone https://github.com/pooja-chaudhri/ashokit-fullstack-ecommerce.git
cd ashokit-fullstack-ecommerce

# Start all services
sudo docker-compose up -d
```

> I have personally run the application this way on an EC2 instance. Anyone following these steps can deploy it on their own EC2 machine and run the full application.

---

### 🗄 MySQL Database

- **Database Name:** `sbms`
- **Username:** `root`
- **Password:** `root`
- The database is automatically created when you run `docker-compose up`.
- **Preloaded Data:** `Dump20250923.sql`

---

## 🏗 Architecture Diagram

```
+-----------------+        +-------------------+        +-----------------+
| Angular Frontend|  --->  | REST APIs (Spring)|  --->  |     MySQL DB    |
|  (Products,     |        | Customer, Orders, |        |  Database sbms  |
|   Orders, etc.) |        | Product APIs)     |        |                 |
+-----------------+        +-------------------+        +-----------------+
```

---

## 📁 ashokit-fullstack-ecommerce/
│
├─ customer-api/           # Spring Boot API for Customer
├─ orders-api/             # Spring Boot API for Orders
├─ product-api/            # Spring Boot API for Product
│
├─ angular-frontend/       # Angular Frontend application
│
├─ Dump20250923.sql        # MySQL preloaded database
├─ docker-compose.yml      # Docker Compose configuration
└─ README.md               # Project documentation
```
