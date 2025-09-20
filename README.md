# 📚 Library Management System

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![Eclipse IDE](https://img.shields.io/badge/Built_with-Eclipse_IDE-orange.svg)
![License](https://img.shields.io/badge/License-MIT-green.svg)

A comprehensive **Java-based Library Management System** that handles book borrowing, returns, reservations, and administrative approvals with an intuitive console interface.

---

## 📜 Table of Contents
- 🌟 [Project Overview](#-project-overview)
- ✨ [Key Features](#-key-features)
- 🏗 [Technical Architecture](#-technical-architecture)
- 🛠 [Installation Guide](#-installation-guide)
- 🚀 [Usage Instructions](#-usage-instructions)
- 📊 [Class Structure](#-class-structure)
- 🔧 [System Requirements](#-system-requirements)
- 🤝 [Contributing](#-contributing)
- 📜 [License](#-license)
- 🙏 [Acknowledgments](#-acknowledgments)

---

## 🌟 Project Overview
This Java-based library management system provides:

- ✅ User registration and authentication system  
- ✅ Book borrowing, returning, and reservation functionality  
- ✅ Administrative approval system for returns and reservations  
- ✅ 16 pre-loaded books across various genres  
- ✅ Input validation and error handling  

### Use Cases
- 🏫 Educational institutions managing their libraries  
- 📚 Public libraries needing a simple management system  
- 🎓 Students learning Java OOP principles  

---

## ✨ Key Features

| Feature           | Description                               | Implementation                          |
|-------------------|-------------------------------------------|------------------------------------------|
| **User Management** | Register and authenticate users           | `User` class with validation             |
| **Book Operations** | Borrow, return, and reserve books         | `Book` class with state management       |
| **Admin Controls**  | Approve returns and reservations          | Privileged admin functions               |
| **Data Persistence**| In-memory storage of users and books      | `ArrayList` collections                  |
| **Input Validation**| Robust error handling for user inputs     | Try-catch with input verification        |

---

## 🏗 Technical Architecture

```plaintext
LibrarySystem/
├── src/
│   └── book/
│       ├── Book.java     # Manages book states and operations
│       ├── Library.java  # Main system controller and UI
│       ├── Main.java     # Application entry point
│       └── User.java     # Handles user data and authentication
└── Configuration Files   # Eclipse IDE settings
```

### Data Flow:
1. User interacts with **Library** class menus  
2. Library manages **Book** and **User** objects  
3. State changes propagate through method calls  
4. Results displayed to user via console  

---

## 🛠 Installation Guide

### Prerequisites
- Java JDK **17** or compatible version  
- Eclipse IDE (recommended) or any Java development environment  

### Setup Steps
1. Clone or download the project files  
2. Import into Eclipse:  
   - Open **Eclipse IDE**  
   - Select **File → Import → General → Existing Projects into Workspace**  
   - Select the root directory containing the project  
   - Click **Finish**  
3. Configure Java Build Path:  
   - Right-click project → **Properties → Java Build Path**  
   - Ensure JRE System Library is set to **Java 17**  
   - Apply and close  
4. Run the application:  
   - Right-click **Main.java** → **Run As → Java Application**  

---

## 🚀 Usage Instructions

### Default Admin Account
- **Username:** `admin`  
- **Password:** `admin123`  

### For Regular Users
- Register a new account with your details  
- Login to browse available books  
- Borrow available books  
- Return books you've borrowed  
- Reserve currently unavailable books  

### For Administrators
- Login with **admin credentials**  
- Access **admin menu options**  
- Approve pending **return requests**  
- Approve pending **reservation requests**  

---

## 📊 Class Structure

### Book Class
- Manages book inventory and status  
- Handles borrow, return, and reservation operations  
- Tracks pending approvals  

### User Class
- Stores user credentials and information  
- Handles authentication  
- Distinguishes between regular users and admins  

### Library Class
- Main system controller  
- Handles user interface and menu navigation  
- Coordinates between users and books  

### Main Class
- Application entry point  
- Initializes the Library system  

---

## 🔧 System Requirements
- **Java Version:** JDK 17 or higher  
- **Memory:** Minimum 256MB RAM  
- **Storage:** 5MB free space  
- **Platform:** Cross-platform (Windows, macOS, Linux)  

---

## 🤝 Contributing
We welcome contributions to enhance this library system:

1. Fork the repository  
2. Create a feature branch:  
   ```bash
   git checkout -b feature/improvement
   ```
3. Commit your changes:  
   ```bash
   git commit -m "Add new feature"
   ```
4. Push to the branch:  
   ```bash
   git push origin feature/improvement
   ```
5. Open a Pull Request  

### Suggested Improvements
- Add database persistence  
- Implement password hashing  
- Create GUI interface  
- Add email notifications  
- Develop fine system for late returns  

---

## 📜 License
This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

---

## 🙏 Acknowledgments
- Built as a demonstration of **Java OOP principles**  
- Thanks to **Eclipse Foundation** for excellent development tools  
- Inspired by real-world library management needs  

**Project Maintainer:** James Clark Q. Badiang, Luke Daniel Nisnisan, and Jeremie Anino

**Last Updated:** May 9, 2025  
