import java.util.*;

/**
 * Finds and returns the nearby elements from a two-dimensional int array.
 */
public class nearbyArray {
    private static int[][] multi = new int[][]{
        { 2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323 },
        { 1, 3, 5, 7 },
        { 321, 320, 32, 3, 41241, -11, -12, -13, -66, -688 }
    };


    /**
     *
     * @param length total length of the array to be created
     * @param start1 position of start of the new array (first element)
     * @param end1 position of target element (excluded from output)
     * @param start2 position of first element after the excluded element
     * @param end2 position where the created array stops
     * @param arrayToSearch original array from which to create new array
     * @return int[] array
     */
    private static int[] createArray(int length, int start1, int end1, int start2, int end2, int[] arrayToSearch) {
        int[] returnArray;
        returnArray = new int[length];
        int counter = 0;
        for (int i=start1; i < end1; i++) {
            returnArray[counter] = arrayToSearch[i];
            counter += 1;
        }
        for (int i=start2; i < end2; i++) {
            returnArray[counter] = arrayToSearch[i];
            counter += 1;
        }
        return returnArray;
    }

    /**
     * @param x - position coordinate of the target array (1st layer)
     * @param y - position coordinate of the target within the array
     * @param range - range of nearby elements +/- around position at y, excluding y
     * @return int[] array with the nearby elements of the target at [x, y] within the maximum "distance" of range (excluding the target element itself)
     */
    public static int[] findNearbyInArray(int x, int y, int range) {
        int totalLengthOfArray = multi[x].length;
        int[] arrayToReturn;

        int length;
        int positionWhereStartBeforeY;
        int positionOfY = y;
        int positionWhereStartAfterY;
        int positionWhereEndNewArray;
        int[] searchArray = multi[x];

        if (y - range >= 0 && y + range <= totalLengthOfArray) {
            length = range * 2;
            positionWhereStartBeforeY = y - range;
            positionWhereStartAfterY = y + 1;
            positionWhereEndNewArray = y + range + 1;
        } else if (y-range < 0 && y+range <= totalLengthOfArray) {
            length = range + y;
            positionWhereStartBeforeY = 0;
            positionWhereStartAfterY = y + 1;
            positionWhereEndNewArray = y + range + 1;
        } else if (y-range >= 0 && y+range > totalLengthOfArray) {
            length = range + y;
            positionWhereStartBeforeY = y - range;
            positionWhereStartAfterY = y + 1;
            positionWhereEndNewArray = totalLengthOfArray - y + 1;
        } else {
            length = totalLengthOfArray - 1;
            positionWhereStartBeforeY = 0;
            positionWhereStartAfterY = y;
            positionWhereEndNewArray = totalLengthOfArray - 1;
        }

        arrayToReturn = createArray(length,positionWhereStartBeforeY, positionOfY, positionWhereStartAfterY, positionWhereEndNewArray, searchArray);
        return arrayToReturn;

    }

    public static void main(String[] args) {
        /*int[] array1 = findNearbyInArray(0 ,2, 2);
        for (int i : array1) {
            System.out.println(i);
        }*/

        System.out.println(Arrays.toString(findNearbyInArray(0 ,2, 2)));
        System.out.println(Arrays.toString(findNearbyInArray(1 ,0, 1)));
        System.out.println(Arrays.toString(findNearbyInArray(1 ,3, 5)));

    }

}
