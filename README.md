# 🛒 E-Commerce Application

A full-stack E-Commerce application built using **Spring Boot**, **React (Vite)**, and **PostgreSQL**. The application allows users to manage products, including adding, viewing, updating, deleting products, and uploading product images.

---

## 🚀 Features

- Add new products
- View all available products
- Search products
- Update existing products
- Delete products
- Upload and display product images
- RESTful API architecture
- Responsive React frontend
- PostgreSQL database integration

---

## 🛠️ Tech Stack

### Backend
- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven

### Frontend
- React
- Vite
- Axios
- HTML
- CSS
- JavaScript

### Database
- PostgreSQL

---

## 📂 Project Structure

```
Desktop
│
├── ecom-project        # Spring Boot Backend
│
└── ecom-frontend       # React + Vite Frontend
```

---

## ⚙️ Installation

### 1. Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/ecom-project.git
cd ecom-project
```

---

### 2. Backend Setup

Create a PostgreSQL database.

Example:

```sql
CREATE DATABASE ecommerce;
```

Update your `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ecommerce
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
```

Run the Spring Boot application:

```bash
mvn spring-boot:run
```

Backend runs on:

```
http://localhost:8080
```

---

### 3. Frontend Setup

Navigate to frontend:

```bash
cd ecom-frontend
```

Install dependencies:

```bash
npm install
```

Run:

```bash
npm run dev
```

Frontend runs on:

```
http://localhost:5173
```

---

## 📡 API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/api/products` | Get all products |
| GET | `/api/product/{id}` | Get product by ID |
| POST | `/api/product` | Add new product |
| PUT | `/api/product/{id}` | Update product |
| DELETE | `/api/product/{id}` | Delete product |
| GET | `/api/product/{id}/image` | Fetch product image |

---

## 📷 Screenshots

Add screenshots here.

Example:

```
screenshots/
    home.png
    add-product.png
    details.png
```

Then include:

```markdown
![Home](screenshots/home.png)
```

---

## 📌 Future Improvements

- User Authentication
- JWT Security
- Shopping Cart
- Order Management
- Payment Gateway Integration
- Admin Dashboard
- Product Categories
- Wishlist
- Pagination
- Product Reviews

---

## 🧪 Testing

Backend:

```bash
mvn test
```

Frontend:

```bash
npm run build
```

---

## 👨‍💻 Author

**Ankit Jha**

GitHub:
https://github.com/YOUR_USERNAME

LinkedIn:
https://linkedin.com/in/YOUR_LINKEDIN

---

## 📄 License

This project is created for learning purposes and is open for educational use.
