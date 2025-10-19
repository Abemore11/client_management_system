public class Main {
    public static void main(String[] args) {
        System.out.println("Client Management System");

        // Instantiate a ClientManager object
        ClientManager clientManager = new ClientManager();

        // Instantiate a CliMenu object
        CliMenu menu = new CliMenu(clientManager);

        menu.start();
    }
}