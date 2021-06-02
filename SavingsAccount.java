/**
 * Tugas Kelompok : Block sync 
 * 
 * Kelompok 7 : 
 * - Gilbert Lauren (1806199865) 
 * - Steven Moses (1806200236) 
 * - Leandro Thiery (1806199985) 
 * - Farid Muhammad Rahman (1806148662)
 */
public class SavingsAccount implements Runnable {
    // Nilai uang yang dimiliki
    private float balance = 50;

    /**
     * Mengurangi jumlah balance yang dimiliki
     * 
     * @param anAmount nominal balance yang akan dikurangi
     */
    public void withdraw(float anAmount) {
        // Memastikan nilai kurang tidak negatif
        if (anAmount < 0.0)
            throw new IllegalArgumentException("Withdraw amount negative");

        // Mengurangi balance jika masih cukup
        if (anAmount <= balance) {
            System.out.println("Saldo awal: " + balance);
            // Memastikan hanya satu thread yang dapat melakukan blok kode didalamnya
            synchronized (this) {
                balance = balance - anAmount;
            }
            System.out.println("Saldo akhir: " + balance);
        }

        /**
         * synchronized (this){ System.out.println("Saldo awal: " + balance); if
         * (anAmount<=balance){ balance = balance - anAmount;} System.out.println("Saldo
         * akhir: " + balance); }
         */

    }

    /**
     * Menambahkan jumlah balance yang dimiliki
     * 
     * @param anAmount nominal uang yang akan ditambahkan
     */
    public void deposit(float anAmount) {
        // Memastikan nilai tidak negatif
        if (anAmount < 0.0)
            throw new IllegalArgumentException("Deposit amount negative");
        // Memastikan hanya satu thread yang dapat melakukan blok kode didalamnya
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " melakukan deposit");
            balance = balance + anAmount;
            System.out.println("Saldo: " + balance);
        }
    }

    @Override
    /**
     * Menjalankan fungsi withdraw ketika di mulai oleh .start()
     */
    public void run() {
        withdraw(50);
    }
}