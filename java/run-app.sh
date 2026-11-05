#!/bin/sh
# Compiles the code and starts the calculator app.
cd "$(dirname "$0")"
echo "Compiling..."
javac -d out -cp lib/junit-4.13.2.jar src/*.java test/*.java || exit 1
java -cp out Main
