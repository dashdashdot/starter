package org.gnw.jstacker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestDup {

    @Test
    public void testDup() throws Exception {
        Stack stack = new Parser().parse("a b dup");
        assertEquals("a b b", stack.toString());
    }
}
