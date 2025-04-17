/* This is a stub for the House class */
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class House extends Building implements HouseRequirements{
  protected ArrayList<Student> residents; // The <Student> tells Java what kind of data we plan to store IN the ArrayList
  protected boolean hasDiningRoom;
  
  /**
   * Constructs a House with specified attributes
   * @param name Name of the house
   * @param address Physical address of the house
   * @param nFloors Number of floors in the house
   * @param hasDiningRoom Whether the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors); //call superclass constructor with name, address, and nFloors parameters
    this.residents = new ArrayList<Student>(); //initialize ArrayList residents
    this.hasDiningRoom = hasDiningRoom; //initalize new parameter hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Indicates whether the house has a dining room
   * @return True if the house has a dining room, false otherwise
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }
  
  /**
   * Counts the number of residents in the house
   * @return The total number of residents
   */
  public int nResidents(){
    int nResidents = this.residents.size(); 
    return nResidents;
  }

  /**
   * Adds a student to the house's residents
   * @param s The student to move in
   * @throws NoSuchElementException If the student is already a resident
   */
  public void moveIn(Student s){ //go through list and ensure student isn't in there and if true then add student
    for (Student resident : this.residents) {
      if (resident.equals(s)) {
        throw new NoSuchElementException("Student " + s + " is already in the house.");
      }
    }
    this.residents.add(s);
    System.out.println("Student " + s + " has moved into the house.");
  }

  /**
   * Removes a student from the house's residents
   * @param s The student to move out
   * @return The removed student
   * @throws NoSuchElementException If the student is not a resident
   */
  public Student moveOut(Student s) {
    for (int i = 0; i < this.residents.size(); i++) {
        Student resident = this.residents.get(i);
        if (resident.equals(s)) {
            Student removedStudent = this.residents.remove(i); 
            System.out.println("Student " + removedStudent + " has moved out.");
            return removedStudent;
        }
    }
    throw new NoSuchElementException("Student " + s + " does not live in the house."); //throws exception if not found
  }

  /**
   * Checks if a student is a resident
   * @param s The student to check
   * @return True if the student is a resident, false otherwise
   */
  public boolean isResident(Student s){
    for (Student resident: this.residents){
      if (resident.equals(s)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    House gillett = new House("Gillett", "Elm St", 5, true);
    System.out.println(gillett);

    Student jenica = new Student("Jenica", "9901wee", 2028);
    Student sharon = new Student("Sharon", "9902bcd", 2027);

    try {
        // Move students in
        gillett.moveIn(jenica);
        gillett.moveIn(sharon);
        System.out.println("Residents: " + gillett.nResidents());

        // Try moving Jenica in again (will throw an error)
        gillett.moveIn(jenica);
    } catch (NoSuchElementException e) {
        System.err.println(e.getMessage()); // Print error message
    }

    // Move Jenica out
    Student removed = gillett.moveOut(jenica);
        System.out.println("Removed: " + removed);
        System.out.println("Residents left: " + gillett.nResidents());
  }
}