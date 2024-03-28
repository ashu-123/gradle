package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    void testMe() {
        Assertions.assertTrue(5==5);
    }

    @Test
    @Disabled
    void testMyself() {
        Assertions.assertTrue(5==7);
    }
}
