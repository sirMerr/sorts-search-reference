package com.tiffanyln.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * In a binary search ( O(logN) ), the array given (assumed sorted in ascending order) is split in half,
 * the target value is compared to the middle value. If it's the same, the target was found at this
 * index (normally {@code true} is returned, in this case we return the index where it was found).
 * If it's smaller, you now ignore all values after and including the middle index and repeat the same steps.
 * If it's greater, you now ignore all values before and including the middle index and repeat the same steps.
 *
 * @author sirMerr
 */
public class BinarySearch {
    private final Logger log = LoggerFactory.getLogger(this.getClass().getName());

    int[] arrToSearch;
    int target;

    public BinarySearch(int[] arrToSearch, int target) {
        this.arrToSearch = arrToSearch;
        this.target = target;
    }

    /**
     * Does a binary search to find the given target {@code int} and
     * returns the index where it was found or -1.
     *
     * @return int
     *      -1 if not found or invalid target or array
     *      or index of the target in the array
     */
    public int search() {
        log.debug("\n");
        log.debug("target: " + target + " arrToSearch: " + Arrays.toString(arrToSearch));

        if (isValid()) {
            int lowerLimit = 0;
            // -1 because we start at 0
            int upperLimit = arrToSearch.length - 1;

            // If the lower limit is bigger than the upper limit,
            // that means that the target is between two existing values, but does
            // not exist itself;
            while (upperLimit >= lowerLimit) {
                log.debug("upperLimit: " + upperLimit + " >= " + "lowerLimit: " + lowerLimit);
                int middleIndex = (upperLimit + lowerLimit) / 2;
                int middleValue = arrToSearch[middleIndex];
                log.debug("new middleIndex: " + middleIndex + " and middleValue: " + middleValue);

                if (middleValue == target) {
                    // Here, we have found the target and return where it is in the array
                    return middleIndex;
                } else if (target > middleValue) {
                    // We do +1 because we do not want to take in account the middleValue
                    // as we have determined the target value is higher than it
                    lowerLimit = middleIndex + 1;
                    log.debug("(target > middleValue) new lowerLimit: " + lowerLimit);
                } else {
                    // We do -1 because we do not want to take in account the middleValue
                    // as we have determined the target value is lower than it
                    upperLimit = middleIndex - 1;
                    log.debug("(target < middleValue) new upperLimit: " + upperLimit);
                }
            }
        }

        // Either invalid or not found
        return  -1;

    }

    /**
     * Checks if the array if null or empty
     *
     * @return boolean
     *      true if valid (array is nor null, nor empty)
     *      false if invalid
     */
    private boolean isValid() {
        return arrToSearch != null && arrToSearch.length != 0;
    }
}
