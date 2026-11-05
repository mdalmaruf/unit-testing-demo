@echo off
REM Compiles the code and runs all unit tests.
cd /d "%~dp0"
echo Compiling...
javac -d out -cp lib\junit-4.13.2.jar src\*.java test\*.java
if errorlevel 1 exit /b 1
java -cp "out;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" org.junit.runner.JUnitCore CalculatorTest
