package fly;

public class pesawatTerbang implements terbang{
    private int CritHit = 25;

    @Override
    public void fly() {
        System.out.println("Plane | Crit Hit : 25%");
    }

    @Override
    public int CritHit() {
        return CritHit;
    }
}
