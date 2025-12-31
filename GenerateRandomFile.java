import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateRandomFile {
    public static void main(String[] args) {
        int jumlahAngka = 2000000; // jumlah angka random yang ingin dibuat
        String namaFile = "random.txt"; // nama file output
        Random rand = new Random();

        try (FileWriter writer = new FileWriter(namaFile)) {
            for (int i = 0; i < jumlahAngka; i++) {
                int angkaRandom = rand.nextInt(100000); // angka random range 0 - 99999
                writer.write(angkaRandom + "\n"); // tulis ke file
            }
            System.out.println("File berhasil dibuat: " + namaFile);
        } catch (IOException e) {
            System.out.println("Terjadi error saat membuat file.");
            e.printStackTrace();
        }
    }
}
