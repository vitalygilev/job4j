package design.lsp;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ControlQualityTest {

    @Test
    public void whenThereIsAFoodForEachStorage() {

        ControlQuality testQC = new ControlQuality();
        Food goodWh = new Food("Food for warehouse", new GregorianCalendar(2017, Calendar.JANUARY , 10), new GregorianCalendar(2017, Calendar.JANUARY , 1) , 0 , 0);
        Food goodSh = new Food("Food for shop", new GregorianCalendar(2017, Calendar.JANUARY , 6), new GregorianCalendar(2017, Calendar.JANUARY , 1) , 0 , 0);
        Food goodTr = new Food("Food for trash", new GregorianCalendar(2017, Calendar.JANUARY , 3), new GregorianCalendar(2017, Calendar.JANUARY , 1) , 0 , 0);
        testQC.balance.add(new StorageUnit(goodWh, null));
        testQC.balance.add(new StorageUnit(goodSh, null));
        testQC.balance.add(new StorageUnit(goodTr, null));
        testQC.distributeFood(new GregorianCalendar(2017, Calendar.JANUARY , 3));
        StringBuilder expect = new StringBuilder()
                .append("Food for warehouse:Warehouse\n")
                .append("Food for shop:Shop\n")
                .append("Food for trash:Trash\n");
        StringBuilder current = new StringBuilder();
        for (StorageUnit curFood : testQC.balance) {
            current.append(curFood.getFood().getName())
                .append(":")
                .append(curFood.getStorage().getName())
                .append("\n");
        }
        assertThat(current.toString(), is(expect.toString()));
    }

}