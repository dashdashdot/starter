package org.gnw.jstacker;

import junit.framework.Assert;

import org.junit.Test;

public class TestDef {

    @Test
    public void testDefinition() throws Exception {
        Parser parser = new Parser();
        parser.parse("hello greeting def");
        Assert.assertEquals("hello", parser.getHeap().get("greeting"));
    }

    @Test
    public void testUsage() throws Exception {
        Parser parser = new Parser();
        Stack stack = parser.parse("hello greeting def greeting");
        Assert.assertEquals("hello", stack.toString());
    }
}
