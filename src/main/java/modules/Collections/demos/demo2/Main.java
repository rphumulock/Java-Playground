package modules.Collections.demos.demo2;

import modules.Collections.demos.Card;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

    }
}
