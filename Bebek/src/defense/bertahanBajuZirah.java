package defense;

public class bertahanBajuZirah implements defenseBehaviour {
    private int DP = 16;

    @Override
    public void defense() {
        System.out.println("Armor | DP : " + DP);
    }

    @Override
    public int DP() {
        return DP;
    }
}
