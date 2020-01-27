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
    
    private String[] ranks = {}; //literally defining the array, so we use curly braces
    private String[] suits = {}; //encapsulated because they are private, ensure no-one touches them
    
    private int nextCard = 0;
    
    public Deck(){ //empty constructor, it is its own return type
        
    }
    
    private void initDeck(){
        
    }
    
    private void shuffle(){
        
    }
    
    //printDeck is for testing only --delete me
    public void printDeck(){
        
    }
    
    public Card dealCard(){ //a class is the data type of an object
        
        return null; //do not forget to change this 
    }
        
        
        
}
