import java.util.Scanner;

// Student Name: Chen Chen
// The HotelMenu class represents the main functionality of the JouLu Hotel program
public class HotelMenu {
    // A loop to display the main menu continuously
    public static void main(String[] args) {
        RoomOperations.rooms = RoomOperations.createHotel();
        while (true) {
            mainMethod();
        }
    }

    // Dispaly the main menu
    public static void mainMenu() {
        System.out.println("");
        System.out.println("");
        System.out.println("=====================================================================");
        System.out.println("                       Welcome to JouLu Hotel!");
        System.out.println("=====================================================================");
        System.out.println("\nEnter 1 - Book room!");
        System.out.println("\nEnter 2 - Search orders!");
        System.out.println("\nEnter 3 - Exit hotel.");
    }

    // Dispaly the price list
    public static void Menu() {
        System.out.println(" \n - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("|                     Price List                        |");
        System.out.println("|- - - - - - - - - - - - - - - - - - - - - - - - - - - -|");
        System.out.println("| 1 - Double Room 150 \u20ac.                                |");
        System.out.println("| 2 - Single Room 100 \u20ac.                                |");
        System.out.println("|(20% discount for more than 3 nights reservation.)     |");
        System.out.println(" - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
    }

    // Prints the available rooms
    public static void plotRooms(Rooms[] subject) {
        for (int arrayIndex = 0; arrayIndex < subject.length; arrayIndex++) {
            subject[arrayIndex].printDetails();
        }
    }

    // Start booking process by displaying the price list, room availability,
    // and then continue booking
    public static void book() {
        HotelMenu.Menu();
        System.out.println("\nWe have " + Rooms.doubleRoomNumbers + " double rooms available, and "
                + Rooms.singleRoomNumbers + " single rooms available.");
        Booking.ChooseRoomType();
        Booking.continueBooking();
        Booking.calculateFee();
    }

    // Search the order by entering a correct guest's name or invoice number
    // Display the details of matching rooms after searching
    public static void search() {
        Scanner scanner = new Scanner(System.in);

        boolean isValidInput = false;
        System.out.print("\nEnter guest's name or invoice number: ");
        do {
            String searchTerm = scanner.nextLine();

            if (!searchTerm.isEmpty()) {
                int[] roomIndexResult = RoomOperations.searchRoom(searchTerm);

                if (roomIndexResult.length == 0) {
                    System.out.print("\nWrong name or invoice number. Please enter again: ");
                } else {
                    isValidInput = true;
                    for (int i = 0; i < roomIndexResult.length; i++) {
                        RoomOperations.printSearchedRooms(roomIndexResult[i]);
                    }
                }
            } else {
                System.out.print("\nWrong name or invoice number. Please enter again: ");
            }
        } while (!isValidInput);
        mainMethod();
    }

    // Display the main menu and processe the chosen option
    public static void mainMethod() {
        mainMenu();
        System.out.print("\nEnter a number: ");
        Scanner scanner = new Scanner(System.in);
        int chooseMenu;

        do {
            while (!scanner.hasNextInt()) {
                System.out.print("\n" + "Invalid input, please enter again: ");
                scanner.next();
            }
            chooseMenu = scanner.nextInt();
            if (chooseMenu < 1 || chooseMenu > 3) {
                System.out.print("\n" + "Invalid input, please enter again: ");
            }
        } while (chooseMenu < 1 || chooseMenu > 3);

        if (chooseMenu == 1) {
            book();
        } else if (chooseMenu == 2) {
            search();
        } else if (chooseMenu == 3) {
            System.out.println("\nThanks for staying with us! We hope to welcome you back soon!\n");
            System.exit(chooseMenu);
        }
    }
}
