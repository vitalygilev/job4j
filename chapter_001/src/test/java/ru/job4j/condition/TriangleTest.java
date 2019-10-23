package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TriangleTest {
    @Test
    public void whenExist() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 1);
        Point c = new Point(1, 1);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        Assert.assertEquals(0.5, result, 0.01);
    }
}
