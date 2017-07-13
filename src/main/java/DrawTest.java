import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by dengdechao on 2017/7/12.
 */

class Account {
    private String accountNo;
    private double balance;

    public Account() {
    }

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        } else if(obj != null && obj.getClass() == Account.class) {
            Account target = (Account)obj;

            return target.getAccountNo().equals(accountNo);
        }

        return false;
    }

    public int hashCode() {
        return accountNo.hashCode();
    }
}

class DrawThread implements Callable {

    private Account account;
    private double drawAmount;

    public DrawThread(Account account, double drawAmount) {
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public Object call() throws Exception {
        synchronized (account) {
            if(account.getBalance() >= drawAmount) {
                System.out.println(Thread.currentThread().getName() + "取钱成功，吐出钞票:" + drawAmount);

//            Thread.sleep(1);
                account.setBalance(account.getBalance() - drawAmount);
                System.out.println("余额为："+ account.getBalance());
            } else {
                System.out.println(Thread.currentThread().getName() + "取钱失败，余额不足！");
            }
        }

        return null;
    }
}


public class DrawTest {
    public static void main(String[] args) {
        Account acct = new Account("12345", 1000);

        DrawThread d1 = new DrawThread(acct,800);
        DrawThread d2 = new DrawThread(acct,800);

        FutureTask<Integer> task1 = new FutureTask<Integer>(d1);
        FutureTask<Integer> task2 = new FutureTask<Integer>(d2);

        new Thread(task1, "甲").start();
        new Thread(task2, "乙").start();
    }
}
