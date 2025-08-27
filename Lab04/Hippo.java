package nature;

/**Hippo interface, extending the Animal intereface.
 * 
 * @author Jesus Sisniega-Serrano
 * @version 6/25/25
 */
public class Hippo extends Animal {
    public Hippo(String name){
        super(name);
    }

    public void eat(){
        System.out.println("slurp...");
        setHungerLevel(getHungerLevel()-1);
    }

    public void makeNoise(){
        System.out.println("blub...");
    }
}
