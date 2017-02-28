
import java.util.Comparator;


//compares the latitude of two cities
public class LatComparator implements Comparator<City>{

    @Override
    public int compare(City o1, City o2) {
        double lat1 = o1.getLatitude();
        double lat2 = o2.getLatitude();
        
        return Double.compare(lat1, lat2);
    }

}
