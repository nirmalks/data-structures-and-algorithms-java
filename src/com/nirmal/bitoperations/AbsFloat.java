package com.nirmal.bitoperations;

public class AbsFloat {
    public static void main(String[] args) {
        Float f = -35.45f;
        //The constant 0x7FFFFFFF is a 32-bit integer in hexadecimal with all but the highest bit set
        //It's a bitmask. In low-level computation, it's an efficient way to clear out bits of register. In this case, the mask has all bits of a 32 bit integer set, except the signed bit. The signed bit is the bit that determines if the number is positive or negative. ANDing (&) with this mask effectively sets the signed bit to 0, which means the number will always be positive.
        Float absValue = Float.intBitsToFloat(Float.floatToIntBits(f) & 0x7fffffff);
        System.out.println("absvalue" + absValue);
    }
}
