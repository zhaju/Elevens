import java.util.*;
/**
 * Write a description of class Deck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Deck
{
    // instance variables - replace the example below with your own
    // Deck is a collection of every Card
    
    // Rank.values()
    // Suit.values()    

    ArrayList<Card> deck = new ArrayList<Card>();
    int size;
    //Card cards[];

    /**
     * Constructor for objects of class Deck
     */
    public Deck(Rank initRank[], Suit initSuit[])
    {
        for (Rank r:initRank){
            for (Suit s: initSuit){
                deck.add(new Card(r,s));
            }
        }
        size=deck.size();
        shuffle();
    }
    public void perfectShuffle(){
        int k=0;
        Card shuffled[]= new Card[52];
        for (int j=0; j<=25; j++){
            shuffled[j]=deck.get(k);
            k+=2;
        }
        k=1;
        for (int j=26; j<=51; j++){
            shuffled[k]=deck.get(j);
            k+=2;
        }
    }
    public void shuffle(){
        for (int m=size-1; m>=1; m--){
            int r = (int)(Math.random()*m);
            Card temp  = deck.get(m);
            deck.set(m, deck.get(r));
            deck.set(r, temp);
        }
    }
    public boolean isEmpty(){
        if (size==0){
            return false;
        }
        else {
            return true;
        }
    }
    public int getSize(){
        return size;
    }
    public Card deal(){
        if (size==0){
            return null;
        }
        else{
            size--;
            return deck.get(size);
        }
    }
    
    @Override
    public String toString(){
        String ans="";
        for (int i=0; i<size; i++){
            ans+=(deck.get(i).getRank()).toString();
            ans+=(deck.get(i).getSuit()).toString();
            ans+=" ";
        }
        return ans;
    }
}
