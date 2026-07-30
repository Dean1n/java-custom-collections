import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarCollectionTest {
    private CarCollection carCollection;
    @BeforeEach
    void setUp() {
        carCollection=new CarArrayList();
        for (int i=0;i<100;i++){
            carCollection.add(new Car("Brand"+i,i));
        }
    }

    @Test
    void contains() {
        assertTrue(carCollection.contains(new Car("Brand20",20)));
        assertFalse(carCollection.contains(new Car("Brand200",200)));
    }
}