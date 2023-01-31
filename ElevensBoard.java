import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board{

    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 9;

    /**
     * Flag used to control debugging print statements.
     */
    private static final boolean I_AM_DEBUGGING = false;


    /**
     * Creates a new <code>ElevensBoard</code> instance.
     */
    public ElevensBoard(){
        super(BOARD_SIZE);
    }
    
    /* Note:
    * Before you write any new methods, recall that you can use all the non-abstract
    public methods in the Board class.
    * You cannot access the private instance variables from the Board class, but with
    the available public methods, you shouldn't need to.  If you think you do, think 
    of a way to avoid it!
    * It is possible to complete the project without implementing any methods 
    other than those here, but if you think that something should be added so the code 
    is clearer, feel free to do so.
    */
    
    /**
     * Determines if the selected cards form a valid group for removal.
     * In Elevens, the legal groups are (1) a pair of non-face cards
     * whose values add to 11, and (2) a group of three cards consisting of
     * a jack, a queen, and a king in some order.
     * @param selectedCards the list of the indices of the selected cards.
     * @return true if the selected cards form a valid group for removal;
     *         false otherwise.
     */
    
    public boolean isLegal(List<Integer> selectedCards) {
        // TODO: implement isLegal
        if (selectedCards.size()==2){
            if (containsPairSum11(selectedCards)){
                return true;
            }
        }
        if (selectedCards.size()==3){
            if (containsJQK(selectedCards)){
                return true;
            }
        }
        return false;
    }

    /**
     * Determine if there are any legal plays left on the board.
     * In Elevens, there is a legal play if the board contains
     * (1) a pair of non-face cards whose values add to 11, or (2) a group
     * of three cards consisting of a jack, a queen, and a king in some order.
     * @return true if there is a legal play left on the board;
     *         false otherwise.
     */
    public boolean anotherPlayIsPossible(List<Integer>selectedCards) {
        //TODO: implement anotherPlayIsPossible
        if (containsPairSum11(selectedCards) || !containsJQK(selectedCards)){
            return true;
        }
        return false;
    }
    
    /**
     * Check for an 11-pair in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find an 11-pair.
     * @return true if the board entries in selectedCards
     *              contain an 11-pair; false otherwise.
     */
    private boolean containsPairSum11(List<Integer> selectedCards) {
        //TODO: implement containsPairSum11
        int s = selectedCards.size();
        for (int i=0; i<s; i++){
            for (int j=i; j<s; j++){
                int card1=cardAt(selectedCards.get(i)).getRank().getPointValue();
                int card2=cardAt(selectedCards.get(j)).getRank().getPointValue();
                if (card1+card2==11){
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Check for a JQK in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find a JQK group.
     * @return true if the board entries in selectedCards
     *              include a jack, a queen, and a king; false otherwise.
     */
    private boolean containsJQK(List<Integer> selectedCards) {
         //TODO: implement containsJQK
         int s = selectedCards.size();
         boolean jack = false;
         boolean queen = false;
         boolean king = false;
        for (int i=0; i<s; i++){
            String card1 = cardAt(selectedCards.get(i)).getRank().name();
            if (card1.equals("JACK")){
                jack = true;
            }
            if (card1.equals("QUEEN")){
                queen = true;
            }
            if (card1.equals("KING")){
                king = true;
            }
        }
        if (jack && queen && king){
            return true;
        }
        else {
            return false;
        }        
    }
}
