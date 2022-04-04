/*
Trent Blair
4/4/24
This is the class for the dictionary
collaborated with Ishan
 */
import java.util.ArrayList;

import java.util.Collection;

public class Dictionary <T, E>{

    private ArrayList<T> values;
    private ArrayList<E> keys;


    public Dictionary(){
        values = new ArrayList<>();

        keys = new ArrayList<>();
    }
    public T get(E key){
        int indexOfKey = keys.indexOf(key);
        return values.get(indexOfKey);
    }

    public void put(E key, T value){
        keys.add(key);
        values.add(value);
    }


    public T remove(E key){
        int indexOfKey = keys.indexOf(key);
        keys.remove(indexOfKey);
        return values.remove(indexOfKey);
    }

    public boolean isEmpty(){
        return !(values.size() > 0);
    }
    public int size(){
        return keys.size();
    }

    public boolean contains(E key){//checks if it contains
        int indexOfKey = keys.indexOf(key);
        return indexOfKey >= 0;
    }

    public Collection<E> values(){//the values
        Collection collection = values;
        return collection;
    }

    public Collection<E> keys(){//the keys
        Collection collection = keys;
        return collection;
    }


}