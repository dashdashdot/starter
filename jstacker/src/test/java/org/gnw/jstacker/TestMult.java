package org.gnw.jstacker;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMult {

    @Test
    public void testMult() throws Exception {
        Stack stack = new Parser().parse("5 5 mult");
        assertEquals(25.0, Double.parseDouble(stack.pop()), 0.01);
    }
}
