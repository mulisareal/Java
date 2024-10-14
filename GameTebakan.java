import java.util.Scanner;

public class GameTebakan {
    public static void main(String[] args) {
        // Array yang menyimpan soal untuk ditebak
        String[] soal = {"apel", "pisang", "anggur", "jeruk", "melon"};
        Scanner scanner = new Scanner(System.in);
        
        // Game loop utama
        boolean playAgain = true;

        while (playAgain) {
            // Memilih kata secara acak dari array
            String kataAcak = soal[(int) (Math.random() * soal.length)];
            boolean isCorrect = false;
            int attempts = 0;

            System.out.println("Selamat datang di game tebak kata!");
            System.out.println("Petunjuk: kata ini adalah nama buah");

            // Loop untuk memberi kesempatan pemain menebak
            while (!isCorrect) {
                System.out.print("Masukkan tebakan anda: ");
                String guess = scanner.nextLine();
                attempts++;

                // Memeriksa apakah tebakan benar
                if (guess.equalsIgnoreCase(kataAcak)) {
                    isCorrect = true; // Set isCorrect ke true saat tebakan benar
                    System.out.println("Tebakan benar! Kata tersebut adalah: " + kataAcak);
                    System.out.println("Anda menebak dalam " + attempts + " kali percobaan");

                    // Menanyakan apakah pemain ingin bermain lagi
                    System.out.print("Apakah Anda ingin bermain lagi? (ya/tidak): ");
                    String response = scanner.nextLine();
                    
                    // Jika pemain memilih "tidak", permainan berhenti
                    if (response.equalsIgnoreCase("tidak")) {
                        playAgain = false;
                        System.out.println("Terima kasih telah bermain! Sampai jumpa lagi.");
                    } else if (!response.equalsIgnoreCase("ya")) {
                        // Menangani input selain "ya" atau "tidak"
                        playAgain = false;
                        System.out.println("Input tidak dikenali, permainan akan berakhir. Terima kasih telah bermain!");
                    }
                } else {
                    System.out.println("Tebakan salah, coba lagi!");
                }
            }
        }
        scanner.close();
    }
}
