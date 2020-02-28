import attack.*;
import defense.*;
import fly.*;
import Sound.*;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int[] terbang = new int[2];
        int[] suara = new int[2];
        int[] senjata = new int[2];
        int[] bertahan = new int[2];
        int[] HP = new int[2];
        int[] AP = new int[2];
        int[] DP = new int[2];
        int[] Crit = new int[2];
        int[] Rate = new int[2];
        String[] nama = new String[2];
        terbang[] fly = new terbang[2];
        soundBehavior[] sound = new soundBehavior[2];
        attackBehaviour[] weapon = new attackBehaviour[2];
        defenseBehaviour[] gear = new defenseBehaviour[2];
        Scanner input = new Scanner(System.in);

        for (int i=0; i<2; i++) {
            System.out.println("    DUCK");
            System.out.print(" Duck "+ (i+1) +" name : ");
            nama[i] = input.nextLine();
            System.out.print(" HP : ");
            HP[i] = input.nextInt();
            System.out.print("   Fly Options : 1. Wings | 2. Plane | 3. Rocket | Choose : ");
            terbang[i] = input.nextInt();
            System.out.print("   Sound Options : 1. Normal | 2. Louadspeaker | Choose : ");
            suara[i] = input.nextInt();
            System.out.print("   Weapon Options : 1. Sword | 2. Crossbow | 3. Bazooka | Choose : ");
            senjata[i] = input.nextInt();
            System.out.print("   Gear Options : 1. Shield | 2. Heavy Armor | Choose : ");
            bertahan[i] = input.nextInt();
            input.nextLine();

            if (HP[i] > 250 || HP[i] < 100) {
                System.out.println(" HP too much/less...");
                System.out.println(" Automatic HP = 175");
                HP[i] = 175;
            }

            if (terbang[i] == 1) {
                fly[i] = new sayapTerbang();
            } else if (terbang[i] == 2) {
                fly[i] = new pesawatTerbang();
            } else if (terbang[i] == 3) {
                fly[i] = new roketTerbang();
            } else {
                System.out.println(" Fly option not available...");
                System.out.println(" Automatic fly option 1");
                fly[i] = new sayapTerbang();
            }

            if (suara[i] == 1) {
                sound[i] = new suaraNormal();
            } else if (suara[i] == 2) {
                sound[i] = new suaraToa();
            } else {
                System.out.println(" Sound option not available...");
                System.out.println(" Automatic sound option 1");
                sound[i] = new suaraNormal();
            }

            if (senjata[i] == 1) {
                weapon[i] = new senjataPedang();
            } else if (senjata[i] == 2) {
                weapon[i] = new senjataPanahan();
            } else if (senjata[i] == 3) {
                weapon[i] = new senjataBazooka();
            } else {
                System.out.println(" Weapon option not available...");
                System.out.println(" Automatic weapon option 1");
                weapon[i] = new senjataPedang();
            }

            if (bertahan[i] == 1) {
                gear[i] = new bertahanPerisai();
            } else if (bertahan[i] == 2) {
                gear[i] = new bertahanBajuZirah();
            } else {
                System.out.println(" Gear option not available...");
                System.out.println(" Automatic gear option 1");
                gear[i] = new bertahanPerisai();
            }
            System.out.println();
        }
        Duck[] bebek = new Duck[4]; //Harus lebih untuk exception
        Duck bebeknya = bebek[2];
        for (int i=0; i<2; i++){
            bebek[i] =new Duck(fly[i], sound[i], HP[i], weapon[i], gear[i]);
            System.out.println();
            System.out.println(nama[i] + " Duck Behaviour : ");
            System.out.println(" HP : " + bebek[i].getHP());
            System.out.print(" Weapons : ");
            bebek[i].fly();
            Crit[i] = bebek[i].getCritHit();
            System.out.print(" Sound : ");
            bebek[i].sound();
            Rate[i] = bebek[i].getCritHitRate();
            System.out.print(" Weapon : ");
            bebek[i].attack();
            AP[i] = bebek[i].getAP();
            System.out.print(" Gear : ");
            bebek[i].defense();
            DP[i] = bebek[i].getDP();

            try {
                Thread.sleep(2000); // 2 second
            } catch (InterruptedException ex) {
                // handle error
            }
        }
        try {
            System.out.println();
            System.out.println("Preparing BATTLE...");
            Thread.sleep(5000); // 5 second
        } catch (InterruptedException ex) {
            // handle error
        }

        System.out.println("\n    BATTLE START");
        int i=1;
        do {
            Battle petarung = new Battle(HP[0],AP[0],DP[0],Crit[0],Rate[0],HP[1],AP[1],DP[1],Crit[1],Rate[1]);
            System.out.println();
            System.out.println("    Round-"+i);
            if (i%2==1){
                petarung.battle(i);
                System.out.println(" LEFT SIDE TURN");
                System.out.println(" Duck " + nama[0] + " attack " + "\t Attack Power Original: " + (AP[0]-DP[1]/2) );
                HP[1] = petarung.getHP2k();
                if(petarung.getRandom()%Rate[0]==0)
                    System.out.println("\tHP " + nama[0] + "\t: " + HP[0] + "\tCrit Hit : " + Crit[0]+"%");
                else
                    System.out.println("\tHP " + nama[0] + "\t: " + HP[0]);
                System.out.println("\tHP " + nama[1] + "\t: " + HP[1] + "\t(-" + petarung.getAP1k()+")");
            }
            else {
                petarung.battle(i);
                System.out.println(" RIGHT SIDE TURN");
                System.out.println(" Duck " + nama[1] + " attack " + "\t Attack Power Original : " + (AP[1]-DP[0]/2));
                HP[0] = petarung.getHP1k();
                System.out.println("\tHP " + nama[0] + "\t: " + HP[0] + "\t(-" + petarung.getAP2k()+")");
                if(petarung.getRandom()%Rate[1]==0)
                    System.out.println("\tHP " + nama[1] + "\t: " + HP[1] + "\tCrit Hit : "+Crit[1]+"%");
                else
                    System.out.println("\tHP " + nama[1] + "\t: " + HP[1]);
            }
            i++;
            if (HP[0] > 0 && HP[1] > 0){
                try {
                    System.out.println();
                    System.out.println("Preparing NEXT ROUND...");
                    Thread.sleep(2000); // 2 second
                } catch (InterruptedException ex) {
                    // handle error
                }
            }
        } while (HP[0] > 0 && HP[1] > 0);
        System.out.println("\n\t\t\tEND BATTLE");
        if(HP[0]==0)
            System.out.println("\t\tDUCK WINNER : " + nama[1]);
        else
            System.out.println("\t\tDUCK WINNER : " + nama[0]);
    }
}
