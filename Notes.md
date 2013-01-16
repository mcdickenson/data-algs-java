# Data Structures and Algorithms ##
#### CS 201, Spring 2013, Duke University ###
#### Instructor: Tabitha Peck ###
#### Notes by MCD ###

[Course site](http://www.cs.duke.edu/courses/spring13/compsci201)

## First class - 1.9.13 ##

### Definitions

**Data structure** - organization of data and its storage allocations in a computer (e.g. list)

**Algorithm** - process or set of rules to be followed in calculations or other problem-solving operations (e.g. sort)

*Example*: Sort a list of names, size on order of 10^4. Humans are naturally good at `insertion sort`. 

### Course goals ###

Things you'll know by the end of the course:

- Lists
- Trees
- Sets
- Tables/maps
- Graphs
- Recursion
- Evaluation of programming techniques
- Analysis of algorithms

Understanding these topics will help you to make smart trade-offs between expensive resources. The *speed* of a code is the inverse of its cost in computer time. The *length* of a program (lines) relates to its cost in developer time. 

### Course details ###

**Exam Dates**:

1. February 13 in class
1. March 27 in class
1. May 3, 7pm (Final)

**Grading Rubric**

- Programming assignments - 40% (approx 10 hrs each)
- APTs - 10%
- Classwork/recitation - 15%
- Midterms - 10% each
- Final - 15%
Grading errors MUST be reported to gradTA and faculty within 3 business days of reported grade. 

**Late policy**: 24 hrs = 10%. >24 hrs = 50%. >2 weeks = 100%. Start early! 

**Honor Code**: Make sure you understand all the code you write. Write it yourself. Acknowledge any help you receive in the Readme--including instructors, TAs, friends in course--anyone or anything you consult for help on the assignment. (Not necessary for APTs or in-class assignments.) Do not share code. 

### Getting started with Java ###
Java is:
- statically typed (e.g. `int i`, `String s`)
- object oriented (everything will be in a class)
- very verbose

Style tips:
- class names start with a Capital Letter
- `main` tells the computer where to start running the program
- function names start with lowercase_letters


**[Assignment due Friday](http://www.cs.duke.edu/courses/spring13/compsci201/Recitations/recitation1.html)**: set up Eclipse, write a basic program

**Reading:** Weiss Sections 1.1-1.2.4 (pp. 1-6) 

## Arrays - 1.11.13 ##

**array** - collection of items selected by *index*

For example, an array of 5 integers in Java can be created with `int[] myArray = new int[5];`. Likewise, an array of 10 Strings could be created by `String s = new String[10];`. These commands make a blank array with a fixed length. This means that the size of the array *cannot* be changed. To make a longer array you would have to put all the items from the old array into a new array with the desired length. A more flexible data type is the `ArrayList`, which we will discuss later. 

You can access the length of an array with `arrayName.length`. Because **arrays are Objects**, you make make function calls on them. Notice that our method call to `length` doesn't have parentheses. Isn't that weird, since method calls usually require parens? Yes it is--the reason is that in Java arrays are special. Because the length of an array is so useful for things like loops, you don't need parentheses to get the length of the array.

Another thing to notice about arrays is that they can only include a single data type. This means you cannot mix chars, Strings, and ints in the same array. 

To get information about an item in the array, you access it with the item's *index*. For example, to get the fourth char in an array of characters, you would do `char fourth = arrayOfChars[3]`. (TODO: discuss how indexing begins at zero.) 

To get some practice working with arrays, give `ArrayPractice` a try. Some questions raised during this part were:

- what does `double[]` do in the line defining `makeArray()`?
- what does `main` mean? 
- what's that line with "ArrayPractice practice" on it? (it creates an object with a name and type)
- does this program actually print 50 lines? 
- what's a `return` statement? 

### Reviewing code from Recitation 1 assignment ###
*What's the difference between `private` and `public`?*
A `public` method can be called from another file. A `private` method can only be called from within its own class.

Today in class we also did the `CirclesCountry` APT.

**APT Set 1 due January 17 (next Thursday)**

## Classes and Objects - 1.14.13  ##

**Announcements:** 

- Hangman assignment due Jan. 24
- Exam 1 may be moved to Friday, Feb. 15

### What is a class? ###

A class is a *blueprint* for an object. As an example, we could have a class `Dog`. All classes have a *state* and one or more *behaviors*.

The *state* of our dog could be its name, age, height, weight, and other details. Its *behavior* could include methods like `catchBall()` and `wagTail()`.

### What is an object? ###

An object is an instance of a *class*. Your `Dog` with name Fido, height of 3ft, weight of 70lbs, and so forth is a specific dog. That dog is an object, and its class is Dog.

### In class code example: Circle ###

In `Circle.java` we first declare our instance variables. These define the state of objects created from the class Circle. Then, we define a Constructor method. Your constructor **always** has the same name as your class. Then, we define the behavior methods for ouur Circle class.

Now, look at `DrawCircles.java`. Can you change the method `buildCircles` to create 50 circles instead of 3? 

The first thing you want to do is add a variable to the input indicating the number of circles you want to make. Next, create a data structure to hold all your new circles--a circle array is probably most appropriate here. Then make a loop to go through your cicle array. In each iteration of the loop, pass in an x, y, color, and diameter for the new circle. You can play around with how all of these instance variables are defined at each iteration. Now run the code and check it out. Pretty neat, eh? 

### What about Java's built-in Object types?  ###

Java has four built-in data types known as "Primitives". These are:

- `int`
- `char`
- `boolean`
- `double`

Some built in Objects are:

- `String` - you know these already
- `ArrayList` - expandable array
- `HashSet` - list that prevents duplicates
- `HashMap` - a "dictionary" where you associate a key to a value

Dictionaries take their name from their resemblance to a certain type of reference book (no suprise). In a conventional, written dictionary the key is the word and the value stored at that location is the definition. But you can make much more flexible dictionaries with Java. For example, you can make the key a letter and its value the number of times that letter appears in a certain sentence.

Let's play around with HashMaps now.

### Example: HashMaps ###

Go back to `DrawCircles.java`. On line 8 we define a HashMap named `aMap`. Notice how we define the object types for both the keys and the values--you cannot use a primitive here. On the right side of the `=` we *declare* the HashMap with the keyword `new` and `()`. 

Can you make the function `countColors` iterate over all of our circles and count how many times each color appears? Once you have written such a function, can you make it shorter (fewer lines of code)?

## Lists and Sets - 1.16.13 ##

We have already talked about both of these data types, but you have not yet seen them in code. Today we will try to understand them better and discuss the trade-offs between them. Knowing the trade-offs and when to choose one data structure over another is an important part of software development. 

Here are the data structures we have gone over so far:

- `Array` - fixed size
- `ArrayList` - dynamic size
- `Set` - only unique elements
- `Map` - key/value pairs (also known as a dictionary)

### Lists ###

Lists have certain properties, some of which are nice and some of which you have to be careful about:

- add elements with `.add`
- query with `.contains`
- cannot store primitives!
- can store objects

You declare a list with:
`ArrayList<String> list = new ArrayList<String>();`

To add:
`boolean canAdd = list.add("hello");`

And to check if an element is in the ArrayList:
`boolean inList = list.contains("hello");`

Notice that here we are creating boolean values to catch the return statement of the method to tell us whether it was successful. You don't necessarily have to capture this information, but sometimes it's helpful for detecting errors. 

### Sets ###

Sets have many of the same properties as lists, and one important additional property:

- add elements with `.add`
- query with `.contains`
- cannot store primitives!
- can store objects
- *does not allow duplicates*

You declare a set with:
`HashSet<String> set = new HashSet<String>();`

To add:
`boolean canAdd = set.add("hello");`
If you try to add a duplicate to the hash set, this method will return false. 

And to check if an element is in the HashSet:
`boolean inList = set.contains("hello");`

### Hangman assignment ###

Here is the data you need to keep track of:

1. Secret word (blanks and correct guesses) (`char[]`)
1. Number of misses left until hanging occurs (`int`)
1. Letters that have been guessed incorrectly (`Set`)

### Code Example: `SimpleWords.java` ###

Look over the code and then take the online quiz. 

### Trade-Offs ###

So is it best to use an Array, ArrayList, or HashSet? As with many things, the answer is not that simple. It is a trade-off between *memory* and *speed*. 

To measure the *speed* of an algorithm, we will use "big-O" notation. You can get an intro to this notation in the reading assignment. 

**No prep work for recitation. No class on Monday!**

**Reading:** Weiss book Sections 2.1 - 2.4.2 (pp. 29-37) 





