package banking;

import java.util.*;

public class Bank {

    private Map<User, ArrayList<Account>> accountsMap = new TreeMap<>();

    public void addUser(User user) {
        this.accountsMap.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        ArrayList<Account> remove = this.accountsMap.remove(user);
    }

    public ArrayList<Account> getAccountsListByPassport(String passport) {
        ArrayList<Account> result = new ArrayList<>();
        for (var curUser : this.accountsMap.entrySet()) {
            if (curUser.getKey().getPassport().equals(passport)) {
                result = curUser.getValue();
                break;
            }
        }
        return result;
    }

    public Account getAccountByPassportAndRequisites(String passport, String requisite) {
        Account result = null;
        ArrayList<Account> curAccountsList = getAccountsListByPassport(passport);
        if (curAccountsList != null) {
            int index = curAccountsList.indexOf(new Account(0, requisite));
            if (index != -1) {
                result = curAccountsList.get(index);
            }
        }
        return result;
    }

    public void addAccountToUser(String passport, Account account) {
        ArrayList<Account> curAccountsList = getAccountsListByPassport(passport);
        if (curAccountsList != null) {
            int index = curAccountsList.indexOf(account);
            if (index == -1) {
                curAccountsList.add(account);
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        this.accountsMap.get(new User("", passport)).remove(account);
    }

    public List<Account> getAccounts(User user) {
        return this.accountsMap.get(user);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        Account srcAccount = getAccountByPassportAndRequisites(srcPassport, srcRequisite);
        Account destAccount = getAccountByPassportAndRequisites(destPassport, dstRequisite);
        return srcAccount != null && destAccount != null && srcAccount.transfer(destAccount, amount);
    }

    public String toString() {
        return "Bank{" + "accounts=" + accountsMap + "}";
    }

    public Map<User, ArrayList<Account>> getAccountsMap() {
        return accountsMap;
    }
}