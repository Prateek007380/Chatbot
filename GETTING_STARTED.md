# Getting Started - Quick Setup Guide

## 30-Second Quick Start

### Windows Users:
```
1. Open Command Prompt
2. Navigate to: ChatbotProject directory
3. Double-click: run.bat
```

### Mac/Linux Users:
```
1. Open Terminal
2. Navigate to: ChatbotProject directory
3. Run: bash run.sh
```

### Manual Compilation (All Platforms):
```bash
cd ChatbotProject/src
javac *.java
java Main
```

---

## System Requirements

✓ **Java Development Kit (JDK)** 8 or higher
- Check if installed: `java -version`
- Download: https://www.oracle.com/java/technologies/downloads/

✓ **Any Terminal/Command Prompt**

---

## What You'll See

```
========================================
     Welcome to AI Chatbot v1.0
========================================

Bot: Hey! I'm your AI assistant. Ask me anything or type 'help' for commands.

You: 
```

## Try These Commands

| Input | Result |
|-------|--------|
| `hello` | Get a greeting |
| `help` | See what chatbot can do |
| `what is java?` | Get FAQ answer |
| `thank you` | Get positive response |
| `bye` | Exit chatbot |

---

## Troubleshooting

### "javac is not recognized"
**Solution**: Java is not in your PATH
- Install JDK from https://www.oracle.com/java/technologies/downloads/
- Or add Java to your system PATH

### "No such file or directory"
**Solution**: Make sure you're in the ChatbotProject directory
```bash
cd ChatbotProject
```

### "Main class not found"
**Solution**: Make sure all files are compiled
```bash
cd src
javac *.java
java Main
```

---

## Files to Know

| File | Purpose |
|------|---------|
| `Main.java` | Starts the program |
| `Chatbot.java` | Brain of the chatbot |
| `ResponseHandler.java` | Creates responses |
| `UserInputProcessor.java` | Understands what user means |
| `FAQDataset.java` | Answers to common questions |

---

## Next Steps

After running successfully:
1. **Explore the code** - Read through each Java file
2. **Add more FAQ** - Edit FAQDataset.java
3. **Customize responses** - Modify ResponseHandler.java
4. **Add new features** - Extend UserInputProcessor.java

---

**Happy coding!** 🚀
