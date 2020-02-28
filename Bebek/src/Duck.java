import fly.*;
import Sound.*;
import attack.*;
import defense.*;

public class Duck {
    private terbang terbangnya;
    private soundBehavior suaranya;
    private attackBehaviour senjatanya;
    private defenseBehaviour pertahanannya;
    private int HP;
    private int DP, AP;
    private int CritHit, CritHitRate;

    public Duck(terbang terbangnya, soundBehavior suaranya, int HP, attackBehaviour senjatanya,
                defenseBehaviour pertahanannya){
        this.terbangnya = terbangnya;
        this.suaranya = suaranya;
        this.HP = HP;
        this.senjatanya = senjatanya;
        this.pertahanannya = pertahanannya;
    }

    public void setTerbangnya(terbang terbangnya) {
        this.terbangnya = terbangnya;
    }

    public void setSuaranya(soundBehavior suaranya) {
        this.suaranya = suaranya;
    }

    public void setSenjatanya(attackBehaviour senjatanya) {
        this.senjatanya = senjatanya;
    }

    public void setPertahanannya(defenseBehaviour pertahanannya) {
        this.pertahanannya = pertahanannya;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getHP() {
        return HP;
    }

    public void fly(){
        terbangnya.fly();
        this.CritHit = terbangnya.CritHit();
    }

    public void sound(){
        suaranya.sound();
        this.CritHitRate = suaranya.CritHitRate();
    }

    public void attack(){
        senjatanya.attack();
        this.AP =  senjatanya.AP();
    }

    public void defense(){
        pertahanannya.defense();
        this.DP = pertahanannya.DP();
    }

    public int getAP() {
        return AP;
    }

    public int getDP() {
        return DP;
    }

    public int getCritHit() {
        return CritHit;
    }

    public int getCritHitRate() {
        return CritHitRate;
    }
}
