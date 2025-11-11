# Bank Account Manager

A simple, menu-driven Java application for managing bank accounts using a HashMap collection. This project demonstrates object-oriented programming, user authentication, and collection handling for both manager and customer roles via a console interface.

## Features

- Add new bank accounts (Manager)
- View all accounts (Manager)
- Deposit and withdraw funds (Manager & Customer)
- Modify account holder name or account balance (Manager)
- Delete accounts (Manager)
- Secure manager login with password protection
- Dedicated Customer Page for viewing and managing your own account
- Fast account lookup using HashMap data structure

## How to Run

1. **Clone the repository:**

    git clone https://github.com/parthac15/BankAccountManager.git

2. **Navigate to the project directory:**

3. **Compile Java files:**

4. **Run the application:**

## System Structure

- `Main.java`: Main menu and navigation between manager and customer roles
- `BankAccount.java`: Represents a single bank account (account number, holder name, balance)
- `BankAccountManager.java`: Business logic for account creation, deletion, updating, viewing
- `CustomerPage.java`: Console options for customers to view, deposit, or withdraw from their own accounts

## Manager Authentication

- To access manager mode, you must enter the manager password:  
Only then will you be able to add, delete, or edit bank accounts.

## Customer Page

- Customers can enter their account number and view account details securely.
- Deposit and withdrawal functions are also accessible.

## Technologies Used

- Java (JDK 8+)
- Java Collections Framework (HashMap)
- Console-based user interface
- No external database; accounts are managed in-memory

## Project Purpose

This project is ideal for beginners to learn:
- Core Java concepts and syntax
- Object-oriented design and encapsulation
- Working with hash-based collections
- Implementing simple authentication
- Branching logic and menu handling in console apps
- Using Git and GitHub for version control

## Contributing

Feel free to fork, clone, and contribute new features!  
For questions or suggestions, open an issue or make a pull request.

## Author

**PARTHIBAN C**
