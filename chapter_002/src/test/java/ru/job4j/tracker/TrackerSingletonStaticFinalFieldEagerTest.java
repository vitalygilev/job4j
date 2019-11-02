package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingletonStaticFinalFieldEagerTest {

    @Test
    public void whenTrackerSingletonStaticFinalFieldEager() {
        Tracker tracker = TrackerSingletonStaticFinalFieldEager.getInstance();
        Tracker expect = TrackerSingletonStaticFinalFieldEager.getInstance();
        assertThat(tracker, is(expect));
    }

}
