//I worked on the homework assignment alone, using only course materials.

/**
 *This class represents Buzzlepuff class which is a child class of Gogwarts.
 *@author Anusha Nandam
 *@version 1.0
 */

public class Buzzlepuff extends Gogwarts {


    private boolean pet;
    private static int buzzlePoints;

    private static int swarmSize = 0;
    public static final int DEFAULT_MAGICLEVEL = 15;
    public static final int DEFAULT_HEALTH = 30;
    public static final boolean DEFAULT_PET = true;

    /**
     *Constructor that takes in name and assigns magic level, health, and pet default values
     *@param initName name of a Buzzlepuff student
     */

    public Buzzlepuff(String initName) {
        this(initName, DEFAULT_MAGICLEVEL, DEFAULT_HEALTH, DEFAULT_PET);
    }

    /**
     *Constructor that takes name, magic level, health, and pet
     *Information about name, magic level, and health is from super class
     *@param name student's name
     *@param magicLevel student's magic level
     *@param health student's health
     *@param pet whether student has a pet or not
     */

    public Buzzlepuff(String name, int magicLevel, int health, boolean pet) {
        super(name, magicLevel, health);
        this.pet = pet;
        swarmSize++;
    }
    /**
    *@return swarm size
    */
    public static int getSwarmSize() {
        return swarmSize;
    }
     /**
    *@return if student has a pet
    */
    public boolean getPet() {
        return pet;
    }

     /**
     *@return buzzlePoints
     */
    public static int getBuzzlePoints() {
        return buzzlePoints;
    }

    /**
     *This method overrides the duel() method in Gogwarts
     *@param g target student
     */

    public void duel(Gogwarts g) {
        if (g instanceof Buzzlepuff) {
            System.out.println("Cannot duel an ally!");
            return;
        }
        if ((this.getHealth() == 0) || (g.getHealth() == 0)) {
            return;
        }

        g.setHealth(g.getHealth() - (2 * this.getMagicLevel()));
        if (g.getHealth() <= 0) {
            g.setHealth(0);
            buzzlePoints += g.getMagicLevel() / 2;
        }
    }

    /**
     *This method adds 15 points to buzzlePoints if their magic level is greater than or equal to 20.
     *If the magic level is less than 20, only 5 points get added.
     */

    public void herbology() {
        if (getMagicLevel() >= 20) {
            buzzlePoints += 15;
        } else {
            buzzlePoints += 5;
        }
        System.out.println("Yay, I got an A in herbology, go plants!");
    }

    /**
     *For every Buzzlepuff ally, the magic level of the Buzzlepuff is increased by 10%.
     *The magic level should be rounded down to the nearest integer.
     */

    public void swarm() {
        int magicLevel2 = (int) (((swarmSize - 1) * 0.1) * getMagicLevel());
        setMagicLevel(getMagicLevel() + magicLevel2);
    }

    /**
     *overrides the Gogwart's equals() method
     *@param o checks equality of 2 Buzzlepuff students based on name, magic level, health, and pet
     *uses the super class to get the name. magic level, and health
     *@return equality of 2 Buzzlepuff students
     */

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Buzzlepuff)) {
            return false;
        }
        Buzzlepuff students = (Buzzlepuff) o;
        return (super.equals(o) && (students.pet == pet));

    }

    /**
     *@return String that describes the Buzzlepuff student
     */

    public String toString() {
        String havePet = "have";
        if (!pet) {
            havePet = "do not have";
        }
        return super.toString() + "I am a Buzzlepuff, and I " + havePet + " a pet.";
    }
}