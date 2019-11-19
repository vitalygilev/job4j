package banking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class BankTest {

    @Test
    public void whenUserAdds() {
        Bank bank = new Bank();
        User curUser = new User("Ivanov Ivan", "1122 334455");
        bank.addUser(curUser);
        bank.addAccountToUser("1122 334455", new Account(500000, "40000000000000000001"));
        Map<User, List<Account>> expect = Map.of(new User("Ivanov Ivan", "1122 334455"), List.of(new Account(500000, "40000000000000000001")));
        assertThat(bank.getAccountsMap(), is(expect));
    }

    @Test
    public void whenMoneyTransfer() {

        Bank bank = new Bank();
        User curUserIvanov = new User("Ivanov Ivan", "1122 334455");
        bank.addUser(curUserIvanov);
        bank.addAccountToUser("1122 334455", new Account(500000, "40000000000000000001"));

        User curUserPetrov = new User("Petrov Petr", "1122 334477");
        bank.addUser(curUserPetrov);
        bank.addAccountToUser("1122 334477", new Account(0, "40000000000000000002"));

        bank.transferMoney("1122 334455", "40000000000000000001", "1122 334477", "40000000000000000002", 500000);

        Map<User, List<Account>> expect = Map.of(new User("Ivanov Ivan", "1122 334455"), List.of(new Account(0, "40000000000000000001")),
                new User("Petrov Petr", "1122 334477"), List.of(new Account(500000, "40000000000000000002")));
        assertThat(bank.getAccountsMap(), is(expect));
    }

    @Test
    public void whenUserAccountDeletes() {
        Bank bank = new Bank();
        User curUser = new User("Ivanov Ivan", "1122 334455");
        bank.addUser(curUser);
        bank.addAccountToUser("1122 334455", new Account(500000, "40000000000000000001"));
        bank.deleteAccountFromUser("1122 334455", bank.getAccounts(curUser).get(0));
        Map<User, List<Account>> expect = Map.of(new User("Ivanov Ivan", "1122 334455"), List.of());
        assertThat(bank.getAccountsMap(), is(expect));
    }

}
