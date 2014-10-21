package org.gnw.jstacker;

import junit.framework.Assert;

import org.junit.Test;

public class TestAdd {

    @Test
    public void testAdd() throws Exception {
        Parser parser = new Parser();
        Stack stack = parser.parse("1 2 add");
        Assert.assertEquals(1, stack.size());
        Assert.assertEquals(3.0, Double.valueOf(stack.pop()));
    }

    @Test(expected = ParserException.class)
    public void testAddBroken() throws Exception {
        new Parser().parse("1 add");
    }

}
