import java.util.Random;

/**
 * ResponseHandler class - manages different types of responses
 * This class generates appropriate responses based on user intent
 */
public class ResponseHandler {
    
    private Random random;
    
    public ResponseHandler() {
        this.random = new Random();
    }
    
    /**
     * Get greeting responses
     */
    public String getGreetingResponse() {
        String[] responses = {
            "Hey! How's it going? 😊",
            "Hi there! What's up?",
            "Hello! Nice to talk to you!",
            "Hey! What can I help you with today?"
        };
        return responses[random.nextInt(responses.length)];
    }
    
    /**
     * Get help message with available commands
     */
    public String getHelpMessage() {
        return "Here's what I can help with:\n" +
               "• Greetings: Say 'hello', 'hi', 'hey'\n" +
               "• Questions: Ask about Java, Programming, Chatbots\n" +
               "• FAQs: Type 'course', 'java', 'learning'\n" +
               "• Exit: Type 'bye', 'exit', or 'quit'\n\n" +
               "Feel free to ask me anything!";
    }
    
    /**
     * Get responses for FAQ queries
     */
    public String getFAQResponse(String topic) {
        return FAQDataset.searchFAQ(topic);
    }
    
    /**
     * Get positive responses (when user is happy/positive)
     */
    public String getPositiveResponse() {
        String[] responses = {
            "That's awesome! I'm glad! 😄",
            "That's great to hear!",
            "I love the energy! Keep it up!",
            "Awesome! You're doing amazing!"
        };
        return responses[random.nextInt(responses.length)];
    }
    
    /**
     * Get negative responses (when user is frustrated/negative)
     */
    public String getNegativeResponse() {
        String[] responses = {
            "Oh no, I'm sorry to hear that. 😔",
            "That doesn't sound good... Is there anything I can help with?",
            "I understand, that must be frustrating.",
            "Don't worry, things will get better! How can I help?"
        };
        return responses[random.nextInt(responses.length)];
    }
    
    /**
     * Get response for unknown/unrecognized input
     */
    public String getUnknownResponse() {
        String[] responses = {
            "Hmm, I didn't quite understand that. Could you rephrase?",
            "I'm not sure what you mean... Can you explain more?",
            "That's interesting, but I don't have a good response for that yet.",
            "Sorry, I didn't catch that. Try asking something else!"
        };
        return responses[random.nextInt(responses.length)];
    }
}
