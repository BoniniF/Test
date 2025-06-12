import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] map = new String[3][50]; String s="",P, I; int p, avoidp=0, ride = -1; boolean b=true, flatland,o,  bo=false, caves, GN, prima;
        boolean autoplay = false;
        p = (int)((Math.random() * 48) + 0); String[][] E = new String[3][8];
//0=╼, 1=i , 2=eud, 3=avoidp,  4=epp, 5=edown, 6=alive, 7=ride.
// se è in ride e va contro un roccia cade come se avesse saltato

        System.out.print("Press something to start.\n");




            P="⊶"; p  = 0; E[0][1] =""+ (int)((map[1].length) * 0.92); o=true; s= ""; flatland=true; caves=false; GN=false; ride = -1; prima = true;

        for (int f = 0; f<E.length;f++) {E[f][4]="0"; E[f][1]="30"; E[f][6]="alive"; E[f][5] = "0";E[f][0] = "╼";E[f][3] = "-1";E[f][2] = "false";E[f][1] = "30";E[f][0] = "╼"; if ((E[f][1]).equals(map[0].length * 0.6)){o=false;} E[f][7]="false";} for (int rig = 0; rig < map[0].length; rig++) {map[1][rig] = " ";}


        do {
            System.out.print("\n ");
            if (autoplay){
                if ( (caves && (p == (map[0].length/2)-3) && ((int) (Math.random() * 2) + 1)==2)  || (p!=0 && p!= 1 && p < map[0].length - 2 && p < map[0].length - 1 && ((P == "⊶" && !(map[1][p + 2].equals(" "))) || (P == "⊷" && !(map[1][p - 2].equals(" "))) || (P == "⊶" && !(map[1][p + 1].equals(" "))) || (P == "⊷" && !(map[1][p-1].equals(" ")))) )){
                    s = "w";
                }else if((p == ((map[0].length / 2) - 3)) && flatland ){
                    switch ((int) (Math.random() * 2) + 1) {
                        case 1:
                            s = "s";
                            break;
                        case 2:
                    }
                }else{
                    switch ((int) (Math.random() * 2) + 1) { //for (int f = 0; f<E[1].length;f++) {if (p + 4 != Integer.parseInt(E[f][1])){bo=true;break;}} if (!bo){
                        case 1:
                            for (int f = 0; f<E.length;f++){if(E[f][3].equals("-1") && !((Integer.parseInt(E[f][3]))==(p + 2)) && ((p + 4 < map[0].length - 1 && p + 2 < map[0].length - 1 && p + 1 < map[0].length - 1) && !(map[1][p + 4].equals("╼") || map[1][p + 4].equals("╾") || map[1][p + 2].equals("╼") || map[1][p + 2].equals("╾")))){
                                s = "d";}}
                            break;
                        case 2:
                            for (int f = 0; f<E.length;f++) {if(p!=0&&p!=1&&p!=2&&p!=3&&(E[f][3].equals("-1") && !((Integer.parseInt(E[f][3]))==(p - 2))  && !(map[1][p - 4].equals("╼") || map[1][p - 4].equals("╾") || map[1][p - 2].equals("╼") || map[1][p - 2].equals("╾")))){
                                s = "a";}}
                    }}}else{ s = sc.nextLine(); if (s.equals("/stop")) {b = false;} if (!s.equals("")){ String[] S;  S = s.split(""); s = S[0];}}
            //
            if (p == ((map[0].length/2)-3 ) && s.equals("s") && flatland){flatland = false; caves=true; for (int f = 0; f<E.length; f++) {E[f][2]="true";}} if (p == ((map[0].length/2)-3) && (s.equals("w") || s.equals(" ")) && caves){flatland = true; caves=false; for (int f = 0; f<E.length; f++) {E[f][2]="true";}} if (prima){E[1][6] = "dead"; E[2][6] = "dead";} if (s.equals("")){s = "null";}
            //for (int f = 0; f<E.length; f++) {if(E[f][7].equals("true") && s.equals("s")){E[f][5]="true";}}
            //
            if (flatland) { /*cielo*/ for (int rig = 0; rig < map[0].length; rig++) {
                switch ((int) (Math.random() * 3) + 1) {
                    case 1:
                        map[0][rig] = " ";
                        break;
                    case 2:
                        map[0][rig] = "-";
                        break;
                    case 3:
                        map[0][rig] = " ";
                }
            }
                /*vuoto*/ for (int rig = 0; rig < map[0].length; rig++) {
                    map[1][rig] = " ";}
                /*terra*/ for (int rig = 0; rig < map[0].length; rig++) {
                    map[2][rig] = "―";
                    map[2][((map[0].length/2)-3 )] = " ";}
            }else if (caves){
                /*grotta*/for (int rig = 0; rig < map[0].length; rig++) {
                    map[0][rig] = "█";
                    map[2][rig] = "█";
                    map[1][rig] = " ";
                    map[0][0] = " ";
                    map[2][0] = " ";
                    if(o){map[1][(int)(map[0].length * 0.6)] = "▭";}
                    map[0][((map[0].length/2)-3 )] = " ";
                    if (prima){E[1][6] = "alive"; E[1][1] = "2"; E[2][6] = "alive"; E[2][1] = "40"; prima = false;}
                }
            }//〰 ͏〓
            bo=false;
            for (int f = 0; f<E.length; f++) {if (E[f][0].equals("▭")){bo=true;break;}} if (bo){o=false;}
            if (caves == true &&  map[1][(int)(map[0].length * 0.6)] != "▭"){o = false;}
            if (s.equals("d")) {
                P = "⊶";
                if (p < map[0].length - 2 && !( map[1][p + 2].equals("▭") )){ p=p+2;}
            }
            if (s.equals("a")) {
                P = "⊷";
                if (p!=0 && !(map[1][p - 2].equals("▭"))){p=p-2;}
            }
            //}

            map[1][p] = P;
            for (int f = 0; f<E.length;f++) {if (E[f][5].equals("2") && ride != -1 && (Integer.parseInt(E[f][4]) == p)){ s = "w"; E[ride][7] = "false"; ride = -2; }}
            /*w*/if ((s.equals("w") || s.equals(" "))  ) {
                for (int f = 0; f<E.length;f++) { if(E[f][7].equals("true")){
                    if (!caves && (p != (map[0].length/2)-3)){E[f][7] = "false"; ride = -1;}
                }else{
                    map[1][p] = " ";
                }}
                if (P.equals("⊶") && p != map[0].length - 4 && p != map[0].length - 2 && p != map[0].length - 1 && p != map[0].length - 3 && !(map[1][p + 4].equals("▭"))) {
                    p = p + 2;
                } else if (p != 0 && p != 2 && p != 1 && !(map[1][p - 4].equals("▭"))) {
                    p = p - 2;
                }

                for (int f = 0; f<E.length; f++) { if (!(E[f][6].equals("dead"))){
                    map[0][p] = P;
                    if (E[f][2].equals("true")) {
                        map[2][(Integer.parseInt(E[f][1]))] = "╽";
                        E[f][2] = "false";
                    } else if (E[f][5].equals("0")) {
                        map[1][(Integer.parseInt(E[f][1]))] = E[f][0];
                    }
                }}
                System.out.print("\n");
                for (int col = 0; col < map.length; col++) {
                    System.out.print("\n");
                    for (int rig = 0; rig < map[0].length - 1; rig++) {
                        System.out.print(map[col][rig]);
                    }
                }
                System.out.print("\n");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                map[0][p] = " ";
                if (P.equals("⊶")) {
                    p = p + 2;
                } else if (p != 0 && p != 2) {
                    p = p - 2;
                }
                for (int f = 0; f<E.length;f++) { if (!(E[f][6].equals("dead"))){
                    if (map[1][p].equals("╼") || map[1][p].equals("╾")){if (E[f][1].equals(""+ p)){E[f][7] = "true"; ride = f;}}else{
                        map[1][p] = P;}
                }}
                for (int f = 0; f<E.length; f++) {if (!(E[f][6].equals("dead"))){if (flatland){map[2][(Integer.parseInt(E[f][1]))] = "―";}}
                }}
            /*w*/

            /*enemie*/ for (int f = 0; f<E.length; f++) { if (!(E[f][6].equals("dead"))){
                map[1][Integer.parseInt(E[f][1])] = " ";
                if (!(E[f][5].equals("0"))){
                    if(E[f][5].equals("1")){
                        map[1][Integer.parseInt(E[f][1])] = " ";
                        /*player*/if(E[f][7].equals("true")){map[1][p] = " "; if ( p<Integer.parseInt(E[f][1])){map[2][(Integer.parseInt(E[f][1]))]="╼";}else{map[2][Integer.parseInt(E[f][1])]="╾";}
                            /*player*/}else{     if (P.equals("⊷")){map[2][(Integer.parseInt(E[f][1]))]="╼"; map[2][(Integer.parseInt(E[f][1]) + 1)]=P;} else if (P.equals("⊶")){ map[2][Integer.parseInt(E[f][1])] = "╾"; map[2][Integer.parseInt(E[f][1]) - 1] = P;}}
                        E[f][5] = ""+ 2;
                        /*ridemap[0].length - 2*/ if (E[f][7].equals("true")){if (P.equals("⊶") ){ p = map[0].length - 2; }else{ p = 1; E[f][4] = ""+ p ;}  E[f][3] = E[f][4];
                        }else if (E[f][5].equals("2")){
                            E[f][5]=E[f][1];
                            while(!(E[f][5].equals(E[f][4]))){
                                if (flatland){map[2][Integer.parseInt(E[f][5])] = "₌"; }else{map[2][Integer.parseInt(E[f][5])] = "═";}
                                if ((Integer.parseInt(E[f][5])) < (Integer.parseInt(E[f][4]))) {E[f][5] = ""+ ((Integer.parseInt(E[f][5])) + 1);}else{E[f][5] = ""+ ((Integer.parseInt(E[f][5])) - 1);}
                            }
                            if (E[f][7].equals("true")){    while(!(E[f][5].equals(E[f][4]))){
                                if (flatland){map[2][Integer.parseInt(E[f][5])] = "₌"; }else{map[2][Integer.parseInt(E[f][5])] = "═";}
                                if ((Integer.parseInt(E[f][5])) < (Integer.parseInt(E[f][4]))) {E[f][5] = ""+ ((Integer.parseInt(E[f][5])) + 1);}else{E[f][5] = ""+ ((Integer.parseInt(E[f][5])) - 1);}
                            }}
                            E[f][1] = ""+ E[f][4];
                            map[1][Integer.parseInt(E[f][1])]= "╽";
                            if (E[f][7].equals("true")){ p = Integer.parseInt(E[f][1]); map[2][p] = P;}

                            E[f][5]=""+0;
                            E[f][3]=""+ -1;
                        }/****/
                    }else if(E[f][2].equals("true") && !(E[f][6].equals("dead")) && (p == ((map[0].length/2)-3 ) && s.equals("s"))){
                        map[0][Integer.parseInt(E[f][1])] = "╿";
                        E[f][2]="false";
                    }else if ( (!(E[f][7].equals("true")) &&  ((( (Integer.parseInt(E[f][1])) > 0 && (map[1][((Integer.parseInt(E[f][1])) - 2)].equals("▭")) || (((Integer.parseInt(E[f][1])) < map[0].length - 2) && (map[1][((Integer.parseInt(E[f][1])) + 2)].equals("▭")))) && ((int)(Math.random()*3) + 1) == 1 ) || ((int)(Math.random()*36) + 1) == 1)) || (E[f][7].equals("true") && s.equals("s"))) {
                        map[1][(Integer.parseInt(E[f][1]))] = "╿";
                        if (E[f][7].equals("true")) {
                            map[0][(Integer.parseInt(E[f][1]))] = P;
                        }
                        E[f][5] = "" + 1;
                        E[f][4] = "" + p;
                    } else {
                        switch ((int) (Math.random() * 4) + 1) {
                            case 1:
                                if (ride == -1 && ((s.equals("w") || s.equals(" "))) && (Integer.parseInt(E[f][1]) + 2) == p) {
                                    E[f][1] = "" + ((Integer.parseInt(E[f][1])) - 2);
                                    E[f][0] = "╼";
                                } else {
                                    if ((Integer.parseInt(E[f][1])) < map[0].length - 2 && (Integer.parseInt(E[f][1])) < map[0].length - 1) {
                                        E[f][1] = "" + ((Integer.parseInt(E[f][1])) + 2);
                                        E[f][0] = "╾";
                                    } else {
                                        E[f][1] = "" + ((Integer.parseInt(E[f][1])) - 2);
                                        E[f][0] = "╼";
                                    }
                                }
                                break;
                            case 2:
                                break;
                            case 3:
                                if (ride == -1 && ((s.equals("w") || s.equals(" "))) && (Integer.parseInt(E[f][1]) - 2) == p) {
                                    E[f][1] = "" + ((Integer.parseInt(E[f][1])) + 2);
                                    E[f][0] = "╾";
                                } else {
                                    if ((Integer.parseInt(E[f][1])) > 2) {
                                        E[f][1] = "" + ((Integer.parseInt(E[f][1])) - 2);
                                        E[f][0] = "╼";
                                    } else {
                                        E[f][1] = "" + ((Integer.parseInt(E[f][1])) + 2);
                                        E[f][0] = "╾";
                                    }
                                }
                        }
                        if (Integer.parseInt(E[f][1]) < map[0].length && Integer.parseInt(E[f][1]) > 0) {
                            map[1][(Integer.parseInt(E[f][1]))] = E[f][0];
                        } else if (Integer.parseInt(E[f][1]) > map[0].length / 2) {
                            map[1][((map[0].length - 1))] = E[f][0];
                        } else {
                            map[1][1] = E[f][0];
                        }//..................................................
                    }}} for (int f = 0; f<E.length; f++) {if (!(E[f][6].equals("dead"))){if (E[f][5].equals("1")){map[1][(Integer.parseInt(E[f][1]))] = "╿";}}}

                /*ride*/for (int f = 0; f<E.length;f++) { if (!(E[f][6].equals("dead")) && !(s.equals("s")) ){
                    if (E[f][7].equals("true")){
                        map[1][Integer.parseInt(E[f][1])] = " ";
                        E[f][1]=""+ p;
                        map[0][p] = P;
                        if ( P == "⊶"){E[f][0] = "╾";}else{E[f][0] = "╼";}
                        map[1][p] = (E[f][0]);
                    }}}
                if (ride == -2){ride = -1; if(P=="⊶"){map[1][p-2]="╽";}else{ map[1][p+2]="╽";}}

                /*GameOver*/ for (int f = 0; f<E.length;f++) {if (E[f][7].equals("true")){ride = f;}} if ((ride == -1 && (map[1][p].equals("╼") || map[1][p].equals("╾") || ( map[1][p].equals("╽")) ))) {
                    if (((map[1].length / 2 - 9) >= 0) || ((map[1].length / 2 + 10) < map[1].length - 1)) {
                        if (p < (map[1].length / 2)) {
                            map[1][p + 1] = "G";
                            map[1][p + 2] = "a";
                            map[1][p + 3] = "m";
                            map[1][p + 4] = "e";
                            map[1][p + 5] = "";
                            map[1][p + 6] = "O";
                            map[1][p + 7] = "v";
                            map[1][p + 8] = "e";
                            map[1][p + 9] = "r";
                        } else {
                            map[1][p - 1] = "r";
                            map[1][p - 2] = "e";
                            map[1][p - 3] = "v";
                            map[1][p - 4] = "o";
                            map[1][p - 5] = "";
                            map[1][p - 6] = "e";
                            map[1][p - 7] = "m";
                            map[1][p - 8] = "a";
                            map[1][p - 9] = "G";
                        }
                    } else {
                        System.out.print("\n  Game Over ");
                    }GN=true;}



                // map[1][p]=":";
                /* stamp */ System.out.print("\n"); for (int col = 0; col < map.length; col++) {
                    System.out.print("\n"); if (caves && col==1){System.out.print("█");}
                    for (int rig = 0; rig < map[0].length; rig++) {
                        System.out.print(map[col][rig]);
                    }
                }


                if (autoplay){
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            } while (!GN && b);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }//
