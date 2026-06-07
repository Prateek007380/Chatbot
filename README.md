# AI Chatbot Project (Java)

A student-built, rule-based chatbot application written in Java. This project demonstrates core Java concepts including OOP, string processing, and basic NLP techniques.

## Project Overview

This chatbot is designed to:
- Engage in natural conversations
- Handle common greetings and questions
- Respond to FAQ queries about Java, programming, and chatbots
- Detect user sentiment (positive/negative)
- Provide helpful information and guidance
- Feel human-like and natural (not robotic)

## Features

✅ **Multiple Response Types**
- Greeting responses
- FAQ answers about Java and programming
- Help/command information
- Sentiment-aware responses
- Error handling for unknown inputs

✅ **Input Processing**
- Intent recognition (what the user wants)
- Keyword detection
- Multiple input variations (e.g., "hi", "hello", "hey")
- Case-insensitive matching

✅ **User Experience**
- Typing effect for natural feel
- Randomized responses for variety
- Clean console interface
- Message counter
- Proper exit handling

✅ **Code Quality**
- Clean OOP design with 5 classes
- Meaningful variable names and comments
- Single responsibility principle
- Easy to understand and extend

## Project Structure

```
ChatbotProject/
├── src/
│   ├── Main.java              # Entry point
│   ├── Chatbot.java           # Core chatbot logic
│   ├── ResponseHandler.java   # Response generation
│   ├── UserInputProcessor.java # Intent & sentiment recognition
│   └── FAQDataset.java        # FAQ database
└── README.md                  # This file
```

## How to Run

### Step 1: Compile the code
Navigate to the `src` directory and compile all Java files:

```bash
cd ChatbotProject/src
javac *.java
```

### Step 2: Run the chatbot
```bash
java Main
```

You should see:
```
========================================
     Welcome to AI Chatbot v1.0
========================================

Bot: Hey! I'm your AI assistant. Ask me anything or type 'help' for commands.

You: 
```

### Step 3: Interact with the chatbot
Try these example inputs:
- "hello" or "hi" → Get a greeting
- "help" → See available commands
- "what is java?" → Get FAQ answer
- "how do i learn programming?" → Get learning guide
- "I love this!" → Get positive sentiment response
- "bye" → Exit the chatbot

## Example Conversation

```
Bot: Hey! I'm your AI assistant. Ask me anything or type 'help' for commands.

You: hi
Bot: Hey! What can I help you with today?

You: what is java?
Bot: Java is a popular object-oriented programming language...

You: can you teach me?
Bot: I didn't quite understand that. Could you rephrase?

You: how to learn java
Bot: Here are some steps to learn Java:
1. Start with basics: variables, data types, loops
...

You: thanks so much!
Bot: That's awesome! I'm glad!

You: bye
Bot: Bye! It was nice talking to you. Have a great day!
```

## Code Highlights

### OOP Principles Used
1. **Encapsulation**: Each class handles specific responsibilities
2. **Single Responsibility**: Chatbot handles logic, ResponseHandler handles responses, etc.
3. **Modularity**: Easy to add new features without modifying existing code
4. **Clean Code**: Simple, readable variable names and logic

### Key Classes

**Main.java**
- Entry point
- Manages user input loop
- Controls program flow

**Chatbot.java**
- Core intelligence
- Intent recognition
- Conversation management
- Greeting/goodbye handling

**ResponseHandler.java**
- Response generation
- Multiple response variants
- Sentiment-based responses

**UserInputProcessor.java**
- Intent detection (greeting, help, FAQ, sentiment)
- Keyword matching
- Input classification

**FAQDataset.java**
- FAQ database
- Search functionality
- Keyword matching for answers

## Features Explained

### 1. Typing Effect
The chatbot simulates typing with a typing effect when responding:
```java
for (int i = 0; i < response.length(); i++) {
    System.out.print(response.charAt(i));
    Thread.sleep(new Random().nextInt(20) + 10);
}
```
This makes the bot feel more human-like.

### 2. Sentiment Detection
The chatbot recognizes positive and negative words:
- Positive: "good", "great", "awesome", "love"
- Negative: "bad", "hate", "terrible", "frustrated"

### 3. Intent Recognition
Multiple input variations are recognized:
- Greeting: "hi", "hello", "hey", "what's up"
- Help: "help", "commands", "how does this work"
- Exit: "bye", "exit", "quit", "goodbye"

### 4. Randomized Responses
Responses are randomly selected from arrays to feel natural:
```java
String[] greetings = {"Hi there!", "Hey!", "Hello!"};
String response = greetings[random.nextInt(greetings.length)];
```

## How It Works

1. **User Input**: User types a message
2. **Processing**: Input is converted to lowercase and trimmed
3. **Intent Recognition**: System determines what user wants
4. **Response Generation**: Appropriate response is selected
5. **Typing Effect**: Response is printed with simulated typing
6. **Loop**: Returns to step 1

## Extending the Chatbot

### Add new FAQ
Edit `FAQDataset.java` and add to the `faqMap`:
```java
faqMap.put("what is machine learning", 
    "Machine learning is...");
```

### Add new intents
Edit `UserInputProcessor.java`:
```java
public boolean isMyNewIntent(String input) {
    String[] keywords = {"keyword1", "keyword2"};
    // implementation
}
```

### Add new responses
Edit `ResponseHandler.java`:
```java
public String getMyCustomResponse() {
    String[] responses = {"Response 1", "Response 2"};
    return responses[random.nextInt(responses.length)];
}
```

## Technical Details

- **Language**: Java (Core Java)
- **JDK**: Java 8 or higher
- **Approach**: Rule-based chatbot with keyword matching
- **Algorithm**: Intent matching + FAQ database search
- **No external libraries**: Pure Java implementation

## Limitations & Future Improvements

### Current Limitations
- Rule-based (no machine learning)
- Limited to predefined patterns
- No context memory (forgets previous conversations)
- FAQ database is hardcoded

### Possible Improvements
1. Add machine learning (Naive Bayes, etc.)
2. Use a file-based FAQ database (JSON/CSV)
3. Implement conversation context tracking
4. Add GUI using Java Swing
5. Connect to external APIs
6. Add logging functionality
7. Implement spell-check correction
8. Add multi-language support

## Portfolio Notes

This project demonstrates:
- ✅ Understanding of OOP concepts (classes, methods, encapsulation)
- ✅ String manipulation and pattern matching
- ✅ Collection usage (HashMap for FAQ)
- ✅ Control flow (loops, conditionals)
- ✅ Clean code practices
- ✅ Problem-solving approach
- ✅ Real-world application building

Great for adding to portfolio or GitHub!

## Author Notes

This chatbot was built as a learning project to understand:
- How chatbots work fundamentally
- NLP basics (intent recognition, keyword matching)
- OOP design patterns
- User experience in CLI applications
- Response randomization for natural feel

Feel free to modify, extend, and use this project for learning!

---

**Questions?** Try asking the chatbot about Java, programming, or chatbots in general! 💬
