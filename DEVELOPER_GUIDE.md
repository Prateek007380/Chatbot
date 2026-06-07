# Developer Guide - Modifying the Chatbot

## Quick Reference for Common Tasks

### Task 1: Add a New FAQ Answer

**File**: `src/FAQDataset.java`

**Location**: Inside the `static` block (around line 14-40)

**How to add**:
```java
faqMap.put("your question pattern", 
    "Your answer here...");
```

**Example**:
```java
faqMap.put("what is python",
    "Python is a popular programming language...");
```

**Test it**: Type "python" and you should get your answer!

---

### Task 2: Add a New Greeting

**File**: `src/ResponseHandler.java`

**Location**: `getGreetingResponse()` method (around line 15)

**How to add**:
```java
String[] responses = {
    "Hi there! How's it going? 😊",
    "Hey! What's up?",
    "YOUR NEW GREETING HERE!",  // Add here
    "Hey! What can I help you with today?"
};
```

**Example**:
```java
String[] responses = {
    "Howdy! What can I do for you?",  // New greeting
    "Yo! What's good?",                // New greeting
    // ... existing responses
};
```

---

### Task 3: Add New Keywords to Greeting Recognition

**File**: `src/UserInputProcessor.java`

**Location**: `isGreeting()` method (around line 10)

**How to add**:
```java
String[] greetings = {
    "hello", "hi", "hey", 
    "YOUR_NEW_KEYWORD_HERE"  // Add here
};
```

**Example**:
```java
String[] greetings = {
    "hello", "hi", "hey", "greetings",
    "yo", "what's good", "howdy"  // New keywords
};
```

---

### Task 4: Add New Positive Sentiment Words

**File**: `src/UserInputProcessor.java`

**Location**: `isSentimentPositive()` method (around line 50)

**How to add**:
```java
String[] positiveWords = {
    "good", "great", "awesome",
    "YOUR_NEW_WORD_HERE"  // Add here
};
```

**Example**:
```java
String[] positiveWords = {
    "good", "great", "awesome",
    "wonderful", "fantastic", "rad"  // New positive words
};
```

---

### Task 5: Add New Negative Sentiment Words

**File**: `src/UserInputProcessor.java`

**Location**: `isSentimentNegative()` method (around line 65)

**How to add**:
```java
String[] negativeWords = {
    "bad", "hate", "terrible",
    "YOUR_NEW_WORD_HERE"  // Add here
};
```

**Example**:
```java
String[] negativeWords = {
    "bad", "hate", "terrible",
    "awful", "disappointing", "yuck"  // New negative words
};
```

---

### Task 6: Change Typing Speed Effect

**File**: `src/Chatbot.java`

**Location**: `printResponse()` method (around line 93)

**Current speed**:
```java
Thread.sleep(new Random().nextInt(20) + 10);  // 10-30ms delay
```

**To make faster** (5-15ms):
```java
Thread.sleep(new Random().nextInt(10) + 5);
```

**To make slower** (50-80ms):
```java
Thread.sleep(new Random().nextInt(30) + 50);
```

**To disable completely**:
```java
// Comment out the sleep line:
// Thread.sleep(new Random().nextInt(20) + 10);
```

---

### Task 7: Add New Intent Type

**Step 1**: Add recognition method in `UserInputProcessor.java`
```java
public boolean isMyNewIntent(String input) {
    String[] keywords = {"keyword1", "keyword2", "keyword3"};
    for (String keyword : keywords) {
        if (input.contains(keyword)) {
            return true;
        }
    }
    return false;
}
```

**Step 2**: Add response method in `ResponseHandler.java`
```java
public String getMyNewResponse() {
    String[] responses = {
        "Response 1",
        "Response 2",
        "Response 3"
    };
    return responses[random.nextInt(responses.length)];
}
```

**Step 3**: Add check in `Chatbot.getResponse()` (around line 26)
```java
if (inputProcessor.isMyNewIntent(processedInput)) {
    return responseHandler.getMyNewResponse();
}
```

**Example - Add Weather Intent**:
```java
// In UserInputProcessor:
public boolean isWeatherQuery(String input) {
    String[] keywords = {"weather", "rain", "sunny", "temperature", "cold"};
    for (String keyword : keywords) {
        if (input.contains(keyword)) {
            return true;
        }
    }
    return false;
}

// In ResponseHandler:
public String getWeatherResponse() {
    String[] responses = {
        "I don't have live weather data, but I hope it's nice! 🌤️",
        "Weather's important! Check a weather app for details.",
        "I wish I could tell you the weather! ☀️"
    };
    return responses[random.nextInt(responses.length)];
}

// In Chatbot.getResponse():
if (inputProcessor.isWeatherQuery(processedInput)) {
    return responseHandler.getWeatherResponse();
}
```

---

### Task 8: Change Exit Commands

**File**: `src/Chatbot.java`

**Location**: `isExitCommand()` method (around line 77)

**Current exits**: "bye", "exit", "quit", "goodbye", "see you", "leave"

**How to customize**:
```java
String[] exitCommands = {
    "bye", "exit", "quit",
    "YOUR_NEW_EXIT_HERE"  // Add here
};
```

**Example**:
```java
String[] exitCommands = {
    "bye", "exit", "quit", "goodbye",
    "cya", "peace out", "gotta go"  // New exit commands
};
```

---

### Task 9: Change Goodbye Messages

**File**: `src/Chatbot.java`

**Location**: `printGoodbye()` method (around line 88)

**How to customize**:
```java
String[] goodbyes = {
    "Bye! It was nice talking to you. Have a great day! 👋",
    "YOUR_NEW_GOODBYE_HERE",  // Add here
};
```

**Example**:
```java
String[] goodbyes = {
    "Catch you later! 👋",
    "Thanks for chatting! Peace! ✌️",
    "Until next time, friend!"
};
```

---

### Task 10: Add More FAQ Topics

**File**: `src/FAQDataset.java`

**Location**: Inside `static` block (add before closing brace)

**How to add multiple FAQs**:
```java
faqMap.put("what is git",
    "Git is a version control system...");

faqMap.put("what is sql",
    "SQL is a language for managing databases...");

faqMap.put("how to debug",
    "Debugging is the process of finding and fixing errors...");
```

---

## Code Structure Reference

### Main.java Structure
```
Main
├── main(String[] args)
│   ├── Create Chatbot instance
│   ├── Create Scanner
│   ├── Show greeting
│   ├── While loop for conversation
│   │   ├── Get user input
│   │   ├── Check if exit
│   │   ├── Get response
│   │   └── Print response
│   └── Close scanner
```

### Chatbot.java Structure
```
Chatbot
├── Fields
│   ├── responseHandler
│   ├── inputProcessor
│   └── messageCount
├── getResponse(String)
│   └── Intent recognition logic
├── isExitCommand(String)
└── printResponse(String)
    └── Typing effect logic
```

### ResponseHandler.java Structure
```
ResponseHandler
├── getGreetingResponse()
├── getHelpMessage()
├── getPositiveResponse()
├── getNegativeResponse()
├── getUnknownResponse()
└── (Add more response methods here)
```

### UserInputProcessor.java Structure
```
UserInputProcessor
├── isGreeting(String)
├── isHelpRequest(String)
├── isFAQQuery(String)
├── isSentimentPositive(String)
├── isSentimentNegative(String)
└── (Add more intent methods here)
```

### FAQDataset.java Structure
```
FAQDataset
├── static {
│   └── faqMap initialization
│       ├── Java FAQs
│       ├── Programming FAQs
│       ├── Chatbot FAQs
│       └── (Add more FAQs here)
├── searchFAQ(String)
└── getMainKeyword(String)
```

---

## Common Modifications Checklist

- [ ] Add new FAQ answers
- [ ] Add new greeting responses
- [ ] Add new positive/negative sentiment words
- [ ] Add new greeting keywords
- [ ] Adjust typing speed
- [ ] Add new intent type
- [ ] Change exit commands
- [ ] Customize goodbye messages
- [ ] Add new response types

---

## Testing After Modifications

1. **Recompile code**:
   ```bash
   cd src
   javac *.java
   ```

2. **Run program**:
   ```bash
   java Main
   ```

3. **Test your changes**:
   - Try keywords related to your modification
   - Test edge cases (empty input, case sensitivity)
   - Verify randomization works

---

## Common Issues & Solutions

| Issue | Solution |
|-------|----------|
| Changes not working | Recompile with `javac *.java` |
| Syntax error | Check for missing semicolons, quotes, braces |
| Method not found | Check spelling and ensure method exists |
| Array errors | Count brackets, ensure proper syntax |
| String not found | Check exact string matching in arrays |

---

## Code Style Guidelines

When adding code, follow these patterns:

**✓ Do this:**
```java
String[] responses = {
    "Response 1",
    "Response 2",
    "Response 3"
};
```

**✗ Don't do this:**
```java
String[] responses = {"Response 1","Response 2","Response 3"};
```

**✓ Do this:**
```java
if (input.contains(keyword)) {
    return true;
}
```

**✗ Don't do this:**
```java
if(input.contains(keyword))return true;
```

---

## Adding Comments

Use meaningful comments (not excessive):

**✓ Good:**
```java
// Check if user is asking for help
public boolean isHelpRequest(String input) {
```

**✗ Bad:**
```java
// Loop through help keywords
for (String keyword : helpKeywords) {
```

---

## Next Steps for Enhancement

1. **Short-term**:
   - Add more FAQ answers
   - Increase response variety
   - Add more sentiment words

2. **Medium-term**:
   - Add conversation context (remember previous messages)
   - Create separate configuration file for FAQ
   - Add spell-check functionality

3. **Long-term**:
   - Add machine learning classification
   - Create GUI with Swing
   - Add database integration
   - Add multi-language support

---

**Happy coding!** If you get stuck, refer to ARCHITECTURE.md or TEST_CASES.md for examples. 🚀
