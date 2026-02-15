import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HotelManager manager = HotelManager.getInstance();

        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        int choice;

        do {
            System.out.println("\n===== HOTEL MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Room");
            System.out.println("2. View Rooms");
            System.out.println("3. Update Room Status");
            System.out.println("4. Delete Room");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Room Number: ");
                    int number = scanner.nextInt();

                    System.out.println("Select Room Status:");
                    System.out.println("1. Available");
                    System.out.println("2. Booked");
                    System.out.print("Enter choice: ");
                    int statusChoice = scanner.nextInt();

                    String status;
                    if (statusChoice == 1) {
                        status = "Available";
                    } else if (statusChoice == 2) {
                        status = "Booked";
                    } else {
                        System.out.println("Invalid status selection.");
                        break;
                    }

                    Room newRoom = new Room(number, status);
                    newRoom.registerObserver(customer1);
                    newRoom.registerObserver(customer2);

                    manager.addRoom(newRoom);
                    break;

                case 2:
                    manager.viewRooms();
                    break;

                case 3:
                    System.out.print("Enter Room Number to Update: ");
                    int updateNumber = scanner.nextInt();

                    System.out.println("Select New Status:");
                    System.out.println("1. Available");
                    System.out.println("2. Booked");
                    System.out.print("Enter choice: ");
                    int newStatusChoice = scanner.nextInt();

                    String newStatus;
                    if (newStatusChoice == 1) {
                        newStatus = "Available";
                    } else if (newStatusChoice == 2) {
                        newStatus = "Booked";
                    } else {
                        System.out.println("Invalid status selection.");
                        break;
                    }

                    manager.updateRoomStatus(updateNumber, newStatus);
                    break;

                case 4:
                    System.out.print("Enter Room Number to Delete: ");
                    int deleteNumber = scanner.nextInt();
                    manager.deleteRoom(deleteNumber);
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
