package ru.job4j;

import java.util.*;

public class UsersEmails {

    static Emails collectEmails(List<String> rawData) {
        String[] subStr, emails;
        Map<String, String> tmpMailToUser = new HashMap<>();
        Emails result = new Emails();
        try {
            for (String curUser: rawData) {
                subStr = curUser.split("->");
                emails = subStr[1].split(",");
                for (String curEmail: emails) {
                    String curVal = tmpMailToUser.get(curEmail);
                    if (curVal != null) {
                        subStr[0] = curVal;
                    }
                    tmpMailToUser.putIfAbsent(curEmail.trim(), subStr[0].trim());
                }
            }
            tmpMailToUser.forEach((e1, e2) -> {
                Set<String> curEmails = result.getEmails().get(e2);
                if (curEmails == null) {
                    curEmails = new TreeSet<>();
                }
                curEmails.add(e1);
                result.getEmails().put(e2, curEmails);
            });
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> rawData = Arrays.asList(
                "user1 ->xxx@ya.ru,foo@gmail.com,lol@mail.ru",
                "user2 ->foo@gmail.com,ups@pisem.net",
                "user3 ->xyz@pisem.net,vasya@pupkin.com",
                "user4 ->ups@pisem.net,aaa@bbb.ru",
                "user5 ->xyz@pisem.net");
        Emails result = collectEmails(rawData);
        System.out.print(result.toString());
    }

}
