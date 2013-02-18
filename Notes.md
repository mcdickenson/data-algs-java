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

## Big-O Notation - 1.23.13

Big-O notation allows us to *estimate* the time required for a program. However, it does not use actual units of time! Rather, it is a count of the number of operations as a function of the input size. That's because two different computers run the same function in different amounts of time. Furthermore, my own computer may run the same function faster or slower depending on whether I'm checking email at the time (or doing a number of other things). As in many other areas, computer scientists are lazy here so they take shortcuts. 

### How to calculate Big-O

1. Assign costs to operations
    - declarations cost 0 units (`double d;`)
    - operations cost 1 unit (`d = 4.56`, `d*5`, etc.)
2. Write the total cost in Big-O notation as a function of input size *N*  (e.g. O(5))
3. Simplify
    - Remove constants: 
        - O(4N) -> O(N)
        - O(3N^2 + 5) -> O(N^2)
    - Remove lower order terms:
        - O(N^2 + N) -> O(N^2)  

Note that none of these methods are language-specific. For example, when you declare a variable in Java it is assigned a default value, but we still treat it as 0 units.

### Examples

(Examples given here with discussion of what the Big-O notation would be.)

```java
public static int sum(int n) // 0
{ // 0
  int partialSum; // 0
  partialSum = 0; // 1
  for(int i=1; i<=n; i++){ // n+1
    partialSum += i*i*i // 4
  } 
  return partialSum; // 1
} // 0
```

So the function above is O(4N) which reduces to O(N).

### Comparing running time

<table>
    <tr>
        <td>FUNCTION</td>
        <td>NAME</td>
    </tr>
    <tr>
        <td>c</td>
        <td>constant</td>
    </tr>
    <tr>
        <td>log N</td>
        <td>logarithmic</td>
    </tr>
    <tr>
        <td>log^2 N</td>
        <td>log-squared</td>
    </tr>
    <tr>
        <td>N</td>
        <td>linear</td>
    </tr>
    <tr>
        <td>N log N</td>
        <td></td>
    </tr>
    <tr>
        <td>N^2</td>
        <td>quadratic</td>
    </tr>
    <tr>
        <td>N^3</td>
        <td>cubic</td>
    </tr>
    <tr>
        <td>2^N</td>
        <td>exponential</td>
    </tr>
</table>

### Rules for Big-O

- For-loops are multiplicative: (#statements in loop)*iterations
- Nested for loops should be calculated from innermost loop outward
- Consecutive statments should be added
- If/else: calculate time for the test and add it to the maximum running time of any one branch the code might follow
- While loops: calculate the worst-case scenario (if the loop never ends, you're in trouble because the running time is infinite)

Practice these rules with `BigOhPractice.java`.

### Announcements :

- Hangman due tomorrow
- APT Set 2 due January 29
- No recitation prep for Friday, but bring textbook 

## Interfaces - 1.28.13  ##

### Comparing Objects

- Are they the same? `.equals()`
- Do they have same order? `.compareTo()`
- Same *values*? `==` DO NOT USE THIS FOR OBJECTS! (including Strings) 

The reason that we cannot use `==` is because objects are saved as *reference values*. For instance, the value `s` "points" to another value `"hello"` somewhere in memory. 

The reason that `.equals()` works is that it is a defined method for the Java class `Object`, which all objects inherit. There are many other defined methods. You can get a sense of them by creating an object in Java with the Eclipse editor, then on a newline typing the object name followed by `.`. 

For a fun example of two objects that are the same in popular culture, read up on the [Utah teapot](http://en.wikipedia.org/wiki/Utah_teapot).   

To play around with equality, check out today's code: `ThreeInts.java`. This code demonstrates that `.equals()` does not work for comparing lists. It also introduces use of `this` in a method definition. 

How do we assign a notion of equality to *ordering*? With numbers it's pretty intuitive. With words or letters we tend to go alphabetically. But for other objects (say, sports teams) we have to choose a method since one is not readily apparent. In Java we do this with `implements Comparable`, which is called an *interface*. `Comparable` is what gets used when we call `.compareTo`. When we implement `compareTo` in our `ThreeInts` code, notice how it automatically affects the behavior of `Collections.sort(list);`. That's because `.sort()` uses the objects' built-in comparison function, which we modified in `compareTo`. 

### Practice

Now create a class `ComplexNumber`, using `ThreeInts` as a guid. `ComplexNumber` objects should have only two instance variables: `myR` and `myI`. You define the `.equals()` and `.compareTo()` methods using the magnitudes (i.e. the square root of the sum of squared r and i variables). 

### Announcements:

- Jotto assignment online, due Feb. 5 (start before Friday)

## More on Interfaces - 1.30.13  ##

Today we'll discuss

- `extends` - when some things are prewritten for you
- `abstract` - some methods implemented for you, some required but not implemented
- `Object` - the superclass for everything
- `implements` - to define some methods
- `interface` - when *no* methods are implemented for you 

### Extends

We use `extends` when we want to add additional functionality to a basic class. For example, we could create a class `Robot` that has a method `useElectricity`. We could create more specialized classes `BendingRobot` with method `doBending` and `ClampingRobot` with method `doClamping` *both of which* also `useElectricity`. The most efficient way of doing this is to have our two specialized classes *extend* the Robot class. We could also give the Robot class any other methods that we want all our robots to have. With `extends` we avoid copy-pasting. We can even build up more and more specialized classes such as `SuperBendingRobot` that `extends` `BendingRobot`. It's like a family tree. 

In the example above, `Robot` is the *superclass* of `BendingRobot` and `SuperBendingRobot` is the *subclass* of `BendingRobot`. Subclasses inherit from their superclass. Subclasses can also "override" functions in their superclass, which we'll discuss momentarily. You should always use the most general type possible for your function inputs and outuputs since subclasses can be used anywhere their superclass can. 

### Abstract

Continuing with our robot example, what if we wanted our robots `useElectricity()` in different ways? In that case we would call it an `abstract` method, which means that robots are required to have a useElectricity() method, but we don't define it. That puts the burden on future coders implementing robots to define the way in which that robot will useElectricity(). 

When you extend a superclass with abstract methods, you *must* implement those abstract methods. Notice that this means you cannot use `new` to create an object of an abstract superclass, since `new` doesn't allow you to define methods on the same line. You *can* use new with the subclass once the abstract methods are implemented in that subclass. 

### Implements

You *implement* an interface in the same way you *extend* a superclass. In your `class ...` line, `extends` *must* come before `implements`. 

Most of the APTs in Set 3 will use the interface `Comparable`. Let's try this with ClientList.java. 


### Announcements:

- Jotto (still) due Feb. 5
- APT Set 3 due Feb. 12
- Midterm Feb. 15

## Jotto Recitation - 2.1.13

### IsomorphicWords

This APT assignment will be helpful as you work on Jotto. Tip: any time you're working with boolean values, do as little as possible. It is better not to compare two booleans. 

### Common

Implementing the instructions in this APT will get you ready to turn in Jotto. 

### Iterators

Iterators are very nice because you know exactly what they will do, and you don't have to worry about adding any bugs of your own to the process. Another advantage is that an iterator works for lots of different types of input, so you don't have to worry about whether you're dealing with an ArrayList or a List, for example. One thing to be careful about: if you're using an iterator, don't change the object that the iterator is working on without using the iterator. For example `iterator.remove()` is much better than `list.remove()` if you're iterating over the list. 

## Linked Lists - 2.4.13

Today we discuss several related data structures:

- Linked lists
- Queues 
- Stacks

### Linked lists

In Java, we have already worked with lists in the form of an `ArrayList`. In general, a `List` is just an ordered collection of values. Now that we know about *interfaces*, we can mention several of the list interfaces given in Java:

- `add(E element)`
- `add(int index, E element)`
- `contains(Object o)`
- and many more! 

An `Array` is a data structure in which elements may be located by index. In Java, `ArrayList implements List`, which as you know means that `ArrayList` implements all of the methods from `List` using an array. That's why we can do things like `ArrayList<String> array = new ArrayList<String>();` OR `List<String> array = new ArrayList<String>();`. 

What kind of advantages do we get from this kind of arrangement? A number of operations that run in constant time *O(1):* `size, isEmpty, get, set, add` (add is *approximately* constant time). Everything else in an `ArrayList` runs in linear time *O(N)*. 

There is another type of list implementation called `LinkedList`, which has many of the same interface operations as `ArrayList`, but with different implementations. A `LinkedList` has a *head* and a *tail*. Each element in the list is referred to as a *node* which has *data* and a *pointer* to the next node. The `LinkedList` object is a pointer to the beginning and (sometimes) the end of the list. 

Say we have a linked list with data (ordered from head to tail) `[h, e, l, o]` and we want to insert another "l" after the "e". First we have to find the "e" starting at "h" (where our list object points). This takes two operations. Then we create a new node with an "l", update its pointer to the existing "l", and replace "e's" pointer to the new "l". 

Here's how the running time of operations compares with different list implementations:
<table>
    <tr>
        <td>Operation</td>
        <td>LinkedList</td>
        <td>ArrayList</td>
    </tr>
    <tr>
        <td>get</td>
        <td>O(n)</td>
        <td>O(1)</td>
    </tr>
    <tr>
        <td>add</td>
        <td>O(1)</td>
        <td>O(1) amortized, O(n) worst case</td>
    </tr>
    <tr>
        <td>remove</td>
        <td>O(n)</td>
        <td>O(n)</td>
    </tr>
</table>

You can have two types of `LinkedList`--singly linked, like we have already discussed, and doubly linked, where each node points to the node after it and the one before it (the latter is the default in Java).

### Queue

A `Queue` works in a First-In-First-Out (FIFO) manner. Here's how we'd make one using a linked list:

```
Queue<String> q = new LinkedList<String>():
  q.add("comp ");
  q.add("sci ");
  q.add("is ");
  q.add("great!");
  while(!q.isEmpty())
    System.out.print(q.remove());
```
This will print "comp sci is great!"
### Stack

In contrast to a `Queue`, a `Stack` works in a Last-In-First-Out (LIFO) manner.

```
Stack<String> q = new Stack<String>():
  q.push("comp ");
  q.push("sci ");
  q.push("is ");
  q.push("great! ");
  while(!q.isEmpty())
    System.out.print(q.pop());
```
This will print "great! is sci comp "

### Announcements 

- Jotto due tomorrow
- APT Set 3 due Feb 12
- Exam 1 on Feb 15 

## Sets and Maps - 2.6.13

Last time we talked about ArrayLists and LinkedLists. Today we'll talk about Sets, Maps, hasing, and Markov Models (which will be useful for the next assignment). 

### Sets

A `Set` is an unordered collection of unique values. The Set interface in Java comes with several methods you already know:

- `Set<E>`
- `add(Element e)`
- `clear()`
- `contains(Object o)`
- `equals(Object o)`
- `hashCode()` - returns hash code value for this set

We have already seen two implementations of Set: HashSet and TreeSet. Today we'll focus on Hash and after the exam we'll learn more about Tree. Here are the Big-Oh runtimes for some common Set operations: 

<table>
    <tr>
        <td>Operation</td>
        <td>HashSet/HashMap</td>
        <td>TreeSet/TreeMap</td>
    </tr>
    <tr>
        <td>Get element with key</td>
        <td>O(1)*</td>
        <td>O(logN)</td>
    </tr>
    <tr>
        <td>Set element with key</td>
        <td>O(1)&</td>
        <td>O(logN)</td>
    </tr>
    <tr>
        <td>Check if key exists</td>
        <td>O(1)</td>
        <td>O(logN)</td>
    </tr>
</table>

### Maps 

A `Map` is a collection of values mapped to keys. A common example is a dictionary: words (keys) are mapped to values (definitions). The Map interface has many of the same methods as Set does, plus a few more:

- `clear()`
- `containsKey(Object key)`
- `containsValue(Object value)`
- `entrySet()` - returns Set of mappings
- `equals(Object O)`
- `get(Object key)`
- `hashCode()` - returns hash code value for this map

### Hashing

We saw above how fast Hashing is relative to a Tree implementation of Sets or Maps. Let's talk about how it works. 

A `HashTable` is an array of fixed size with a key to each location. Each key is mapped to an index in the table. The Hash function itself is relatively simple to compute, and is used to ensure that two distinct keys get different cells in the table. Two equal objects should hash to the same place (i.e. have the same key):

```
if a.equals(b)
  a.hashCode() == b.hashCode()
```

Checking equality is relatively straightforward. But how do we **ensure** that distinct keys get different cells? The solution we use is called *separate chaining*, which means making the table into linked lists. 

For code practice today, open your code from Jan. 28 and practice with Hashing. Here are the constraints to keep in mind:

- every object should have a hash code
- hashCode should not change unless the value changes
- two equal objects should hash to the same place 

### Markov Models

You may have heard the "infinite monkey theorem": that an infinite number of monkeys with infinite time and infinite keyboards would eventually type out the complete work of Shakespeare. With a Markov model, we could learn how to reduce the running time of this "algorithm" by studying existing text and looking at which letters commonly follow each other.

For example, we could take a *training text* (e.g. *Huckleberry Finn*), build a map from the text ('e' is followed by 'a' 30% of the time, 'a' is followed by 't' 20% of the time) and use the map to generate random text. 

Another trick is to use [n-grams](http://books.google.com/ngrams) instead of individual letters. For example, the string "abcdeabcdf" contains the following tri-grams (n=3):

- abc
- bcd
- cde
- dea
- eab
- cdf

From this example, we compare what tri-grams are likely to follow one another:

<table>
    <tr>
        <td><b>abc</b></td>
        <td>bcd</td>
        <td></td>
    </tr>
    <tr>
        <td><b>bcd</b></td>
        <td>cde</td>
        <td>cdf</td>
    </tr>
    <tr>
        <td><b>cde</b></td>
        <td>dea</td>
        <td></td>
    </tr>
    <tr>
        <td><b>dea</b></td>
        <td>eab</td>
        <td></td>
    </tr>
    <tr>
        <td><b>eab</b></td>
        <td>abc</td>
        <td></td>
    </tr>
    <tr>
        <td><b>cdf</b></td>
        <td>dfa</td>
        <td></td>
    </tr>
</table>

The only really interesting part of this is the row **bcd**: this tri-gram is followed by "cde" 50% of the time and "cdf" 50% of the time. Obviously in a longer corpus of text this kind of model gets more interesting and complex. 

### Announcements

- Exam 1 on Feb 15
- Markov Models assignment due Feb. 19--start early!!!

## Recursion - 2.18.13

Here is an example in semi-pseudocode to illustrate recursion:

```
void solve(ProblemClass instance){
    if(instance is simple){
        solve instance
    }
    else{
        divide into subinstance(s)
        solve(subinstance)
        reassemble problem
    }
}
```

We then work through recursion examples from [coding bat](http://codingbat.com/java/Recursion-1). Here are some that I did:

Compute factorial: 
```
public int factorial(int n) {
  if(n==1){ return n; }
  else{ return n*factorial(n-1); }
}
```

Count bunnies' ears without loops or multiplication:
```
public int bunnyEars(int bunnies) {
  if(bunnies==0){ return bunnies; }
  else{ return 2+bunnyEars(bunnies-1); }
}
```

BunnyEars2--even-numbered bunnies have 3 ears:
```
public int bunnyEars2(int bunnies) {
  if(bunnies==0){ return bunnies; }
  else if((bunnies%2)==0){ return 3 + bunnyEars2(bunnies-1); }
  else{ return 2 + bunnyEars2(bunnies-1); }
}
```

Compute the Fibonacci sequence:
```
public int fibonacci(int n) {
  if(n==0 || n==1){return n;}
  else{ return fibonacci(n-1) + fibonacci(n-2); }
}
```

Turn "hello" into "h\*e\*l\*l\*o":
```
public String allStar(String str) {
  if(str.length() == 1 || str.length() == 0){return str;}
  else{return str.substring(0,1)+"*"+allStar(str.substring(1));}
}
```