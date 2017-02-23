/**
 * Created by jbc on 2/22/2017.
 */
public class Itinerary {

    private TripStopNode head;
    private TripStopNode tail;
    private TripStopNode cursor;
    private int count;
    public Itinerary(){
        this.head = null;
        this.tail = null;
        this.cursor = null;
        this.count = 0;
    }

    public int getStopsCount(){
        return count;
    }

    public int getTotalDistance(){
        return;
    }

    public TripStop getCursorStop(){
        if(cursor== null){
            return null;
        }
        return cursor.getData();
    }

    public void resetCursorToHead(){
        if(head != null)
        cursor = head;

        else
            cursor = null;

    }

    public void cursorForward(){
       cursor = cursor.getNext();
    }

    public void cursorBackward(){
        cursor = cursor.getPrev();
    }

    public void insertBeforeCursor (TripStop newStop){
        // 0-0-0
        if(newStop == null){
            throw new IllegalArgumentException();
        }

        TripStopNode newNode = new TripStopNode(newStop);
        if(cursor.getPrev()!= null){
            newNode.setPrev(cursor.getPrev());
            newNode.setNext(cursor);
        }

        else{
            head = newNode;
            tail = newNode;

        }
        count++;
        cursor = newNode;

    }

    public void appendToTail(TripStop newStop){
        if (newStop == null){
            throw new IllegalArgumentException();
        }
        TripStopNode newNode = new TripStopNode(newStop);

        if(cursor == null){
            head = newNode;
            tail = newNode;
            cursor = newNode;
        }
        else{
            newNode.setPrev(tail);
            tail.setNext(newNode);

        }
        count++;
        tail = newNode;
    }

    public TripStop removeCursor(){
        //0-0-0-1-0-0-
        TripStopNode temp;
        TripStop result = cursor.getData();

        if (cursor == null){
            throw new IllegalArgumentException(); //replace later
        }


        else{
            temp = cursor.getPrev();

            cursor.getPrev().setNext(cursor.getNext());
            cursor.getNext().setPrev(cursor.getPrev());

            cursor = temp;

        }
        count --;
        return result;
    }


}
