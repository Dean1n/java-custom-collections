# Custom Java Collections

An educational Java project with custom implementations of basic collection data structures.

## Implemented Collections

- `CarArrayList` — dynamic array implementation.
- `CarLinkedList` — doubly linked list implementation.
- `CarHashSet` — hash table implementation with separate chaining.

## Interface Hierarchy

```text
CarCollection
├── CarList
│   ├── CarArrayList
│   └── CarLinkedList
└── CarSet
    └── CarHashSet
```

## Supported Operations

All collections support:

- `add`
- `remove`
- `contains`
- `size`
- `clear`

List implementations also support:

- `get`
- `add by index`
- `remove by index`

## Hash Set Features

`CarHashSet`:

- prevents duplicate elements;
- uses `equals()` and `hashCode()`;
- handles collisions with separate chaining;
- automatically increases its internal capacity.

## Technologies

- Java
- Gradle
- JUnit 5

## Running Tests

Run the tests from the project root:

```bash
./gradlew test
```

## Project Structure

```text
src/
├── main/java/
│   ├── Car.java
│   ├── CarCollection.java
│   ├── CarList.java
│   ├── CarSet.java
│   ├── CarArrayList.java
│   ├── CarLinkedList.java
│   └── CarHashSet.java
└── test/java/
    ├── CarCollectionTest.java
    ├── CarListTest.java
    └── CarSetTest.java
```

## Purpose

This project was created to practice:

- Java Core;
- object-oriented programming;
- arrays and linked data structures;
- hash tables and collision handling;
- interfaces and inheritance;
- unit testing.

This is an educational project and not a replacement for the Java Collections Framework.