import java.util.Random;
import java.util.Scanner;

// The Booking class is the booking process for rooms at JouLu Hotel
public class Booking {

    // Variables used through the class
    public static int numberOfChoice;
    public static String enterOne;
    public static String choice;
    public static int bookNight;
    public static double bookFee;
    public static double discount = 0.2;
    public static int priceOfDouble = 150;
    public static int priceOfSingle = 100;
    public static int comfirmNumber;
    public static String customerName;
    public static int invoiceNumber;
    public static String roomType = "";
    public static int roomNumber;

    // User choose the room type (Double or Single)
    public static void ChooseRoomType() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n-> Enter 1 - Book Double Room");
        System.out.println("\n-> Enter 2 - Book Single Room");
        System.out.print("\nEnter a number: ");
        do {
            while (!scanner.hasNextInt()) {
                System.out.print("\n" + "Invalid input, please enter again: ");
                scanner.next();
            }
            numberOfChoice = scanner.nextInt();
            if (numberOfChoice < 1 || numberOfChoice > 2) {
                System.out.print("\n" + "Invalid input, please enter again: ");
            }
        } while (numberOfChoice < 1 || numberOfChoice > 2);
        if (numberOfChoice == 1) {
            roomType = "Double Room";
        }
        if (numberOfChoice == 2) {
            roomType = "Single Room";
        }
    }

    // User choose whether to continue booking or go back to the main menu
    public static void continueBooking() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("\n-> Enter 1 - Continue booking  ");
        System.out.println("\n-> Enter 2 - Back to Menu ");
        System.out.print("\nEnter a number: ");

        do {
            while (!scanner.hasNext()) {
                System.out.print("\n" + "Invalid input, please enter again: ");
                scanner.next();
            }
            enterOne = scanner.nextLine();
            if (!enterOne.equals("1") && !enterOne.equals("2")) {
                System.out.print("\n" + "Invalid input, please enter again: ");
            }
        } while (!enterOne.equals("1") && !enterOne.equals("2"));

        if (enterOne.equals("2")) {
            // return;
            HotelMenu.mainMethod();
        }
    }

    // Calculate the booking fee based on the user's choices for room type and
    // number of stay. At the end, display the order details and ask user for
    // confirmation
    public static void calculateFee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("\n-> How many nights you want to stay? (min: 1 night, max: 30 nights)");
        System.out.print("\nEnter a number: ");
        do {
            while (!scanner.hasNextInt()) {
                scanner.next();
            }
            bookNight = scanner.nextInt();
            if (bookNight < 0 || bookNight > 30) {
                System.out.print("\n" + "Invalid input, please enter again: ");
            }
        } while (bookNight < 0 || bookNight > 30);

        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        switch (numberOfChoice) {
            case 1:
                if (bookNight >= 1 && bookNight < 3) {
                    bookFee = priceOfDouble * bookNight;
                }
                if (bookNight >= 3 && bookNight <= 30) {
                    bookFee = priceOfDouble * bookNight * (1 - discount);
                }
                System.out.println("\n-> Your order: one double room for " + bookNight + " nights will be " + bookFee
                        + " \u20ac in total.");
                break;

            case 2:
                if (bookNight >= 1 && bookNight < 3) {
                    bookFee = priceOfSingle * bookNight;
                } else if (bookNight >= 3 && bookNight <= 30) {
                    bookFee = priceOfSingle * bookNight * (1 - discount);
                }
                System.out.println("\nYour order: one single rooms for " + bookNight + " nights: " + bookFee
                        + " \u20ac in total.");
                break;
        }
        confirmStep();
        bookingRoom(roomType, customerName, bookNight);
        printTheOrder();
        HotelMenu.mainMethod();
    }

    // User confirm the order or go back to the main menu. User need to input names
    // to confirm order
    public static String confirmStep() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n-> Enter 1 - Confirm order");
        System.out.println("\n-> Enter 2 - Back to Menu");
        System.out.print("\nEnter a number: ");

        do {
            while (!scanner.hasNext()) {
                System.out.print("\n" + "Invalid input, please enter again: ");
                scanner.next();
            }
            choice = scanner.nextLine();
            if (!choice.equals("1") && !choice.equals("2")) {
                System.out.print("\n" + "Invalid input, please enter again: ");
            }
        } while (!choice.equals("1") && !choice.equals("2"));

        switch (choice) {
            case "1":
                System.out.println("\nConfirming...\n");
                System.out.print("Enter your name before payment(eg. Nova Chen): ");
                customerName = scanner.nextLine();
                break;
            case "2":
                HotelMenu.mainMethod();
                break;
        }
        return customerName;
    }

    // Book the selected room by finding the first available room of the chosen
    // type, and generating an invoice number, and updating the room status
    public static void bookingRoom(String roomType, String customerName, int nights) {
        roomNumber = RoomOperations.firstEmptyRoom(roomType);
        int roomNumberIndex = roomNumber - 1;
        invoiceNumber = generateInvoice();
        RoomOperations.rooms[roomNumberIndex].book(customerName, invoiceNumber, nights);
    }

    // Generate a random invoice number within 10000~99999
    public static int generateInvoice() {
        int lowerBound = 10000;
        int upperBound = 99999;
        return (int) (Math.random() * (upperBound - lowerBound + 1)) + lowerBound;
    }

    // Print the details of the booking order
    public static void printTheOrder() {
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("       JOULU HOTEL         ");
        System.out.println("\nInvoice No. " + invoiceNumber);
        System.out.println("\nRoom No. " + roomNumber);
        System.out.println("\nName: " + customerName);
        System.out.println("\nDays: " + bookNight);
        switch (numberOfChoice) {
            case 1:
                System.out.println("\nRoomtype: Double room");
                break;
            case 2:
                System.out.println("\nRoomtype: Single room");
                break;
        }

        System.out.println("\nTotal: " + bookFee);
        System.out.println("\nHave a pleasant stay!");

    }
}