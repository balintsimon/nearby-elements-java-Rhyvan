import java.util.*;

public class nearbyArray {
    private static int[][] multi = new int[][]{
        { 2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323 },
        { 1, 3, 5, 7 },
        { 321, 320, 32, 3, 41241, -11, -12, -13, -66, -688 }
    };

    private static int[] createArray(int length, int start1, int end1, int start2, int end2, int[] array) {
        int[] returnArray;
        returnArray = new int[length];
        int counter = 0;
        for (int i=start1; i < end1; i++) {
            returnArray[counter] = array[i];
            counter += 1;
        }
        for (int i=start2; i < end2; i++) {
            returnArray[counter] = array[i];
            counter += 1;
        }
        return returnArray;
    }

    public static int[] findNearbyInArray(int x, int y, int range) {
        int totalLengthOfArray = multi[x].length;
        int[] arrayToReturn;
        if (y-range >= 0 && y+range <= totalLengthOfArray) {
            arrayToReturn = createArray(range*2, y-range, y, y+1, y+1+range, multi[x]);
        } else if (y-range < 0 && y+range <= totalLengthOfArray) {
            arrayToReturn = createArray(range+y, 0, y, y+1, y+1+range, multi[x]);
        } else if (y-range >= 0 && y+range > totalLengthOfArray) {
            arrayToReturn = createArray(range+y, y-range, y, y+1, totalLengthOfArray-y+1, multi[x]);
        } else {
            arrayToReturn = createArray(totalLengthOfArray-1, 0, y, y, totalLengthOfArray-1, multi[x]);
        }

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
