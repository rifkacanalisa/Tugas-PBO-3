package attack;

public class senjataBazooka implements attackBehaviour {
    private int AP = 25;

    @Override
    public void attack() {
        System.out.println("Bazooka | AP : " + AP);
    }

    @Override
    public int AP() {
        return AP;
    }
}
