package nature;

/**Wolf class, extending Canine. 
 * 
 * @author Jesus Sisniega-Serrano
 * @version 6/25/25
 */
public class Wolf extends Canine {
    public Wolf(String name){
        super(name);
    }

    public void eat(){
        System.out.println("rip with teeth...");
        setHungerLevel(getHungerLevel()-2);
    }

    public void makeNoise(){
        System.out.println("growl...");
    }
}
