import java.util.Iterator;

public class CarLinkedList implements CarList{
    private Node first;
    private Node last;
    private int size=0;
    @Override
    public Car get(int index) {
        return getNode(index).value;
    }

    @Override
    public boolean add(Car car) {
        if(size==0){
            first=new Node(null,null, car);
            last=first;
        }
        else {
            Node secondLast = last;
            last=new Node(secondLast,null,car);
            secondLast.next=last;

        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Car car) {
        Node node=first;
        for(int i=0;i<size;i++){
            if(node.value.equals(car)){
                return removeAt(i);
            }
            node=node.next;
        }
        return false;
    }

    @Override
    public boolean removeAt(int idx) {
        Node node= getNode(idx);
        Node nodenext=node.next;
        Node nodeprevious=node.prev;
        if(nodenext!=null) {
            nodenext.prev = nodeprevious;
        } else {
            last=nodeprevious;
        }
        if(nodeprevious!=null) {
            nodeprevious.next = nodenext;
        } else {
            first = nodenext;
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first=null;
        last=null;
        size=0;

    }

    @Override
    public boolean add(Car car, int index) {
        if(index<0 || index>size){
            throw new IndexOutOfBoundsException();
        }
        if(index==size){
            return add(car);
        }
        Node nodeNext=getNode(index);
        Node nodePrev=nodeNext.prev;
        Node newNode=new Node(nodePrev,nodeNext,car);
        nodeNext.prev=newNode;
        if(nodePrev!=null) {
            nodePrev.next = newNode;
        } else{
            first=newNode;
        }
        size++;
        return true;
    }
    private static class Node{
        private Node prev;
        private Node next;
        private Car value;

        public Node(Node prev, Node next, Car value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }

    }
    private Node getNode(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        Node node=first;
        for (int i=0;i<index;i++){
            node=node.next;
        }
        return node;
    }

    @Override
    public boolean contains(Car car) {
        Node node=first;
        for(int i=0;i<size;i++){
            if(node.value.equals(car)){
                return true;
            }
            node=node.next;
        }
        return false;
    }
    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {
            private Node node = first;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public Car next() {
                Car car = node.value;
                node = node.next;
                return car;
            }
        };
    }
}
