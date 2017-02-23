/**
 * Created by jbc on 2/22/2017.
 */
public class TripStopNode {

    private TripStop data;
    private TripStopNode next;
    private TripStopNode prev;

    public TripStopNode(TripStop initData)throws IllegalArgumentException{
        if(initData == null){
            throw new IllegalArgumentException();
        }

        data = initData;
        next = null;
        prev = null;
    }


    public TripStop getData(){
        return data;
    }

    public void setData (TripStop newData)throws IllegalArgumentException{
        if (newData == null){
            throw new IllegalArgumentException();
        }

        this.data = newData;

    }

    public TripStopNode getNext(){
        return next;
    }

    public void setNext(TripStopNode newNext){
        this.next = newNext;
    }

    public TripStopNode getPrev(){
        return prev;
    }

    public void setPrev(TripStopNode newPrev){
        this.prev = newPrev;
    }


}
