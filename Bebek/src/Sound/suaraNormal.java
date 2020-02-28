package Sound;

public class suaraNormal implements soundBehavior {
    private int Rate = 20; //Rate 5%

    @Override
    public void sound() {
        System.out.println("Normal | Critical Hit Rate : 5%");
    }

    @Override
    public int CritHitRate() {
        return Rate;
    }
}
