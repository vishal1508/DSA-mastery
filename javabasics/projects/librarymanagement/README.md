# Library Management System (Console-Based Java Application)

A fully functional **Library Management System** built in Java, using **OOP principles**.
Supports **librarian and member functionalities**, book management, and robust **input error handling**.

---

## Features

* **User Management**

  * Register and login as **Librarian**.
  * Register and login as **Member**.
* **Librarian Functions**

  * Add new books with title, author, category, and total copies.
  * Remove books by ID.
  * Search books by title, author, or category.
  * View all books in the library.
  * Register new members.
* **Member Functions**

  * Borrow books (cannot borrow the same book twice, checks availability).
  * Return borrowed books.
  * View list of borrowed books.
* Robust input handling to prevent crashes on invalid entries.
* Proper **ID management** for books and members.
* Clean console output for easy readability.

---

## Classes

| Class        | Description                                                                                                   |
| ------------ | ------------------------------------------------------------------------------------------------------------- |
| `Person`     | Abstract class, parent of Member and Librarian. Contains name, contact, username, password, and login status. |
| `Librarian`  | Inherits from `Person`. Can manage books and register members.                                                |
| `Member`     | Inherits from `Person`. Can borrow and return books.                                                          |
| `Book`       | Represents a library book with ID, title, author, category, availability, and total copies.                   |
| `BorrowBook` | Represents a borrowed book for a member.                                                                      |

---

## Console Usage

### **Main Menu**

```
=== Library System ===
1. Register Librarian
2. Show Librarians
3. Login as Librarian
4. Login as Member
0. Exit
Enter choice:
```

---

### **Librarian Menu**

```
=== Librarian Menu ===
1. Add Book
2. Remove Book
3. Search Book
4. View All Books
5. Register Member
0. Logout
Enter choice:
```

**Add Book Example:**

```
Book Title: Java Basics
Book Author: John Doe
Book Category: Programming
Total Copies: 5
Book added successfully!
```

**Search Book Example:**

```
Enter keyword to search (title/author/category): java
================================================
Book id := 1
Book Name := Java Basics
Book Author := John Doe
Book Category := Programming
Availability := true
Total Copies := 5
================================================
```

---

### **Member Menu**

```
=== Member Menu ===
1. Borrow Book
2. Return Book
3. View Borrowed Books
0. Logout
Enter choice:
```

**Borrow Book Example:**

```
Enter Book ID to borrow: 1
Book borrowed successfully!
```

**Return Book Example:**

```
Enter Book ID to return: 1
Book returned successfully!
```

**View Borrowed Books Example:**

```
=== Borrowed Books ===
================================================
Book id := 1
Book Name := Java Basics
Book Author := John Doe
Book Category := Programming
================================================
```

---

## Installation & Running

1. Clone the repository:

```bash
git clone https://github.com/your-username/library-management-system.git
```

2. Navigate to the project directory:

```bash
cd library-management-system
```

3. Compile all Java files:

```bash
javac projects/librarymanagement/*.java
```

4. Run the main class:

```bash
java projects.librarymanagement.Library
```

---

## Notes

* The system is **console-based** and intended for learning OOP concepts in Java.
* All input is validated to prevent crashes.
* Passwords are stored in plain text for simplicity; in production, use **hashing**.
* Each book and member has a **unique ID** to avoid index-related errors.
* Designed for **expandability**: easily add more features like multiple copies, book reservation, etc.

---

## License

MIT License
