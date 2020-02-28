package attack;

public class senjataPedang implements attackBehaviour {
    private int AP = 14;
    @Override
    public void attack() {
        System.out.println("Sword | AP : " + AP);
    }

    @Override
    public int AP() {
        return AP;
    }
}
