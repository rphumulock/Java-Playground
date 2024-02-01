package modules.Collections.demos.demo2;

import modules.Collections.utils.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    /**
     * The provided code snippet demonstrates various ways to manipulate collections of `Card` objects in Java, highlighting different methods for initializing, filling, and copying collections. It uses a custom `Card` class and assumes the presence of methods like `getStandardDeck()`, `getFaceCard()`, and `printDeck()` within that class. Here's a breakdown of the code and its key operations:
     *
     * 1. **Initialize and Print a Standard Deck**:
     *    - A list of `Card` objects representing a standard deck is obtained and printed. This is straightforward and depends on the `Card.getStandardDeck()` and `Card.printDeck()` methods being properly implemented in the `Card` class.
     *
     * 2. **Initialize Array with `Arrays.fill()`**:
     *    - An array of `Card` objects is created with a fixed size of 13, initially filled with `null` values. This array is then filled with the same `Card` object (`aceOfHearts`), effectively creating an array where every element is a reference to the same `Card` object. A potential caveat here is that modifying one element of the array would affect all others since they refer to the same object.
     *
     * 3. **Attempt to Use `Collections.fill()` on an Empty List**:
     *    - A new `ArrayList` with an initial capacity of 52 is created, but it's important to note that initial capacity does not equate to size; the list is still empty. The `Collections.fill()` method call will fail to add elements to the list because it only replaces existing elements. The code here will not work as intended because the list needs to have pre-existing elements for `Collections.fill()` to replace. Consequently, the list remains empty, and its size is 0, which is a significant misunderstanding of how `Collections.fill()` works.
     *
     * 4. **Correct Use of `Collections.nCopies()`**:
     *    - The `Collections.nCopies()` method is used correctly to create immutable lists of a specified number of copies of a single object. This method is shown creating lists of `aceOfHearts` and `kingOfClubs`. These lists are immutable, meaning their structure (size, elements) cannot be changed after creation. This limitation should be considered when using `nCopies()` for creating lists.
     *
     * 5. **Adding Elements to a List with `Collections.addAll()`**:
     *    - The `Collections.addAll()` method is used to add all elements of the `cardArray` to the `cards` list twice. This demonstrates a way to add elements to a collection effectively. However, since `cardArray` contains references to the same object, this operation further emphasizes the issue of having multiple references to a single object in a collection.
     *
     * 6. **Copying Collections with `Collections.copy()`**:
     *    - The `Collections.copy()` method is used to copy the contents of `kingsOfClubs` into `cards`. This operation requires that the destination list (`cards`) has enough capacity (size) to hold all the elements of the source list. This method replaces the content of `cards` with that of `kingsOfClubs`. A potential issue here is that if `cards` is not large enough, an `IndexOutOfBoundsException` will be thrown.
     *
     * 7. **Immutable List Copy with `List.copyOf()`**:
     *    - Finally, `List.copyOf()` creates an immutable copy of `kingsOfClubs`. This immutable list cannot be modified after creation, which is a crucial consideration for design decisions regarding the mutability of collections.
     *
     * **Caveats and Considerations**:
     * - **Mutability vs. Immutability**: The use of `Collections.nCopies()` and `List.copyOf()` creates immutable collections, which cannot be modified. This is crucial for understanding the limitations in modifying these collections later in the program.
     * - **Shared References**: Filling arrays or collections with the same object instance means all elements point to the same memory location. Any modification to the object will reflect across all references.
     * - **Initialization and Capacity**: The misuse of `Collections.fill()` on an empty list highlights the importance of understanding the difference between a collection's capacity and its actual size.
     * - **Error Handling**: The code does not explicitly handle potential exceptions (e.g., `IndexOutOfBoundsException` from `Collections.copy()`), which is essential for robustness, especially when working with collections whose sizes might not match.
     * @param args
     */

    public static void main(String[] args) {

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardArray, aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray), "Aces of Hearts", 1);

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards, aceOfHearts);
        System.out.println(cards);
        System.out.println("cards.size() = " + cards.size());

        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesOfHearts, "Aces of Hearts", 1);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "Kings of Clubs", 1);

        Collections.addAll(cards, cardArray);
        Collections.addAll(cards, cardArray);
        Card.printDeck(cards, "Card Collection with Aces added", 2);

        Collections.copy(cards, kingsOfClubs);
        Card.printDeck(cards, "Card Collection with Kings copied", 2);

        cards = List.copyOf(kingsOfClubs);
        Card.printDeck(cards, "List Copy of Kings", 1);

    }
}
