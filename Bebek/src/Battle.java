import attack.*;
import defense.*;

import java.util.Random;

public class Battle {
    private int HP1,AP1,DP1,HP2,AP2,DP2,HP1k, HP2k, AP1k, AP2k, Crit1, Crit2, Rate1, Rate2, random;
    public Battle(int HP1, int AP1, int DP1, int Crit1, int Rate1, int HP2, int AP2, int DP2,  int Crit2, int Rate2){
        this.HP1= HP1;
        this.AP1 = AP1;
        this.DP1 = DP1;
            this.Crit1 = Crit1;
            this.Rate1 = Rate1;
        this.HP2 = HP2;
        this.AP2 = AP2;
        this.DP2 = DP2;
            this.Crit2 = Crit2;
            this.Rate2 = Rate2;
    }

    public int getAP1k() {
        if (random%Rate1==0){
            AP1k = Math.abs(AP1+AP1*Crit1/100-DP2/2);
        }
        else
            AP1k = Math.abs(AP1-DP2/2);
        return AP1k;
    }

    public int getAP2k() {
        if (random%Rate2==0)
            AP2k = Math.abs(AP2+AP2*Crit2/100-DP1/2);
        else
            AP2k = Math.abs(AP2-DP1/2);
        return AP2k;
    }

    public int getRandom() {
        return random;
    }

    public int getHP1k() {
        return HP1k;
    }
    public int getHP2k() {
        return HP2k;
    }

    public int battle(int i){
        Random rand = new Random();
        random = rand.nextInt(100);
        if (i%2==1){ //SERANGAN DARI BEBEK 1, BEBEK 2 DEFEND
            if(random%Rate1==0)
                HP2k = HP2-Math.abs(AP1+AP1*Crit1/100-DP2/2);
            else
                HP2k = HP2-Math.abs(AP1-DP2/2);
            if (HP2k < 0)
                HP2k = 0;
            return HP2k;
        }
        else{ //SERANGAN DARI BEBEK 2, BEBEK 1 DEFEND
            if (random%Rate2==0)
                HP1k = HP1-Math.abs(AP2+AP2*Crit2/100-DP1/2);
            else
                HP1k = HP1-Math.abs(AP2-DP1/2);
            if (HP1k < 0)
                HP1k = 0;
            return HP1k;
        }
    }
}
