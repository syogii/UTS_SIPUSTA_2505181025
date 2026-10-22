import model.*;
import layanan.*;
import eksepsi.*;

public class Main {
    public static void main(String[] args) {
        KatalogPerpustakaan katalog = new KatalogPerpustakaan();

        // Mengisi Data Uji Wajib
        Koleksi bk1 = new BukuCetak("BK-001", "Java How to Program", 2022, 620, "rak A-12", false);
        Koleksi bk2 = new BukuCetak("BK-002", "Basis Data Relasional", 2021, 410, "rak B-04", true);
        Koleksi mj1 = new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026, "edisi 88", "Agustus", true);
        Koleksi mj2 = new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026, "edisi 87", "Juli", false);
        Koleksi bd1 = new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024, 15, "unduh.polmed.ac.id/bd001");
        Koleksi bd2 = new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025, 8, "unduh.polmed.ac.id/bd002");

        katalog.tambahKoleksi(bk1);
        katalog.tambahKoleksi(bk2);
        katalog.tambahKoleksi(mj1);
        katalog.tambahKoleksi(mj2);
        katalog.tambahKoleksi(bd1);
        katalog.tambahKoleksi(bd2);

        //Mencetak Status Polimorfik
        katalog.cetakStatus();

        // 
        katalog.urut(new UrutLayakLaluJudul());
        System.out.println("=== Setelah Diurutkan (Layak lalu Judul) ===");
        katalog.cetakStatus();

       
        System.out.println("=== Uji Peminjaman ===");
        try {
            katalog.pinjam(bk1); 
            katalog.pinjam(bk1);
        } catch (PustakaException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            katalog.pinjam(bk2); 
        } catch (PustakaException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();

        //Ekspor Katalog
        EksporKatalog.ekspor(katalog.getDaftarKoleksi());
    }
    
    
}
