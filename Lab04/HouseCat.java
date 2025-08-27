package nature;

/**HouseCat class, extending Feline, inheriting Pet. 
 * 
 * @author Jesus Sisniega-Serrano
 * @version 6/25/25
 */
public class HouseCat extends Feline implements Pet {
    public HouseCat(String name){
        super(name);
    }

    public void eat(){
        System.out.println("crunch crunch...");
        setHungerLevel(getHungerLevel()-3);
    }

    public void beFriendly(){
        System.out.println("purr...");
    }

    public void play(){
        System.out.println("frolic");
    }
}
