# Design & Architecture Documentation

## Architecture Overview

This chatbot uses a **layered architecture** with clear separation of concerns:

```
User Input (Console)
    ↓
Main.java (Controller)
    ↓
Chatbot.java (Orchestrator)
    ↓
┌─────────────────────────────────────┐
│  UserInputProcessor.java (Analyzer) │ → Intent Recognition
│  ResponseHandler.java (Generator)   │ → Response Creation
│  FAQDataset.java (Database)         │ → FAQ Lookup
└─────────────────────────────────────┘
    ↓
Output to Console
```

## Class Responsibilities

### 1. Main.java
- **Role**: Program entry point
- **Responsibilities**:
  - Initialize chatbot
  - Handle user input loop
  - Manage program lifecycle
  - Detect exit commands
- **Key Methods**: `main()`

### 2. Chatbot.java
- **Role**: Orchestrator/Controller
- **Responsibilities**:
  - Route user input to appropriate handlers
  - Determine response type
  - Manage conversation state
  - Apply typing effect
- **Key Methods**: 
  - `getResponse()` - Main decision logic
  - `printResponse()` - Typing effect
  - `isExitCommand()` - Exit detection

### 3. ResponseHandler.java
- **Role**: Response generator
- **Responsibilities**:
  - Generate contextually appropriate responses
  - Maintain response variety
  - Handle different response types
- **Response Types**:
  - Greeting responses
  - FAQ responses
  - Positive sentiment responses
  - Negative sentiment responses
  - Unknown input responses

### 4. UserInputProcessor.java
- **Role**: Input analyzer
- **Responsibilities**:
  - Classify user intent
  - Detect sentiment
  - Recognize patterns
  - Keyword matching
- **Intent Types**:
  - Greeting intent
  - Help request
  - FAQ query
  - Sentiment (positive/negative)

### 5. FAQDataset.java
- **Role**: Knowledge base
- **Responsibilities**:
  - Store FAQ data
  - Search FAQ database
  - Keyword matching for answers
- **Storage**: HashMap with String key-value pairs

---

## Data Flow Example

### Scenario: User asks "How do I learn Java?"

```
1. User input: "How do I learn Java?"
   ↓
2. Main.java → reads input → passes to Chatbot
   ↓
3. Chatbot.java → processes input:
   - Convert to lowercase: "how do i learn java?"
   - Check greeting? No
   - Check help? No
   - Check FAQ? YES (contains "learn" and "java")
   ↓
4. UserInputProcessor.isFAQQuery() → returns true
   ↓
5. Chatbot calls handleFAQQuery()
   ↓
6. FAQDataset.searchFAQ() → searches for matching FAQ
   - Finds: "how to learn java"
   - Returns: "Here are some steps to learn Java..."
   ↓
7. ResponseHandler receives the FAQ answer
   ↓
8. Chatbot.printResponse() → prints with typing effect
   ↓
9. Output to user with ~20ms delay per character
```

---

## Design Patterns Used

### 1. **Separation of Concerns**
Each class has ONE job:
- Input processing (UserInputProcessor)
- Response generation (ResponseHandler)
- Data storage (FAQDataset)
- Orchestration (Chatbot)

### 2. **Strategy Pattern (Implicit)**
Different response strategies based on intent:
- Greeting → greeting strategy
- FAQ → FAQ strategy
- Sentiment → sentiment strategy
- Unknown → fallback strategy

### 3. **State Management**
- Message counter tracks conversation state
- Input validation prevents empty messages
- Exit detection manages lifecycle

### 4. **Random Selection**
Response variety through randomization:
```java
Random random = new Random();
String response = responses[random.nextInt(responses.length)];
```

---

## Key Algorithms

### 1. Intent Recognition
```
Intent Recognition Algorithm:
├── Input: user_input (lowercase)
├── Check each intent type:
│   ├── isGreeting(input)
│   ├── isHelpRequest(input)
│   ├── isFAQQuery(input)
│   ├── isSentimentPositive(input)
│   └── isSentimentNegative(input)
└── Return appropriate response
```

### 2. FAQ Search
```
FAQ Search Algorithm:
├── Input: query
├── Try exact keyword match:
│   └── for each FAQ keyword: if query contains it → return answer
├── Try partial match:
│   └── for each FAQ word: if query contains word → return answer
└── Return empty string if no match
```

### 3. Sentiment Analysis
```
Sentiment Detection:
├── Positive: Check if any positive words in input
│   └── Words: "good", "great", "awesome", etc.
├── Negative: Check if any negative words in input
│   └── Words: "bad", "hate", "terrible", etc.
└── Return sentiment type
```

---

## Extensibility Points

### Adding New FAQ
**File**: `FAQDataset.java`
```java
faqMap.put("new question pattern", "answer here");
```

### Adding New Intent
**File**: `UserInputProcessor.java`
```java
public boolean isNewIntent(String input) {
    String[] keywords = {"keyword1", "keyword2"};
    for (String keyword : keywords) {
        if (input.contains(keyword)) return true;
    }
    return false;
}
```

**File**: `Chatbot.java` (in getResponse())
```java
if (inputProcessor.isNewIntent(processedInput)) {
    return responseHandler.getNewResponse();
}
```

### Adding New Response Type
**File**: `ResponseHandler.java`
```java
public String getNewResponse() {
    String[] responses = {"Response 1", "Response 2"};
    return responses[random.nextInt(responses.length)];
}
```

---

## Performance Considerations

### Time Complexity
- Intent recognition: O(n) where n = number of keywords
- FAQ search: O(m) where m = number of FAQs
- Overall: O(n + m) per user input

### Space Complexity
- FAQ storage: O(k) where k = number of FAQs
- Response arrays: O(1) fixed size
- Overall: O(k) space

### Typing Effect Impact
- Adds ~2-3 seconds per response
- Intentional delay for natural feel
- Can be disabled by removing sleep logic

---

## Error Handling Strategy

| Scenario | Handling |
|----------|----------|
| Empty input | Skip (continue loop) |
| Unknown input | Return generic unknown response |
| No FAQ match | Return unknown response |
| Interrupted thread | Complete printing |

---

## Code Quality Metrics

| Metric | Value |
|--------|-------|
| Lines of Code | ~350 |
| Number of Classes | 5 |
| Methods per Class | 3-6 |
| Cyclomatic Complexity | Low (mostly if-else) |
| Code Duplication | Minimal |
| Documentation | Javadoc comments on all classes |

---

## Testing Recommendations

### Unit Test Ideas
- `UserInputProcessor`: Test intent recognition
- `FAQDataset`: Test search functionality
- `ResponseHandler`: Test response generation
- `Chatbot`: Test conversation flow

### Integration Test Ideas
- Full conversation flow
- Exit command detection
- Multiple message sequences

### Manual Testing Checklist
- [ ] Greeting variations ("hi", "hello", "hey")
- [ ] FAQ queries
- [ ] Exit commands
- [ ] Sentiment detection
- [ ] Unknown inputs
- [ ] Empty inputs
- [ ] Case insensitivity
- [ ] Message counter accuracy

---

## Future Architecture Improvements

### Phase 2: Persistence
- Add chat history logging
- Save conversations to file

### Phase 3: ML Integration
- Replace keyword matching with ML model
- Use Naive Bayes or similar for classification

### Phase 4: GUI
- Add Java Swing interface
- Replace console with window

### Phase 5: API Integration
- Connect to real APIs
- Get live data for responses

---

**This architecture keeps the chatbot simple yet extensible!** 🏗️
