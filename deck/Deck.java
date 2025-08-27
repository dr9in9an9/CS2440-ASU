package deck;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Deck{
    public static final int NUM_CARDS = 52;
    private Random generator;
    private ArrayList<PlayingCard> deck;

    /**No param constructor.
     * 
     */
    public Deck(){
        this.generator = new Random();
        initialize();
    }
    /**Constuctor.
     * 
     * @param seed
     */
    public Deck(int seed){
        this.generator = new Random(seed);
        initialize();
    }
    /**Creates a PlayingCard ArrayList containing 
     * every card found in a standard deck.
     */
    public void initialize(){
        this.deck = new ArrayList<PlayingCard>();
        Rank[] rank = Rank.values();
        Suit[] suit = Suit.values();
        for (int i = 0; i < rank.length; i++){
            for (int j = 0; j < suit.length; j++) {
                deck.add(new PlayingCard(rank[i], suit[j]));
            }
        }
    }
    /**Moves around all cards wihtin deck in pseudo-
     * random arrangement.
     */
    public void shuffleDeck(){
        for (int i = (deck.size() - 1); 0 < i; i --){
            int rand = generator.nextInt(i);
            PlayingCard card1 = deck.get(rand);
            deck.set(rand, deck.get(i));
            deck.set(i, card1);
        }
    }
    /**Returns desired PlayingCard obj.
     * 
     * @param index index of desired obj.
     * @return PlayingCard.
     */
    public PlayingCard getCard(int index){
        return deck.get(index);
    }
    /**Returns String representation of deck *yay*.
     * 
     * @return String.
     */
    public String toString(){
        String str = "";
        Iterator it = deck.iterator();

        while (it.hasNext()){
            str += it.next();
            if (it.hasNext()){
                str += "\n";
            }
        }
        return str;
    }
}