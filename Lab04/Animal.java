package nature;

/**Animal interface.
 * Contains potential Animal inheritor methods.
 * 
 * @author Jesus Sisniega-Serrano
 * @version 6/25/25
 */
public abstract class Animal {
    protected String name;
    protected int hungerLevel;

    public Animal(String name){
        setName(name);
    }

    public int getHungerLevel(){
        return hungerLevel;
    }

    public String getName(){
        return name;
    }

    public void setHungerLevel(int hungerLevel){
        if (hungerLevel > 10){
            this.hungerLevel = 10;
        }
        else if (hungerLevel < 0) {
            this.hungerLevel = 0;
        }
        else {
            this.hungerLevel = hungerLevel;
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public void sleep(){
        System.out.println("sleeping...");
        setHungerLevel(10);
    }

    public void roam(){
        System.out.println("moving around...");
        setHungerLevel(getHungerLevel()+1);
    }

    public abstract void eat();

    public abstract void makeNoise();
}
