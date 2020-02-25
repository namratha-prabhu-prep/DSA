package ArraysAndStrings;

import org.junit.Test;
import static org.junit.Assert.*;

public class PermutationTest {
    @Test
    public void isPermutationWithStringsOfDiffLengths() {
        String str1 = "hell";
        String str2 = "ell";
        Permutation perm = new Permutation();
        assertFalse(perm.isPermutation(str1,str2));
    }
}
