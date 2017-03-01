
import java.util.ArrayList;
import java.util.List;


public class MyArrayList extends ArrayList<Object>{ //extends ArrayList<Object>{

    private Object[] elements;
    
    public MyArrayList(int initialCapacity) {
        elements = new Object[initialCapacity];
    }

    public MyArrayList() {
        this(16);
    }
    
    public boolean add(Object o){
       return super.add(o);
    }
    
    public void add(int index, Object o){
        super.add(index, o);
    }
    
    public void clear(){
        super.clear();
    }
    
    public boolean contains(Object o){
        return super.contains(o);
    }
    
    public Object get(int index){
        return super.get(index);
    }
    
    public int indexOf(Object o){
        return super.indexOf(o);
    }
    
    public boolean isEmpty(){
        return super.isEmpty();
    }
    
    public int lastIndexOf(Object o){
        return super.lastIndexOf(o);
    }
    
    public boolean remove(Object o){
        return super.remove(o);
    }
    
    public int size(){
        return super.size();
    }
    
    public Object remove(int index){
        return super.remove(index);
    }
    
    public Object set(int index, Object o){
        return set(index, o);
    }
    
}
