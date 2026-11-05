@echo off
REM Compiles the code and starts the calculator app.
cd /d "%~dp0"
echo Compiling...
javac -d out -cp lib\junit-4.13.2.jar src\*.java test\*.java
if errorlevel 1 exit /b 1
java -cp out Main
