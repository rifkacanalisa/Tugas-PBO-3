package defense;

public class bertahanPerisai implements defenseBehaviour {
    private int DP = 12;

    @Override
    public void defense() {
        System.out.println("Shield | DP : " + DP);
    }

    @Override
    public int DP() {
        return DP;
    }
}
