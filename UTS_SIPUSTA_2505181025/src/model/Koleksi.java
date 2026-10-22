package model;

public abstract class Koleksi {
    protected String kodeKoleksi;
    protected String judul;
    protected int tahunTerbit;
    protected boolean isDipinjam; 

    public Koleksi(String kodeKoleksi, String judul, int tahunTerbit) {
        this.kodeKoleksi = kodeKoleksi;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.isDipinjam = false;
    }

    // Method abstract untuk aturan kelayakan pinjam
    public abstract boolean isLayakPinjam();

    // Method deskripsi yang akan diperluas oleh turunan
    public String deskripsi() {
        return "Kode: " + kodeKoleksi + " | Judul: " + judul + " | Tahun: " + tahunTerbit;
    }

    public String getJudul() { return judul; }
    public boolean isDipinjam() { return isDipinjam; }
    public void setDipinjam(boolean dipinjam) { this.isDipinjam = dipinjam; }
}