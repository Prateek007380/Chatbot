import java.util.HashMap;
import java.util.Map;

/**
 * FAQDataset class - contains frequently asked questions and answers
 * This is a simple hardcoded FAQ database
 */
public class FAQDataset {
    
    private static final Map<String, String> faqMap = new HashMap<>();
    
    // Initialize FAQ data
    static {
        // Java-related FAQs
        faqMap.put("what is java", 
            "Java is a popular object-oriented programming language. It's platform-independent " +
            "and runs on the Java Virtual Machine (JVM). Java is used for building desktop, web, " +
            "and mobile applications.");
        
        faqMap.put("how to learn java",
            "Here are some steps to learn Java:\n" +
            "1. Start with basics: variables, data types, loops\n" +
            "2. Learn OOP concepts: classes, objects, inheritance\n" +
            "3. Practice with small projects\n" +
            "4. Build a real project\n" +
            "5. Keep coding and exploring!");
        
        faqMap.put("what is oop",
            "OOP stands for Object-Oriented Programming. It's a programming paradigm that uses " +
            "'objects' and 'classes' to structure code. Key concepts include:\n" +
            "• Encapsulation\n" +
            "• Inheritance\n" +
            "• Polymorphism\n" +
            "• Abstraction");
        
        // Chatbot-related FAQs
        faqMap.put("what is a chatbot",
            "A chatbot is a software program designed to simulate conversation. It can understand " +
            "user input and provide relevant responses. Chatbots use techniques like pattern matching, " +
            "keyword detection, and machine learning to communicate.");
        
        faqMap.put("how does this chatbot work",
            "This chatbot uses rule-based approach with:\n" +
            "1. Intent recognition (what user wants)\n" +
            "2. Keyword detection (what keywords are present)\n" +
            "3. Pattern matching\n" +
            "4. Response generation\n" +
            "It's designed to be simple but effective!");
        
        // Programming-related FAQs
        faqMap.put("what is programming",
            "Programming is the process of creating a set of instructions that tell a computer " +
            "how to perform a specific task. It involves writing code in a programming language " +
            "to solve problems and build applications.");
        
        faqMap.put("what is coding",
            "Coding is writing code using programming language syntax. It's part of programming. " +
            "When you code, you're writing the actual statements that will be executed by a computer.");
        
        faqMap.put("what languages should i learn",
            "Popular languages to learn:\n" +
            "• Java - Great for beginners, widely used\n" +
            "• Python - Easy to learn, good for data science\n" +
            "• JavaScript - Essential for web development\n" +
            "• C++ - Good for performance-critical apps\n" +
            "• Start with one, then explore others!");
        
        // General FAQs
        faqMap.put("who are you",
            "I'm a chatbot built with Java! I'm here to answer questions and chat with you. " +
            "I was created as a student project to learn about NLP and conversation design.");
        
        faqMap.put("what can you do",
            "I can:\n" +
            "• Have conversations with you\n" +
            "• Answer common questions about programming and Java\n" +
            "• Respond to greetings\n" +
            "• Detect your sentiment\n" +
            "• Provide helpful information\n" +
            "Ask me anything!");
    }
    
    /**
     * Search FAQ database for a response
     * Returns the answer if found, otherwise returns empty string
     */
    public static String searchFAQ(String query) {
        if (query == null || query.isEmpty()) {
            return "";
        }
        
        // Convert query to lowercase for matching
        String lowerQuery = query.toLowerCase();
        
        // Try exact match first (or close match)
        for (String key : faqMap.keySet()) {
            if (lowerQuery.contains(key) || key.contains(getMainKeyword(lowerQuery))) {
                return faqMap.get(key);
            }
        }
        
        // If no exact match, try partial matching
        for (String key : faqMap.keySet()) {
            for (String word : key.split(" ")) {
                if (lowerQuery.contains(word) && word.length() > 3) {
                    return faqMap.get(key);
                }
            }
        }
        
        return "";
    }
    
    /**
     * Extract the main keyword from a query
     * Used for better matching
     */
    private static String getMainKeyword(String query) {
        String[] words = query.split(" ");
        for (String word : words) {
            if (word.length() > 3) {
                return word;
            }
        }
        return query;
    }
}
