package nature;

/**Feline interface, extending the Animal intereface.
 * 
 * @author Jesus Sisniega-Serrano
 * @version 6/25/25
 */
public abstract class Feline extends Animal {
    public Feline(String name){
        super(name);
    }

    public void roam(){
        System.out.println("felines like to roam alone...");
        setHungerLevel(getHungerLevel()+1);
    }

    public void sleep(){
        System.out.println("taking a cat nap...");
        setHungerLevel(10);
    }

    public void makeNoise(){
        System.out.println("meow...");
    }
}
