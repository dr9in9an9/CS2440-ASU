package nature;

/**HouseCat class, extending Feline. 
 * 
 * @author Jesus Sisniega-Serrano
 * @version 6/25/25
 */
public class Ocelot extends Feline {
    public Ocelot(String name){
        super(name);
    }

    public void eat() {
        System.out.println("pick...");
        setHungerLevel(getHungerLevel()-3);
    }
}
