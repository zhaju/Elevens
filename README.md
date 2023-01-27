# Elevens Card Game Assignment
## Introduction

The following activities are related to a simple solitaire game called Elevens. You will learn the rules of Elevens, and will be able to play it by using the supplied Graphical User Interface (GUI) shown below. You will learn about the design and the Object-Oriented Principles (OOP) that suggested that design. You will also implement much of the code.

 ![Elevens GUI](/img/01-gui.png)
 

## Activity 1: Design and Create a Card Class

### Introduction:
In this activity, you will complete a `Card` class that will be used to create card objects.

Think about card games you’ve played. What kinds of information do these games require a card object to “know”? 

What kinds of operations do these games require a card object to provide?

### Exploration:
Now think about implementing a class to represent a playing card. 

* What instance variables should it have?
* What data types are appropriate for the instance variables?
* What methods should be provided? 
* Should this class be mutable or immutable?

Discuss your ideas for this Card class someone in your class before implementing

### Implementation:
Complete the implementation of the provided `Card` class. You will be required to complete:
1)	Open BlueJ and start a new project called Elevens.
2)	Using the Edit menu, or the button on the left, make a new class called `Card`.
3)	Make sure your `Card` class has the following:
    * instance variables to represent the suit and rank of the card;
    * a constructor for the class;
    * getters for the instance variables (these should be called `getRank` and `getSuit`);
    * a method called `matches` that takes one parameter of type `Card` called `other` and returns `true` if `this` and `other` represent the same card.
4)	When you are done, check that it complies correctly and compare with someone else.  Note any differences and similarities between your solutions.
5)  Create several objects in your workspace:
    * create two objects that are identical (same rank and suit)
    * create another object that has the same rank, but different suit.
    * create another object that has the same suit as the two identical cards, but a different rank.
    * run the `matches` method and make sure that it gives the desired result
 

## Activity 2: Improving the Card class with `enum` 

### Introduction:
In the previous activity, we used `String`s to represent the rank and suit of a card.  This is bad design, since our intention is to have the rank be one of 13 values, and the suit one of 4 values.
Java provides a way to create new data types that can only have a predefined (finite) set of possible values called enumerated classes (or enums).
#### How enums work:
Below is the `.java` file for an enumeration that represents the months in a year.  A client class can then refer to these twelve constants as `Month.APRIL, Month.MAY`, etc.

```java
public enum Month
{
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;
}
```

#### The `.values()` method
If you right-click on the Month enumerated class in BlueJ, you will see that it has three static methods, the first of which is `Month[] values()`.
This method returns an array of `Month`s **in the order they are declared in the `enum` definition**.	   

#### Other (non-`static`) methods
Each value of an enumerated class is itself an object, and Java provides several built-in methods. Two that will be useful for us are 
* `.name()` returns (as a `String`) the identifier of the constant, e.g. `Month.JULY.name()` returns `"JULY"`
*	`.ordinal()` returns (as an `int`) the number of the calling object, with respect to the order in which they were defined, e.g. `Month.JULY.ordinal()` returns 6 (not 7: in CS we start counting at zero).
 
### Instance Fields and the Constructor
Enumerated classes can also have instance fields, for example we can add a field for number of days in the month.  After adding your instance fields (declared `private final`), add a `private` constructor with a parameter for each instance field.  Then put the actual parameters in parentheses after each identifier (see example below).  You’ll probably want to access the data in the field, so add a “getter” as well.	  

```java
public enum Month
{
    JANUARY(31),
    FEBRUARY(28),
    MARCH(31),
    APRIL(30),
    MAY(31),
    JUNE(30),
    JULY(31),
    AUGUST(31),
    SEPTEMBER(30),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31);
    
    private final int daysInMonth;
    
    private Month(int daysInMonth){
        this.daysInMonth = daysInMonth;
    }
    
    public int getDaysInMonth(){
        return daysInMonth;
    }
}
```

### Implementation:
1)	In the same project (folder) as your `Card` class, create two enumerated classes for `Suit` and `Rank`.
The Suit class should have four values: `CLUBS, DIAMONDS, HEARTS, SPADES`; the `Rank` class should have thirteen values: `ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING`.
2)	Add a point value to the Rank class:
    * Add an integer (`int`) instance field to the `Rank` class called `pointValue`,
    * Assign the face value (1-10) for `ACE` through `TEN`, and zero for `JACK, QUEEN, KING`.
    * Write a (`private`) constructor to initialize the values.
    * Add a (`public`) "getter" method `getPointValue`.
3)	Update your `Card` class to use the `enum` types you have created.
4)	In the `Card` class, write a main method to re-implement the tests from Activity 1: Design and Create a Card Class.
5)	Add a method to the `Card` class called `print` that prints a `String` in the format `<N> of <suit>` if the rank of the card is `TWO-TEN`, and print 
`<rank> of <suit>` otherwise.  The string should be all lower case.  
**Notes**
    * `enum`s can be used in `switch` statements.
    * `enum`s can be compared with `==`
    * use the `name()` method from `enum`
    * use the `toLowerCase()` method from `String`
6)	Add a call to print to your main method.
 
## Activity 3: Initial Design of a Deck Class

### Introduction:
A standard deck contains 52 cards, one of each [rank/suit combination](https://en.wikipedia.org/wiki/Standard_52-card_deck) ($13\times 4 = 52$).  In this Activity, you will write a Deck class that represents a collection of Cards 

### Exploration:
What instance variables do you need to represent a deck of cards?
What methods should a deck object have?

### Implementation:
1)	Create a new class `Deck` in the same project as your `Card` class.
Your class should have two instance variables, An `ArrayList` of `Cards` called `deck`, and an `int` called `size`.
    * The constructor should take two instance variables, an array of `Rank` and an array of `Suit`.
    * Use nested `for` loops to add one card of each rank/suit combination to your `ArrayList`. (You can use [for-each loops](https://codehs.com/lms/assignment/89809670) here)
    * Initialize the `size` field to be the total number of cards in the deck.
    * Finally, call the `void` method `shuffle` (to be implemented later).
2)	Add the following methods to your `Deck` class:
    * `shuffle`: just add a `public void` method with no contents for now.
    * `isEmpty`: This method should return `true` when the `size` of the deck is 0; `false` otherwise.
    * `size`: This method returns the number of cards in the deck that are left to be dealt.
    * `deal`: This method "deals" a card by removing a card from the deck and returning it, if there are any cards in the deck left to be dealt. It returns `null` if the deck is empty. There are several ways of accomplishing this task. Here are two possible algorithms:

        #### Algorithm 1: 
        Because the cards are being held in an `ArrayList`, it would be easy to simply call the method that removes an object at a specified index, and return that object. This algorithm also requires a separate "discard" list to keep track of the dealt cards. This is necessary so that the dealt cards can be reshuffled and dealt again.
        #### Algorithm 2: 
        Instead of removing the card, decrement the `size` instance variable and then return the card at size. In this algorithm, the size instance variable does double duty; it determines which card to "deal" and it also represents how many cards in the deck are left to be dealt. This is the algorithm that you should implement.

3)	Once you have completed the `Deck` class, add a `main` method to `Deck` and test the methods: 
    * create a `Deck`, 
    * check the `size`, 
    * deal some cards, 
    * make sure the deck has the correct number of cards after dealing, 
    * deal the rest of the cards (`while` loop, using `isEmpty`),
    * make sure deal returns `null` from an empty `Deck`.
4)	Explain in your own words the relationship between a `Deck` and a `Card`.
 

## Activity 4: Shuffling the Cards in a Deck

### Introduction:
Think about how you shuffle a deck of cards by hand. How well do you think it randomizes the cards in the deck?

### Exploration:
We now consider the shuffling of a deck, that is, the permutation of its cards into a random-looking sequence. A requirement of the shuffling procedure is that any particular permutation has just as much chance of occurring as any other. We will be using the `Math.random()` method to generate random numbers to produce these permutations. Several ideas for designing a shuffling method come to mind. We will consider two:
#### Perfect (Faro) Shuffle
Card players often shuffle by splitting the deck in half and then interleaving the two half-decks.  (See [Faro Shuffle][def]).

This procedure is called a perfect (or faro) shuffle if the interleaving alternates between the two half-decks. Unfortunately, the perfect shuffle comes nowhere near generating all possible deck permutations. In fact, eight shuffles of a 52-card deck return the deck to its original state!
Consider the following “perfect shuffle” algorithm that starts with an array named cards that contains 52 cards and creates an array named shuffled.
```pseudo
Initialize shuffled to contain 52 “empty” elements. 
Set k to 0.
For j = 0 to 25:
    Copy cards[j] to shuffled[k];
    Set k to k+2. 
Set k to 1.
    For j = 26 to 51,
    Copy cards[j] to shuffled[k];
    Set k to k+2.
```
This approach moves the first half of cards to the even index positions of shuffled, and it moves the second half of cards to the odd index positions of shuffled.

#### Selection Shuffle

The [Fisher-Yates Shuffle](https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle) is a random shuffle, in that each card has an equally likely chance of ending up in a given position. For an array cards of length $n$:
```pseudo
for k = n-1 down to 1:
    Generate a random integer r between 0 and k, inclusive;
    Exchange cards[k] and cards[r]
```

The selection shuffle algorithm does not require to a loop to find the largest (or smallest) value to swap, so it works quickly.

### Implementation:
1)	In the `Deck` class, add a `public void` method called `perfectShuffle` and implement the perfect shuffle algorithm.  This method should reset the `size` variable to the number of cards in the full deck.
2)	Implement the selection shuffle in the body of the shuffle method you created earlier. (Don’t forget to reset the `size` variable).
3)	Test both methods, and in particular verify that eight perfect shuffles returns the deck to its original state.
4)	Modify your perfect shuffle algorithm so the original top card is now second from the top (make another method called `inShuffle`).  If implemented correctly, this should reverse the order of the deck after 26 shuffles!

## Activity 5: The `toString()` Method

### Introduction 
Every class starts out with several inherited methods, one of which is `toString()`.  Its default behaviour is rarely what the programmer needs, so it is usually **overridden**.  In this activity, we will examine the default behaviour of `toString()`, and then modify that behaviour to meet the needs of the project.

### Exploration
In BlueJ, create an object of type `Card`.  Right-click to pull up the context menu, then select "Inherited from Object".

![Inherited from Object](/img/02-inherited-from-object.png)

Run the method `toString()` and observe the output.  What do you think it represents?

While this information can sometimes be helpful, it is common to **override** the `toString()` method.  There will be much more to say about overriding later, but for now we will see how to override the `toString()` method in our classes.

### Implementation
The Graphical User Interface (or GUI, pronounced 'gooey') for the Elevens game requires that `Card`'s `toString()` method returns a string in the form `<N><suit>` for number cards (2-10) and `<rank><suit>` for aces and face cards.  For example, `toString` should return `8hearts` for the eight of hearts and `acespades` for the ace of spades.

1) Override the `toString` method in the `Suit` class.  To override a method, put `@Override` on a single line, then write the method as you normally would: 

```java
@Override
public String toString(){
    return name().toLowerCase();
}
```

The `@Override` lets the compiler know that you intend to override this method, and checks that you have done it correctly.  This means it must have the same **signature** as the original method, that is, the same name and parameter list.

2) Override the `toString` method in the `Rank` class. To return `"<N>"` if the rank is `TWO-TEN`, and `"<rank>"` otherwise (the string should be all lower case).  For example, `Rank.NINE.toString()` should return the `String` `"9"` and `Rank.KING.toString()` should return the `String` `"king"`.  (You can make use of the `getPointValue()` and `name()` methods, and a `switch` statement.)

3) Override the `toString` method in the `Card` class so it has the behaviour described above.  You should accomplish this by calling the two methods you just wrote.

4) Override the `toString` method in the `Deck` class.  It should return a `String` with one line for each card left in the deck (**not** each card in the `ArrayList`!).  You can accomplish this using a `for` loop and either concatenation or a [StringBuilder](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/lang/StringBuilder.html) object.

5) Describe the difference between the `print()` and `toString()` methods in `Card`.

## Activity 6: Play Elevens

### Introduction

In this activity, the game Elevens will be explained, and you will play an interactive version of the game.

### Exploration

The solitaire game of Elevens uses a deck of 52 cards, with ranks A (ace), 2, 3, 4, 5, 6, 7, 8, 9, 10, J (jack), Q (queen), and K (king), and suits &#x2663;&#xFE0F; (clubs), &#x2666;&#xFE0F; (diamonds), &#x2665;&#xFE0F; (hearts), and &#x2660;&#xFE0F; (spades). Here is how it is played.
1)	The deck is shuffled, and nine cards are dealt "face up" from the deck to the board.
2)	Then the following sequence of steps is repeated:
    * The player removes each pair of cards (A, 2, ... , 10) that total 11, e.g., an 8 and a 3, or a 10 and an A. An ace is worth 1, and suits are ignored when determining cards to remove.  Face cards are worth 0.
    * Any triplet consisting of a J, a Q, and a K is also removed by the player. Suits are also ignored when determining which cards to remove.
    * Cards are dealt from the deck if possible to replace the cards just removed.
3) The game is won when the deck is empty and no cards remain on the table.

An interactive GUI version of Elevens allows one to play by clicking card images and buttons rather than by handling actual cards. When `Elevens.jar` is run, the cards on the board are displayed in a window. Clicking on an unselected card selects it; clicking on a selected card unselects it. Clicking on the 'Replace' button first checks that the selection is legal; if so, it does the removal and deals cards to fill the empty slots. Clicking on the 'Restart' button restarts the game.

The git repository for this assignment contains the file `Elevens.jar`, which runs an GUI-based implementation of the Elevens game.  It can be run either by double-clicking or from the command line:

```PowerShell
java -jar Elevens.jar
```

Play through a few games of Elevens to get a feel for how the game works.

## Activity 7: Design the `ElevensBoard` class

### Introduction

Now that you have played the Elevens game, we will design the `ElevensBoard` class.  This class will contain the **state** and **behavior** of the Elevens game.  We will also introduce **subclasses** and **abstract classes**

### Exploration

Before we design the `ElevensBoard`,  read the following descriptions of two other solitare games:

#### Thirteens
The solitaire game of Thirteens uses a deck of 52 cards, with ranks A (ace), 2, 3, 4, 5, 6, 7, 8, 9, 10, J (jack), Q (queen), and K (king), and suits &#x2663;&#xFE0F; (clubs), &#x2666;&#xFE0F; (diamonds), &#x2665;&#xFE0F; (hearts), and &#x2660;&#xFE0F; (spades). Here is how it is played.
1)	The deck is shuffled, and ten cards are dealt "face up" from the deck to the board.
2)	Then the following sequence of steps is repeated:
    * The player removes each pair of cards (A, 2,..., 10) that total 13, e.g., an 8 and a 5, or a Q and an A. An ace is worth 1, and suits are ignored when determining cards to remove.  Jacks are worth 11, and queens 12.
    * K has a value of 13, and so may be removed singly.
    * Cards are dealt from the deck if possible to replace the cards just removed.
3) The game is won when the deck is empty and no cards remain on the table.
    
#### Tens
The solitaire game of Tens uses a deck of 52 cards, with ranks A (ace), 2, 3, 4, 5, 6, 7, 8, 9, 10, J (jack), Q (queen), and K (king), and suits &#x2663;&#xFE0F; (clubs), &#x2666;&#xFE0F; (diamonds), &#x2665;&#xFE0F; (hearts), and &#x2660;&#xFE0F; (spades). Here is how it is played.
1)	The deck is shuffled, and thirteen cards are dealt "face up" from the deck to the board.
2)	Then the following sequence of steps is repeated:
    * The player removes each pair of cards (A, 2,..., 9) that total 10, e.g., an 8 and a 2, or a 9 and an A. An ace is worth 1, and suits are ignored when determining cards to remove.  10, J,Q and K are worth zero points.
    * Groups of 4 cards may be removed if they all have equal rank, and that common rank is 10,J,Q or K. For example, the four cards Q &#x2663;&#xFE0F;,  Q &#x2666;&#xFE0F;, Q &#x2665;&#xFE0F;, Q &#x2660;&#xFE0F;.
    * Cards are dealt from the deck if possible to replace the cards just removed.
3) The game is won when the deck is empty and no cards remain on the table.
    
These three games, along with Elevens, have several similarities, along with several differences.

### Implementation

1) Below is a list of instance fields and methods that you might include in a class definition for `ElevensBoard`. 
    * identify attributes and behaviours that can be used **interchangably** (i.e. they could be written once and reused as-is),
    * identify attributes and behaviours that are required for each of the three games, **but would need to be redefined for each game**,
    * identify attributes and behaviours that **would not be used by Thirteens or Tens**.
    
```java
    /**
     * The cards on this board.
     */
    private Card[] cards;

    /**
     * The deck of cards being used to play the current game.
     */
    private Deck deck;
    
    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 9;
    
    /**
     * Start a new game by shuffling the deck and
     * dealing some cards to this board.
     */
    public void newGame() {
    }

     /**
     * Accesses the size of the board.
     * Note that this is not the number of cards it contains,
     * which will be smaller near the end of a winning game.
     * @return the size of the board
     */
    public int size() {
    }

    /**
     * Determines if the board is empty (has no cards).
     * @return true if this board is empty; false otherwise.
     */
    public boolean isEmpty() {
    }

    /**
     * Deal a card to the kth position in this board.
     * If the deck is empty, the kth card is set to null.
     * @param k the index of the card to be dealt.
     */
    public void deal(int k) {
    }

    /**
     * Accesses the deck's size.
     * @return the number of undealt cards left in the deck.
     */
    public int deckSize() {
    }

    /**
     * Accesses a card on the board.
     * @return the card at position k on the board.
     * @param k is the board position of the card to return.
     */
    public Card cardAt(int k) {
    }

    /**
     * Replaces selected cards on the board by dealing new cards.
     * @param selectedCards is a list of the indices of the
     *        cards to be replaced.
     */
    public void replaceSelectedCards(List<Integer> selectedCards) {
    }

    /**
     * Gets the indexes of the actual (non-null) cards on the board.
     *
     * @return a List that contains the locations (indexes)
     *         of the non-null entries on the board.
     */
    public List<Integer> cardIndexes() {
    }

    /**
     * Generates and returns a string representation of this board.
     * @return the string version of this board.
     */
    public String toString() {
    }

    /**
     * Determine whether or not the game has been won,
     * i.e. neither the board nor the deck has any more cards.
     * @return true when the current game has been won;
     *         false otherwise.
     */
    public boolean gameIsWon() {
    }

    /**
     * Determinesif the selected cards form a valid group for removal.
     * @param selectedCards the list of the indices of the selected cards.
     * @return true if the selected cards form a valid group for removal;
     *         false otherwise.
     */
    public boolean isLegal(List<Integer> selectedCards){
    }

    /**
     * Determines if there are any legal plays left on the board.
     * @return true if there is a legal play left on the board;
     *         false otherwise.
     */
    public boolean anotherPlayIsPossible(){
    }

    /**
     * Deal cards to this board to start the game.
     */
    private void dealMyCards() {
    }
    
    private boolean containsPairSum11(List<Integer> selectedCards) {
    }
    

    /**
     * Check for a JQK in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find a JQK group.
     * @return true if the board entries in selectedCards
     *   include a jack, a queen, and a king; false otherwise.
     */
    private boolean containsJQK(List<Integer> selectedCards) {
    }
    
    /** 
    * return the point value for this card
    * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find a JQK group.
     * @return true if the board entries in selectedCards
     *   include a jack, a queen, and a king; false otherwise.
     */
    private int pointValue(Card card){
    }
```

2) Currently, the point value of a card is an attribute of its rank; however, as you have realized the point value is specific to the game.  There are various ways to handle this: create different `Rank`-type classes for specific games, create different `Card`-type classes for specific games, or (as we have done here) make a method that assigns point values in the class that defines the rules.  Having already written a class that has the correct point values for Elevens, you may wish to keep it that way, but note that it is not necessary.

3) Given that each of these games uses a standard 52-card deck, it is appropriate to add a "no-arg" constructor to your `Deck` class.
    * in the `Deck.java` file, add a constructor that takes no arguments and returns a standard 52-card deck.
    * if you want to call the constructor you have written previously, the syntax for calling a constructor from within the same class is `this(<params>)`, where `<params>` is the parameter list of the constructor being called.
    
## Activity 8: Write the `ElevensBoard` Class

### Introduction

We will now use the classes `Rank`, `Suit`, `Card` and `Deck` to write the `ElevensBoard` class, which defines the rules of the game and allows the GUI to play an interactive version.  Along the way we will encounter **subclasses** and the keywords `abstract` and `extends`.

### Exploration

Open the file `Board.java` in your IDE.  Read through the code, and observe:

* the class definition contains the keyword `abstract`
* there are definitions and implementations for the instance fields and methods from the listing above that can be used interchangably for the three solitare games.
* there are method headers, but no method bodies, for methods that each solitare game needs, but would have different definitions.  These method headers also contiain the keyword `abstract`.

`Board` is called an **abstract class**.  Abstract classes cannot be instantiated; instead, they act as supertypes for **concrete classes**.  Below is a diagram that shows the relationship between `Board` and `ElevensBoard`, `ThirteensBoard` and `TensBoard`.  The arrow should be read "**IS-A**", so `ElevensBoard` **is a** `Board`.  The IS-A relationship is a fundamental feature of object-oriented design, and we will have much more to say about it later.

![Inheritance diagram](img/03%20-%20inheritance.png)

The "is-a" relationship is created using the keyword `extends` when defining a class; in this case, the class header for `ElevensBoard` is
```java
public class ElevensBoard extends Board{
    ...
}
```
and similarly for `TensBoard` and `ThirteensBoard`.  
**Notes**  
* when a class an extension of another class, it **inherits** all the `public` (non-`abstract`) from its **superclass**, i.e. all the methods of `Board` are now also methods of `ElevensBoard`
* `ElevensBoard` can **override** methods of the `Board` class using the same syntax as above when we redefined the `toString()` methods.  We will not override any of the implemented methods of `Board`.
* However, because `Board` is an abstract class, the subclass `ElevensBoard` *must* implement all the `abstract` methods.  The compiler will insist.
* Subclasses do not have access to `private` instance fields or methods of the parent class.
* A subclass can also define additional methods to those in the abstract "contract", and they can be either `public` or `private`.  
* A subclss can also have its own (`private`) instance variables.

### Implementation

1) If you haven't already, open the `ElevensBoard.java` file and get yourself oriented.  
   * there are four methods for you to implement; you do not need to alter any of the other code in the file, but you should have a look.
   * although you won't be altering the code in `Board`, you should keep that file open so you can refer to the definitions and documentation.  Remember that you can use all the `public` methods __as if they are defined in the__ `ElevensBoard` __class__.
   * Some of the methods take an argument of type `ArrayList<Integer>`. While you don't have to be concerned with how those lists are constructed, it's important to understand what they mean: each `Integer` represents the **index in the array** `cards` of a `Card` that has been selected in the GUI.  You can't directly access `cards`, so use the `cardAt` method from `Board` to retrieve the appropriate `Card` object.
   * Remember that auto-boxing and unboxing makes it very easy to switch between `Integer` and `int`.  While you need to understand the difference theoretically, in practice just treat them the same until the compiler complains &#x1f600;


[def]: https://en.wikipedia.org/wiki/Faro_shuffle