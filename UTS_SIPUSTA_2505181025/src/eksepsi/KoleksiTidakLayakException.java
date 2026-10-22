package eksepsi;

public class KoleksiTidakLayakException extends PustakaException {
    public KoleksiTidakLayakException(String judul) {
        super("Koleksi '" + judul + "' tidak dapat dipinjam karena tidak memenuhi syarat kelayakan (sedang diperbaiki atau edisi terbaru).");
    }
}