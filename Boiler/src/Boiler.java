public class Boiler {
   private int pressure = 0;                                                        //sets pressure as an int

    public int getPressure() {   //calls method getPressure, from gauge.java
        return pressure;
    }

    public synchronized void increasePressure(int value) throws Exception {         //synchronizes threads (regulators)
        //must lock the boiler so only one thread can change at each given time
        //it also tells the user when the boiler overheats.
        pressure = pressure + value;
        System.out.println("Increase Boiler PSI: " + pressure);
        if(pressure >= 100) throw new Exception("Boiler overheated");


    }
    public synchronized void decreasePressure(int value){                           //synchronizes threads (regulators)
        //must lock the boiler so only one thread can change at each given time
        pressure = pressure - value;
        System.out.println("Decrease Boiler PSI: " + pressure);                     //tells the user that the boiler decreased the pressure
    }
}
