package nature;

/**Coyote class, extending Canine. 
 * 
 * @author Jesus Sisniega-Serrano
 * @version 6/25/25
 */
public class Coyote extends Canine {
    public Coyote(String name){
        super(name);
    }

    public void eat(){
        System.out.println("gnaws...");
        setHungerLevel(getHungerLevel()-2);
    }

    public void makeNoise(){
        System.out.println("howl...");
    }
}
