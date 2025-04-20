public class Cafe extends Building implements CafeRequirements{
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    private boolean hasElevator;

    
    /**
     * Full constructor
     * Constructs a Cafe with specified attributes and initial inventory
     * @param name Name of the cafe
     * @param address Physical address of the cafe
     * @param nFloors Number of floors in the cafe
     * @param nCoffeeOunces Initial ounces of coffee in inventory
     * @param nSugarPackets Initial number of sugar packets in inventory
     * @param nCreams Initial number of cream splashes in inventory
     * @param nCups Initial number of cups in inventory
     * @param hasElevator Whether cafe has an elevator
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups, boolean hasElevator) {
        super(name, address, nFloors);
        this.nSugarPackets = nSugarPackets;
        this.nCoffeeOunces = nCoffeeOunces;
        this.nCreams = nCreams;
        this.nCups = nCups;
        this.hasElevator = hasElevator;

        System.out.println("You have built a cafe: ☕");
    }
    
    /* Overloaded constructor with name, address */
    public Cafe(String name, String address) {
        this(name, address, 1, 30, 10, 10, 10, true); // Call full constructor with elevator and hard-coded # floors, coffee, sugar packets, cream splashes, and cups
    }

    /* Overloaded constructor with name */
    public Cafe(String name) {
        this(name, "<Address Unknown>", 1, 30, 10, 10, 10, true); // Call full constructor with default value for address and elevator and hard-coded # floors, coffee, sugar packets, cream splashes, and cups
    }

    /**
     * Sells coffee and updates inventory
     * @param size Ounces of coffee per sale
     * @param nSugarPackets Sugar packets used per sale
     * @param nCreams Cream splashes used per sale
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        while (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups < 1){
            restock(size, nSugarPackets, nCreams, 1);
            System.out.println("Restocked ingredients to complete order!");
        }

        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Coffee sold! Remaining stock: \nnCoffeeOunces: " + this.nCoffeeOunces + "\nnSugarPackets: " + this.nSugarPackets + "\nnCreams: " + this.nCreams + "\nnCups: " + this.nCups);
    }

    /**
     * Restocks inventory items
     * @param nCoffeeOunces Ounces of coffee to add
     * @param nSugarPackets Sugar packets to add
     * @param nCreams Cream splashes to add
     * @param nCups Cups to add
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    } 

    public void goToFloor(int floorNum) {
        //prevent player from going to any floor other than 1
        if (this.activeFloor != -1 && floorNum != 1) {
            throw new RuntimeException("Customers cannot access floor #" + floorNum + ". Only employees may go to other floors.");
        }
        super.goToFloor(floorNum);
    }

    public void showOptions(){
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + sellCoffee(size, sugars, creams)");
    }

    public static void main(String[] args) {
        Cafe compassCafe = new Cafe("Compass Cafe", "7 Neilson Drive", 2, 10, 5, 5, 3, true);
        
        compassCafe.showOptions();
        compassCafe.enter();

        compassCafe.sellCoffee(12, 3, 2);
        compassCafe.sellCoffee(12, 3, 2);
        compassCafe.sellCoffee(5, 2, 1);
        compassCafe.goUp();
        compassCafe.goToFloor(2);
        compassCafe.exit();
    }
    
}
