import java.util.Random;                                                                                            //Random class is used to generate pseudo random numbers in java

public class Regulator extends Thread {                                                                             //Feature which allows concurrent execution


boolean stop = false;                                                                                               //gives a value to an object

   private Gauge myGauge;                                                                                           //calls the method myGauge in Gauge.java

    public void setMyGauge(Gauge myGauge) {
        this.myGauge = myGauge;                                                                                     // references the object myGauge so it can be used in the program
    }

    private Boiler myBoiler;                                                                                        //calls the method myBoiler in Boiler.java

    public void setMyBoiler(Boiler myBoiler) {                                                                      //references the object myBoiler so it can be used in the program
        this.myBoiler = myBoiler;
    }

    @Override
    public void run (){                                                                                                  //method is called when a thread is created using a runnable run object.
        //picks a random amount of regulators (threads) between 1 and 6
        Random random = new Random();                                                                               //calls for the java utility random to be executed
        int number = random.nextInt(5) +1;                                                                  //gives a random number between 0 to 5 and then add +1 to it.


        while(stop == false){                                                                                       //control flow statement
        //checks if the boiler is gone past 100 PSI, and calculates
            double pressure = this.myGauge.getPressure()* 14.504 ;                                                  //checks myGauge, getPressure value and then multiplies it by 14.504, the value, 14.504 corresponds to 1 bar of pressure
            if (this.myBoiler.getPressure() >= 100){                                                                //if a condition happens in this case, if the pressure goes 100 or more it will do something
                System.out.println("Boiler exploded");                                                              //prints out a message to the user "Boiler exploded"
                break;                                                                                              //this breaks the application.
            }
            double PSI = 14.504;                                                                                    //giving the PSI a value
                                                             //prints a message to the screen

            try {                                                                                                   //tries a condition
                //checks the pressure of the boiler and either adds more pressure or takes it away depending on the value
                if (pressure >= 29.0075) {                                                                          //if pressure is 29.0075 or more it does something
                    this.myBoiler.increasePressure(15);                                                       //myBoiler increasePressure is called and adds a value of 15

                }else if (pressure > 0 && pressure < 29.0075){                                                      //if the earlier condition didnt trigger then this happens
                    this.myBoiler.decreasePressure(10);                                                       //decreases the value of myBoiler by 10
                }
                System.out.println("Bar " + pressure / PSI);                                                        //prints PSI to the screen with the value of pressure divided by the psi.
                Thread.sleep(number * 1000);                                                                  //put the thread to sleep

            }catch (InterruptedException e) {                                                                       //catches any errors and prints them to the screen
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;                                                                                              //stops the application
            }
        }
    }

    public void stopRegulator (){
        stop = true;
    }
}
