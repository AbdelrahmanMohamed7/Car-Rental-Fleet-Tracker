# Object-Oriented Car Rental & Fleet Tracking Management System

A robust, desktop-based fleet administration tool built in Java utilizing a Swing graphical user interface (GUI). The system streamlines the workflow of vehicle reservations, inventory tracking, and client contract management using strict object-oriented paradigms.

This application separates data models, business rules, and presentation layers to maintain a scalable architecture for rental business logistics.

## 🚀 Key Features
* **Interactive Dashboard:** A clean, intuitive GUI built with Java Swing components to manage fleet status and bookings seamlessly.
* **Granular Fleet State Management:** Tracks real-time vehicle statuses (Available, Rented, Maintenance) and automates cost calculations based on tiered rental durations.
* **Data Encapsulation & Polymorphism:** Leverages core OOP design principles to model diverse vehicle categories (e.g., Sedans, SUVs, Luxury cars) with distinct pricing algorithms.
* **Persistent Text-File Storage:** Implements local file I/O operations to save and retrieve client information, booking logs, credentials, and fleet metrics securely without relying on complex database servers.

## 🛠️ Tech Stack
* **Language:** Java (JDK 11+)
* **GUI Framework:** Java Swing / AWT Form Engine
* **Storage Engine:** Flat Text File Databases (`.txt`)

## 📂 Key Architecture Modules
* **`CustomerLogin.java`:** The authentication gateway handling system security and entry points.
* **`BookingRegistration.java` & `PaymentCollection.java`:** Core logical controllers managing reservation lifecycle states and transaction calculations.
* **`text files/`:** Local persistent data layer holding text matrices for bookings, customers, and active car states.

## 💻 How to Run Locally

1. Clone this repository to your machine:
   ```bash
   git clone [https://github.com/AbdelrahmanMohamed7/car-rental-fleet-tracker.git](https://github.com/AbdelrahmanMohamed7/car-rental-fleet-tracker.git)
