//I worked on the homework assignment alone, using only course materials.

public class HouseCup {
    public static void main(String[] args) {
        Buzzlepuff b1 = new Buzzlepuff("Edward Cullen", 101, 50, false);
        Buzzlepuff b2 = new Buzzlepuff("Dedric Ciggory");
        Ramblinclaw r1 = new Ramblinclaw("Stan Loona", 16, 12, 45);
        Ramblinclaw r2 = new Ramblinclaw("Cho Cheng");
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(r2.toString());
        System.out.println(r1.toString());
        b1.duel(r2);
        r1.brainFreeze();
        r1.quidditch();
        b1.potion();
        b2.swarm();
        b2.duel(r1);
        b2.herbology();
        System.out.println(b1.toString());
        System.out.println(b2.toString());
        System.out.println(r2.toString());
        System.out.println(r1.toString());
        String winner = "";
        if (Buzzlepuff.getBuzzlePoints() > Ramblinclaw.getRamblinPoints()) {
            winner = "Buzzlepuff";
        } else {
            winner = "Ramblinclaw";
        }
        System.out.println("Buzzlepuff has " + Buzzlepuff.getBuzzlePoints() + ", and Ramblinclaw has " +
            Ramblinclaw.getRamblinPoints() + ", which makes " + winner + " the winner of this year's House Cup!");


    }
}