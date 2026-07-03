# QN3-AquaSmart-Meter

A simple Java smart meter demo application that models a token-based water meter.

## Overview

This project includes a `SmartMeter` class with a credit balance and valve state. The demo application in `src/main/java/com/kis/aquasmart/Main.java` shows how to:

- create a smart meter instance
- display the meter ID and current credit
- record water consumption
- handle insufficient credit and valve closure
- load tokens to restore credit

## Requirements

- Java 17
- Maven

## Build

```bash
mvn clean package
```

## Run

```bash
mvn exec:java -Dexec.mainClass="com.kis.aquasmart.Main"
```

If you prefer to run the packaged JAR after building:

```bash
java -cp target/QN3-AquaSmart-Meter-1.0.0.jar com.kis.aquasmart.Main
```

## Test

```bash
mvn test
```

## Project Structure

- `src/main/java` - application source code
- `src/test/java` - unit tests
- `pom.xml` - Maven project configuration

## Notes

This is a small proof-of-concept for a prepaid smart meter simulation.
