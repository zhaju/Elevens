
/**
 * Enumeration class Suit - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Suit
{
    DIAMONDS, CLUBS, HEARTS, SPADES; 
    
    @Override
    public String toString(){
        return name().toLowerCase();
    }
}
