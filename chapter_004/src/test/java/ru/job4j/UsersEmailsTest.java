package ru.job4j;

import org.junit.Test;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UsersEmailsTest {

    @Test
    public void whenIsEmpty() {
        List<String> rwaUsersData = Arrays.asList("");
        Emails expect = new Emails();
        assertThat(UsersEmails.collectEmails(rwaUsersData), is(expect));
    }

    @Test
    public void whenLoneUser() {
        List<String> rwaUsersData = Arrays.asList(
                "user1 ->xxx@ya.ru,foo@gmail.com,lol@mail.ru",
                "user2 ->foo@gmail.com,ups@pisem.net",
                "user4 ->ups@pisem.net,aaa@bbb.ru");

        Emails expect = new Emails();
        Set<String> addrUser1 = new TreeSet<>(Arrays.asList("aaa@bbb.ru", "foo@gmail.com", "lol@mail.ru", "ups@pisem.net", "xxx@ya.ru"));
        expect.getEmails().put("user1", addrUser1);

        assertThat(UsersEmails.collectEmails(rwaUsersData), is(expect));
    }

    @Test
    public void whenIsDefault() {

        List<String> rwaUsersData = Arrays.asList(
                        "user1 ->xxx@ya.ru,foo@gmail.com,lol@mail.ru",
                        "user2 ->foo@gmail.com,ups@pisem.net",
                        "user3 ->xyz@pisem.net,vasya@pupkin.com",
                        "user4 ->ups@pisem.net,aaa@bbb.ru",
                        "user5 ->xyz@pisem.net");

        Emails expect = new Emails();
        Set<String> addrUser1 = new TreeSet<>(Arrays.asList("aaa@bbb.ru", "foo@gmail.com", "lol@mail.ru", "ups@pisem.net", "xxx@ya.ru"));
        expect.getEmails().put("user1", addrUser1);
        Set<String> addrUser2 = new TreeSet<>(Arrays.asList("vasya@pupkin.com", "xyz@pisem.net"));
        expect.getEmails().put("user3", addrUser2);

        assertThat(UsersEmails.collectEmails(rwaUsersData), is(expect));
    }


}
