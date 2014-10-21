package org.gnw.jstacker;

import junit.framework.Assert;

import org.junit.Test;

public class TestDiv {

    @Test
    public void testDiv() throws Exception {
        Parser parser = new Parser();
        Stack stack = parser.parse("8 2 div");
        Assert.assertEquals(1, stack.size());
        Assert.assertEquals(4.0, Double.valueOf(stack.pop()));
    }

    @Test(expected = ParserException.class)
    public void testDivBroken() throws Exception {
        new Parser().parse("1 div");
    }
}
