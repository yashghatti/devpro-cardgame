package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Player {

    private String name;
    private List<Card> hand = new ArrayList<>(10);
    private List<Card> playerDeck = new ArrayList<>(10);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    public Player(String name){
        this.name = name;
    }

    public void addToPlayerDeck(Card card){
        this.playerDeck.add(card);
    }

    public List<Card> showHand(){
        return hand;
    }

    public void draw5ToHand(){
        Collections.shuffle(playerDeck);
        hand = new ArrayList<>(playerDeck.subList(0,5));
        playerDeck.subList(0,5).clear();
    }

    public int getScore() {
        int sum = 0;
        for(Card card : hand){
            sum += card.getValue();
        }
        return sum >30 ? 0 : sum;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
//                ", hand=" + hand +
//                ", playerDeck=" + playerDeck +
//                ", hasMoreCards= "+ hasMoreCardsToPlay() +
                '}';
    }

    public boolean hasMoreCardsToPlay(){
        return !playerDeck.isEmpty();
    }

}
