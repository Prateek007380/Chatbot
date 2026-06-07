/**
 * UserInputProcessor class - processes and categorizes user input
 * Handles intent recognition and input classification
 */
public class UserInputProcessor {
    
    /**
     * Check if user input is a greeting
     */
    public boolean isGreeting(String input) {
        String[] greetings = {"hello", "hi", "hey", "greetings", "what's up", "whats up", "howdy"};
        
        for (String greeting : greetings) {
            if (input.contains(greeting)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Check if user is asking for help
     */
    public boolean isHelpRequest(String input) {
        String[] helpKeywords = {"help", "what can you do", "commands", "how does this work", 
                                  "how to use", "guide", "info"};
        
        for (String keyword : helpKeywords) {
            if (input.contains(keyword)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Check if user is asking a FAQ-related question
     */
    public boolean isFAQQuery(String input) {
        String[] faqKeywords = {"java", "course", "learning", "programming", "chatbot", 
                               "database", "python", "c++", "web", "question"};
        
        for (String keyword : faqKeywords) {
            if (input.contains(keyword)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Detect if user sentiment is positive
     */
    public boolean isSentimentPositive(String input) {
        String[] positiveWords = {"good", "great", "awesome", "excellent", "love", "thank", 
                                 "thanks", "nice", "cool", "amazing", "perfect", "wonderful",
                                 "happy", "yay", "excellent", "brilliant"};
        
        for (String word : positiveWords) {
            if (input.contains(word)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Detect if user sentiment is negative
     */
    public boolean isSentimentNegative(String input) {
        String[] negativeWords = {"bad", "hate", "terrible", "awful", "stupid", "dumb", 
                                 "annoying", "frustrated", "angry", "sad", "upset",
                                 "worst", "horrible", "useless"};
        
        for (String word : negativeWords) {
            if (input.contains(word)) {
                return true;
            }
        }
        return false;
    }
}
