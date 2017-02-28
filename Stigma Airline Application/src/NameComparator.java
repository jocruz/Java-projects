
import java.util.Comparator;

//compares the name of two cities
public class NameComparator implements Comparator<City>{

    @Override
    public int compare(City o1, City o2) {
        String name1 = o1.getName();
        String name2 = o2.getName();
        
        //takes the shorter of the two names, and goes through the strings character by character if the beggining
        //of the strings are the same. 
        //For example - St.Petersburg, St.Petersburg Province
        //in this case, St.Petersburg would come first because it is shorter.
        int shorterLength = (name1.length() > name2.length())?name2.length():name1.length();
        for (int i = 0; i < shorterLength; i++){
            int compare = Character.compare(name1.charAt(i),name2.charAt(i));
            if (compare != 0)
                return compare;
        }
        return 0;
    }

}
