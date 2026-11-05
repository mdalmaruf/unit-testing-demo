#!/bin/sh
# Compiles the code and runs all unit tests.
cd "$(dirname "$0")"
echo "Compiling..."
javac -d out -cp lib/junit-4.13.2.jar src/*.java test/*.java || exit 1
java -cp "out:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore CalculatorTest
