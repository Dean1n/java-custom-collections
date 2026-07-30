import java.util.Arrays;

public class CarHashSet implements CarSet{
    private static final int INITIAL_CAPACITY=16;
    private final double LOAD_FACTOR=0.75;
    private Entry[] array=new Entry[INITIAL_CAPACITY];
    private int size=0;

    private static class Entry {
        private Car value;
        private Entry next;

        public Entry(Car value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }
    private int getelementposition(Car car, int arraylenth){
        return Math.abs(car.hashCode()%arraylenth);
    }

    @Override
    public boolean remove(Car car) {
        int pos = getelementposition(car, array.length);
        if(array[pos]==null) {
            return false;
        }
        Entry secondlast=array[pos];
        Entry last=secondlast.next;

        if (secondlast.value.equals(car)) {
            array[pos] = last;
            size--;
            return true;
        }
        while (last!=null) {
            if (last.value.equals(car)) {
                secondlast.next = last.next;
                size--;
                return true;
            } else {
                secondlast = last;
                last = last.next;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array=new Entry[INITIAL_CAPACITY];
        size=0;
    }
    @Override
    public boolean add(Car car) {
        if(size>=array.length*LOAD_FACTOR){
            increaseArray();
        }
        boolean added =add(car,array);
        if(added){
            size++;
        }
        return added;
    }
    private boolean add(Car car ,Entry[] dst){
        int pos = getelementposition(car, dst.length);

        if (dst[pos] == null) {
            Entry entry = new Entry(car, null);
            dst[pos] = entry;
            return true;
        } else {
            Entry existedElement = dst[pos];
            while (true) {
                if (existedElement.value.equals(car)) {
                    return false;
                } else if (existedElement.next == null) {
                    existedElement.next = new Entry(car, null);
                    return true;
                } else {
                    existedElement = existedElement.next;
                }
            }
        }
    }
    private void increaseArray(){
        Entry[] newArray=new Entry[array.length*2];
        for(Entry entry : array){
            Entry existedElement=entry;
            while(existedElement != null){
                add(existedElement.value,newArray);
                existedElement=existedElement.next;
            }
        }
        array=newArray;
    }

    @Override
    public boolean contains(Car car) {
        int pos = getelementposition(car, array.length);
        if(array[pos]==null) {
            return false;
        }
        Entry last=array[pos];

        if (last.value.equals(car)) {
            return true;
        }
        while (last!=null) {
            if (last.value.equals(car)) {
                return true;
            } else {
                last = last.next;
            }
        }
        return false;
    }
}
