/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.IOException;
import java.util.Scanner;

final class Tahta extends Oyuncu {

        public String BilKoordinat;
        public int BilgSatir;
        public int BilgSutun;
        Scanner x = new Scanner(System.in);

        Tahta() throws IOException {
	    System.out.println("Oyuncu belirleme işlemi:");
            System.out.println("Parametresiz için 1 - Tek parametre 2 - İki parametre 3:");
            int parakontrol = x.nextInt();
            if (parakontrol == 1) {
                Oyuncu o1 = new Oyuncu();
            }
            if (parakontrol == 2) {
                boolean robot;
                System.out.println("İnsan mısınız? true-false:");
                robot = x.nextBoolean();
                Oyuncu o2 = new Oyuncu(robot);
            }
            if (parakontrol == 3) {
                boolean robot;
                System.out.println("İnsan mısınız? true-false:");
                robot = x.nextBoolean();
                System.out.println("İşaretçinizi seçiniz X/O:");
                char kr;
                kr = x.next().charAt(0);
                Oyuncu o3 = new Oyuncu(robot, kr);
            }
            for (int i = 0; i < boyut; i++) {
                for (int j = 0; j < boyut; j++) {
                    oyunTahtasi[i][j] = ' ';
                }
            }

            oyunTahtasiniYazdir();

            for (int i = 0; i < boyut * boyut; i++) {
                if (oyuncu == 'X') {
                    insanOyuncuHamlesiniKontrol();
                    while (hamleyiYaz(hamle, oyuncu) == false) {
                        insanOyuncuHamlesiniKontrol();
                    }
                    if (i == ((boyut * boyut) / 2)) {
                        oyunTahtasiniYazdir();
                        break;
                    }
                    BilKoordinat = bilgisayarHamlesiUret();
                    BilgSatir = BilKoordinat.charAt(0);
                    BilgSutun = BilKoordinat.charAt(1);
                    oyunTahtasiniYazdir();
                    if (kazanan(oyuncu) == true) {
                        System.out.println("Oyun bitti. Kazanan Oyuncu : " + oyuncu);
                        kont=1;
                        break;
                    }
                    if (kazanan(bsayar) == true) {
                        System.out.println("Oyun bitti. Kazanan Bilgisayar : " + bsayar);
                        kont=1;
                        break;
                    }
                } else {

                    BilKoordinat = bilgisayarHamlesiUret();
                    BilgSatir = BilKoordinat.charAt(0);
                    BilgSutun = BilKoordinat.charAt(1);
                    if (kazanan(oyuncu) == true) {
                        oyunTahtasiniYazdir();
                        System.out.println("Oyun bitti. Kazanan Oyuncu : " + oyuncu);
                        kont=1;
                        break;
                    }
                    if (kazanan(bsayar) == true) {
                        oyunTahtasiniYazdir();
                        System.out.println("Oyun bitti. Kazanan Bilgisayar : " + bsayar);
                        kont=1;
                        break;
                    }
                    oyunTahtasiniYazdir();

                    if (i == ((boyut * boyut) / 2)) {
                        break;
                    }
                    insanOyuncuHamlesiniKontrol();
                    while (hamleyiYaz(hamle, oyuncu) == false) {
                        insanOyuncuHamlesiniKontrol();
                    }

                }
            }
            if(kont!=1)
                  if (beraberlikKontrol() == true) {
                System.out.println("Oyun Berabere Bitti.");
            }
        }

        Tahta(char[][] oyunTahtasi) throws IOException {

            int sayac = 0;
            for (int i = 0; i < boyut; i++) {
                for (int j = 0; j < boyut; j++) {
                    if (oyunTahtasi[i][j] == ' ') {
                        sayac++;
                    }
                }
            }
            oyuncu = o;
            oyunTahtasiniYazdir();

            for (int i = 0; i < sayac; i++) {
                if (oyuncu == 'X') {
                    insanOyuncuHamlesiniKontrol();
                    while (hamleyiYaz(hamle, oyuncu) == false) {
                        insanOyuncuHamlesiniKontrol();
                    }
                    if (i == sayac / 2) {
                        oyunTahtasiniYazdir();
                        break;
                    }
                    BilKoordinat = bilgisayarHamlesiUret();
                    BilgSatir = BilKoordinat.charAt(0);
                    BilgSutun = BilKoordinat.charAt(1);
                    oyunTahtasiniYazdir();
                    if (kazanan(oyuncu) == true) {
                        System.out.println("Oyun bitti. Kazanan Oyuncu : " + oyuncu);
                        break;
                    }else if (kazanan(bsayar) == true) {
                        System.out.println("Oyun bitti. Kazanan Bilgisayar : " + bsayar);
                        break;
                    }
                } else {

                    BilKoordinat = bilgisayarHamlesiUret();
                    BilgSatir = BilKoordinat.charAt(0);
                    BilgSutun = BilKoordinat.charAt(1);
                    if (kazanan(oyuncu) == true) {
                        oyunTahtasiniYazdir();
                        System.out.println("Oyun bitti. Kazanan Oyuncu : " + oyuncu);
                        break;
                    }
                    if (kazanan(bsayar) == true) {
                        oyunTahtasiniYazdir();
                        System.out.println("Oyun bitti. Kazanan Bilgisayar : " + bsayar);
                        break;
                    }
                    oyunTahtasiniYazdir();

                    if (i == sayac / 2) {
                        break;
                    }

                    insanOyuncuHamlesiniKontrol();
                    while (hamleyiYaz(hamle, oyuncu) == false) {
                        insanOyuncuHamlesiniKontrol();
                    }

                }
            }
            if (beraberlikKontrol() == true) {
                System.out.println("Oyun Berabere Bitti.");
            }

        }

        void oyunTahtasiniYazdir() {
            System.out.print("    ");
            int k = 0;
            for (char i = 'A'; k < boyut; i++, k++) {
                System.out.print(i + " | ");
            }
            System.out.println();
            System.out.print("   ");
            for (int i = 0; i < boyut; i++) {
                System.out.print("- - ");
            }
            System.out.println();

            for (int i = 0; i < oyunTahtasi.length; i++) {
                System.out.print((i + 1) + " | ");
                for (int j = 0; j < oyunTahtasi.length; j++) {
                    System.out.print(oyunTahtasi[i][j] + " | ");
                }
                System.out.println();
            }
        }

        boolean hamleyiYaz(String koordinat, char oyuncu) {
            char sutun = koordinat.charAt(0);
            char satir = koordinat.charAt(1);
            char sayac1 = 'A';
            char sayac2 = '1';
            int say1 = 0;
            int say2 = 0;
            for (int i = 0; i < 7; i++, sayac1++) {
                if (sutun == sayac1) {
                    say1 = i;
                    break;
                }
            }
            for (int i = 0; i < 7; i++, sayac2++) {
                if (satir == sayac2) {
                    say2 = i;
                    break;
                }
            }

            if (oyunTahtasi[say2][say1] == ' ') {
                oyunTahtasi[say2][say1] = oyuncu;
                return true;
            } else {
                System.out.println("Seçilen koordinatlar dolu. Tekrar koordinat girin:");
                return false;
            }
        }

        boolean kazanan(char oyuncu) {
            if (boyut == 3) {

                if (oyunTahtasi[0][0] == oyuncu && oyunTahtasi[0][1] == oyuncu && oyunTahtasi[0][2] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[1][0] == oyuncu && oyunTahtasi[1][1] == oyuncu && oyunTahtasi[1][2] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[2][0] == oyuncu && oyunTahtasi[2][1] == oyuncu && oyunTahtasi[2][2] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[0][0] == oyuncu && oyunTahtasi[1][0] == oyuncu && oyunTahtasi[2][0] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[0][1] == oyuncu && oyunTahtasi[1][1] == oyuncu && oyunTahtasi[2][1] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[0][2] == oyuncu && oyunTahtasi[1][2] == oyuncu && oyunTahtasi[2][2] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[2][0] == oyuncu && oyunTahtasi[1][1] == oyuncu && oyunTahtasi[0][2] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[0][0] == oyuncu && oyunTahtasi[1][1] == oyuncu && oyunTahtasi[2][2] == oyuncu) {
                    return true;
                }
            }
            if (boyut == 5) {
                if (oyunTahtasi[0][0] == oyuncu && oyunTahtasi[0][1] == oyuncu && oyunTahtasi[0][2] == oyuncu && oyunTahtasi[0][3] == oyuncu && oyunTahtasi[0][4] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[1][0] == oyuncu && oyunTahtasi[1][1] == oyuncu && oyunTahtasi[1][2] == oyuncu && oyunTahtasi[1][3] == oyuncu && oyunTahtasi[1][4] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[2][0] == oyuncu && oyunTahtasi[2][1] == oyuncu && oyunTahtasi[2][2] == oyuncu && oyunTahtasi[2][3] == oyuncu && oyunTahtasi[2][4] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[3][0] == oyuncu && oyunTahtasi[3][1] == oyuncu && oyunTahtasi[3][2] == oyuncu && oyunTahtasi[3][3] == oyuncu && oyunTahtasi[3][4] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[4][0] == oyuncu && oyunTahtasi[4][1] == oyuncu && oyunTahtasi[4][2] == oyuncu && oyunTahtasi[4][3] == oyuncu && oyunTahtasi[4][4] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[0][0] == oyuncu && oyunTahtasi[1][1] == oyuncu && oyunTahtasi[2][2] == oyuncu && oyunTahtasi[3][3] == oyuncu && oyunTahtasi[4][4] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[4][0] == oyuncu && oyunTahtasi[3][1] == oyuncu && oyunTahtasi[2][2] == oyuncu && oyunTahtasi[1][3] == oyuncu && oyunTahtasi[0][4] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[0][0] == oyuncu && oyunTahtasi[1][0] == oyuncu && oyunTahtasi[2][0] == oyuncu && oyunTahtasi[3][0] == oyuncu && oyunTahtasi[4][0] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[0][1] == oyuncu && oyunTahtasi[1][1] == oyuncu && oyunTahtasi[2][1] == oyuncu && oyunTahtasi[3][1] == oyuncu && oyunTahtasi[4][1] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[0][2] == oyuncu && oyunTahtasi[1][2] == oyuncu && oyunTahtasi[2][2] == oyuncu && oyunTahtasi[3][2] == oyuncu && oyunTahtasi[4][2] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[0][3] == oyuncu && oyunTahtasi[1][3] == oyuncu && oyunTahtasi[2][3] == oyuncu && oyunTahtasi[3][3] == oyuncu && oyunTahtasi[4][3] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[0][4] == oyuncu && oyunTahtasi[1][4] == oyuncu && oyunTahtasi[2][4] == oyuncu && oyunTahtasi[3][4] == oyuncu && oyunTahtasi[4][4] == oyuncu) {
                    return true;
                }

            }
            if (boyut == 7) {
                if (oyunTahtasi[0][0] == oyuncu && oyunTahtasi[0][1] == oyuncu && oyunTahtasi[0][2] == oyuncu && oyunTahtasi[0][3] == oyuncu && oyunTahtasi[0][4] == oyuncu && oyunTahtasi[0][5] == oyuncu && oyunTahtasi[0][6] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[1][0] == oyuncu && oyunTahtasi[1][1] == oyuncu && oyunTahtasi[1][2] == oyuncu && oyunTahtasi[1][3] == oyuncu && oyunTahtasi[1][4] == oyuncu && oyunTahtasi[1][5] == oyuncu && oyunTahtasi[1][6] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[2][0] == oyuncu && oyunTahtasi[2][1] == oyuncu && oyunTahtasi[2][2] == oyuncu && oyunTahtasi[2][3] == oyuncu && oyunTahtasi[2][4] == oyuncu && oyunTahtasi[2][5] == oyuncu && oyunTahtasi[2][6] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[3][0] == oyuncu && oyunTahtasi[3][1] == oyuncu && oyunTahtasi[3][2] == oyuncu && oyunTahtasi[3][3] == oyuncu && oyunTahtasi[3][4] == oyuncu && oyunTahtasi[3][5] == oyuncu && oyunTahtasi[3][6] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[4][0] == oyuncu && oyunTahtasi[4][1] == oyuncu && oyunTahtasi[4][2] == oyuncu && oyunTahtasi[4][3] == oyuncu && oyunTahtasi[4][4] == oyuncu && oyunTahtasi[4][5] == oyuncu && oyunTahtasi[4][6] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[5][0] == oyuncu && oyunTahtasi[5][1] == oyuncu && oyunTahtasi[5][2] == oyuncu && oyunTahtasi[5][3] == oyuncu && oyunTahtasi[5][4] == oyuncu && oyunTahtasi[5][5] == oyuncu && oyunTahtasi[5][6] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[6][0] == oyuncu && oyunTahtasi[6][1] == oyuncu && oyunTahtasi[6][2] == oyuncu && oyunTahtasi[6][3] == oyuncu && oyunTahtasi[6][4] == oyuncu && oyunTahtasi[6][5] == oyuncu && oyunTahtasi[6][6] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[0][0] == oyuncu && oyunTahtasi[1][0] == oyuncu && oyunTahtasi[2][0] == oyuncu && oyunTahtasi[3][0] == oyuncu && oyunTahtasi[4][0] == oyuncu && oyunTahtasi[5][0] == oyuncu && oyunTahtasi[6][0] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[0][1] == oyuncu && oyunTahtasi[1][1] == oyuncu && oyunTahtasi[2][1] == oyuncu && oyunTahtasi[3][1] == oyuncu && oyunTahtasi[4][1] == oyuncu && oyunTahtasi[5][1] == oyuncu && oyunTahtasi[6][1] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[0][2] == oyuncu && oyunTahtasi[1][2] == oyuncu && oyunTahtasi[2][2] == oyuncu && oyunTahtasi[3][2] == oyuncu && oyunTahtasi[4][2] == oyuncu && oyunTahtasi[5][2] == oyuncu && oyunTahtasi[6][2] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[0][3] == oyuncu && oyunTahtasi[1][3] == oyuncu && oyunTahtasi[2][3] == oyuncu && oyunTahtasi[3][3] == oyuncu && oyunTahtasi[4][3] == oyuncu && oyunTahtasi[5][3] == oyuncu && oyunTahtasi[6][3] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[0][4] == oyuncu && oyunTahtasi[1][4] == oyuncu && oyunTahtasi[2][4] == oyuncu && oyunTahtasi[3][4] == oyuncu && oyunTahtasi[4][4] == oyuncu && oyunTahtasi[5][4] == oyuncu && oyunTahtasi[6][4] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[0][5] == oyuncu && oyunTahtasi[1][5] == oyuncu && oyunTahtasi[2][5] == oyuncu && oyunTahtasi[3][5] == oyuncu && oyunTahtasi[4][5] == oyuncu && oyunTahtasi[5][5] == oyuncu && oyunTahtasi[6][5] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[0][6] == oyuncu && oyunTahtasi[1][6] == oyuncu && oyunTahtasi[2][6] == oyuncu && oyunTahtasi[3][6] == oyuncu && oyunTahtasi[4][6] == oyuncu && oyunTahtasi[5][6] == oyuncu && oyunTahtasi[6][6] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[0][0] == oyuncu && oyunTahtasi[1][1] == oyuncu && oyunTahtasi[2][2] == oyuncu && oyunTahtasi[3][3] == oyuncu && oyunTahtasi[4][4] == oyuncu && oyunTahtasi[5][5] == oyuncu && oyunTahtasi[6][6] == oyuncu) {
                    return true;
                } else if (oyunTahtasi[0][6] == oyuncu && oyunTahtasi[1][5] == oyuncu && oyunTahtasi[2][4] == oyuncu && oyunTahtasi[3][3] == oyuncu && oyunTahtasi[4][2] == oyuncu && oyunTahtasi[5][1] == oyuncu && oyunTahtasi[6][0] == oyuncu) {
                    return true;
                }

            }
            return false;
        }

        boolean beraberlikKontrol() {
            if ((kazanan(oyuncu) == true && kazanan(bsayar) == false) || (kazanan(oyuncu) == false && kazanan(bsayar) == true)) {
                return false;
            } else {
                return true;
            }
        }
    ;

}