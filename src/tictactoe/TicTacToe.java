package tictactoe;

import java.util.*;
import java.io.*;

public class TicTacToe {

    public static int boyut;
    public static char[][] oyunTahtasi;
    public static char oyuncu;
    public static char bsayar;
    public static char o;
    public static int kont=0;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        File file = new File("Oyun.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        System.out.println("TIC TAC TOE");

        System.out.println("[1] Yeni oyun ");
        System.out.println("[2] Kaydedilen oyun");

        int kontrol = s.nextInt();
        while (kontrol != 1 && kontrol != 2) {
            kontrol = s.nextInt();
        }
        if (kontrol == 1) {
            System.out.println("Tahta boyutunuzu seçiniz (3,5,7):");
            boyut = s.nextInt();
            oyunTahtasi = new char[boyut][boyut];

            Tahta t = new Tahta();
        }
        if (kontrol == 2) {
            FileReader fileReader = new FileReader(file);
            String line;
            char ch;
            String ch2;
            BufferedReader br = new BufferedReader(fileReader);
            line = br.readLine();
            o = line.charAt(7);
            line = br.readLine();
            ch = line.charAt(6);
            ch2 = ch + "";
            boyut = Integer.parseInt(ch2);
            line = br.readLine();
            oyunTahtasi = new char[boyut][boyut];
            System.out.println("boyut:" + boyut + " oyuncu:" + o);
            if (boyut == 3) {
                for (int i = 0; i < boyut; i++) {
                    oyunTahtasi[0][i] = line.charAt(i);
                }
                line = br.readLine();
                for (int i = 0; i < boyut; i++) {
                    oyunTahtasi[1][i] = line.charAt(i);
                }
                line = br.readLine();
                for (int i = 0; i < boyut; i++) {
                    oyunTahtasi[2][i] = line.charAt(i);
                }
            }

            if (boyut == 5) {
                for (int i = 0; i < boyut; i++) {
                    oyunTahtasi[0][i] = line.charAt(i);
                }
                line = br.readLine();
                for (int i = 0; i < boyut; i++) {
                    oyunTahtasi[1][i] = line.charAt(i);
                }
                line = br.readLine();
                for (int i = 0; i < boyut; i++) {
                    oyunTahtasi[2][i] = line.charAt(i);
                }
                line = br.readLine();
                for (int i = 0; i < boyut; i++) {
                    oyunTahtasi[3][i] = line.charAt(i);
                }
                line = br.readLine();
                for (int i = 0; i < boyut; i++) {
                    oyunTahtasi[4][i] = line.charAt(i);
                }
            }

            if (boyut == 7) {
                for (int i = 0; i < boyut; i++) {
                    oyunTahtasi[0][i] = line.charAt(i);
                }
                line = br.readLine();
                for (int i = 0; i < boyut; i++) {
                    oyunTahtasi[1][i] = line.charAt(i);
                }
                line = br.readLine();
                for (int i = 0; i < boyut; i++) {
                    oyunTahtasi[2][i] = line.charAt(i);
                }
                line = br.readLine();
                for (int i = 0; i < boyut; i++) {
                    oyunTahtasi[3][i] = line.charAt(i);
                }
                line = br.readLine();
                for (int i = 0; i < boyut; i++) {
                    oyunTahtasi[4][i] = line.charAt(i);
                }
                line = br.readLine();
                for (int i = 0; i < boyut; i++) {
                    oyunTahtasi[5][i] = line.charAt(i);
                }
                line = br.readLine();
                for (int i = 0; i < boyut; i++) {
                    oyunTahtasi[6][i] = line.charAt(i);
                }

            }

            for (int i = 0; i < boyut; i++) {
                for (int j = 0; j < boyut; j++) {
                    System.out.print(oyunTahtasi[i][j]);
                }
                System.out.println("");
            }

            Tahta t = new Tahta(oyunTahtasi);

        }

    }
   
}