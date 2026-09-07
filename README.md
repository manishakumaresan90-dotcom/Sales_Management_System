# Sales_Management_System
Java-based Sales Management System using JDBC, MySQL, and layered architecture. It manages products, customers, sales transactions, and stock efficiently. The system follows Model, Controller, Service, Repository, and Database layers, providing CRUD operations and database connectivity. It is designed for maintenance, reusability, and scalability.
# Sales Management System

A simple **Sales Management System** developed using **Java, JDBC, and MySQL**. The application allows users to manage product information through a console-based menu and perform basic CRUD operations.

## 📌 Project Overview

The Sales Management System is a Java-based application designed to manage product details efficiently. It connects Java with a MySQL database using **JDBC (Java Database Connectivity)**.

The system allows users to:

* Add new products
* View all products
* Update existing products
* Delete products
* Store and manage product information in MySQL

## 🛠️ Technologies Used

* **Java** – Application development
* **JDBC** – Connects Java application with MySQL
* **MySQL** – Database for storing product information
* **Maven** – Dependency management and project build
* **Eclipse** – Development environment

## 📂 Project Structure

```text
salesmanagement/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/sales/main/
│   │   │   │   └── Mainapp.java
│   │   │   │
│   │   │   └── org/anudip/sms/
│   │   │       ├── controller/
│   │   │       │   └── Productcontroller.java
│   │   │       ├── dao/
│   │   │       │   └── Productdao.java
│   │   │       ├── database/
│   │   │       │   └── Dbconnection.java
│   │   │       ├── model/
│   │   │       │   └── Product.java
│   │   │       └── main/
│   │   │           └── Main.java
│   │   │
│   │   └── resources/
│   │
│   └── test/
│
├── pom.xml
└── README.md
```

## ⚙️ Features

### 1. Add Product

Allows the user to add a new product by entering:

* Product name
* Price
* Stock quantity

### 2. View Products

Displays all products stored in the MySQL database, including:

* Product ID
* Product name
* Price
* Stock quantity

### 3. Update Product

Allows the user to update the details of an existing product using its Product ID.

### 4. Delete Product

Allows the user to delete a product from the database using its Product ID.

## 🗄️ Database

The project uses a MySQL database named:

```text
sales_management
```

Create the database using:

```sql
CREATE DATABASE sales_management;
```

Create the required `products` table:

```sql
CREATE TABLE products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(100) NOT NULL,
    price DOUBLE NOT NULL,
    quantity INT NOT NULL
);
```

## 🔌 JDBC Connection

JDBC is used to establish communication between the Java application and MySQL database.

The application uses:

```text
jdbc:mysql://localhost:3306/sales_management
```

Before running the project, update the MySQL username and password in:

```text
Dbconnection.java
```

Example:

```java
String user = "root";
String password = "your_password";
```

**Do not upload your actual database password to GitHub.**

## ▶️ How to Run

### Step 1: Install Requirements

Make sure you have:

* Java JDK
* MySQL Server
* Maven
* Eclipse or another Java IDE

### Step 2: Create Database

Open MySQL and execute:

```sql
CREATE DATABASE sales_management;
```

Then create the `products` table using the SQL provided above.

### Step 3: Configure Database

Update the username and password in `Dbconnection.java`.

### Step 4: Run the Project

Run:

```text
Main.java
```

The application will display:

```text
--- Product Management ---
1. Add New Product
2. View All Products
3. Update Product
4. Delete Product
```

Choose an option and follow the instructions displayed in the console.

## 🔄 Application Flow

```text
User
  ↓
Product Controller
  ↓
Product DAO
  ↓
JDBC
  ↓
MySQL Database
  ↓
Product Data
```

## 🧩 Architecture

The project follows a simple layered structure:

**Model**
Stores product information such as ID, name, price, and quantity.

**Controller**
Handles user input and provides the product management menu.

**DAO (Data Access Object)**
Performs database operations such as INSERT, SELECT, UPDATE, and DELETE.

**Database Connection**
Establishes the connection between Java and MySQL using JDBC.

## 📚 CRUD Operations

| Operation | SQL    |
| --------- | ------ |
| Create    | INSERT |
| Read      | SELECT |
| Update    | UPDATE |
| Delete    | DELETE |

## 🎯 Learning Outcomes

Through this project, the following concepts are demonstrated:

* Java Object-Oriented Programming
* JDBC connectivity
* MySQL database operations
* CRUD operations
* PreparedStatement
* ResultSet
* DAO architecture
* Maven dependency management
* Basic project structure

## 🚀 Future Enhancements

The project can be further improved by adding:

* User login and authentication
* Sales and billing management
* Customer management
* Search and filter products
* Stock alerts
* Sales reports
* Graphical User Interface (GUI)
* Input validation
* Exception handling
* Role-based access


