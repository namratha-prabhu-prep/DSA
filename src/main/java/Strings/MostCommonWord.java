package Strings;


import java.util.*;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> bannedList = Arrays.asList(banned);
        paragraph = paragraph.toLowerCase();
        Map<String, Integer> map = new HashMap();
        StringBuilder sb = new StringBuilder();
        String finalWord = "";
        int ansFreq = 0;
        String ans ="";

        char[] charArr = paragraph.toCharArray();

        for(int i = 0; i < charArr.length; i++) {
            if(Character.isLetter(charArr[i])) {
                sb.append(charArr[i]);
                System.out.println(sb.toString());
            } else if(sb.length() > 0) {
                finalWord = sb.toString();
                System.out.println(finalWord);
                if(!bannedList.contains(finalWord)) {
                    map.put(finalWord, map.getOrDefault(finalWord, 0)+1);

                    if(map.get(finalWord) > ansFreq) {
                        ansFreq = map.get(finalWord);
                        ans = finalWord;
                    }
                }
                // to reset the sb to empty
                sb = new StringBuilder();
            }
        }
        return ans;
    }

    // Alternate approach
    public String mostCommonWordNew(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap();
        String para = paragraph.replaceAll(",", " ");
        String[] words = para.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase().split("\\s+");
        // Use set instead of list because, list takes O(n) for search, where as set takes O(1)
        Set<String> bannedSet = new HashSet(Arrays.asList(banned));

        for(String word : words) {
            if(!bannedSet.contains(word)) {
                map.put(word, map.getOrDefault(word, 0)+1);
            }
        }
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        MostCommonWord commonWord = new MostCommonWord();
//        System.out.println(commonWord.mostCommonWord(
//                "Bob",
//                new String[]{}));
        System.out.println(commonWord.mostCommonWordNew(
                "Bob hit a ball, the hit BALL flew far after it was hit.",
                new String[]{"hit"}));
        System.out.println(commonWord.mostCommonWordNew(
                "a, a, a, a, b,b,b,c, c",
                new String[]{"a"}));

    }
}