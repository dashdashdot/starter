package org.gnw.jstacker;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

public class TestPop extends TestCase {

    @Test
    public void testEmptyPop() throws Exception {
        Parser parser = new Parser();
        Stack stack = parser.parse("pop");
        Assert.assertEquals(0, stack.size());
    }

    public void testPop() throws Exception {
        Parser parser = new Parser();
        Stack stack = parser.parse("1 2 3 pop");
        Assert.assertEquals(2, stack.size());
        Assert.assertEquals("2", stack.pop());
        Assert.assertEquals("1", stack.pop());
    }
}
