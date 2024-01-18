
package dto;

public class Wallet {
    private String walletID;
    private String accID;
    private int accountBalance;

    public Wallet() {
    }

    public Wallet(String walletID, String accID, int accountBalance) {
        this.walletID = walletID;
        this.accID = accID;
        this.accountBalance = accountBalance;
    }

    public String getWalletID() {
        return walletID;
    }

    public void setWalletID(String walletID) {
        this.walletID = walletID;
    }

    public String getAccID() {
        return accID;
    }

    public void setAccID(String accID) {
        this.accID = accID;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "Wallet{" + "walletID=" + walletID + ", accID=" + accID + ", accountBalance=" + accountBalance + '}';
    }
}
