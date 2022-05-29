public class Bank {

    private long[] balance;

    public Bank(long[] balance) {
        this.balance = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        account1--;
        account2--;
        if (!isValid(account1) || !isValid(account2) || balance[account1] < money) {
            return false;
        }
        balance[account1] -= money;
        balance[account2] += money;
        return true;
    }

    public boolean deposit(int account, long money) {
        account--;
        if (!isValid(account)) {
            return false;
        }
        balance[account] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        account--;
        if (!isValid(account) || balance[account] < money) {
            return false;
        }
        balance[account] -= money;
        return true;
    }

    public boolean isValid(int index) {
        return index >= 0 && index < balance.length;
    }
}
