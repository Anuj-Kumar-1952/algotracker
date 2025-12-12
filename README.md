# 🧠 AlgoTracker – DSA Practice & Progress Tracker (Spring Boot + JWT + MySQL)

AlgoTracker is a secure DSA practice & progress tracker built with **Spring Boot**, **Spring Security (JWT)**, and **MySQL**.
Users can register, log in, and manage their own DSA problems.
Each user only sees their own data, and under the hood the project demonstrates custom data structure
implementations (ArrayList, Stack, Queue, LinkedList) in real APIs.

---

## 🏗️ Tech Stack

- Backend : Java 21 & Spring Boot 3.5.8
- Security : Spring Security 6 + JWT
- Database : Spring Data JPA (Hibernate) & MySQL 8
- Build Tool : Maven
- Core Java Concepts: OOPs, Collections, Custom DSA Implementations

---

## 🧠 Custom DSA Classes Implemented

| Class             | Description                                             |
| ----------------- | ------------------------------------------------------- |
| `MyArrayList<T>`  | Custom dynamic array with `add()`, `get()`, `size()`    |
| `MyStack<T>`      | Array-based LIFO stack with `push()`, `pop()`, `peek()` |
| `MyQueue<T>`      | Circular queue with `enqueue()`, `dequeue()`, `peek()`  |
| `MyLinkedList<T>` | Singly linked list with add-first operations            |

---

## 🚀 Features (current – Phase 4)
## 🧩 Core Features

| Feature                     | Description                                 | Endpoint                        | Data Structure Used |
| --------------------------- | ------------------------------------------- | ------------------------------- | ------------------- |
| 🔐 User Auth                | Register / Login / JWT Token Validation     | `/api/auth/**`                  | —                   |
| 🧮 Problem CRUD             | Add / View / Update / Delete Problems       | `/api/problems/**`              | —                   |
| 💡 Recommendations          | Suggest next problems by topic & difficulty | `/api/problems/recommend`       | `MyArrayList`       |
| 🔁 Reversed Recent Problems | View last N problems in reverse order       | `/api/problems/recent/reversed` | `MyStack`           |
| 🎯 Practice Queue           | Get upcoming problems (TODO / IN_PROGRESS)  | `/api/problems/queue/next`      | `MyQueue`           |
| 🏆 Recently Solved List     | View recently solved problems               | `/api/problems/solved/recent`   | `MyLinkedList`      |

---

## ⚙️ Setup

### 3 Clone the repo
### 1️ Clone the repo

```bash```:
git clone https://github.com/Anuj-Kumar-1952/algotracker.git
cd algotracker


### 2 Create Database

CREATE DATABASE algotracker_db;

### 3 Configure application 

Copy src/main/resources/application-example.properties to application.properties and update:

-->spring.datasource.username

-->spring.datasource.password

-->app.jwt.secret

### 4 Run the application

->mvn spring-boot:run

Server: http://localhost:8080

---
## 🔐 Auth APIs

| Method | Endpoint             | Description        |
|--------|----------------------|--------------------|
| POST   | `/api/auth/register` | Register new user  |
| POST   | `/api/auth/login`    | Login, returns JWT |

## 📘 Problem APIs (JWT required)

Use header:
Authorization: Bearer <token>`

| Method | Endpoint               | Description                      |
|--------|------------------------|----------------------------------|
| POST   | `/api/problems`        | Create a problem                 |
| GET    | `/api/problems`        | List current user's problems     |
| GET    | `/api/problems/{id}`   | Get a single problem (owned)     |
| PUT    | `/api/problems/{id}`   | Update a problem (owned)         |
| DELETE | `/api/problems/{id}`   | Delete a problem (owned)         |
| GET    | `/api/users`           | Get current logged-in user info  |


---
 ->
![table-structure](/table-structure.png)

---
🧭 Project Architecture

com.anuj.algotracker
 ┣ 📂 controller         # REST Controllers
 ┣ 📂 dto                # Request & Response DTOs
 ┣ 📂 entity             # JPA Entities
 ┣ 📂 repository         # Spring Data Repositories
 ┣ 📂 service            # Business Logic + Custom DS Services
 ┣ 📂 security           # JWT + Authentication Logic
 ┣ 📂 datastructure      # Custom DSA Implementations
 ┗ 📜 AlgotrackerApplication.java


com.anuj.algotracker
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
 ├── datastructure
 │     ├── MyArrayList.java
 │     ├── MyLinkedList.java
 │     ├── MyQueue.java
 │     ├── MyStack.java
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
## 📊 Phase 5 – Advanced & Polish (Planned)

These items are planned and not yet implemented:

- 📌 Dashboard summary endpoint  
  - Aggregate stats like total problems, solved vs TODO, topic-wise counts, etc.
- ✅ Better validation & global exception handling  
  - Use `@ControllerAdvice` + custom exception classes for clean error responses  
  - Stronger request validation with `@Valid` and custom messages
- 🧾 Swagger/OpenAPI docs  
  - Auto-generated API documentation with UI (e.g., Springdoc OpenAPI + Swagger UI)
- 📦 Postman collection  
  - Export and include `/postman/AlgoTracker.postman_collection.json` for easy API testing

---
📊 Future Enhancements (Phase 5+)

🧪 Add JUnit + Mockito tests for key services
📈 Add analytics dashboard for progress & topic-wise performance
🧾 Integrate Swagger/OpenAPI for API documentation
🌐 Deploy to Render / AWS for demo link

---

👨‍💻 Author

Anuj Kumar
Java Backend Developer (Spring Boot | JPA | SQL | Hibernate)

📧 Email: ak1952002@gmail.com

💼 LinkedIn: https://www.linkedin.com/in/anuj-kumar192002/

📂 GitHub: https://www.github.com/Anuj-Kumar-1952

