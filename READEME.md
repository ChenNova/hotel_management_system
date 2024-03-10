# **Student Name: Chen Chen**

# **Final Assignment: Hotel room booking program**

# **JouLu Hotel Management System**

JouLu Hotel Management System is a Java-based console application for managing hotel room bookings conveniently. For example, users can book double or single rooms with a specified number of nights. The system calculates the booking fee, considering the room type, number of nights, and applicable discounts. Users can search for orders by guest name or invoice number. Users can view the available rooms, their details, and occupancy status.

## **Table of Contents**

- [About the project](#joulu-hotel-management-system)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Code Overview](#code-overview)

## **Getting Started**

To run the JouLu Hotel Management System on your local machine, follow these steps:

1. Clone the repository:

   git clone https://github.com/TAMK-programmming/programming-languages-1-final-assingment-ChenNova

2. Run the command:

   javac HotelMenu.java
   java HotelMenu

## **Usage**

Follow these on-screen instructions when using the JouLu Hotel Management System:

### Main Menu

- Enter `1` to book a room.
- Enter `2` to search for existing orders.
- Enter `3` to exit the hotel.

### Booking Rooms

To book a room, follow these steps:

- Choose the room type (Double or Single).
- Confirm the booking or go back to the main menu.
- Enter the number of nights for the booking.
- Confirm the order or go back to the main menu.

### Searching Orders

To search for your orders:

Enter the guest's name or invoice number to search for existing orders.

### Exiting the Hotel

To exit the hotel and end the program by choosing the exit.

## **Code Overview**

### HotelMenu.java

- Represents the main functionality of the JouLu Hotel program.

### Booking.java

- Contains methods for booking rooms, calculating fees, confirming orders, and generating invoice numbers.

### RoomOperations.java

- Manages hotel room operations such as finding the first empty room, searching for rooms, and creating the hotel.

### Rooms.java

- Shows individual hotel rooms with details, and booking rooms, and retrieving availability.
