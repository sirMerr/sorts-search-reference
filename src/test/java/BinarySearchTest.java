import com.tiffanyln.search.BinarySearch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BinarySearchTest {
    // Array to search through
    int[] arrayToSearch;
    // Target int that we want to find
    int target;
    // Expected index
    int expectedIndex;

    public BinarySearchTest(int[] arrayToSearch, int target, int expectedIndex) {
        this.arrayToSearch = arrayToSearch;
        this.target = target;
        this.expectedIndex = expectedIndex;

    }

    @Parameterized.Parameters(name = "{index} plan[{1} -> index: {2}]")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[] {1,2,3}, 1, 0},
                {new int[] {1,2,3,4,5,6,7,8,9,10}, 10, 9},
                {new int[] {1,2,3}, 2, 1},
                {new int[] {1,2,3,4,5,6}, 4, 3},
                {new int[] {1,2,3,4,5,6}, 5, 4},
                {new int[] {1,2,3,4,5,6,7}, 6, 5},
                {new int[] {-1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,50}, 20, -1},
                {new int[] {-1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,50}, 20, -1},
                {new int[] {-1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,34,50}, -30, -1},
                {new int[] {-1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,34,50}, 11, 10},
                {new int[] {-1,2,3,4,5,6,7,8,9,10,11,12,13,15,34,50}, 14, -1}
        });
    }

    @Test
    public void testBinarySearch() {
        int result = new BinarySearch(arrayToSearch, target).search();

        assertEquals(expectedIndex, result, 0);
    }
}
