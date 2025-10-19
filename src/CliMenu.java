import java.util.Scanner;

/**
 * ============================================================
 * CliMenu.java
 * ============================================================
 * <p>
 * The CliMenu class provides a command-line interface (CLI)
 * for interacting with the Client Management System.
 * <p>
 * Primary Role:
 * - Handles all user interaction through menus and prompts.
 * - Collects and validates input before passing data to ClientManager.
 * - Delegates operations such as adding, updating, removing,
 * and viewing client records to the ClientManager.
 * <p>
 * Responsibilities:
 * - Display the main menu and submenus for client operations.
 * - Read and validate user input using a Scanner instance.
 * - Provide loops and checks to ensure proper input and navigation.
 * - Show client details and directory information in a clear format.
 * ============================================================
 */


public class CliMenu {

    private ClientManager manager;
    private Scanner scanner;

    public CliMenu(ClientManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            displayMenu();
            System.out.println("--------------------------------");
            System.out.print("Select and option: ");
            choice = getIntInput();

            switch (choice) {
                case 1:
                    addClient();
                    break;
                case 2:
                    updateClient();
                    break;
                case 3:
                    removeClient();
                    break;
                case 4:
                    viewClientDirectory();
                    break;
                case 5:
                    System.out.println("👋 Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("⚠️ Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    // Helper method for displaying main menu.
    private void displayMenu() {
        System.out.println("\n================================");
        System.out.println("=== CLIENT MANAGEMENT SYSTEM ===");
        System.out.println("================================");
        System.out.println("1. Register New Client");
        System.out.println("2. Update Client Record");
        System.out.println("3. Remove Client Record");
        System.out.println("4. View Client Directory");
        System.out.println("5. Exit Application");
    }

    // Helper method for displaying simple client list
    private void displayClientList() {
        // Prints basic list
        for (Client c : manager.getAllClients()) {
            System.out.println(c.getId() + " - " + c.getFirstName() + " " + c.getLastName());
        }
        System.out.println("--------------------------------");
    }


    // ----------------------------
    // 1. Add Client
    // ----------------------------
    private void addClient() {
        manager.addClient();
    }


    // ----------------------------
    // 2. Update Client
    // ----------------------------
    private void updateClient() {
        System.out.println("\n=== UPDATE CLIENT ===");

        // Handle empty list first
        if (manager.getAllClients().isEmpty()) {
            System.out.println("⚠️ There are no clients in the system to update.");
            return;
        }

        // Display all clients for reference
        displayClientList();

        Client client = null;

        // Loop until valid ID or cancel
        while (client == null) {
            System.out.print("Enter Client ID to update (0 to cancel): ");
            int id = getIntInput();

            if (id == 0) {
                System.out.println("Update canceled.");
                return;
            }

            client = manager.findClientById(id);
            if (client == null) {
                System.out.println("⚠️ No client found with ID: " + id);
            }
        }

        // Continue with the update process
        System.out.println("Editing client: " + client.getFirstName() + " " + client.getLastName());

        boolean done = false;
        while (!done) {
            System.out.println("\nSelect field to update:");
            System.out.println("1. First Name: "     + client.getFirstName());
            System.out.println("2. Last Name: "      + client.getLastName());
            System.out.println("3. Company: "        + client.getCompany());
            System.out.println("4. Email: "          + client.getEmail());
            System.out.println("5. Phone: "          + client.getPhone());
            System.out.println("6. Street Address: " + client.getStreetAddress());
            System.out.println("7. City: "           + client.getCity());
            System.out.println("8. State: "          + client.getState());
            System.out.println("9. ZIP: "            + client.getZip());
            System.out.println("10. Notes: "         + client.getNotes());
            System.out.println("11. Done");

            System.out.print("Enter your choice: ");
            int fieldChoice = getIntInput();

            switch (fieldChoice) {
                case 1 -> {
                    System.out.print("Enter new First Name: ");
                    client.setFirstName(scanner.nextLine().trim());
                }
                case 2 -> {
                    System.out.print("Enter new Last Name: ");
                    client.setLastName(scanner.nextLine().trim());
                }
                case 3 -> {
                    System.out.print("Enter new Company: ");
                    client.setCompany(scanner.nextLine().trim());
                }
                case 4 -> {
                    System.out.print("Enter new Email: ");
                    client.setEmail(scanner.nextLine().trim());
                }
                case 5 -> {
                    System.out.print("Enter new Phone: ");
                    client.setPhone(scanner.nextLine().trim());
                }
                case 6 -> {
                    System.out.print("Enter new Street Address: ");
                    client.setStreetAddress(scanner.nextLine().trim());
                }
                case 7 -> {
                    System.out.print("Enter new City: ");
                    client.setCity(scanner.nextLine().trim());
                }
                case 8 -> {
                    System.out.print("Enter new State: ");
                    client.setState(scanner.nextLine().trim());
                }
                case 9 -> {
                    System.out.print("Enter new ZIP: ");
                    client.setZip(scanner.nextLine().trim());
                }
                case 10 -> {
                    System.out.print("Enter new Notes: ");
                    client.setNotes(scanner.nextLine().trim());
                }
                case 11 -> {
                    done = true;
                    System.out.println("✅ Client record updated successfully!");
                }
                default -> System.out.println("⚠️ Invalid choice. Try again.");
            }
        }
    }


    // ----------------------------
    // 3. Remove Client
    // ----------------------------
    private void removeClient() {
        System.out.println("\n=== REMOVE CLIENT ===");

        // Catches an empty client list
        if (manager.getAllClients().isEmpty()) {
            System.out.println("⚠️ There are no clients in the system to remove.");
            return;
        }

        // Displays all clients on the list.
        displayClientList();

        while (true) {
            System.out.print("Enter ID to remove (0 to cancel): ");
            int id = getIntInput();

            if (id == 0) {
                System.out.println("Removal canceled.");
                return; // Exits upon user request.
            }

            if (manager.removeClient(id)) {
                System.out.println("❌ Client removed from system. ID: " + id);
                return; // Exits once removal is successful.
            } else {
                System.out.println("⚠️ No client found with ID: " + id);
            }
        }
    }

    // ----------------------------
    // 4. View Client Directory (Submenu)
    // ----------------------------
    private void viewClientDirectory() {
        boolean back = false;
        while (!back) {
            System.out.println("\n=== CLIENT DIRECTORY ===");
            if (manager.getAllClients().isEmpty()) {
                System.out.println("⚠️ There are no clients in the system.");
                return;
            }

            // Displays all client on the list.
            displayClientList();

            System.out.print("Enter Client ID to view details (0 to go back): ");
            int id = getIntInput();

            if (id == 0) {
                back = true;
                continue;
            }

            Client selected = manager.findClientById(id);
            if (selected == null) {
                // Client list is shown again, loop restarts
                System.out.println("⚠️ No client found with ID: " + id);
            } else {
                showClientDetails(selected);
            }
        }
    }

    private void showClientDetails(Client c) {
        System.out.println("\n=== CLIENT DETAILS ===");
        System.out.println("ID: " + c.getId());
        System.out.println("Name: " + c.getFirstName() + " " + c.getLastName());
        System.out.println("Company: " + c.getCompany());
        System.out.println("Email: " + c.getEmail());
        System.out.println("Phone: " + c.getPhone());
        System.out.println("Address: " + c.getStreetAddress() + ", " + c.getCity() + ", " + c.getState() + " " + c.getZip());
        System.out.println("Notes: " + c.getNotes());
        System.out.println("==========================");
    }

    // ------------------------------------------------
// Checks to see if user input matches integer type
// ------------------------------------------------
    private int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim()); // clean & direct
            } catch (NumberFormatException e) {
                System.out.print("⚠️ Please enter a valid number: ");
            }
        }
    }
}
