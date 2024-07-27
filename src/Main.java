import model.Deck;
import model.Player;
import model.Round;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Player player1 = new Player("p1");
        Player player2 = new Player("p2");
        Deck deck = new Deck();

        //for 1000 iterations of the game
        List<Round> roundHistory = new ArrayList<>();
        for(int i=1; i<=1000; i++) {
            Round round = new Round(deck, player1, player2);
            round.play();
            roundHistory.add(round);
            System.out.println("[Itr-"+i+"] "+round);
        }

        System.out.println("-----------------");
        List<Round> p1Wins = roundHistory.stream().filter(round ->
                round.getOutcome()== Round.Outcome.WIN && round.getWinningPlayer().equals(player1)
        ).collect(Collectors.toList());

        List<Round> p2Wins = roundHistory.stream().filter(round ->
                round.getOutcome()== Round.Outcome.WIN && round.getWinningPlayer().equals(player2)
        ).collect(Collectors.toList());
        if(p1Wins.size() > p2Wins.size()){
            System.out.println("Player 1 has won the game : ["+p1Wins.size()+" - "+p2Wins.size()+"]");
        }
        else if(p2Wins.size() > p1Wins.size()){
            System.out.println("Player 2 has won the game : ["+p1Wins.size()+" - "+p2Wins.size()+"]");
        }
        else {
            System.out.println("The game was a draw : ["+p1Wins.size()+" - "+p2Wins.size()+"]");
        }
    }

}
