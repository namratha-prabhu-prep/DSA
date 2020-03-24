package Graphs;

/*
997. Find the Town Judge
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
Example 1:

Input: N = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: N = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3
 */
public class TownJudge {
    public int findJudge(int N, int[][] trust) {
        // If there are N people, then N-1 people must trust one person out of N people, because town judge cannot trust anyone including himself
        // create one array for incrementing for a each indegree and decrementing for each outdegree.
        // whoever has the highest value of this that person is the judge.

        // if the number of edges is smaller than N-1, terminate and return zero
        // because there should be a total N-1 number of inward edges for judge to be valid.
        // So if the number of edges is smaller than N-1 it means that there is no judge
        if (trust.length < N - 1) {
            return -1;
        }

        int[] trustDegree = new int[N+1];
        for(int[] relation : trust) {
            // we can use two arrays as well
            // outDegree[relation[0]]++;
            // inDegree[relation[1]]++;
            trustDegree[relation[0]]--;
            trustDegree[relation[1]]++;
        }

        // Now check for the condition where judge would have 0 outdegree and N-1 indegree
        for(int i = 1; i <= N; i++) {
            // if(outDegree[i] == 0 && inDegree[i] == N-1)
            if(trustDegree[i] == N-1) {
                return i;
            }
        }
        return -1;
    }

    /*
    TC: O(E)
    1. Loop through trust (which is nothing but edges) = O(E)
    2. Loop through person (N) = O(N)
    3. Which is equal to O(max(N,E)) = O(N+E), we add it because we don't know which is greater
       * In best case, E < N-1, then it returns -1 and hence O(1)
       * In worst case, E >= N-1, then ignore constant of 1, hence O(N) , since E >= N
    SC: O(N), because of allocating an array of length N+1
     */
}
