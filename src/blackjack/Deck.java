 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author gubotdev
 */
public class Deck {
    private Card[] myCards = new Card[52]; //use new keyword because Card is an object
    
    private String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"}; //literally defining the array, so we use curly braces
    private String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"}; //encapsulated because they are private, ensure no-one touches them
    
    private int nextCard = 0;
    
    public Deck(){ //empty constructor, it is its own return type
        initDeck(); //whenever I create a deck it will initialize the deck
        shuffle();
    }
    
    private void initDeck(){
        int index = 0;
        for(int s = 0; s < suits.length; s++){
            for(int r = 0; r <ranks.length; r++){
                myCards[index] = new Card(ranks[r], suits[s]);
                index++;
            }
        }
        //for(int i = 0; i < mycards.length; i++){
            //myCards[i] = new Card(ranks[i % 13], suits[1/13])}
    }
    
    private void shuffle(){
        for(int i = 0; i < myCards.length; i++){
            Card temp = myCards[i];
            int rand = (int) (Math.random()*52);
            myCards[i] = myCards[rand];
            myCards[rand] = temp;
        }
    }
    
    //printDeck is for testing only --delete me
    public void printDeck(){
        for(int i = 0; i < myCards.length; i++){
            System.out.println(myCards[i].RANK + " of " + myCards[i].SUIT);
        }
    }
    
    public Card dealCard(){ //a class is the data type of an object
        
        return null; //do not forget to change this 
    }
        
        
        
}
