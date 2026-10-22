package model;


public class BerkasDigital extends Koleksi {
    private int ukuranMB;
    private String tautanUnduh;

    public BerkasDigital(String kode, String judul, int tahun, int ukuranMB, String tautanUnduh) {
        super(kode, judul, tahun);
        this.ukuranMB = ukuranMB;
        this.tautanUnduh = tautanUnduh;
    }

    @Override
    public boolean isLayakPinjam() {
        return true; // Selalu layak dipinjam
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Ukuran: " + ukuranMB + "MB | Link: " + tautanUnduh;
    }
}