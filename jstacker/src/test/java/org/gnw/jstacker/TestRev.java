package org.gnw.jstacker;

import junit.framework.Assert;

import org.junit.Test;

public class TestRev {

    @Test
    public void testRev() throws Exception {
        Parser parser = new Parser();
        Stack stack = parser.parse("a b c d rev");
        Assert.assertEquals("d c b a", stack.toString());
    }
    
    public void testEmpty() throws Exception {
        Parser parser = new Parser();
        Stack stack = parser.parse("rev");
        Assert.assertEquals(0,stack.size());
    }

}
