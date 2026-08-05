# Java Collections From Scratch

A learning project that implements simplified versions of Java collections from scratch.

The project demonstrates how dynamic arrays, linked lists, hash sets, and hash maps work internally without relying on their standard Java implementations for data storage.

## Implemented Collections

### CarArrayList

A dynamic array implementation.

Supported operations:

- Add an element
- Insert an element at a specific index
- Get an element by index
- Remove an element
- Remove an element by index
- Check whether an element exists
- Clear the collection
- Iterate using `Iterator<Car>`
- Automatic capacity expansion

### CarLinkedList

A doubly linked list implementation.

Supported operations:

- Add an element
- Insert an element at a specific index
- Get an element by index
- Remove an element
- Remove an element by index
- Check whether an element exists
- Clear the collection
- Iterate using `Iterator<Car>`

### CarHashSet

A hash-based collection that stores unique cars.

Supported operations:

- Add a unique element
- Remove an element
- Check whether an element exists
- Clear the collection
- Iterate using `Iterator<Car>`
- Handle hash collisions using separate chaining
- Resize and rehash elements when the load factor is exceeded

### CarHashMap

A hash-based key-value collection where `CarOwner` is the key and `Car` is the value.

Supported operations:

- Add or update a key-value pair
- Find a car by its owner
- Remove an entry by key
- Get all keys
- Get all values
- Clear the map
- Handle hash collisions using separate chaining
- Resize and rehash entries when the load factor is exceeded

## Interface Hierarchy

```text
CarCollection extends Iterable<Car>
├── CarList
│   ├── CarArrayList
│   └── CarLinkedList
└── CarSet
    └── CarHashSet

CarMap
└── CarHashMap
```

## Data Models

### Car

Represents a car and is used as an element in the custom collections.

Its `equals()` and `hashCode()` methods allow cars to be compared and stored correctly in `CarHashSet`.

### CarOwner

Represents a car owner and is used as a key in `CarHashMap`.

The key contains:

- ID
- First name
- Last name

Its `equals()` and `hashCode()` methods are used to find the correct map entry.

## Hash Table Implementation

Both `CarHashSet` and `CarHashMap` use:

- An initial capacity of 16
- A load factor of 0.75
- Separate chaining for collision handling
- Automatic table expansion
- Rehashing after expansion

Average expected complexity for `add`, `put`, `get`, `contains`, and `remove` is `O(1)`. In the worst case, when many keys have the same hash, these operations may take `O(n)`.

## Testing

The project uses JUnit 5.

Tests cover:

- Adding and removing elements
- Collection size
- Duplicate handling
- Indexed operations
- Iteration
- Hash table resizing
- Updating an existing map entry
- Retrieving values by key
- Getting map keys and values
- Clearing collections

Run all tests with:

```bash
./gradlew test
```

## Technologies

- Java
- Gradle
- JUnit 5
- IntelliJ IDEA

## Project Structure

```text
src/
├── main/java/
│   ├── Car.java
│   ├── CarOwner.java
│   ├── CarCollection.java
│   ├── CarList.java
│   ├── CarSet.java
│   ├── CarMap.java
│   ├── CarArrayList.java
│   ├── CarLinkedList.java
│   ├── CarHashSet.java
│   ├── CarHashMap.java
│   └── CarQueueMap.java
└── test/java/
    ├── CarCollectionTest.java
    ├── CarListTest.java
    ├── CarSetTest.java
    ├── CarMapTest.java
    └── CarQueueTest.java
    
```

## Purpose

This project was created to practise:

- Object-oriented programming
- Interfaces and implementations
- Generics and iterators
- Dynamic arrays
- Doubly linked lists
- Hash tables
- Collision handling
- `equals()` and `hashCode()`
- Unit testing
- Algorithm complexity analysis