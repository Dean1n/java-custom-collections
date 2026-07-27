public class Main {
    public static void main(String[] args) {
        Car car1= new Car("bmw",1);
        Car car2= new Car("bmw",1);
        System.out.println(car1.equals(car2));
        System.out.println((car1.hashCode()));
        System.out.println((car2.hashCode()));
    }
}
