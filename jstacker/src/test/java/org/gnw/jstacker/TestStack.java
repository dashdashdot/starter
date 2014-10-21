package org.gnw.jstacker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestStack {

    @Test
    public void testPush() {
        Stack stack = new Stack();
        stack.push("a");
        stack.push("b");
        assertEquals("a b", stack.toString());
    }

}
