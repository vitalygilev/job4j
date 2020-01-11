package test.java.ru.job4j.array;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import main.java.ru.job4j.array.EvenIt;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EvenItTest {
    private Iterator<Integer> it;

    @Before
    public void setUp() {
        it = new EvenIt(new int[] {4, 2, 1, 1});
    }

    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(2));
    }

    @Test
    public void transcendentalHasNextInvocationDentAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(2));
    }
}