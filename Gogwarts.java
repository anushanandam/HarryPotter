//I worked on the homework assignment alone, using only course materials.

/**
 *This class represents Gogwarts class which is an abstract parent class.
 *@author Anusha Nandam
 *@version 1.0
 */

public abstract class Gogwarts {
    private String name;
    private int magicLevel;
    private int health;

    /**
     *Constructor that takes name, magic level, and health
     *@param name student's name
     *@param magicLevel student's magic level
     *@param health student's health
     */

    public Gogwarts(String name, int magicLevel, int health) {
        this.name = name;
        this.magicLevel = magicLevel;
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    /**
     *getter for name so it can be accessed in the child classes
     *@return name
     */

    public String getName() {
        return name;
    }

    /**
     *getter for magic level so it can be accessed in the child classes
     *@return magic level
     */

    public int getMagicLevel() {
        return magicLevel;
    }

    /**
     *setter for magic level so it can be adjusted in the child classes
     *@param magicLevel student's magic level
     */

    public void setMagicLevel(int magicLevel) {
        this.magicLevel = magicLevel;
    }

    /**
     *getter for health so it can be accessed in the child classes
     *@return health
     */

    public int getHealth() {
        return health;
    }

    /**
     *setter for health so it can be adjusted in the child classes
     *@param health student's health
     */

    public void setHealth(int health) {
        this.health = health;
    }

    /**
     *This method challenges another Gogwarts student to battle.
     *@param g target student
     */

    public abstract void duel(Gogwarts g);

    /**
     *Increases health by 15 points
     */


    public void potion() {
        health += 15;
    }

    /**
     *@param o checks equality of 2 Gogwarts students based on name, magic level, and health
     *@return equality of 2 Gogwarts students
     */

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Gogwarts)) {
            return false;
        }
        Gogwarts students = (Gogwarts) o;
        return ((students.name.equals(name)) && (students.magicLevel == magicLevel)
            && (students.health == health));

    }

    /**
     *@return String that describes the Gogwarts student
     */

    public String toString() {
        return "My name is " + name + ", and I am a student at Gogwarts. My magic level is "
            + magicLevel + " and my current health is " + health + ". ";
    }
}