import java.io.BufferedReader;
        import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter amount of factories");                    //asks the user for an amount of factories
            int factories = Integer.parseInt(br.readLine());                    //reads the users input and saves it to 'factories'
            System.out.println("Enter amount of quota");                        //asks the user for a quota amount
            int quotas = Integer.parseInt(br.readLine());                       //reads the users input and saves it to 'quotas'
            CentralWareHouse centralwarehouse = new CentralWareHouse(quotas);
            for (int i = 0; i < factories; i++) {
                ManufactoringSite site = new ManufactoringSite();
                centralwarehouse.AddSite(site);
            }
            centralwarehouse.StartManufactoring();
        } catch (Exception nfe) {
            System.err.println("Invalid Format!");
        }
    }
}
