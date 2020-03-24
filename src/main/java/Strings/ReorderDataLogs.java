package Strings;

import java.util.Arrays;

/*
937. Reorder Data in Log Files

You have an array of logs.  Each log is a space delimited string of words.
For each log, the first word in each log is an alphanumeric identifier.  Then, either:
Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier,
with the identifier used in case of ties.  The digit-logs should be put in their original order.
Return the final order of the logs.

Example 1:
Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 */
public class ReorderDataLogs {
    public String[] reorderLogFiles(String[] logs) {
        // This algo sorts the arr in place
        // 1. Sort the array by splitting each log in to an array of two elements
        // 2. Find out if the second element of the above split arrays is a digit or character
        // 3. if they are nt a digit then compare the second element of the split arrays
        // 4. if they are the same, compare the identifier and return the value of that
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if(!isDigit1 && !isDigit2) {
                int compare = split1[1].compareTo(split2[1]);
                // if compare == 0, means split1[1] and split2[1] are equal
                // if positive, split1[1] > split2[1]
                // if negative, split1[1] < split2[1]
                if(compare != 0) return compare;
                // At this point it means that compare is zero, which means split1[1] == split2[1]
                // so we have to comapre the identifiers
                return split1[0].compareTo(split2[0]);
            }
            // At this point, isDigit1 or isDigit1 is true or both are true which means they might a digit
            // here we return,
            // 1. 0 if isDigit2 is true and isDigit1 is true, which means both are digits and no need of sorting
            // 2. 1 if isDigit1 is true and isDigit2 is false, which means isDigit1 is a digit and isDigit2 is not. 1 is
            // returned so that we can bring the letter log to the front (isDigit2)
            // 3. -1 if isDigit1 is false, because when it is false, it automatically means that isDigit2 is true,
            // because if both were false then it would have inside the if statement on line 13 and it wouldn't have executed the below code.
            return isDigit1 ? (isDigit2 ? 0 : 1 ) : -1;
        });
        return logs;
        /*
        TC: O(nlogn), because of merge sort
        SC: O(n)
         */
    }
}
