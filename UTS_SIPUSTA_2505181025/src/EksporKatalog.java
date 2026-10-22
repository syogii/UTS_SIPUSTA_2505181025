import model.Koleksi;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EksporKatalog {
    public static void ekspor(List<Koleksi> koleksiList) {
        String formatKolom = "%-10s %-30s %-6s %-12s%n";
        
        // try-with-resources untuk memastikan aliran ditutup
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("katalog.txt"))) {
            writer.write(String.format(formatKolom, "KODE", "JUDUL", "TAHUN", "STATUS LAYAK"));
            writer.write("-".repeat(60) + "\n");
            
            for (Koleksi k : koleksiList) {
                writer.write(String.format(formatKolom, 
                        k.deskripsi().substring(6, 12), // Mengambil kode
                        k.getJudul(), 
                        k.deskripsi().replaceAll(".*Tahun: (\\d{4}).*", "$1"), 
                        k.isLayakPinjam() ? "Layak" : "Tidak"));
            }
            System.out.println("Katalog berhasil diekspor ke katalog.txt\n");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis berkas: " + e.getMessage());
        }
    }
}