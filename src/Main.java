import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Ogrenci> ogrenciler = new ArrayList<>();

        // Öğrenci verilerini alıyoruz
        while (true) {
            System.out.println("Öğrenci numarası girin (çıkmak için -1 girin): ");
            int ogrenciNumarasi = scanner.nextInt();
            if (ogrenciNumarasi ==-1) {
               break;
            }
            scanner.nextLine();  // Buffer temizliği

            System.out.println("Öğrenci ismini girin: ");
            String ogrenciAdi = scanner.nextLine();

            Ogrenci ogrenci = new Ogrenci(ogrenciNumarasi, ogrenciAdi);

            while (true) {
                System.out.println("Ders adı girin (çıkmak için boş bırakın): ");
                String dersAdi = scanner.nextLine();
                if (dersAdi.isEmpty()) {
                    break;
                }
                System.out.println(dersAdi + " dersinin vize notunu girin: ");
                double vize = scanner.nextDouble();

                System.out.println(dersAdi + " dersinin final notunu girin: ");
                double finalSinavi = scanner.nextDouble();
                scanner.nextLine();

                Ders ders = new Ders(dersAdi, vize, finalSinavi);
                ogrenci.dersEkle(ders);
            }

            ogrenciler.add(ogrenci);
        }

        // Menü
        while (true) {

            System.out.println("1. Öğrencileri Görüntüle");
            System.out.println("2. Öğrencilerin Ortalamalarını Görüntüle");
            System.out.println("3. 60'dan Küçük Not Alanlar");
            System.out.println("4. En Yüksek Not");
            System.out.println("5. En Düşük Not");
            System.out.println("6. Notları Küçükten Büyüğe Sırala");
            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    ogrencileriGoruntule(ogrenciler);
                    break;

                case 2:
                    ogrencilerinOrtalamalariniGoruntule(ogrenciler);
                    break;

                case 3:
                    notlariFiltrele(ogrenciler, 60, "Kucuk");
                    break;

                case 4:
                    enYuksekNotuBul(ogrenciler);
                    break;

                case 5:
                    enDusukNotuBul(ogrenciler);
                    break;

                case 6:
                    ogrencileriSiralayarakGoruntule(ogrenciler);
                    break;
            }
        }
    }

    // Öğrencileri görüntüleyen metod
    private static void ogrencileriGoruntule(ArrayList<Ogrenci> ogrenciler) {
        for (Ogrenci ogrenci : ogrenciler) {
            System.out.println("Öğrenci: " + ogrenci.getOgrenciAdi() + ", Numarası: " + ogrenci.getOgrenciNumarasi());
            for (Ders ders : ogrenci.getDersler()) {
                System.out.println("  Ders: " + ders.getDersAdi() + ", Vize: "
                        + ders.getVize() + ", Final: " + ders.getFinalSinavi());
            }
        }
    }

    // Öğrencilerin genel ortalamalarını görüntüleyen metod
    private static void ogrencilerinOrtalamalariniGoruntule(ArrayList<Ogrenci> ogrenciler) {
        for (Ogrenci ogrenci : ogrenciler) {
            System.out.println("Öğrenci: " + ogrenci.getOgrenciAdi() + ", Ortalama: "
                    + ogrenci.genelOrtalamaHesapla());
        }
    }

    // Notları 60'tan küçük olanları ve bunların bilgilerini görüntüleyen metod
    private static void notlariFiltrele(ArrayList<Ogrenci> ogrenciler, double sinir, String taraf) {
        for (Ogrenci ogrenci : ogrenciler) {
            for (Ders ders : ogrenci.getDersler()) {
                double ortalama = ders.ortalamaHesapla();
                if (taraf.equals("Kucuk") && ortalama < sinir) {
                    System.out.println(ogrenci.getOgrenciAdi() +  ders.getDersAdi() + ": " + ortalama);
                } else if (taraf.equals("Buyuk") && ortalama > sinir) {
                    System.out.println(ogrenci.getOgrenciAdi() + ders.getDersAdi() + ": " + ortalama);
                }
            }
        }
    }



    // En yüksek notu bulmak ve gösteren metod
    private static void enYuksekNotuBul(ArrayList<Ogrenci> ogrenciler) {
        double enyuksek = ogrenciler.get(0).getDersler().get(0).ortalamaHesapla();
        for (Ogrenci ogrenci : ogrenciler) {
            for (Ders ders : ogrenci.getDersler()) {
                double ortalama = ders.ortalamaHesapla();
                if (ortalama > enyuksek) {
                    enyuksek = ortalama;
                }
            }
        }
        System.out.println("En yüksek not: " + enyuksek);
    }

    // En düşük notu bulmak ve gösteren metod
    private static void enDusukNotuBul(ArrayList<Ogrenci> ogrenciler) {
        double endusuk = ogrenciler.get(0).getDersler().get(0).ortalamaHesapla();

        for (Ogrenci ogrenci : ogrenciler) {
            for (Ders ders : ogrenci.getDersler()) {
                double ortalama = ders.ortalamaHesapla();
                if (ortalama < endusuk) {
                    endusuk = ortalama;
                }
            }
        }
        System.out.println("En düşük not: " + endusuk);
    }




    // Öğrencileri ortalamalarına göre küçükten büyüğe sıralayan metod
    private static void ogrencileriSiralayarakGoruntule(ArrayList<Ogrenci> ogrenciler) {
        ogrenciler.sort(Comparator.comparingDouble(Ogrenci::genelOrtalamaHesapla));
        for (int i = 0; i < ogrenciler.size(); i++) {
            Ogrenci ogrenci = ogrenciler.get(i);
            System.out.println("öğrenci: " + ogrenci.getOgrenciAdi() + ", ortalama: " + ogrenci.genelOrtalamaHesapla());
        }

    }
}