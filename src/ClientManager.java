import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ============================================================
 * ClientManager.java
 * ============================================================
 * <p>
 * The ClientManager class serves as the business logic layer
 * for managing client records in the Client Management System.
 * <p>
 * Primary Role:
 * - Acts as the "Controller" in the MVC structure for client data.
 * - Handles creation, retrieval, updating, and removal of Client objects.
 * <p>
 * Responsibilities:
 * - Maintain an in-memory list of all Client objects.
 * - Generate unique IDs for new clients (beginning with #1010).
 * - Provide methods for finding, adding, and removing clients.
 * - Offer helper methods for validating user input (e.g., non-empty fields, valid email).
 * ============================================================
 */

public class ClientManager {

    private List<Client> clients;

    // auto-incrementing ID for each new client
    private int nextId = 1010;
    private Scanner scanner;

    public ClientManager() {
        this.clients = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // ------------------------------------------------
    // Adds a new client to the system.
    // Loops until valid input is provided for each required field.
    // ------------------------------------------------
    public void addClient() {
        System.out.println("\n=== Add New Client ===");

        String firstName = prompt("Enter first name: ");
        String lastName = prompt("Enter last name: ");
        String company = prompt("Enter company name: ");
        String email = emailPromptValidated();
        String phone = prompt("Enter phone number: ");
        String streetAddress = prompt("Enter street address: ");
        String city = prompt("Enter city: ");
        String state = prompt("Enter state: ");
        String zip = prompt("Enter ZIP code: ");
        String notes = prompt("Enter notes: ");

        // Create client using validated input
        Client newClient = new Client(firstName, lastName, company, email, phone, streetAddress, city, state, zip, notes);
        // Gives the new client a unique ID
        newClient.setId(nextId++);
        clients.add(newClient);

        System.out.println("✅ " + firstName + " " + lastName + " was added to the system successfully! ID: " + newClient.getId());
    }

    // ------------------------------------------------
    // Helper function.
    // Prompts the user for input - ensures input is not empty.
    // ------------------------------------------------
    private String prompt(String message) {
        String input;
        do {
            System.out.print(message);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("⚠️ This field cannot be empty.");
                System.out.println("⚠️ Enter N/A for missing info.");
            }
        } while (input.isEmpty());
        return input;
    }

    // ------------------------------------------------
    // Helper function.
    // Prompts for input and checks that it contains '@'.
    // ------------------------------------------------
    private String emailPromptValidated() {
        String input;
        do {
            System.out.print("Enter email address: ");
            input = scanner.nextLine().trim();
            if (!input.contains("@")) {
                System.out.println("⚠️ Invalid input. Please include '@' in the email.");
                input = "";
            }
        } while (input.isEmpty());
        return input;
    }


    // Retrieval of all clients
    public List<Client> getAllClients() {
        return new ArrayList<>(clients);
    }

    // Returns specified client
    public Client findClientById(int id) {
        for (Client c : clients) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    // Removes client from list
    public boolean removeClient(int id) {
        Client client = findClientById(id);
        if (client != null) {
            clients.remove(client);
            return true;
        } else {
            return false;
        }
    }
}
