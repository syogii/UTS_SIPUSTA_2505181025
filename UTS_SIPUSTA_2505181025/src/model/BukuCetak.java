package model;

public class BukuCetak extends Koleksi implements Terarsip {
    private int jumlahHalaman;
    private String nomorRak;
    private boolean sedangDiperbaiki;

    public BukuCetak(String kode, String judul, int tahun, int halaman, String rak, boolean diperbaiki) {
        super(kode, judul, tahun);
        this.jumlahHalaman = halaman;
        this.nomorRak = rak;
        this.sedangDiperbaiki = diperbaiki;
    }

    @Override
    public boolean isLayakPinjam() {
        return !sedangDiperbaiki;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Halaman: " + jumlahHalaman + " | Status Perbaikan: " + sedangDiperbaiki;
    }

    @Override
    public String nomorRak() { return nomorRak; }

    @Override
    public String lokasiLantai() { return "Lantai 1"; } // Asumsi lokasi lantai
}