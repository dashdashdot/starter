package org.gnw.jstacker;

import junit.framework.Assert;

import org.junit.Test;

public class TestSub {

    @Test
    public void testSub() throws Exception {
        Parser parser = new Parser();
        Stack stack = parser.parse("3 2 sub");
        Assert.assertEquals(1, stack.size());
        Assert.assertEquals(1.0, Double.valueOf(stack.pop()));
    }

    @Test(expected = ParserException.class)
    public void testSubBroken() throws Exception {
        new Parser().parse("1 sub");
    }
}
