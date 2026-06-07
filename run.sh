#!/bin/bash
# Compile script for Linux/Mac
# This script compiles and runs the chatbot

echo ""
echo "========================================"
echo "   Compiling Chatbot Project..."
echo "========================================"
echo ""

cd src

echo "[*] Compiling Java files..."
javac *.java

if [ $? -ne 0 ]; then
    echo "[!] Compilation failed!"
    exit 1
fi

echo "[+] Compilation successful!"
echo ""
echo "========================================"
echo "   Running Chatbot..."
echo "========================================"
echo ""

java Main
