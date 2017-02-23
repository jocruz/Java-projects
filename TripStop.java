import java.util.IllegalFormatCodePointException;

/**
 * Created by jbc on 2/22/2017.
 */
public class TripStop {
    private String location;
    private int distance;
    private String activity;

    public TripStop (String location, int distance, String activity)throws IllegalArgumentException{
        if (distance < 0){
            throw new IllegalArgumentException();
        }
        this.location = location;
        this.distance = distance;
        this.activity = activity;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String Location){
        this.location = location;
    }

    public int getDistance (){
        return distance;
    }

    public void setDistance(int distance)throws IllegalArgumentException{
        if(distance < 0){
            throw new IllegalArgumentException();
        }
        this.distance = distance;
    }


}
