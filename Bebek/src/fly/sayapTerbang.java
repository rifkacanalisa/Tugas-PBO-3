package fly;

public class sayapTerbang implements terbang{
    private int CritHit = 15;

    @Override
    public void fly() {
        System.out.println("Wings | Crit Hit : 15%");
    }

    @Override
    public int CritHit() {
        return CritHit;
    }
}
