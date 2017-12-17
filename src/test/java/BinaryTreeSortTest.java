import com.oracle.tools.packager.Log;
import com.tiffanyln.sort.BinaryTreeSort;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;

import static org.junit.Assert.assertSame;

@RunWith(Parameterized.class)
public class BinaryTreeSortTest {
    // Array to search through
    LinkedHashSet<Integer> setToSort;
    // Target int that we want to find
    String expectedSortedAsc;

    public BinaryTreeSortTest(LinkedHashSet<Integer> setToSort, String expectedSortedAsc) {
        this.setToSort = setToSort;
        this.expectedSortedAsc = expectedSortedAsc;
    }

    @Parameterized.Parameters(name = "{index} plan[{0} -> {1}]")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new LinkedHashSet<>(Arrays.asList(3,7,40,33,5,2,-6,7,32,42,10)), "-6,2,3,5,7,10,32,33,40,42"}
        });
    }

    @Test
    public void testBinaryTreeSort() {
        BinaryTreeSort binaryTreeSort = new BinaryTreeSort(setToSort);
        binaryTreeSort.sort();
        String result = binaryTreeSort.displayAsc(binaryTreeSort.root);

        assertSame(expectedSortedAsc, result);
    }
}
