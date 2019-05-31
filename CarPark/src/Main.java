import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        carParkManager manager = new carParkManager(50);    //sets a number of spaces

        List cars = new ArrayList();                //makes an array list for cars

        for(int i = 0; i != 200; i++){
            //starts the threads for the car.java method
            car car1 = new car(manager);
            car1.start();
        }
    }
}
