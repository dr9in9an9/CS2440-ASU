package nature;

/**HouseCat class, extending HouseCat. 
 * 
 * @author Jesus Sisniega-Serrano
 * @version 6/25/25
 */
public class SiameseCat extends HouseCat{
    public SiameseCat(String name){
        super(name);
    }

    public void makeNoise(){
        System.out.println("mrrooowwww...");
    }

    public void play(){
        System.out.println("zoom zoom zoom...");
    }
}
