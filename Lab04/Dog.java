package nature;

/**Dog class, extending Canine, inheriting Pet. 
 * 
 * @author Jesus Sisniega-Serrano
 * @version 6/25/25
 */
public class Dog extends Canine implements Pet {
    public Dog(String name){
        super(name);
    }

    public void eat(){
        System.out.println("slop...");
        setHungerLevel(getHungerLevel()-3);
    }

    public void makeNoise(){
        System.out.println("bark...");
    }

    public void beFriendly(){
        System.out.println("nuzzles...");
    }

    public void play(){
        System.out.println("runs...");
    }
}
