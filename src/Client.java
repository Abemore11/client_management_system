/**
 * ============================================================
 * Client.java
 * ============================================================
 * <p>
 * The Client class represents an individual client record within the
 * Client Management System. It serves as a Plain Old Java Object (POJO)
 * used to encapsulate all client-related data and provide controlled
 * access through getters and setters.
 * <p>
 * Primary Role:
 * Acts as the "Model" in a Model–View–Controller (MVC) architecture,
 * holding data that can be accessed and managed by other components
 * (ClientManager and user interface).
 * <p>
 * Responsibilities:
 * - Store client details in private fields
 * - Provide encapsulated access via public getters and setters
 * - Instantiation through a parameterized constructor
 * - Delegate all data management, validation, and display logic to external classes
 * ===============================================================
 */


public class Client {

    // Encapsulated fields
    private int id;
    private String firstName;
    private String lastName;
    private String company;
    private String email;
    private String phone; // Will handle parentheses, dashes, and spaces
    private String streetAddress;
    private String city;
    private String state;
    private String zip; // Will handle non-numeric chars
    private String notes;


    // ------------------------------------------------
    // Partial Constructor.
    // Client ID is generated and assigned externally.
    // ------------------------------------------------
    public Client(String firstName, String lastName, String company,
                  String email, String phone, String streetAddress,
                  String city, String state, String zip, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.email = email;
        this.phone = phone;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.notes = notes;
    }


    // Getters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getNotes() {
        return notes;
    }


    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
