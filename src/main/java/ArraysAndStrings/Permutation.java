package ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class Permutation {
//    // Solution 1: Sort the strings and compare to see if they are equal
//    public String sortString(String s){
//        char[] content = s.toCharArray();
//        java.util.Arrays.sort(content);
//        return new String(content);
//    }
//    public boolean permOrNot(String s, String t){
//        if(s.length() != t.length()){
//            return false;
//        }
//        return sortString(s).equals(sortString(t));
//    }
//
//    // Solution 2: Create an array of size 128, increment the char location if found in s, decrement if found in t
//    public boolean permOrNotAnswer2(String s, String t){
//        if(s.length() != t.length()){
//            return false;
//        }
//
//        int[] charArray = new int[128];
//        char[] s_array = s.toCharArray();
//        for(char c : s_array){
//            charArray[c]++;
//        }
//
//        for(int i = 0; i < t.length(); i++){
//            int c = (int) t.charAt(i); // get the char at i and then convert it to int, which gives the ASCII value of that character
//            charArray[c]--;
//            if(charArray[c] < 0){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static void main(String[] args) {
//        Permutation perm = new Permutation();
//        System.out.println(perm.permOrNot("nas", "man"));
//        System.out.println("=================");
//        System.out.println(perm.permOrNotAnswer2("nam", "man"));
//    }

    public Boolean isPermutation(String s1, String s2) {
        Map<Character, Integer> map = new HashMap(26);
        for(char c : s1.toCharArray()) {
            map.put(c, 1);
        }
        if(s1.length() != s2.length()) return false;
        for(char c : s2.toCharArray()) {
            if(map.get(c) == null) {
                System.out.println(c);
                return false;
            }
        }
        System.out.println(map);
        return true;
    }

    public static void main(String[] args) {
        Permutation perm = new Permutation();
        System.out.println(perm.isPermutation("hell", "hellm"));
    }


































}

