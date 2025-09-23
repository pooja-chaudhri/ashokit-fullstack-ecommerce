-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: sbms
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address_table`
--

DROP TABLE IF EXISTS `address_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address_table` (
  `address_id` bigint NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `house_num` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zipcode` int DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`address_id`),
  KEY `FK9jyphbb47smhsm4xop2b93xdv` (`customer_id`),
  CONSTRAINT `FK9jyphbb47smhsm4xop2b93xdv` FOREIGN KEY (`customer_id`) REFERENCES `customer_table` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_table`
--

LOCK TABLES `address_table` WRITE;
/*!40000 ALTER TABLE `address_table` DISABLE KEYS */;
INSERT INTO `address_table` VALUES (1,'risod','3','maharashtra','risod',444504,3),(2,'risod','4','maharashtra','risod',444504,4),(3,'risod','4','maharashtra','risod',444504,4),(4,'risod','4','maharashtra','risod',444504,4),(5,'risod','4','maharashtra','risod',444504,4),(6,'risod','4','maharashtra','risod',444504,4),(7,'risod','4','maharashtra','risod',444504,4),(8,'risod','4','maharashtra','risod',444504,4),(9,'risod','4','maharashtra','risod',444504,4),(10,'risod','4','maharashtra','risod',444504,4),(11,'risod','4','maharashtra','risod',444504,4),(12,'risod','4','maharashtra','risod',444504,4),(13,'risod','3','maharashtra','risod',444504,5),(14,'risod','7','maharashtra','risod',444504,4),(15,'risod','7','maharashtra','risod',444504,4),(16,'risod','7','maharashtra','risod',444504,4),(17,'risod','7','maharashtra','risod',444504,4),(18,'risod','7','maharashtra','risod',444504,4),(19,'risod','7','maharashtra','risod',444504,4),(20,'risod','4','maharashtra','risod',444504,6),(21,'risod','3','maharashtra','risod',444504,1),(22,'risod','3','maharashtra','risod',444504,7),(23,'risod','3','maharashtra','risod',444504,8),(24,'risod','6','maharashtra','risod',444504,9),(25,'risod','3','maharashtra','risod',444504,10),(26,'risod','4','maharashtra','risod',444504,11),(27,'risod','4','maharashtra','risod',444504,4),(28,'risod','4','maharashtra','risod',444504,12),(29,'risod','4','maharashtra','risod',444504,13),(30,'risod','4','maharashtra','risod',444504,4);
/*!40000 ALTER TABLE `address_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_table`
--

DROP TABLE IF EXISTS `category_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_table` (
  `category_id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_table`
--

LOCK TABLES `category_table` WRITE;
/*!40000 ALTER TABLE `category_table` DISABLE KEYS */;
INSERT INTO `category_table` VALUES (1,'All'),(2,'Laptops'),(3,'Mobiles'),(4,'Shirts'),(5,'Beauty'),(6,'Grocery');
/*!40000 ALTER TABLE `category_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_table`
--

DROP TABLE IF EXISTS `customer_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_table` (
  `customer_id` bigint NOT NULL AUTO_INCREMENT,
  `phno` decimal(38,0) DEFAULT NULL,
  `created_date` datetime(6) DEFAULT NULL,
  `last_updated_date` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `pwd_updated` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_table`
--

LOCK TABLES `customer_table` WRITE;
/*!40000 ALTER TABLE `customer_table` DISABLE KEYS */;
INSERT INTO `customer_table` VALUES (1,7972697248,'2025-08-20 12:32:55.221000','2025-08-20 12:33:47.278000','pschaudhri2003@gmail.com','pooja shyam chaudhri','$2a$10$kshMR6Ki3Y0ds8JONOtGYOdKqUyFIdqDIxakD/n48v3zefLimaJKq','yes'),(2,867556788,'2025-08-20 12:35:49.526000','2025-08-20 12:35:49.526000','jhon@gmail.com','jhon ','$2a$10$uC9ZIVvdm4GpE3LvUo7l/OXHNSKMCae/3JRWiFiYqVU3Dv6MYfFeu',NULL),(3,92879,NULL,NULL,'ps@gmail.com','pooja shyam chaudhri',NULL,NULL),(4,4936593,NULL,NULL,'pschaudhri@gmail.com','pooja shyam chaudhri',NULL,NULL),(5,863953,NULL,NULL,'lssjoowhl@gmil.com','pooja shyam chaudhri',NULL,NULL),(6,97593793,NULL,NULL,'pschaud@gmail.com','pooja shyam chaudhri',NULL,NULL),(7,937509,NULL,NULL,'pschau@gmail.com','pooja shyam chaudhri',NULL,NULL),(8,398759,NULL,NULL,'lowld@gmil.com','pooja shyam chaudhri',NULL,NULL),(9,897350943,NULL,NULL,'lkdkljeojkjld@gmail.com','pooja shyam chaudhri',NULL,NULL),(10,9385093,NULL,NULL,'poojal@gmail.com','pooja shyam chaudhri',NULL,NULL),(11,97409309,NULL,NULL,'lsjkdfskl@gmail.com','pooja shyam chaudhri',NULL,NULL),(12,9497593,NULL,NULL,'pooja@gmail.com','pooja shyam chaudhri',NULL,NULL),(13,98739,NULL,NULL,'pooja@gmil.com','pooja shyam chaudhri',NULL,NULL);
/*!40000 ALTER TABLE `customer_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item_table`
--

DROP TABLE IF EXISTS `order_item_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_item_table` (
  `order_item_id` bigint NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  PRIMARY KEY (`order_item_id`),
  KEY `FKoqkrponkrckn7yv8x7a3alsf7` (`order_id`),
  CONSTRAINT `FKoqkrponkrckn7yv8x7a3alsf7` FOREIGN KEY (`order_id`) REFERENCES `orders_table` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item_table`
--

LOCK TABLES `order_item_table` WRITE;
/*!40000 ALTER TABLE `order_item_table` DISABLE KEYS */;
INSERT INTO `order_item_table` VALUES (1,'assets/images/products/laptops/acer-laptop-1002.png','ACER - Laptop',1,49.99,1),(2,'assets/images/products/laptops/hp-laptop-1001.png','HP - Laptop',1,59.99,2),(3,'assets/images/products/laptops/dell-laptop-1000.png','DELL - Laptop',1,19.99,3),(4,'https://m.media-amazon.com/images/I/51pNLVL+DKL._SL1000_.jpg','POND\'S  Powder',1,3,3),(5,'assets/images/products/laptops/hp-laptop-1001.png','HP - Laptop',1,59.99,4),(6,'assets/images/products/laptops/hp-laptop-1001.png','HP - Laptop',1,59.99,5),(7,'assets/images/products/laptops/acer-laptop-1002.png','ACER - Laptop',1,49.99,6),(8,'assets/images/products/laptops/hp-laptop-1001.png','HP - Laptop',1,59.99,7),(9,'https://m.media-amazon.com/images/I/51pNLVL+DKL._SL1000_.jpg','POND\'S  Powder',1,3,8),(10,'assets/images/products/laptops/acer-laptop-1002.png','ACER - Laptop',1,49.99,9),(11,'assets/images/products/laptops/hp-laptop-1001.png','HP - Laptop',1,59.99,10),(12,'assets/images/products/laptops/hp-laptop-1001.png','HP - Laptop',1,59.99,11),(13,'assets/images/products/laptops/hp-laptop-1001.png','HP - Laptop',1,59.99,12),(14,'assets/images/products/laptops/hp-laptop-1001.png','HP - Laptop',1,59.99,13);
/*!40000 ALTER TABLE `order_item_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_table`
--

DROP TABLE IF EXISTS `orders_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_table` (
  `order_id` bigint NOT NULL AUTO_INCREMENT,
  `date_created` datetime(6) DEFAULT NULL,
  `delivery_date` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `invoice_url` varchar(255) DEFAULT NULL,
  `last_updated` datetime(6) DEFAULT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `order_tracking_number` varchar(255) DEFAULT NULL,
  `razor_pay_order_id` varchar(255) DEFAULT NULL,
  `razor_pay_payment_id` varchar(255) DEFAULT NULL,
  `total_prices` double DEFAULT NULL,
  `total_quantity` int DEFAULT NULL,
  `address_id` bigint DEFAULT NULL,
  `customer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FKa4cheugo5td4g4x7jjf3joeab` (`address_id`),
  KEY `FKcbbdhehckta7tf50jfac21qb5` (`customer_id`),
  CONSTRAINT `FKa4cheugo5td4g4x7jjf3joeab` FOREIGN KEY (`address_id`) REFERENCES `address_table` (`address_id`),
  CONSTRAINT `FKcbbdhehckta7tf50jfac21qb5` FOREIGN KEY (`customer_id`) REFERENCES `customer_table` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_table`
--

LOCK TABLES `orders_table` WRITE;
/*!40000 ALTER TABLE `orders_table` DISABLE KEYS */;
INSERT INTO `orders_table` VALUES (1,'2025-09-10 13:52:19.473000','2025-09-13','ps@gmail.com',NULL,'2025-09-10 13:52:41.945000','CONFIRMED','OD2025091013521774F90','order_RFpb7NTgUeHDK6','pay_RFpbHGikNWxHD2',49.99,1,1,3),(2,'2025-09-11 15:27:19.385000','2025-09-14','lssjoowhl@gmil.com',NULL,'2025-09-11 15:27:39.325000','CONFIRMED','OD202509111527187ABB8','order_RGFkb4bDxlTQ30','pay_RGFkiDCnQ2QKyj',59.99,1,13,5),(3,'2025-09-12 13:24:44.806000','2025-09-15','pschaud@gmail.com',NULL,'2025-09-12 13:25:14.027000','CONFIRMED','OD202509121324433CB92','order_RGcCFrblr19FMW','pay_RGcCNUjtqup4rk',22.99,2,20,6),(4,'2025-09-12 13:25:54.500000','2025-09-15','pschaudhri2003@gmail.com',NULL,'2025-09-12 13:26:16.849000','CONFIRMED','OD202509121325547FED9','order_RGcDTxw7w2Q3bx','pay_RGcDZjMggiMrHD',59.99,1,21,1),(5,'2025-09-12 20:16:17.637000','2025-09-15','pschau@gmail.com',NULL,'2025-09-12 20:16:57.624000','CONFIRMED','OD202509122016154C346','order_RGjCylpUau3oId','pay_RGjDQEziwyvtsW',59.99,1,22,7),(6,'2025-09-12 20:17:47.609000',NULL,'lowld@gmil.com',NULL,'2025-09-12 20:17:47.609000','created','OD202509122017473F1D1','order_RGjEZBo7cCBwF7',NULL,49.99,1,23,8),(7,'2025-09-12 20:19:48.249000',NULL,'lkdkljeojkjld@gmail.com',NULL,'2025-09-12 20:19:48.249000','created','OD20250912201947F756B','order_RGjGgiApXlcY3I',NULL,59.99,1,24,9),(8,'2025-09-12 20:34:23.435000',NULL,'poojal@gmail.com',NULL,'2025-09-12 20:34:23.435000','created','OD20250912203422459D9','order_RGjW638nFguohA',NULL,3,1,25,10),(9,'2025-09-12 20:42:28.094000',NULL,'lsjkdfskl@gmail.com',NULL,'2025-09-12 20:42:28.094000','created','OD2025091220422666AF4','order_RGjedAHK8uiKe9',NULL,49.99,1,26,11),(10,'2025-09-12 20:52:35.136000','2025-09-15','pschaudhri@gmail.com',NULL,'2025-09-12 20:52:57.727000','CONFIRMED','OD202509122052348D998','order_RGjpJh0d5b5r7v','pay_RGjpShZxElugBg',59.99,1,27,4),(11,'2025-09-12 20:54:16.311000','2025-09-15','pooja@gmail.com',NULL,'2025-09-12 20:54:36.903000','CONFIRMED','OD20250912205416C5CFD','order_RGjr6EiXWBYPss','pay_RGjrDEmv0WqTyh',59.99,1,28,12),(12,'2025-09-12 20:54:59.319000',NULL,'pooja@gmil.com',NULL,'2025-09-12 20:54:59.319000','created','OD20250912205458C67C8','order_RGjrr2mjvkTKj6',NULL,59.99,1,29,13),(13,'2025-09-14 12:35:19.345000','2025-09-17','pschaudhri@gmail.com',NULL,'2025-09-14 12:35:41.541000','CONFIRMED','OD2025091412351789F8B','order_RHOQIOlClKoFN9','pay_RHOQQ42kEVdTz4',59.99,1,30,4);
/*!40000 ALTER TABLE `orders_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_table`
--

DROP TABLE IF EXISTS `product_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_table` (
  `product_id` bigint NOT NULL AUTO_INCREMENT,
  `date_created` varchar(255) DEFAULT NULL,
  `active` bit(1) DEFAULT NULL,
  `des` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `last_updated` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `unit_price` decimal(38,2) DEFAULT NULL,
  `unit_stock` int DEFAULT NULL,
  `category_id` bigint NOT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FKju4vmjxhehnlyp68h8tcfn43h` (`category_id`),
  CONSTRAINT `FKju4vmjxhehnlyp68h8tcfn43h` FOREIGN KEY (`category_id`) REFERENCES `category_table` (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_table`
--

LOCK TABLES `product_table` WRITE;
/*!40000 ALTER TABLE `product_table` DISABLE KEYS */;
INSERT INTO `product_table` VALUES (1,'2025-02-22 17:19:16',_binary '','Processor: Intel Core i5-1235U 12th Generation (up to 4.40 GHz, 12MB 10 Cores)','assets/images/products/laptops/dell-laptop-1000.png',NULL,'DELL - Laptop','DELL-LAPTOP-1000',19.99,100,2),(2,'2025-02-22 17:21:06',_binary '','Processor: Intel Core i5-1235U 12th Generation (up to 4.40 GHz, 12MB 10 Cores)','assets/images/products/laptops/hp-laptop-1001.png',NULL,'HP - Laptop','HP-LAPTOP-1001',59.99,100,2),(3,'2025-02-22 17:21:06',_binary '','Acer Aspire Lite 12th Gen Intel Core i5-1235U Thin and Light Laptop ','assets/images/products/laptops/acer-laptop-1002.png',NULL,'ACER - Laptop','ACER-LAPTOP-1002',49.99,100,2),(4,'2025-02-22 17:21:06',_binary '','Lenovo ThinkPad E14 AMD Ryzen 5','assets/images/products/laptops/lenovo-laptop-1003.png',NULL,'Lenovo ThinkPad E14','LENOVO-LAPTOP-1003',45.00,100,2),(5,'2025-02-22 17:24:31',_binary '','Apple iPhone 13 (128GB) - Green','assets/images/products/mobiles/apple-mobile-1000.png',NULL,'Apple-Iphone','Apple-IPhone-1000',59.00,100,3),(6,'2025-02-22 17:24:31',_binary '','Redmi 13C (Stardust Black, 6GB RAM, 128GB Storage)','assets/images/products/mobiles/redmi-mobile-1001.png',NULL,'Redmi 13C','RED-MI-1001',29.00,100,3),(7,'2025-02-22 17:24:31',_binary '','SAMSUNG Galaxy F14 5G 6GB RAM 128GB STORAGE','assets/images/products/mobiles/samsung-mobile-1002.png',NULL,'Samsung Mobile','SAMSUNG-Galaxy-1002',39.00,100,3),(8,'2025-02-22 17:24:52',_binary '','POCO C65 (Pastel Green 4GB RAM 128GB Storage)','assets/images/products/mobiles/poco-mobile-1003.png',NULL,'POCO C65','POCO C65',49.00,100,3),(9,'2025-02-22 17:26:27',_binary '','Amazon Brand - Symbol Mens Cotton Shirt','assets/images/products/clothes/shirt-1000.png',NULL,'Mens Cotton Shirt','Mens Cotton Shirt',5.00,100,4),(10,'2025-03-06 22:25:00',_binary '','PONDS Natural Glow Face Powder','https://m.media-amazon.com/images/I/51pNLVL+DKL._SL1000_.jpg',NULL,'POND\'S  Powder',' PONDS Powder-30G, Pink',3.00,50,5),(13,'2025-03-06 22:35:35',_binary '','Swiss Beauty Creamy Lipstick','https://m.media-amazon.com/images/I/51IlRKGb7kL._AC_UL480_FMwebp_QL65_.jpg',NULL,'Creamy Lipstick',' Lipstick ',2.00,50,5),(14,'2025-03-06 22:40:31',_binary '','Mascara For Eye Makeup | Jet Black,8.5Ml','https://m.media-amazon.com/images/I/61RH5LWdzoL._AC_UL480_FMwebp_QL65_.jpghttps://m.media-amazon.com/images/I/61RH5LWdzoL._AC_UL480_FMwebp_QL65_.jpg',NULL,'Waterproof Mascara',' Mascara ',2.00,50,5),(15,'2025-03-06 22:45:41',_binary '','Symbol Men Solid Cotton Formal Shirt','https://m.media-amazon.com/images/I/61GtS6IrR7L._AC_UL480_FMwebp_QL65_.jpg',NULL,'Cotton Formal Shirt',' shirts ',4.00,50,4),(16,'2025-03-07 21:32:59',_binary '','Matte Compact Powder For Oily Skin','https://m.media-amazon.com/images/I/61Antu9rCpL._AC_UL480_FMwebp_QL65_.jpg',NULL,'Compact Powder ',' Compact Powder',4.00,100,5);
/*!40000 ALTER TABLE `product_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-09-23 13:51:02
