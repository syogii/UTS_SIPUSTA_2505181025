package layanan;

import model.Koleksi;
import java.util.Comparator;

public class UrutLayakLaluJudul implements Comparator<Koleksi> {
    @Override
    public int compare(Koleksi k1, Koleksi k2) {
        // Layak pinjam lebih dulu (true diurutkan sebelum false)
        int layakCompare = Boolean.compare(k2.isLayakPinjam(), k1.isLayakPinjam());
        if (layakCompare != 0) {
            return layakCompare;
        }
        // Jika status kelayakan sama, urutkan berdasarkan judul alfabet
        return k1.getJudul().compareToIgnoreCase(k2.getJudul());
    }
}