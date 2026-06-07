@echo off
REM Compile script for Windows
REM This script compiles all Java files in the src directory

echo.
echo ========================================
echo   Compiling Chatbot Project...
echo ========================================
echo.

cd src

echo [*] Compiling Java files...
javac *.java

if %errorlevel% neq 0 (
    echo [!] Compilation failed!
    pause
    exit /b 1
)

echo [+] Compilation successful!
echo.
echo ========================================
echo   Running Chatbot...
echo ========================================
echo.

java Main

pause
