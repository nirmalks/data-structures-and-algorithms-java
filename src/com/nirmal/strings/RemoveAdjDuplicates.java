package com.nirmal.strings;

public class RemoveAdjDuplicates {
    public static void main(String[] args) {
        RemoveAdjDuplicates ra = new RemoveAdjDuplicates();
        String str = "azxxzy";
        System.out.println(ra.removeAdjDuplicates(str,'\0'));
    }

    private String removeAdjDuplicates(String str, char lastRemoved) {
        if (str.length() == 0 || str.length() == 1)
            return str;

        if (str.charAt(0) == str.charAt(1)) {
            lastRemoved = str.charAt(0);
            while (str.length() > 1 && str.charAt(0) == str.charAt(1))
                str = str.substring(1);
            str = str.substring(1);
            return removeAdjDuplicates(str,lastRemoved);
        }
        String remainingStr = removeAdjDuplicates(str.substring(1), lastRemoved);
        if (remainingStr.length() != 0 && str.charAt(0) == remainingStr.charAt(0)) {
            return remainingStr.substring(1);
        }
        if (remainingStr.isEmpty() && lastRemoved == str.charAt(0)) {
            return remainingStr;
        }
        return str.charAt(0) + remainingStr;
    }
}
