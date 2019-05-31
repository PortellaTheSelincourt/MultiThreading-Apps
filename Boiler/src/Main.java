import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        //calls all the objects needed
        Boiler PedBoiler = new Boiler();
        Gauge PedGauge = new Gauge();
        PedGauge.setMyBoiler(PedBoiler);

        List regulatorList = new ArrayList(); //sets an arrays list for the regulators

        for(int i = 0; i != 6; i++){ //makes sure that this value is never 0

            Regulator regulator1 = new Regulator();
            regulator1.setMyBoiler(PedBoiler);
            regulator1.setMyGauge(PedGauge);
            regulatorList.add(regulator1);
            regulator1.start();         //starts the threads
        }
        try {
            //allows the user to stop the application at anytime
             System.out.println("Press any key to close");
             int c = System.in.read();
            regulatorList.forEach((reg) ->{((Regulator)reg).stopRegulator();});
        } catch (IOException e) {
    e.printStackTrace();
}

    }
}
