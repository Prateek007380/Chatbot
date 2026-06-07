import java.util.Random;

/**
 * Chatbot class - handles the main chatbot logic and conversation flow
 * This is where the intelligence of the chatbot lives
 */
public class Chatbot {
    
    private ResponseHandler responseHandler;
    private UserInputProcessor inputProcessor;
    private int messageCount;
    
    public Chatbot() {
        this.responseHandler = new ResponseHandler();
        this.inputProcessor = new UserInputProcessor();
        this.messageCount = 0;
    }
    
    /**
     * Print greeting message when chatbot starts
     */
    public void printGreeting() {
        String[] greetings = {
            "Hey! I'm your AI assistant. Ask me anything or type 'help' for commands.",
            "Hi there! 👋 I'm here to chat. Feel free to ask me questions!",
            "Welcome! I'm a chatbot here to help. What would you like to know?"
        };
        
        String greeting = greetings[new Random().nextInt(greetings.length)];
        printResponse(greeting);
    }
    
    /**
     * Get response from the chatbot based on user input
     */
    public String getResponse(String userInput) {
        this.messageCount++;
        
        // Convert input to lowercase and remove extra spaces
        String processedInput = userInput.toLowerCase().trim();
        
        // Check for different intent types
        if (inputProcessor.isGreeting(processedInput)) {
            return responseHandler.getGreetingResponse();
        }
        
        if (inputProcessor.isHelpRequest(processedInput)) {
            return responseHandler.getHelpMessage();
        }
        
        if (inputProcessor.isFAQQuery(processedInput)) {
            return handleFAQQuery(processedInput);
        }
        
        if (inputProcessor.isSentimentPositive(processedInput)) {
            return responseHandler.getPositiveResponse();
        }
        
        if (inputProcessor.isSentimentNegative(processedInput)) {
            return responseHandler.getNegativeResponse();
        }
        
        // Default response for unknown input
        return responseHandler.getUnknownResponse();
    }
    
    /**
     * Handle FAQ queries by searching the dataset
     */
    private String handleFAQQuery(String userInput) {
        String faqResponse = FAQDataset.searchFAQ(userInput);
        if (faqResponse != null && !faqResponse.isEmpty()) {
            return faqResponse;
        }
        return responseHandler.getUnknownResponse();
    }
    
    /**
     * Check if the user wants to exit the chatbot
     */
    public boolean isExitCommand(String userInput) {
        String[] exitCommands = {"bye", "exit", "quit", "goodbye", "see you", "leave"};
        String processed = userInput.toLowerCase().trim();
        
        for (String command : exitCommands) {
            if (processed.contains(command)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Print goodbye message and exit
     */
    public void printGoodbye() {
        String[] goodbyes = {
            "Bye! It was nice talking to you. Have a great day! 👋",
            "See you later! Thanks for chatting with me!",
            "Goodbye! Come back soon if you have more questions!"
        };
        
        String goodbye = goodbyes[new Random().nextInt(goodbyes.length)];
        printResponse(goodbye);
        System.out.println("\n[Chat ended - " + messageCount + " messages exchanged]");
    }
    
    /**
     * Print response with typing effect to simulate thinking
     */
    public void printResponse(String response) {
        System.out.print("Bot: ");
        
        // Add typing delay for effect (makes it feel more natural)
        try {
            for (int i = 0; i < response.length(); i++) {
                System.out.print(response.charAt(i));
                // Random delay between 10-30ms to simulate typing
                if (i % 5 == 0) {
                    Thread.sleep(new Random().nextInt(20) + 10);
                }
            }
        } catch (InterruptedException e) {
            // If interrupted, just print the rest
            System.out.print(response.substring(Math.min(
                new Random().nextInt(response.length()), 
                response.length()
            )));
        }
        
        System.out.println("\n");
    }
}
