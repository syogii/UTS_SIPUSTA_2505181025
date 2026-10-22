package model;

public class Majalah extends Koleksi implements Terarsip {
    private String edisi;
    private String bulanTerbit;
    private boolean edisiTerbaru;

    public Majalah(String kode, String judul, int tahun, String edisi, String bulan, boolean terbaru) {
        super(kode, judul, tahun);
        this.edisi = edisi;
        this.bulanTerbit = bulan;
        this.edisiTerbaru = terbaru;
    }

    @Override
    public boolean isLayakPinjam() {
        return !edisiTerbaru;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Edisi: " + edisi + " | Bulan: " + bulanTerbit + " | Terbaru: " + edisiTerbaru;
    }

    @Override
    public String nomorRak() { return "Rak Majalah"; } // Sesuai data uji atau default

    @Override
    public String lokasiLantai() { return "Lantai 2"; }
}