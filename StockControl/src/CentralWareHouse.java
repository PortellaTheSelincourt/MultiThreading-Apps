import java.util.ArrayList;
import java.util.List;

public class CentralWareHouse {
    private int quota;
    private List < ManufactoringSite > sites;                       //makes an array list
    CentralWareHouse (int quota){
        this.sites = new ArrayList<ManufactoringSite>();
        this.quota = quota;
    }
    public void AddSite(ManufactoringSite site){
        this.sites.add(site);
    }
    public void StartManufactoring(){
        //this section does the calculation for the quota versus sites and deals with the problem of broken numbers
        int itemsToBeMade = quota;
        int widgeCount = (int) Math.floor(quota / sites.size());    // divides the quota by the number of sites and rounds it down
        if (widgeCount != Math.round(widgeCount)) {
            System.out.println("Integer");
        }
        for (int i = 0; i != sites.size(); i ++){

            //this part it works out if there is any widget left to be produced by the factories, if there is not the program finishes
            sites.get(i).setQuota(widgeCount);
            itemsToBeMade = itemsToBeMade - widgeCount;
            if (itemsToBeMade == 0)break;
        }
        // if there is any 'broken' number left it is then added to 1 factory or more depending how much is left over and runs the program
        if (itemsToBeMade > 0){
            sites.get(0).setQuota(widgeCount + itemsToBeMade);
        }
        sites.forEach(site -> {
            site.start();
        });
    }
}
