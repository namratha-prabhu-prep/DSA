package ArraysAndStrings;

// LeetCode: https://leetcode.com/problems/remove-outermost-parentheses/
public class RemoveOutermostParenthesis {
    // Solution: Primitive string will have equal number of opened and closed parenthesis.
    // Add every char to the result string, except the left most and the right most
    // Keep count of opened brackets and decrement opened when you find closing bracket
    public String removeOuterParentheses(String S){
        int opened = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for(char c : S.toCharArray()){
            if(c == '(' && opened++ > 0) stringBuilder.append(c);
            if(c == ')' && opened-- > 1) stringBuilder.append(c);
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public String removeDuplicates(String S) {
        StringBuilder strBuilder = new StringBuilder();
        int length = S.length();
        char[] arr = S.toCharArray();
        for(int i = 0; i < S.length(); i++){
            if (arr[i] == ' ') continue;
            if(arr[i] == arr[i+1]){
                arr[i] = ' ';
                arr[i+1] = ' ';
            }
        }
        for(char c : arr){
            if(c != ' '){
                strBuilder.append(c);
            }
        }
        return strBuilder.toString();
    }

    public static void main(String[] args) {
        RemoveOutermostParenthesis para = new RemoveOutermostParenthesis();
//        String str = "(()())(())(()(()))";
//        String str2 = "()()";
//        para.removeOuterParentheses(str);
//        System.out.println("()() => " + para.removeOuterParentheses(str2));
        System.out.println(para.removeOuterParentheses("abbaca"));
    }

}
