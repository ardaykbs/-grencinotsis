class Ders {
    private String dersAdi;
    private double vize;
    private double finalSinavi;

    public Ders(String dersAdi, double vize, double finalSinavi) {
        this.dersAdi = dersAdi;
        this.vize = vize;
        this.finalSinavi = finalSinavi;
    }

    public double ortalamaHesapla() {
        return (this.vize * 0.4) + (this.finalSinavi * 0.6);
    }

    public String getDersAdi() {
        return dersAdi;
    }

    public void setDersAdi(String dersAdi) {
        this.dersAdi = dersAdi;
    }

    public double getVize() {
        return vize;
    }
    public void setVize(double vize){
        this.vize=vize;
    }

    public double getFinalSinavi() {
        return finalSinavi;
    }
    public void setFinalSinavi(double finalSinavi){
        this.finalSinavi=finalSinavi;
    }
}

