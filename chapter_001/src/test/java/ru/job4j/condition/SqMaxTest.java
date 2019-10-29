package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SqMaxTest {

    @Test
    public void whenFstMax() {
        assertThat(
                SqMax.max(4, 3),
                is(4)
        );
    }

    @Test
    public void whenSndMax() {
        assertThat(
                SqMax.max(0, 3, 2),
                is(3)
        );
    }

    @Test
    public void whenThdMax() {
        assertThat(
                SqMax.max(0, 0, 2, 1),
                is(2)
        );
    }

    @Test
    public void whenFourMax() {
        assertThat(
                SqMax.max(0, 0, 0, 1),
                is(1)
        );
    }

    @Test
    public void whenFourMax1() {
        assertThat(
                SqMax.max(8, 3, 4, 1),
                is(8)
        );
    }

    @Test
    public void whenFourMax2() {
        assertThat(
                SqMax.max(4, 8, 3, 1),
                is(8)
        );
    }

    @Test
    public void whenFourMax3() {
        assertThat(
                SqMax.max(4, 3, 8, 1),
                is(8)
        );
    }

    @Test
    public void whenFourMax4() {
        assertThat(
                SqMax.max(4, 3, 8, 9),
                is(9)
        );
    }

}
