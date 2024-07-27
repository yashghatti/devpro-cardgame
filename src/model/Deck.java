package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Deck {

    private List<Card> cards = new ArrayList<>(20);

    public Deck(){
        IntStream.range(1, 21).forEach(value -> cards.add(new Card(value)));
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }

    public List<Card> drawTop(int amount) {
        if(!cards.isEmpty()) {
            List<Card> playerHand = new ArrayList<>(cards.subList(0,amount));
            cards.subList(0,amount).clear();
            return playerHand;
        } else {
            return List.of();
        }
    }

    public void distribute10ToEachPlayerAlternatively(Player player1, Player player2) {
        for(int i=0; i<20; i++){
            if(i%2 == 0)
                player1.addToPlayerDeck(cards.get(i));
            else
                player2.addToPlayerDeck(cards.get(i));
        }
    }
}
