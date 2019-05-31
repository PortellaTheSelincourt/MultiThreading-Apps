import java.util.Random;

public class car extends Thread{
    carParkManager carpark;

    car(carParkManager c) {
        carpark = c;
    }

    @Override
    public void run (){

        Random random = new Random();
        int number = random.nextInt(5) +1;

        while(true){
            //lets the user know when a car has arrived or left and put the thread to sleep in between
            try {
                Thread.sleep(number * 1000);
                this.carpark.arrive();              //calls method arrive from carParkManager.java
                System.out.println("Car arrived");
                Thread.sleep(number * 1000);
                this.carpark.depart();              //calls method depart from carParkManager.java
                System.out.println("Car departed");
                break;

            }catch (InterruptedException e) {       // catches any errors and prints them out to the user
                e.printStackTrace();
            }
        }
    }



}

