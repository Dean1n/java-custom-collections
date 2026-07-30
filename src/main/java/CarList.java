public interface CarList extends CarCollection{
    Car get(int index);
    boolean add(Car car);
    boolean remove(Car car);
    boolean removeAt(int idx);
    int size();
    void clear();
    boolean add(Car car,int index);
    boolean contains(Car car);
}
