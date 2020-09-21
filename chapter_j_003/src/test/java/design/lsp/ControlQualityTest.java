package design.lsp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ControlQualityTest {

    @Test
    public void whenThereIsAFoodForEachStorage() {

        ControlQuality testQC = new ControlQuality();
        List<Food> balance = new ArrayList<>();
        Food goodWh = new Food("Food for warehouse", new GregorianCalendar(2017, Calendar.JANUARY , 10), new GregorianCalendar(2017, Calendar.JANUARY , 1) , 0 , 0);
        Food goodSh = new Food("Food for shop", new GregorianCalendar(2017, Calendar.JANUARY , 6), new GregorianCalendar(2017, Calendar.JANUARY , 1) , 0 , 0);
        Food goodTr = new Food("Food for trash", new GregorianCalendar(2017, Calendar.JANUARY , 3), new GregorianCalendar(2017, Calendar.JANUARY , 1) , 0 , 0);
        balance.add(goodWh);
        balance.add(goodSh);
        balance.add(goodTr);
        testQC.distributeFood(new GregorianCalendar(2017, Calendar.JANUARY , 3), balance);
        StringBuilder expect = new StringBuilder()
                .append("Food for warehouse:Warehouse\n")
                .append("Food for shop:Shop\n")
                .append("Food for trash:Trash\n");
        StringBuilder current = new StringBuilder();
        for (Storage curStorage : testQC.getStorages()) {
            List<Food> curStoreBalance = curStorage.clear();
            for (Food curFood : curStoreBalance) {
                current.append(curFood.getName())
                        .append(":")
                        .append(curStorage.getName())
                        .append("\n");
            }
        }
        assertThat(current.toString(), is(expect.toString()));
    }

}