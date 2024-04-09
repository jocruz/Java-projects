# 💳 Bank Card Management System

## 🌟 Overview
This Bank Card Management System is a Java-based application designed for handling various types of bank cards, including credit, prepaid, and rewards cards. It allows for transaction management, balance tracking, and statement generation.

## 🚀 Features

- **💳 General Card Management:** Abstract class `BankCard` serves as a base for different card types, managing common properties like card number and balance.
- **💰 Credit Card Handling:** `CreditCard` class extends `BankCard` to include credit-specific features such as credit limits and expiration dates.
- **🎁 Rewards Card Features:** `RewardsCard` extends `CreditCard` to add rewards points functionality.
- **💵 Prepaid Card Operations:** `PrepaidCard` class for managing prepaid debit cards with direct balance control.
- **📊 Transaction Management:** Track and manage debit and credit transactions for all card types.
- **🔍 Sorting and Searching:** Comparator classes (`LatComparator`, `LngComparator`, `NameComparator`) to sort and organize data efficiently.

## 📁 File Descriptions

- **`BankCard.java`**: Abstract base class defining common attributes and methods for various types of bank cards.
- **`CreditCard.java`**: Class that extends `BankCard`, tailored for credit card functionalities including credit limit and expiration management.
- **`RewardsCard.java`**: Subclass of `CreditCard` adding rewards points accumulation and redemption features.
- **`PrepaidCard.java`**: Class for managing prepaid cards, extending `BankCard` with functionalities like fund addition and specific transaction handling.
- **`Transcation.java`**: Defines a transaction, including type (debit/credit), amount, merchant, and notes.
- **`LatComparator.java`, `LngComparator.java`, `NameComparator.java`**: Comparator classes used for sorting cities or transactions based on different criteria.

## 🎯 Use Cases

- Manage a portfolio of various bank cards, tracking their balances and transactions.
- Perform credit operations with support for limits and expirations.
- Utilize rewards points for beneficial transactions on the RewardsCard.
- Load and manage funds on PrepaidCard with detailed transaction tracking.
- Generate detailed statements for each card, providing transaction history and current card status.

## 💡 Potential Enhancements

- Integrate with a real-world banking API for live transaction processing.
- Add user authentication and encryption for secure management.
- Develop a graphical user interface (GUI) for a more user-friendly experience.
- Implement additional card types and features like balance transfer, variable interest rates, etc.

## 🔄 Interaction and Flow

1. Initialize cards (credit, rewards, or prepaid) with relevant details.
2. Execute transactions, adding them to the card's history.
3. Periodically generate and review card statements for financial tracking.
4. Utilize rewards and manage funds effectively across different card types.
