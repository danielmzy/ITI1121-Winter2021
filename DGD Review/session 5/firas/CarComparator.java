import java.util.Comparator;

public class CarComparator implements Comparator<Car> {
    public int compare(Car firstCar, Car lastCar){
        if(firstCar.getBrand().compareTo(lastCar.getBrand()) > 0){
            return 1;
        } else if(firstCar.getBrand().compareTo(lastCar.getBrand()) < 0){
            return -1;
        } else {
            if(firstCar.getModel().compareTo(lastCar.getModel()) > 0){
                return 1;
            } else if(firstCar.getModel().compareTo(lastCar.getModel()) < 0){
                return -1;
            } else {
                if(firstCar.getYear() > (lastCar.getYear())){
                    return 1;
                } else if(firstCar.getYear() < (lastCar.getYear())){
                    return -1;
                }
            }
        }
        return 0;
    }
}