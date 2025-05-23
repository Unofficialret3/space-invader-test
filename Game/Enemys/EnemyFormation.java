package Game.Enemys;

import Game.Tim_der_Furry_Slayer_VERYHD_69FPS_EXTREME_2_OPENALPHA_V4_20;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public abstract class EnemyFormation {

    //spawn patterns
    private static final int[][] spawnPattern1 = {
            { 1,0,0}, // linke spalte
            { 1, 1,1 } , // mitte
            { 1,0,0 }// rechte spalte
    };
    private static final int[][] spawnPattern2 = {
            { 0,1,0}, // linke spalte
            { 1, 0,1 } , // mitte
            { 0,1,0 }// rechte spalte
    };
    private static final int[][] spawnPattern3 = {
            { 1,1,1}, // linke spalte
            { 1, 1,1 } , // mitte
            { 1,1,1 }// rechte spalte
    };
    protected static int[][] spawnPatternArrow = {
            { 0, 0, 1, 0, 0 },
            { 0, 1, 1, 1, 0 },
            { 1, 1, 1, 1, 1 }
    };
    protected static int[][] spawnPatternShield = {
            { 1, 1, 0, 1, 1 },
            { 1, 0, 0, 0, 1 },
            { 1, 1, 1, 1, 1 }
    };
    protected static int[][] spawnPatternStaggered = {
            { 1, 0, 1, 0, 1 },
            { 0, 1, 0, 1, 0 },
            { 1, 0, 1, 0, 1 },
            { 0, 1, 0, 1, 0 }
    };
    protected static int[][] spawnPatternCross = {
            { 0, 0, 1, 0, 0 },
            { 0, 0, 1, 0, 0 },
            { 1, 1, 1, 1, 1 },
            { 0, 0, 1, 0, 0 },
            { 0, 0, 1, 0, 0 }
    };
    protected static int[][] spawnPatternDiamond = {
            { 0, 0, 1, 0, 0 },
            { 0, 1, 0, 1, 0 },
            { 1, 0, 0, 0, 1 },
            { 0, 1, 0, 1, 0 },
            { 0, 0, 1, 0, 0 }
    };
    protected static int[][] spawnPatternChaos = {
            { 1, 0, 1, 1, 0, 1 },
            { 0, 1, 0, 0, 1, 0 },
            { 1, 1, 0, 1, 1, 0 },
            { 0, 0, 1, 0, 0, 1 }
    };
    protected static int[][] spawnPatternDNA = {
            { 1, 0, 0, 0, 1 },
            { 0, 1, 0, 1, 0 },
            { 0, 0, 1, 0, 0 },
            { 0, 1, 0, 1, 0 },
            { 1, 0, 0, 0, 1 }
    };


    //Spawn Logic
    protected static void spawnEnemies(ArrayList<Enemy> e ,int waveCount, BufferedImage texture1, BufferedImage texture2) {

        //spawnpattern choosing
        Random rand = new Random();

        int choice;
        if(waveCount==0){ choice = 0;}
        else if (waveCount <=3){choice= rand.nextInt(2);} // ergibt 0-3
        else {choice= rand.nextInt(10);} // ergibt 0-9

        int[][] pattern =null;

            switch (choice) {
                case 0:
                    pattern= spawnPattern1;
                    break;
                case 1:
                    pattern= spawnPattern2;
                    break;
                case 2:
                    pattern= spawnPattern3;
                    break;
                case 3:
                    pattern=spawnPatternArrow ;
                    break;

                case 4:
                    pattern=spawnPatternChaos ;
                    break;

                case 5:
                    pattern=spawnPatternCross;
                    break;
                case 6:
                    pattern=spawnPatternDNA;
                    break;
                case 7:
                    pattern=spawnPatternDiamond;
                    break;
                case 8:
                    pattern= spawnPatternShield;
                    break;
                case 9:
                    pattern=spawnPatternStaggered;
                    break;
                default:
                    System.out.println("fehler beim pattern aussuchen");
                    break;
            }

        int mid = pattern.length/ 2;

        // enemys spawnen
        for(int i= 0;i<=pattern.length-1;i++){
            for(int j = 0;j<=pattern.length-1;j++){


                // zufällige typen für enemys
                int anzahlTypen= 2;
                int type = (int)(Math.random() * anzahlTypen) + 1;

                switch(type){
                    case 1:
                        spawnPattern(e, waveCount, texture1, pattern, mid, i, j, type);
                        break;
                    case 2:
                        spawnPattern(e, waveCount, texture2, pattern, mid, i, j, type);
                        break;
                }



            }
        }


    }

    private static void spawnPattern(ArrayList<Enemy> e, int waveCount, BufferedImage texture, int[][] pattern, int mid, int i, int j, int type) {
        if(pattern[i][j] == 1){
            if(i==mid){
                Enemy enemy = new Enemy(Tim_der_Furry_Slayer_VERYHD_69FPS_EXTREME_2_OPENALPHA_V4_20.sizeX/2-12, Tim_der_Furry_Slayer_VERYHD_69FPS_EXTREME_2_OPENALPHA_V4_20.sizeY-950 +j *100,type,waveCount, texture);
                e.add(enemy);
            }
            else if(i<mid){

                Enemy enemy = new Enemy((Tim_der_Furry_Slayer_VERYHD_69FPS_EXTREME_2_OPENALPHA_V4_20.sizeX/2-12)-((1+i)*100), Tim_der_Furry_Slayer_VERYHD_69FPS_EXTREME_2_OPENALPHA_V4_20.sizeY-950+j*50,type,waveCount, texture);
                e.add(enemy);
            }
            else if(i>mid){
                Enemy enemy = new Enemy((Tim_der_Furry_Slayer_VERYHD_69FPS_EXTREME_2_OPENALPHA_V4_20.sizeX/2-12)+((i-1)*100), Tim_der_Furry_Slayer_VERYHD_69FPS_EXTREME_2_OPENALPHA_V4_20.sizeY-950+j*50,type,waveCount, texture);
                e.add(enemy);
            }
            else{
                System.out.println("heyho");
            }
        }
    }
}
