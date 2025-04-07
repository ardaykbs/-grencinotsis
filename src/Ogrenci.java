import java.util.ArrayList;
class Ogrenci {
    private int ogrenciNumarasi;
    private String ogrenciAdi;
    private ArrayList<Ders> dersler;

    public Ogrenci(int ogrenciNumarasi, String ogrenciAdi) {
        this.ogrenciNumarasi = ogrenciNumarasi;
        this.ogrenciAdi = ogrenciAdi;
        this.dersler = new ArrayList<>();
    }

    public void dersEkle(Ders ders) {

        this.dersler.add(ders);
    }

    public double genelOrtalamaHesapla() {
        double toplam = 0;
        for (Ders ders : dersler) {
            toplam += ders.ortalamaHesapla();
        }
        return toplam / dersler.size();
    }

    public ArrayList<Ders> getDersler() {

        return dersler;
    }

    public void setDersler(ArrayList<Ders> dersler) {
        this.dersler = dersler;
    }

    public int getOgrenciNumarasi() {

        return ogrenciNumarasi;
    }

    public void setOgrenciNumarasi(int ogrenciNumarasi) {
        this.ogrenciNumarasi = ogrenciNumarasi;
    }

    public String getOgrenciAdi() {
        return ogrenciAdi;
    }

    public void setOgrenciAdi(String ogrenciAdi) {
        this.ogrenciAdi = ogrenciAdi;
    }
}