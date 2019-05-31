public class ManufactoringSite extends Thread {
    private int quota = 0;
    private int widgetsMade = 0;

    @Override
    public void run() {                                 //method is called when a thread is created
        while (getWidgetsMade() < quota){               // as long as widgetsMade is less then quota then it will do the bellow
          try {
              setWidgetsMade(getWidgetsMade() + 1);     //get the amount of widgets made and add 1 to it
              Thread.sleep(25);                    //set the thread to sleep
          }catch (Exception e){                         // catches any errors
              e.printStackTrace();
          }
        }
        System.out.println("Widgets made: " + widgetsMade); // prints out the actual amount of widgets made
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public int getWidgetsMade() {
        return widgetsMade;
    }

    private void setWidgetsMade(int widgetsMade) {
        this.widgetsMade = widgetsMade;
    }
}
