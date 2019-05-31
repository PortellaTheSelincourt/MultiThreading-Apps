import java.util.Random;

public class Gauge {                                                                        //name of the class
    private Boiler myBoiler;                                                                //gives an object a name


    public void setMyBoiler(Boiler myBoiler) {
        this.myBoiler = myBoiler;
    }                   //calls the object boiler

    public int getPressure(){                                                               //calls getPressure
       Random random = new Random();                                                        // randomize it
       int number = random.nextInt(5)+1;                                            //gives a random number between 0 to 5 and then add +1 to it.
        return number;                                                                      // returns the number
    }

}
