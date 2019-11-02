package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingletonEnumEagerTest {

    @Test
    public void whenTrackerSingletonEnumEager() {
        TrackerSingletonEnumEager tracker = TrackerSingletonEnumEager.INSTANCE;
        TrackerSingletonEnumEager expect = TrackerSingletonEnumEager.INSTANCE;
        assertThat(tracker, is(expect));
    }
}
