jStacker
========

This is a simple stack parser that reads an input string from left to right.  Instructions are simple:

1. The input is a space delimited set of tokens
2. If a token isn't a recognised command, it's put on the stack
3. If a token is recognised, then that command is run
4. If a token is wrapped in parentheses, put it all on the stack

The set of known commands is:

|Command|Example  |Result|Description|
|-------|---------|------|-----------|
|pop    |a b pop  |a     |Removes the top most item from the stack|
|swap   |a b swap |b a   |Swaps two elements on the stack|
|dup    |a dup    |a a   |Duplicates the topmost element|
|rev    |a b c rev|c b a |Reverses the stack|
|add    |1 2 add  |3.0   |Adds the top two elements|
|sub    |5 3 sub  |2.0   |Subtracts the topmost from the second top|
|mult   |5 4 mult |20.0  |Multiplies the top two elements|
|div    |20 5 div |4.0   |Divides the top two elements|
|def    |5 x def x 2 mult|10.0|Defines a variable.  In the example 'x' is defined as 5 and then multiplied by 2.|
|while  |(command) n while|...|While the topmost element on the stack is greater than zero, keep on running the command.|
