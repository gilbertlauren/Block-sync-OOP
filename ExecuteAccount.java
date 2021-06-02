/**
 * Tugas Kelompok : Group assignment - Block sync 
 * 
 * Kelompok 7 : 
 * - Gilbert Lauren (1806199865) 
 * - Steven Moses (1806200236) 
 * - Leandro Thiery (1806199985) 
 * - Farid Muhammad Rahman (1806148662)
 */
public class ExecuteAccount {
    //
    static float v1 = 0; // contoh shared variable (reference by address, sehingga v1++ oleh thread lain
                         // bukan merupakan operasi yg atomic)

    /**
     * Kode driver, menjalankan
     */
    public static void main(String args[]) {
        SavingsAccount savingsAccount = new SavingsAccount();
        // Membuat dua thread baru
        Thread threadSavings1 = new Thread(savingsAccount);
        Thread threadSavings2 = new Thread(savingsAccount);
        // Mengatur nama thread
        threadSavings1.setName("savingsAccount1");
        threadSavings2.setName("savingsAccount2");
        // Memulai atau kedua thread
        threadSavings1.start();
        threadSavings2.start();
    }
}
