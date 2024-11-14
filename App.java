import java.util.Scanner;

public class App {

    static final int MAX_SEATS = 12; //for readability
    static Passenger[] seats = new Passenger[MAX_SEATS];
    static Scanner scan = new Scanner(System.in); //scan introduces new scanner
    public static void main(String[] args) {
         // Initialize seats
        for (int i = 0; i < MAX_SEATS; i++) {
            seats[i] = new Passenger("", 0);
        }
        // Start of the program
        boolean running = true;
        while (running) {
            System.out.print("What would you like to do? (type 'Help' to see available commands) ");
            String command = scan.nextLine();
            switch (command) {
                case "Insert passenger":
                    insertPassenger();
                    break;
                case "Remove passenger":
                    removePassenger();
                    break;
                case "Switch seats":
                    switchSeats();
                    break;
                case "Change passenger info":
                    changePassengerInfo();
                    break;
                case "Count passengers":
                    countPassengers();
                    break;
                case "Print passenger manifest":
                    printPassengerManifest();
                    break;
                case "Help":
                    help();
                    break;
                case "Exit":
                    exit();
                    break;
                default:
                    System.out.println("Invalid command");
                    System.out.println("Commands are case sensitive");
                    break;
            }
        }
       
    }

    // Insert passenger
    private static void insertPassenger() {
            for (int i = 0; i < MAX_SEATS; i++) {
                if (seats[i].isEmpty()) {
                    System.out.println("What is the passenger's name? ");
                    String name = scan.nextLine();
                    System.out.println("What is the passenger's age? ");
                    int age = scan.nextInt();
                    scan.nextLine(); // Consume newline
                    seats[i] = new Passenger(name, age);
                    System.out.println("Passenger inserted");
                    return;
                }
            }
            System.out.println("No available seats");
    }

       // Remove passenger
    private static void removePassenger() {
            System.out.println("Which seat would you like to remove the passenger from? ");
            int seatNumber = scan.nextInt();
            scan.nextLine(); // Consume newline

            if (seatNumber < 1 || seatNumber > MAX_SEATS) {
                System.out.println("Invalid seat number");
                return;
            }

            Passenger passenger = seats[seatNumber - 1];
            if (passenger.isEmpty()) {
                System.out.println("Seat is already empty");
                return;
            }

            System.out.println("The passenger sitting here is " + passenger.getName() + " " + passenger.getAge());
            System.out.println("Do you want to remove them? (yes/no)");
            String confirmation = scan.nextLine();

            if (confirmation.equalsIgnoreCase("yes")) {
                seats[seatNumber - 1] = new Passenger("", 0);
                System.out.println("Passenger removed");
            } else {
                System.out.println("Passenger not removed");
            }
    }

        // Switch seats
    private static void switchSeats() {
            System.out.println("Enter the first seat number (1-12):");
            int seat1 = Integer.parseInt(scan.nextLine()) - 1;
            System.out.println("Enter the second seat number (1-12):");
            int seat2 = Integer.parseInt(scan.nextLine()) - 1;

            if (seat1 >= 0 && seat1 < MAX_SEATS && seat2 >= 0 && seat2 < MAX_SEATS) {
                Passenger temp = seats[seat1];
                seats[seat1] = seats[seat2];
                seats[seat2] = temp;
                System.out.println("Seats switched.");
            } else {
                System.out.println("Invalid seat numbers.");
            }
    }

        // Change passenger info
    private static void changePassengerInfo() {
            System.out.println("Which seat would you like to change the passenger information for? ");
            int seatNumber = scan.nextInt();
            scan.nextLine(); // Consume newline

            if (seatNumber < 1 || seatNumber > MAX_SEATS) {
                System.out.println("Invalid seat number");
                return;
            }

            Passenger passenger = seats[seatNumber - 1];
            if (passenger.isEmpty()) {
                System.out.println("The seat is empty.");
                return;
            }

            System.out.println("Enter the new name for the passenger: ");
            String newName = scan.nextLine();
            passenger.setName(newName);

            System.out.println("Enter the new age for the passenger: ");
            int newAge = scan.nextInt();
            scan.nextLine(); // Consume newline
            passenger.setAge(newAge);

            System.out.println("Passenger information updated: " + passenger);
    }

        // Count passengers
    private static void countPassengers() {
            int count = 0;
            for (int i = 0; i < MAX_SEATS; i++) {
                if (!seats[i].isEmpty()) {
                    count++;
                }
            }
            System.out.println("There are " + count + " passengers on board.");
    }

             // Print passenger manifest
    
    private static void printPassengerManifest() {
            System.out.println("###### PASSENGER MANIFEST ######");
            System.out.println("SkyBox Ltd.");
            System.out.println("Seat\t\tName\t\tAge");
            for (int i = 0; i < MAX_SEATS; i++) {
                System.out.println((i + 1) + "\t\t" + seats[i].getName() + "\t\t" + seats[i].getAge());
            }
            System.out.println("##### ##### ##### ##### ##### ###");
    }

        // Help command
    private static void help() {
            System.out.println("Available commands (case sensitive):");
            System.out.println("Insert passenger");
            System.out.println("Remove passenger");
            System.out.println("Switch seats");
            System.out.println("Change passenger info");
            System.out.println("Count passengers");
            System.out.println("Print passenger manifest");
            System.out.println("Help");
            System.out.println("Exit");
    }

        // Exit command
    private static void exit() {
            System.out.println("Goodbye!");
            System.exit(0);
    }
}
//
