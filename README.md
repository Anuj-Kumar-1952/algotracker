# 🧠 AlgoTracker – DSA Practice & Progress Tracker (Spring Boot + JWT + MySQL)

A secure, multi-user backend application built with **Spring Boot**, **Spring Security (JWT)**, and **MySQL**.

Users can register, log in, and manage their own DSA problems. Each user only sees their own data, protected by JWT authentication.

---

## 🚀 Features (current – Phase 3)

- ✅ User registration & login (JWT-based)
- ✅ Secure CRUD APIs for DSA problems
- ✅ Each user sees only their own problems
- ✅ Ownership checks on Problem access (user cannot access others' problems)
- ✅ Automatic timestamps via JPA lifecycle (`@PrePersist`, `@PreUpdate`)

---

## 🏗️ Tech Stack

- Java 21 
- Spring Boot 3.5.8  
- Spring Security 6 + JWT  
- Spring Data JPA (Hibernate)  
- MySQL 8  
- Maven  

---

## ⚙️ Setup

### 1️⃣ Clone the repo

```bash
git clone https://github.com/<your-username>/algotracker.git
cd algotracker


### 2 Create Database 

CREATE DATABASE algotracker_db;

###3️ Configure application

Copy src/main/resources/application-example.properties to application.properties and update:

-->spring.datasource.username

-->spring.datasource.password

-->app.jwt.secret

###4 Run the application

-->mvn spring-boot:run

Server: http://localhost:8080

---

🔐 Auth APIs
Method	Endpoint	        Description
POST	/api/auth/register	Register new user
POST	/api/auth/login	    Login, returns JWT

📘 Problem APIs (JWT required)
Use header:
Authorization: Bearer <token>

Method	Endpoint	          Description
POST	/api/problems	      Create a problem
GET	    /api/problems         List current user's problems
GET	    /api/problems/{id}	  Get a single problem (owned)
PUT	    /api/problems/{id}	  Update a problem (owned)
DELETE	/api/problems/{id}	  Delete a problem (owned)
GET	    /api/users/me	      Get current logged-in user info

---
 ->
![table-structure](/table-structure.png)

---

🧭 Project Architecture
com.algotracker
 ├── controller
 │     ├── AuthController.java
 │     ├── ProblemController.java
 │     └── UserController.java
 ├── service
 │     ├── AuthService.java
 │     ├── ProblemService.java
 │     └── CurrentUserService.java
 ├── repository
 │     ├── UserRepository.java
 │     └── ProblemRepository.java
 ├── entity
 │     ├── User.java
 │     ├── Problem.java
 │     ├── Role.java
 │     ├── Difficulty.java
 │     └── ProblemStatus.java
 ├── security
 │     ├── JwtAuthenticationFilter.java
 │     ├── CustomUserDetailsService.java
 |     ├── JWTService.java
 │     └── SecurityConfig.java
 └── dto
       ├── RegisterRequest.java
       ├── LoginRequest.java
       ├── ProblemRequest.java
       ├── ProblemResponse.java
       └── AuthResponse.java 
       
---

📊 Future Enhancements (Phase 4+)

🧱 Implement custom data structures (MyArrayList, MyLinkedList, MyStack, MyQueue)

🔁 Add recommendation engine using your DS

📈 Dashboard: progress, streaks, topic analytics

🌐 Deploy to Render / AWS for demo link

---

👨‍💻 Author

Anuj Kumar
Java Backend Developer (Spring Boot | JPA | SQL | Hibernate)

📧 Email: ak1952002@gmail.com

💼 LinkedIn: linkedin.com/in/anuj-kumar192002/

📂 GitHub: github.com/Anuj-Kumar-1952