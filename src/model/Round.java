package model;

public class Round {

    private Deck deck;
    private Player player1;
    private Player player2;
    private Outcome outcome;
    private Player winningPlayer;

    public Round(Deck deck, Player player1, Player player2) {
        this.deck = deck;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play(){
        deck.shuffle();
        deck.distribute10ToEachPlayerAlternatively(player1, player2);

        int p1Wins = 0;
        int p2Wins = 0;
        while (player1.hasMoreCardsToPlay() && player2.hasMoreCardsToPlay()) {

            player1.draw5ToHand();
            player2.draw5ToHand();

            if(player1.getScore() > player2.getScore())
                p1Wins++;
            else if(player1.getScore() < player2.getScore())
                p2Wins++;
        }

        if(p1Wins == p2Wins){
            this.outcome = Outcome.DRAW;
        } else if(p1Wins > p2Wins) {
            this.outcome = Outcome.WIN;
            this.winningPlayer = player1;
        } else if(p2Wins > p1Wins) {
            this.outcome = Outcome.WIN;
            this.winningPlayer = player2;
        }
    }

    public static enum Outcome{
        WIN, DRAW;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public Player getWinningPlayer(){
        return winningPlayer;
    }

    @Override
    public String toString() {
        return "Round{" +
                "outcome=" + outcome +
                (outcome==Outcome.WIN ? ", winningPlayer=" + winningPlayer : "")+
                '}';
    }
}
