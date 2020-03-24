package Strings;

public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] values = new int[] {
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };
        StringBuilder sb = new StringBuilder();
        for (int val : values) {
            if (val > num) continue;
            int numSymbol = num / val;
            while (numSymbol > 0) {
                sb.append(getSymbol(val));
                numSymbol -= 1;
            }
            num %= val;
        }
        return sb.toString();
    }

    private String getSymbol(int val) {
        if (val == 1)    return "I";
        if (val == 5)    return "V";
        if (val == 10)   return "X";
        if (val == 50)   return "L";
        if (val == 100)  return "C";
        if (val == 500)  return "D";
        if (val == 1000) return "M";
        if (val == 4)    return "IV";
        if (val == 9)    return "IX";
        if (val == 40)   return "XL";
        if (val == 90)   return "XC";
        if (val == 400)  return "CD";
        if (val == 900)  return "CM";
        throw new IllegalArgumentException("Unsupported Value");
    }
}
