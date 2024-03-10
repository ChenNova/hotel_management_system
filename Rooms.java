// The Rooms class shows individual hotel rooms details
public class Rooms {
    int roomNumber;
    String roomType;
    private String availability;
    String customerName;
    int invoiceNumber;
    int nights;
    // Keep track of the number of available Double and Single rooms
    public static int singleRoomNumbers = 0;
    public static int doubleRoomNumbers = 0;

    // Update the available double and single room numbers
    public Rooms(int roomNumber, String roomType, String availability, String customerName, int invoiceNumber,
            int nights) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.availability = availability;
        this.customerName = customerName;
        this.invoiceNumber = invoiceNumber;
        this.nights = nights;
        if (roomType.equals("Double Room")) {
            doubleRoomNumbers += 1;
        }
        if (roomType.equals("Single Room")) {
            singleRoomNumbers += 1;
        }
    }

    // Print the details of the room
    public void printDetails() {
        System.out.println(this.roomNumber);
        System.out.println(this.roomType);
        System.out.println(this.availability);
        System.out.println(this.customerName);
        System.out.println(this.invoiceNumber);
        System.out.println(this.nights);
    }

    // Book the room with the entered customer name, invoice number, and nights
    public void book(String customerName, int invoiceNumber, int nights) {
        this.availability = "Occupied";
        this.customerName = customerName;
        this.invoiceNumber = invoiceNumber;
        this.nights = nights;
        // Update the number of available double and single rooms after booking
        if (this.roomType.equals("Double Room")) {
            doubleRoomNumbers -= 1;
        }
        if (this.roomType.equals("Single Room")) {
            singleRoomNumbers -= 1;
        }
    }

    // Get the availabity status of the room
    public String getAvailability() {
        return this.availability;
    }

}
