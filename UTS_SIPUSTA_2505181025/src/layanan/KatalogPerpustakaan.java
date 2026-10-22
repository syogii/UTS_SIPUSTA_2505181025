package layanan;

import model.Koleksi;
import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KatalogPerpustakaan {
    private List<Koleksi> daftarKoleksi = new ArrayList<>();

    public void tambahKoleksi(Koleksi koleksi) {
        daftarKoleksi.add(koleksi);
    }

    public List<Koleksi> getDaftarKoleksi() {
        return daftarKoleksi;
    }

    // Pemrosesan polimorfik tanpa instanceof
    public void cetakStatus() {
        System.out.println("=== Status Seluruh Koleksi ===");
        for (Koleksi k : daftarKoleksi) {
            System.out.println(k.deskripsi() + " | Layak Pinjam: " + k.isLayakPinjam());
        }
        System.out.println();
    }

    public void urut(Comparator<Koleksi> comparator) {
        Collections.sort(daftarKoleksi, comparator);
    }

    public void pinjam(Koleksi koleksi) throws KoleksiSedangDipinjamException, KoleksiTidakLayakException {
        if (koleksi.isDipinjam()) {
            throw new KoleksiSedangDipinjamException(koleksi.getJudul());
        }
        if (!koleksi.isLayakPinjam()) {
            throw new KoleksiTidakLayakException(koleksi.getJudul());
        }
        koleksi.setDipinjam(true);
        System.out.println("Berhasil meminjam: " + koleksi.getJudul());
    }
}