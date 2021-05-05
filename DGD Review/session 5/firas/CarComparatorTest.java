import static org.junit.Assert.*;

public class CarComparatorTest {

    @org.junit.Test
    public void compareCars_Car1SmallerThanCar2_Success() {
        Car Car1 = new Car("brand1", "model1", 2020);
        Car Car2 = new Car("brand1", "model2", 2020);
        CarComparator CarComparator = new CarComparator();

        int result = CarComparator.compare(Car1,Car2);

        assertEquals(-1,result);
    }
}