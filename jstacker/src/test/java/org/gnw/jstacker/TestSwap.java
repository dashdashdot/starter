package org.gnw.jstacker;

import junit.framework.Assert;

import org.junit.Test;

public class TestSwap {

    @Test
    public void testSwap() throws Exception {
        Parser parser = new Parser();
        Stack stack = parser.parse("bill fred swap");
        Assert.assertEquals("bill", stack.pop());
        Assert.assertEquals("fred", stack.pop());
        Assert.assertEquals(0, stack.size());
    }
    
    @Test(expected=ParserException.class)
    public void testSwapEmpty() throws Exception {
        new Parser().parse("fred swap");
    }

}
