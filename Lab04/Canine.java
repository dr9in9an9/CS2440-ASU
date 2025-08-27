package nature;

/**Canine interface, extending the Animal intereface.
 * 
 * @author Jesus Sisniega-Serrano
 * @version 6/25/25
 */
public abstract class Canine extends Animal{
    public Canine(String name){
        super(name);
    }

    public void roam(){
        System.out.println("like canines roam in packs...");
        setHungerLevel(getHungerLevel()+1);
    }
}
