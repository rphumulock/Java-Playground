package modules.Collections.challenges.challenge1;

import modules.Collections.challenges.challenge1.poker.PokerGame;

public class GameController {

    public static void main(String[] args) {

        PokerGame fiveCardDraw = new PokerGame(4, 5);
        fiveCardDraw.startPlay();

    }
}
