/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;

/**
 *
 * @author
 */
public class Dealer {
   private Hand dealerHand = new Hand();
   private Deck myDeck = new Deck();
   private Player[] myPlayers;
   private Scanner scan = new Scanner(System.in);
   
   public Dealer(int numOfPlayers){
       initMyPlayers(numOfPlayers);  
   }
   
   public void playGame(){
       dealOutOpeningHand();
       takePlayerTurns();
       playOutDealerHand();
       declareWinners();
   }
    
   public void dealOutOpeningHand(){
        for(int i = 0; i < 2; i++){
            for(Player currPlayer : myPlayers){ //for each player in myplayers, take that player and stick into another variable, the currPlayer
                currPlayer.getMyHand().addCard(myDeck.dealCard());
            }
            dealerHand.addCard(myDeck.dealCard());
        }
   }
   
   public void takePlayerTurns(){
       for(Player currPlayer : myPlayers){
           while(currPlayer.getMyHand().getNumOfCards() < 5 && currPlayer.getMyHand().getScore() < 21){
               System.out.println(currPlayer.getName() + "'s Hand:");
               currPlayer.getMyHand().printHand();
               System.out.println("Would you like to hit? (y/n)");
               char opt = scan.next().charAt(0); //returns the char at the 0 location, the first location
               if(opt == 'y'){
                   currPlayer.getMyHand().addCard(myDeck.dealCard());
               }else{
                   break;
               }
           }
           currPlayer.getMyHand().printHand();
       }
   }
   
    public void playOutDealerHand(){
       while(dealerHand.getScore() < 17){
           dealerHand.addCard(myDeck.dealCard());
       }
       dealerHand.printHand();
   }
   
   public void declareWinners(){
       System.out.println("---------------------------------------------------");
       System.out.println("Dealer's Hand: ");
       dealerHand.printHand();
       for(int i = 0; i < myPlayers.length; i++){
           Player currPlayer = myPlayers[i];
           System.out.print("\n");
           System.out.println(currPlayer.getName() + "'s Hand:");
           currPlayer.getMyHand().printHand();
           if(dealerHand.getScore() > 21 || currPlayer.getMyHand().getScore() > 21){
               if(currPlayer.getMyHand().getScore() > 21){
                   System.out.println(currPlayer.getName() + " Busts.");
               }else{
                   System.out.println("Dealer Busted " + currPlayer.getName() + " Wins.");
               }
           }else if(dealerHand.getScore() == 21 || dealerHand.getNumOfCards() > 4){
               System.out.println("The dealer is hot tonight, " + currPlayer.getName() +  " loses.");
           }else if(currPlayer.getMyHand().getNumOfCards() > 4){
               System.out.println(currPlayer.getName() + " wins with a 5-Card Charlie.");
           }else if(currPlayer.getMyHand().getScore() > dealerHand.getScore()){
               System.out.println(currPlayer.getName() + "'s score is greater than the dealer's, they win.");
           }else{
               System.out.println(currPlayer.getName() + " loses, quit while you have money for the cab home.");
           }
       }
   }
   
   private void initMyPlayers(int numPlayers){
       myPlayers = new Player[numPlayers];
       for(int i = 0; i < myPlayers.length; i++){
           System.out.println("Player " + (i+1) + ", what is your name?");
           String name = scan.next();
           if(name.equals("")){
               myPlayers[i] = new Player(i+1);
           }else{
               myPlayers[i] = new Player(name);
           }
       }
   }
}
