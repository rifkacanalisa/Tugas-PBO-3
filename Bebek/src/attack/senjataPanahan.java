package attack;

public class senjataPanahan implements attackBehaviour {
    private int AP = 20;

    @Override
    public void attack() {
        System.out.println("Crossbow | AP : " + AP);
    }

    @Override
    public int AP() {
        return AP;
    }
}
