// The RoomOperations class manages operations for storing details for rooms, and searching orders and printing the searched order besed on guest's name or invoice number
public class RoomOperations {
    // Store information about hotel rooms in the array
    public static Rooms[] rooms;

    // Find the room number of the first available room of the chosen type
    public static int firstEmptyRoom(String roomType) {
        int aRoomNumber = 0;
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].roomType.equals(roomType) && rooms[i].getAvailability().equals("Available")) {
                aRoomNumber = rooms[i].roomNumber;
                break;
            }
        }
        return aRoomNumber;
    }

    // Searche rooms based on invoice number or guest's name
    public static int[] searchRoom(String searchTerm) {
        int numberOfResults = 0;
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].customerName != null) {
                if (String.valueOf(rooms[i].invoiceNumber).equals(searchTerm.trim())
                        || rooms[i].customerName.trim().toLowerCase().equals(searchTerm.trim().toLowerCase())) {
                    numberOfResults += 1;
                }
            }
        }
        int[] roomIndexArray = new int[numberOfResults];
        int arrayIndex = 0;
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].customerName != null) {
                if (String.valueOf(rooms[i].invoiceNumber).equals(searchTerm.trim())
                        || rooms[i].customerName.trim().toLowerCase().equals(searchTerm.trim().toLowerCase())) {
                    roomIndexArray[arrayIndex] = i;
                    arrayIndex += 1;
                }
            }
        }

        return roomIndexArray;
    }

    // Print details of the searched room
    public static void printSearchedRooms(int roomIndex) {
        System.out.println("\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("       JOULU HOTEL         ");
        System.out.println("\nInvoice No. " + rooms[roomIndex].invoiceNumber);
        System.out.println("\nRoom No. " + rooms[roomIndex].roomNumber);
        System.out.println("\nName: " + rooms[roomIndex].customerName);
        System.out.println("\nDays: " + rooms[roomIndex].nights);
        System.out.println("\nRoomtype: " + rooms[roomIndex].roomType);
    }

    // Create an array of hotel rooms, initialize them with unique numbers and
    // types.
    public static Rooms[] createHotel() {
        int roomsNumber = 40;
        // Initializes an array to store room types
        String[] typePool = new String[roomsNumber];
        for (int poolCounter = 0; poolCounter < roomsNumber; poolCounter++) {
            if (poolCounter % 2 == 0) {
                typePool[poolCounter] = "Double Room";
            } else {
                typePool[poolCounter] = "Single Room";
            }
        }
        // Store room types in the array
        Rooms[] rooms = new Rooms[roomsNumber];
        int poolSize = typePool.length;
        for (int i = 0; i < rooms.length; i++) {
            int drewIndex = draw(poolSize);
            String drewRoomType = typePool[drewIndex];
            // Shift elements in the typePool array to fill the gap
            if (drewIndex < poolSize - 1) {
                for (int i2 = drewIndex; i2 < poolSize - 1; i2++) {
                    typePool[i2] = typePool[i2 + 1];
                }
            }
            // Create a Room with initialized details and add it to the rooms array
            rooms[i] = new Rooms(i + 1, drewRoomType, "Available", "", 0, 0);
            poolSize -= 1;
        }
        return rooms;
    }

    // Generate a random number within the pool(has 40 rooms) which is used for
    // dividing double and single rooms
    // randomly
    public static int draw(int poolSize) {
        int randomIndex = (int) (Math.random() * poolSize);
        return randomIndex;
    }
}
