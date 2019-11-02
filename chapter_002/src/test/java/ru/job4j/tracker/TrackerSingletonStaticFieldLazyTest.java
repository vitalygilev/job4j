package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingletonStaticFieldLazyTest {

    @Test
    public void whenTrackerSingletonStaticFieldLazy() {
        Tracker tracker = TrackerSingletonStaticFieldLazy.getInstance();
        Tracker expect = TrackerSingletonStaticFieldLazy.getInstance();
        assertThat(tracker, is(expect));
    }

}
