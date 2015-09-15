# Campr XSS Workshop

## Getting started

Generate Intellij project files:

```bash
./gradlew idea
```

Run the application

```bash
./gradlew bootRun
```

Run the tests - (only) `all_should_not_allow_obvious_xss_attacks` should fail

```bash
./gradlew test
```

## Requirements

* JDK 1.7+
* A Java IDE
