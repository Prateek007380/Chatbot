import java.util.Scanner;

/**
 * Main class to run the chatbot application
 * This is the entry point for the program
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("\n========================================");
        System.out.println("     Welcome to AI Chatbot v1.0");
        System.out.println("========================================\n");
        
        Chatbot chatbot = new Chatbot();
        Scanner scanner = new Scanner(System.in);
        
        // Show initial greeting
        chatbot.printGreeting();
        
        // Main conversation loop
        boolean running = true;
        while (running) {
            System.out.print("You: ");
            String userInput = scanner.nextLine().trim();
            
            // Check if user wants to exit
            if (userInput.isEmpty()) {
                continue;
            }
            
            if (chatbot.isExitCommand(userInput)) {
                chatbot.printGoodbye();
                running = false;
            } else {
                // Get and display chatbot response
                String response = chatbot.getResponse(userInput);
                chatbot.printResponse(response);
            }
        }
        
        scanner.close();
    }
}
