public class Cafe extends Building implements CafeRequirements{
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    
    /**
     * Constructs a Cafe with specified attributes and initial inventory
     * @param name Name of the cafe
     * @param address Physical address of the cafe
     * @param nFloors Number of floors in the cafe
     * @param nCoffeeOunces Initial ounces of coffee in inventory
     * @param nSugarPackets Initial number of sugar packets in inventory
     * @param nCreams Initial number of cream splashes in inventory
     * @param nCups Initial number of cups in inventory
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nSugarPackets = nSugarPackets;
        this.nCoffeeOunces = nCoffeeOunces;
        this.nCreams = nCreams;
        this.nCups = nCups;

        System.out.println("You have built a cafe: ☕");
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


    public static void main(String[] args) {
        Cafe compassCafe = new Cafe("Compass Cafe", "7 Neilson Drive", 1, 10, 5, 5, 3);
        
        compassCafe.sellCoffee(12, 3, 2);
        compassCafe.sellCoffee(12, 3, 2);
        compassCafe.sellCoffee(5, 2, 1);
    }
    
}
