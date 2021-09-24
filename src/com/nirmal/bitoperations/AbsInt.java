package com.nirmal.bitoperations;

public class AbsInt {
    public static void main(String[] args) {
        int i = -35;
     //   https://stackoverflow.com/questions/21923791/how-to-get-absolute-value-of-a-number-in-java-using-bit-manipulation
       /* In our case x is shifted arithmetically 31 times to the right which basically erases its value
and spreads the highest bit. That means, line 3 evaluates either to 0x00000000 (→ 0) or
0xFFFFFFFF (→ −1).
Note: 32 bit systems require a shift by 31, 64 bit systems require a shift by 63 accordingly.

Consequently, line 4 turns out to be (x XOR 0) − 0 for positive values of x (including x=0).
x XOR 0 is still x and x − 0 remains x, too. So for positive x we get x ≥ 0 → x.

We saw that for negative values of x, bit31 is set to 0xFFFFFFFF.
Line 4 is then (x XOR 0xFFFFFFFF) − 0xFFFFFFFF. The bracketed XOR is equivalent to NOT(x) and
the constant −0xFFFFFFFF turns out to be −(-1) = +1.
In the end, the whole term is NOT(x) + 1, exactly what we wanted: for x < 0 → NOT(x) + 1
*/
       int bit31 = i >> 31;
        i = (i ^ bit31) - bit31;
        System.out.println("absvalue" + i);
    }
}
