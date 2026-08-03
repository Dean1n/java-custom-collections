import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarHashMap implements CarMap{
    private static final int INITIAL_CAPACITY=16;
    private static final double LOAD_FACTOR=0.75;
    private Entry[] entries = new Entry[INITIAL_CAPACITY];
    private int size=0;
    private static class Entry{
        private CarOwner key;
        private Car value;
        Entry next;

        public Entry(CarOwner carOwner, Car car, Entry next) {
            this.key = carOwner;
            this.value = car;
            this.next = next;
        }
    }

    @Override
    public void put(CarOwner key, Car value) {
        if(size>=entries.length*LOAD_FACTOR){
            increaseArray();
        }
        boolean put=put(key,value,entries);
        if(put){
            size++;
        }
    }
    private boolean put(CarOwner key,Car value, Entry[] dst){
        int pos = getElementPosition(key,dst.length);
        Entry existedElement=dst[pos];
        if(existedElement==null){
            Entry entry=new Entry(key,value,null);
            dst[pos]=entry;
            return true;
        } else{
            while(true){
                if (existedElement.key.equals(key)){
                    existedElement.value=value;
                    return false;
                }
                if(existedElement.next==null){
                    existedElement.next=new Entry(key,value,null);
                    return true;
                }
                existedElement=existedElement.next;
            }
        }
    }
    @Override
    public Car get(CarOwner key) {
        int pos=getElementPosition(key,entries.length);
        Entry existedElement= entries[pos];
        while (existedElement!=null){
            if(existedElement.key.equals(key)){
                return existedElement.value;
            }
            existedElement=existedElement.next;
        }
        return null;
    }

    @Override
    public Set<CarOwner> keySet() {
        Set<CarOwner> result = new HashSet<>();
        for (Entry entry : entries) {
            Entry existedElement = entry;
            while (existedElement != null) {
                result.add(existedElement.key);
                existedElement = existedElement.next;
            }
        }
        return result;
    }

    @Override
    public List<Car> values() {
        List<Car> result = new ArrayList<>();
        for (Entry entry : entries) {
            Entry existedElement = entry;
            while (existedElement != null) {
                result.add(existedElement.value);
                existedElement = existedElement.next;
            }
        }
        return result;
    }

    @Override
    public boolean remove(CarOwner key) {
        int pos=getElementPosition(key,entries.length);
        Entry existedElement= entries[pos];
        if( existedElement!=null && existedElement.key.equals(key)){
            entries[pos]=existedElement.next;
            size--;
            return true;
        } else{
            while(existedElement!=null){
                Entry nextElement=existedElement.next;
                if(nextElement==null){
                    return false;
                }
                if(nextElement.key.equals(key)){
                    existedElement.next=nextElement.next;
                    size--;
                    return true;
                }
                existedElement=existedElement.next;
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
        entries=new Entry[INITIAL_CAPACITY];
        size=0;
    }
    private int getElementPosition(CarOwner carOwner, int arraylenth){
        return Math.abs(carOwner.hashCode() % arraylenth);
    }
    private void increaseArray(){
        Entry[] newEntries =new Entry[entries.length*2];
        for (Entry entry : entries) {
            Entry existedElement = entry;
            while (existedElement != null) {
                put(existedElement.key,existedElement.value,newEntries);
                existedElement = existedElement.next;
            }
        }
        entries=newEntries;
    }
}
