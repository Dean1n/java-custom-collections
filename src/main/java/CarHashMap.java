import java.util.*;

public class CarHashMap<K,V> implements CarMap<K,V>{
    private static final int INITIAL_CAPACITY=16;
    private static final double LOAD_FACTOR=0.75;
    private Object[] entries = new Object[INITIAL_CAPACITY];
    private int size=0;
    private class Entry{
        private K key;
        private V value;
        Entry next;

        public Entry(K carOwner, V car, Entry next) {
            this.key = carOwner;
            this.value = car;
            this.next = next;
        }
    }

    @Override
    public void put(K key, V value) {
        if(size>=entries.length*LOAD_FACTOR){
            increaseArray();
        }
        boolean put=put(key,value,entries);
        if(put){
            size++;
        }
    }
    private boolean put(K key,V value, Object[] dst){
        int pos = getElementPosition(key,dst.length);
        Entry existedElement= (Entry) dst[pos];
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
    public V get(K key) {
        int pos=getElementPosition(key,entries.length);
        Entry existedElement= (Entry) entries[pos];
        while (existedElement!=null){
            if(existedElement.key.equals(key)){
                return existedElement.value;
            }
            existedElement=existedElement.next;
        }
        return null;
    }

    @Override
    public Set<K> keySet() {
        Set<K> result = new HashSet<>();
        for (Object entry : entries) {
            Entry existedElement = (Entry) entry;
            while (existedElement != null) {
                result.add(existedElement.key);
                existedElement = existedElement.next;
            }
        }
        return result;
    }

    @Override
    public List<V> values() {
        List<V> result = new ArrayList<>();
        for (Object entry : entries) {
            Entry existedElement = (Entry) entry;
            while (existedElement != null) {
                result.add(existedElement.value);
                existedElement = existedElement.next;
            }
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        int pos=getElementPosition(key,entries.length);
        Entry existedElement= (Entry) entries[pos];
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
        entries=new Object[INITIAL_CAPACITY];
        size=0;
    }
    private int getElementPosition(K carOwner, int arraylenth){
        return Math.abs(carOwner.hashCode() % arraylenth);
    }
    private void increaseArray(){
        Object[] newEntries =new Object[entries.length*2];
        for (Object entry : entries) {
            Entry existedElement = (Entry) entry;
            while (existedElement != null) {
                put(existedElement.key,existedElement.value,newEntries);
                existedElement = existedElement.next;
            }
        }
        entries=newEntries;
    }
}
