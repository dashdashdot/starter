package org.gnw.jstacker;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestClear {

    @Test
    public void testClear() throws Exception {
        Stack stack = new Parser().parse("a b c clear");
        assertEquals(0, stack.size());
    }

}
