
import java.io.Serializable;
public class City implements Serializable{

    //City class represents a city of the world, with a name, latitude, longitude
    // as well as a static variable cityCount, which represents the total amount of cities instantiated,
    // and an int variable indexPos which represents the city's position in SigmaAir's <City> list.
    private String name;
    private int indexPos;
    public static int cityCount;
    private double latitude;
    private double longitude;
    
    //default constructor increments cityCount
    public City(){
        cityCount++;
    }
    
    
    
    //toString method returns formatted representation of city
    public String toString(){
        return String.format("%-20s%-15f%-15f",name,latitude,longitude);
    }

    
    //getSet methods for every instance variable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndexPos() {
        return indexPos;
    }

    public void setIndexPos(int indexPos) {
        this.indexPos = indexPos;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    
    
}
