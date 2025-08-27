package nature;

import java.util.ArrayList;

/**Habitat Class.
 * 
 * @author Jesus Sisniega-Serrano
 * @version 6/25/25
 */
public class Habitat {
    private String name;
    private double latitude;
    private double longitude;
    private ArrayList<Animal> animals;

    public Habitat(String name, double lat, double lon){
        setName(name);
        setLatitude(lat);
        setLongitude(lon);
        this.animals = new ArrayList<Animal>();
    }

    public double getLatitude(){
        return latitude;
    }

    public double getLongitude(){
        return longitude;
    }

    public String getName(){
        return name;
    }

    public void setLatitude(double lat){
        latitude = lat;
    }

    public void setLongitude(double lon){
        longitude = lon;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getNumOfAnimals(){
        return animals.size();
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public void testAnimals(){
        System.out.println(getName() + "\n" + getLatitude() 
            + "\n" + getLongitude() + "\n" + getNumOfAnimals());
        for (int i = 0; i < getNumOfAnimals(); i++) {
            animals.get(i).sleep();
            animals.get(i).makeNoise();
            animals.get(i).eat();
            animals.get(i).roam();
            if (animals.get(i) instanceof Pet){
                ((Pet) animals.get(i)).play();
                ((Pet) animals.get(i)).beFriendly();
            }
        }
    }
}
