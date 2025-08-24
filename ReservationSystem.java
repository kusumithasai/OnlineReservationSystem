import java.util.Scanner;
import java.util.UUID;

public class OnlineReservationSystem {
    static Scanner sc = new Scanner(System.in);
    static boolean isReserved = false;
    static String name, trainNo, classType, date, from, to, pnr;

    public static void main(String[] args) {
        System.out.println("----- Welcome to Spark Railway Reservation System -----");

        System.out.print("Enter User ID: ");
        String user = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        if (user.equals("user") && pass.equals("pass")) {
            System.out.println("Login successful!");

            while (true) {
                System.out.println("\n----- MENU -----");
                System.out.println("1. Reservation");
                System.out.println("2. Cancellation");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1: reserve(); break;
                    case 2: cancel(); break;
                    case 3:
                        System.out.println("Thank you for using Railway Reservation System!");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    static void reserve() {
        if (isReserved) {
            System.out.println("You already have a reservation.");
            return;
        }

        System.out.println("----- Reservation Form -----");
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter Train Number: ");
        trainNo = sc.nextLine();
        System.out.print("Enter Class Type (e.g., Sleeper, AC): ");
        classType = sc.nextLine();
        System.out.print("Enter Date of Journey: ");
        date = sc.nextLine();
        System.out.print("Enter From: ");
        from = sc.nextLine();
        System.out.print("Enter To: ");
        to = sc.nextLine();

        pnr = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        isReserved = true;

        System.out.println("Reservation Successful! ✅");
        System.out.println("Your PNR: " + pnr);
    }

    static void cancel() {
        if (!isReserved) {
            System.out.println("No reservation found to cancel.");
            return;
        }

        System.out.print("Enter your PNR to cancel: ");
        String inputPNR = sc.nextLine();

        if (inputPNR.equalsIgnoreCase(pnr)) {
            isReserved = false;
            System.out.println("Reservation Cancelled Successfully. ❌");
        } else {
            System.out.println("PNR not found or incorrect.");
        }
    }
}
