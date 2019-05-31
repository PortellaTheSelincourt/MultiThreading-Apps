public class carParkManager {
    //set int values
     int spaces;
     int capacity;
     int numberOfCarsSeen = 0;

    carParkManager(int n) {
        capacity = spaces = n;
    }

    synchronized void arrive() throws InterruptedException {
        //synchronizes threads to work out spaces to cars arriving
        while (spaces==0) wait();
        --spaces;
        ++numberOfCarsSeen;
        System.out.println("Current amount of spaces: " + spaces+ " of " + capacity + " Cars seen " + numberOfCarsSeen);
        notifyAll();  //wakes up all threads related to this method
    }

    synchronized void depart() throws InterruptedException{
        //synchronizes threads to work out spaces to cars departing
        while (spaces==capacity) wait();
        ++spaces;
        System.out.println("Current amount of spaces: " + spaces+ " of " + capacity + " Cars seen " + numberOfCarsSeen);
        notifyAll();//wakes up all threads related to this method
    }
}
