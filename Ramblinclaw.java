//I worked on the homework assignment alone, using only course materials.
//import java.util.Random;

/**
 *This class represents Ramblinclaw class which is a child class of Gogwarts.
 *@author Anusha Nandam
 *@version 1.0
 */

public class Ramblinclaw extends Gogwarts {

    private int knowledgeLevel;
    private static int ramblinPoints;
    public static final int DEFAULT_MAGICLEVEL = 30;
    public static final int DEFAULT_HEALTH = 20;
    public static final int DEFAULT_KNOWLEDGELEVEL = 30;

    /**
     *Constructor that takes in name and assigns magic level, health, and knowledge level default values
     *@param initName name of a Ramblinclaw student
     */

    public Ramblinclaw(String initName) {
        this(initName, DEFAULT_MAGICLEVEL, DEFAULT_HEALTH, DEFAULT_KNOWLEDGELEVEL);
    }

    /**
     *Constructor that takes name, magic level, health, and knowledge level
     *Information about name, magic level, and health is from super class
     *@param name student's name
     *@param magicLevel student's magic level
     *@param health student's health
     *@param knowledgeLevel student's knowledge level
     */

    public Ramblinclaw(String name, int magicLevel, int health, int knowledgeLevel) {
        super(name, magicLevel, health);
        //super(magicLevel);
        //super(health);
        this.knowledgeLevel = knowledgeLevel;
    }

   /**
    *@return knowledge level
    */

    public int getKnowledgeLevel() {
        return knowledgeLevel;
    }

    /**
     *@return ramblinPoints
     */

    public static int getRamblinPoints() {
        return ramblinPoints;
    }

    /**
     *This method overrides the duel() method in Gogwarts
     *@param g target student
     */

    public void duel(Gogwarts g) {
        if (g instanceof Ramblinclaw) {
            System.out.println("Cannot duel an ally!");
            return;
        }
        if ((this.getHealth() == 0) || (g.getHealth() == 0)) {
            return;
        }

        if (knowledgeLevel > 13) {
            int number = (int) (Math.random() * 11 + 1);
            if (number == 5 || number == 7) {
                brainFreeze();
            }
        }

        g.setHealth(g.getHealth() - 15 + this.getMagicLevel() / 2);
        if (g.getHealth() <= 0) {
            g.setHealth(0);
            ramblinPoints += g.getMagicLevel() / 2;
        }

    }

    /**
     *If the Ramblinclaw's health is more than 20, they can play quidditch.
     *20 ramblinPoints are added if knowledge level is greater or equal to 30 and 10 points if level less than 30
     */
    public void quidditch() {
        if (getHealth() > 20) {
            if (knowledgeLevel >= 30) {
                ramblinPoints += 20;
            } else {
                ramblinPoints += 10;
            }
            System.out.println("We won the quidditch match, yay!");
        }
        return;
    }

    /**
     *Magic level is increased by the current knowledge level.
     *When this method is called, knowledge level should be decreased by 15, and should never go below 0.
     */

    public void brainFreeze() {
        setMagicLevel(getMagicLevel() + knowledgeLevel);
        knowledgeLevel -= 15;
        if (knowledgeLevel < 0) {
            knowledgeLevel = 0;
        }
    }

    /**
     *overrides the Gogwart's equals() method
     *@param o checks equality of 2 Ramblinclaw students based on name, magic level, health, and knowledge level
     *uses the super class to get the name. magic level, and health
     *@return equality of 2 Ramblinclaw students
     */

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Ramblinclaw)) {
            return false;
        }
        Ramblinclaw students = (Ramblinclaw) o;
        return (super.equals(o) && (students.knowledgeLevel == knowledgeLevel));


    }
    /**
     *@return String that describes the Ramblinclaw student
     */

    public String toString() {
        return super.toString() + "I am a Ramblinclaw, and I have " + knowledgeLevel + " knowledge.";
    }
}