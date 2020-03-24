package Strings;

public class ReplaceWhiteSpace {
    public void replace(char[] str, int trueLength){
        //char[] str = s.toCharArray();
        // find number of spaces
        int spaceCount = 0, i = 0;
        for(i = 0; i < trueLength; i++){
            if(str[i] == ' '){ spaceCount++; }
        }
        // * 2 because for one space we replace it by 3 character, which is 2 extra characters
        int index = trueLength + spaceCount * 2; // 25
        // End the array if there are trailing spaces
        if(trueLength < str.length) {
            str[trueLength] = '\0';
        }
        char[] new_char_array = str;
        str = new char[index];
        // start from the last element
        for(i = trueLength - 1; i >= 0; i--){
            if(new_char_array[i] == ' '){
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = new_char_array[i];
                index--;
            }
        }
        System.out.println(str);
    }

    public static void main(String[] args){
        ReplaceWhiteSpace rep = new ReplaceWhiteSpace();
        char[] charArray = "My name is Namratha".toCharArray();
        rep.replace(charArray, charArray.length);
    }
}
