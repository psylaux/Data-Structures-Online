package datastructures;

public class DynamicArray<String> {

    private Object[] data;
    private int size = 0;
    private int initialCapacity;

    public DynamicArray(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        data = new Object[initialCapacity];
    }

    public String get(int index) {
        return (String)data[index];
    }

    public void set(int index, String value) {
        data[index] = value;
    }

    public void insert(int index, String value) {

        // Check size
        if (size == initialCapacity) {
            resize();
        }

        // Copy up
        for (int j = size; j > index; j--) {
            data[j] = data[j-1];
        }

        // Insert
        data[index] = value;
        size++;
    }


    public void delete(int index) {

        if(index > size || size <= 0) {
            System.out.println("error");
        }

        else {
            for(int i = index; i < size; i++){
                data[i] = data[i+1];
            }

            size--;
        }

    }

    public boolean isEmpty() {

        if (size <= 0){
            return true;
        }
        return false;
    }

    public boolean Contains(String value) {


        for(int i = 0; i < size; i++){
            String val = (String) (data[i]);
            if(val.equals(value)){
                return true;
            }
        }
        return false;
    }


    private void resize() {
        Object[] newData = new Object[initialCapacity * 2];
        for (int i = 0; i < initialCapacity; i++) {
            newData[i] = data[i];
        }
        data = newData;
        initialCapacity = initialCapacity * 2;
    }

    public int size() {
        return size;
    }

    public void print() {
        for (int i=0;i< size;i++) {
            System.out.println("data[i] = " + data[i]);
        }
    }

    // Some array implementations offer methods like insert (also known as pushBack).
    // Which is like insert, only in does the insert at the end of the array.
    public void add(String value) {

        if (size == initialCapacity) {
            resize();
        }

        data[size] = value;
        size++;
    }


}