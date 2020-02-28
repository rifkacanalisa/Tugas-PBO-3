package Sound;

public class suaraToa implements soundBehavior {
    private int Rate = 12; //Rate = 8.3%

    @Override
    public void sound() {
        System.out.println("Toa | Critical Hit Rate : 8.3%");
    }

    @Override
    public int CritHitRate() {
        return Rate;
    }
}
