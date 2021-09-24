package com.nirmal.recursion;

import java.util.List;

public class TowerOFHanoi {
    private void towerOfHanoi(int no, String sourceRod,
                              String targetRod, String auxRod) {
        if (no == 1) {
            System.out.println("Move disk " + no + " from rod " +  sourceRod + " to rod " +
                    targetRod);
            return;
        }
        towerOfHanoi(no - 1, sourceRod , auxRod, targetRod);
        System.out.println("Move disk " + no + " from rod " +  sourceRod + " to rod " +
                targetRod);
        towerOfHanoi(no - 1, auxRod, targetRod, sourceRod);
    }
    public static void main(String[] args) {
        int noOfDisks = 3;
        TowerOFHanoi t = new TowerOFHanoi();
        t.towerOfHanoi(noOfDisks, "A","C", "B");
    }
}
