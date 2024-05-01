/**
 * implements queue interface to create a queue
 */

import java.util.LinkedList;
public class MyQueue1<E> implements Queue1<E>
{
    LinkedList<E> list;
    public MyQueue1(){
        list = new LinkedList<E>();
    }

    /**
     * Return the Object at the beginning of this Queue
     * If the Queue is empty, return null
     */
    public E peek(){
        if(list.size() == 0){
            return null;
        }
        else{
            return list.get(0);
        }
    }

    /**
     * Add obj to the end of this Queue
     */
    public void add(E obj){
        list.add(obj);
    }

    /**
     * Remove the Object from the front of this Queue and return it.
     * If the Queue is empty, return null
     */
    public E remove(){

        if(list.size() == 0){
            return null;
        }
        else{
            E removed = list.get(0);
            list.remove(0);
            return removed;
        }

    }

    /**
     * Return true if this Queue is empty
     */
    public boolean isEmpty(){
        boolean boo = false;
        if(list.size() == 0){
            boo = true;
        }
        return boo;
    }

    /**
     * Return the number of Objects in this Queue
     */
    public int size(){
        return list.size();
    }
}