package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingletonStaticFinalClassLazyTest {

    @Test
    public void whenTrackerSingletonStaticFinalClassLazyTest() {
        Tracker tracker = TrackerSingletonStaticFinalClassLazy.getInstance();
        Tracker expect = TrackerSingletonStaticFinalClassLazy.getInstance();
        assertThat(tracker, is(expect));
    }
}
