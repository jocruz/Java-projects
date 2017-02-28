
import java.util.Comparator;

//compares the longitude of two cities
public class LngComparator implements Comparator<City>{

    @Override
    public int compare(City o1, City o2) {
        double lng1 = o1.getLongitude();
        double lng2 = o2.getLongitude();
        
        return Double.compare(lng1, lng2);
    }

}
