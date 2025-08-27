package nature;

/**HouseCat class, extending Feline. 
 * 
 * @author Jesus Sisniega-Serrano
 * @version 6/25/25
 */
public class Lion extends Feline {
    public Lion(String name){
        super(name);
    }

    public void eat(){
        System.out.println("rip with teeth...");
        setHungerLevel(getHungerLevel()-2);
    }

    public void makeNoise(){
        System.out.println("roar...");
    }
}