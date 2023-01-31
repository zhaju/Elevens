/**
 * Write a description of class Card here.
 *
 * @julian (your name)
 * @01/20 (a version number or a date)
 */
public class Card
{
    private Rank rank;
    private Suit suit;

    /**
     * Constructor for objects of class Card
     */
    Card(Rank initRank, Suit initSuit)
    {
        rank = initRank;
        suit = initSuit;
    }

    /**
     * takes one parameter of type Card called other and returns true if 
     * this and other represent the same card
     * NOTE: "this" is a keyword in java (for some reason)
     * in this case, you don't need "this" because 
     * the instance variable is also in the class
     */
    public boolean matches(Card other)
    {
        //you can use getRank or getSuit, but you don't need it
        //because this is also in the Card class so you can refer to it
        return other.rank.equals(this.rank) && other.suit.equals(this.suit);
    }
    public void print(){
        String name = this.rank+" of "+ this.suit;
        System.out.println(name.toLowerCase());
    }
    public Rank getRank()
    {
        return rank;
    }
    public Suit getSuit()
    {
        return suit;
    }
    @Override
    public String toString(){
        return rank.toString()+"of"+suit.toString();
    }
}

