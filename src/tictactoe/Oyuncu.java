package tictactoe;
import java.util.Scanner;
import java.util.Random;
import java.io.*;
class Oyuncu extends TicTacToe{

        String hamle;
        Scanner x2 = new Scanner(System.in);

        Oyuncu(boolean insanmiKontrolu, char kr) {
            if (insanmiKontrolu == true) {
                if (kr == 'X') {
                    oyuncu = kr;
                } else {
                    oyuncu = 'O';
                }
            } else {
                if (kr == 'O') {
                    oyuncu = 'X';
                } else {
                    oyuncu = 'O';
                }
            }
        }

        Oyuncu(boolean insanmiKontrolu) {

            if (insanmiKontrolu == true) {
                oyuncu = 'X';
            } else {
                oyuncu = 'O';
            }
        }

        Oyuncu() {
            oyuncu = 'X';
        }

        char karakteriAl() {
            return oyuncu;
        }

        String insanOyuncuHamlesiniKontrol() throws IOException {
            File file = new File("Oyun.txt");
            String kayit;
            System.out.println("Hamleyi giriniz (A5 ya da C3 gibi) :");
            System.out.println("Çıkış yapmak isterseniz 1 yazınız.");
            hamle = x2.nextLine();
            if (hamle.equals("1") == true) {
                System.out.println("Oyun kaydedilsin mi? E/H");
                kayit = x2.nextLine();
                if ("E".equals(kayit)) {
                    FileWriter fileWriter = new FileWriter(file, false);
                    BufferedWriter bWriter = new BufferedWriter(fileWriter);
                    bWriter.write("Oyuncu:" + oyuncu);
                    bWriter.newLine();
                    bWriter.write("Boyut:" + boyut);
                    bWriter.newLine();
                    for (int i = 0; i < boyut; i++) {
                        for (int j = 0; j < boyut; j++) {
                            bWriter.write(oyunTahtasi[i][j]);
                        }
                        bWriter.newLine();
                    }
                    bWriter.close();
                    System.exit(0);
                }
            }
            return hamle;
        }

        String bilgisayarHamlesiUret() {
            if (oyuncu == 'X') {
                bsayar = 'O';
            } else {
                bsayar = 'X';
            }
            Random rand = new Random();
            Random rand2 = new Random();
            int x, y;
            x = rand.nextInt(boyut);
            y = rand2.nextInt(boyut);

            if (oyunTahtasi[x][y] != ' ') {
                bilgisayarHamlesiUret();
            } else {
                oyunTahtasi[x][y] = bsayar;
            }
            return "" + x + y;
        }

    }
