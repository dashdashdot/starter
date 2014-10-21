package org.gnw.jstacker;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestParser {

    @Test
    public void testBrackets() throws Exception {
        Parser parser = new Parser();
        Stack stack = parser.parse("a b (c d e)");
        assertEquals(3,stack.size());
        assertEquals("a b \"c d e\"",stack.toString());
    }

    @Test
    public void testQuotes() throws Exception {
        Parser parser = new Parser();
        Stack stack = parser.parse("a b \"c d e\"");
        assertEquals(3,stack.size());
        assertEquals("a b \"c d e\"",stack.toString());
    }

    @Test(expected=ParserException.class) 
    public void testUnclosedBrackets() throws Exception {
        new Parser().parse("( a b");
    }
    
    /**
     * Test to see if we can get 1 2 3 ... 10 onto the stack using a while loop.
     */
    @Test
    public void testTill10() throws ParserException {
        Parser parser = new Parser();
        Stack stack = parser.parse("10.0 (dup 1 sub dup) 10.0 while pop rev");
        assertEquals("1.0 2.0 3.0 4.0 5.0 6.0 7.0 8.0 9.0 10.0",stack.toString());
    }

}
