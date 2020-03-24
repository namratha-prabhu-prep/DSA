package Strings;

import java.util.ArrayList;
import java.util.List;

public class IsStringUnique {
    public Boolean isUnique(String str) {
        List<Character> list = new ArrayList<>();
        for(char c : str.toCharArray()) {
            if(list.contains(c)) {
                return false;
            }
            list.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        IsStringUnique isStringUnique = new IsStringUnique();
        System.out.println(isStringUnique.isUnique("StringS"));
    }

}
