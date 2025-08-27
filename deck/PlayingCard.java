package deck;
/**PlayingCard class.
 * 
 * @author Jesus Sisniega-Serrano
 * @version 5/29/25
 */
public class PlayingCard{
    private Suit suit;
    private Rank rank;

    /**Constructor class.
     * 
     * @param rank
     * @param suit
     */
    public PlayingCard(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }
    /**
     * 
     * @return
     */
    public Rank getRank(){
        return this.rank;
    }
    /**
     * 
     * @return
     */
    public Suit getSuit(){
        return this.suit;
    }
    /**
     * 
     * @param rank
     */
    public void setRank(Rank rank){
        this.rank = rank;
    }
    /**
     * 
     * @param suit
     */
    public void setSuit(Suit suit){
        this.suit = suit;
    }
    /**
     * 
     */
    public String toString(){
        return getRank() + " of " + getSuit();
    }
}