package fly;

public class roketTerbang implements terbang{
    private int CritHit = 45;

    @Override
    public void fly() {
        System.out.println("Rocket | Critical Hit : 45%");
    }

    @Override
    public int CritHit() {
        return CritHit;
    }
}
