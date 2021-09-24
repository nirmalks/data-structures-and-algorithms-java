package com.nirmal.bitoperations;

public class BitManipulation {
    public int setBit(int x , int position) {
        int mask = 0b00000001 << position;
        return x | mask;
    }

    public int clearBit(int x, int position) {
        int mask = 0b00000001 << position;
        return x & ~mask;
    }

    public int flipBit(int x, int position) {
        int mask = 0b00000001 << position;
        return x ^ mask;
    }

    public int isBitSet(int x, int position) {
        int shifted = x >> position;
        return shifted & 1;
    }

    public int modifyBit(int x, int position, int state) {
        int mask = 1 << position;
        return (x & ~mask) | (-state & mask);
    }

    public boolean isEven(int x) {
        int result = x & 1;
        if(result == 0) {
            return true;
        }else {
            return false;
        }
    }

    public boolean isPowerOfTwo(int x) {
        int result = x & x - 1;
        if(result == 0) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        BitManipulation bm = new BitManipulation();
        int res = bm.setBit(0b00000000, 2);
        System.out.println("result " + res);
        int clearBitResult = bm.clearBit(0b00001001,3);
        System.out.println("clearbit result " + clearBitResult);
        int flipBitResult = bm.flipBit(0b00000001,3);
        System.out.println("flipbit result " + flipBitResult);
        int isBitSettResult = bm.isBitSet(0b00000001,5);
        System.out.println("isBitSett result " + isBitSettResult);
        int setBitByModify = bm.modifyBit(0b00000001,1, 0b00000001);
        System.out.println("setbitmodify result " + setBitByModify);
        int clearBitByModify = bm.modifyBit(0b00000001,0, 0b00000000);
        System.out.println("clearbitmodify result " + clearBitByModify);
        System.out.println("is even result " + bm.isEven(0b00000010));
        System.out.println("is power of two " + bm.isPowerOfTwo(0b00000011));
    }
}
