import java.util.*;

public class nearbyArray {
    private static int[][] multi = new int[][]{
        { 2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323 },
        { 1, 3, 5, 7 },
        { 321, 320, 32, 3, 41241, -11, -12, -13, -66, -688 }
    };

    public static int[] findNearbyInArray(int x, int y, int range) {
        int totalLengthOfArray = multi[x].length;
        int[] arrayToReturn;
        if (y-range >= 0 && y+range <= totalLengthOfArray) {
            arrayToReturn = new int[range*2];

            int counter = 0;
            for (int i=y-range; i < y; i++) {
                arrayToReturn[counter] = multi[x][i];
                counter += 1;
            }
            for (int i=y+1; i < y+1+range; i++) {
                arrayToReturn[counter] = multi[x][i];
                counter += 1;
            }
        } else if (y-range < 0 && y+range <= totalLengthOfArray) {
            arrayToReturn = new int[range + y];

            int counter = 0;
            for (int i=0; i < y; i++) {
                arrayToReturn[counter] = multi[x][i];
                counter += 1;
            }
            for (int i=y+1; i < y+1+range; i++) {
                arrayToReturn[counter] = multi[x][i];
                counter += 1;
            }
        } else if (y-range >= 0 && y+range > totalLengthOfArray) {
            arrayToReturn = new int[range + y];

            int counter = 0;
            for (int i=y-range; i < y; i++) {
                arrayToReturn[counter] = multi[x][i];
                counter += 1;
            }
            for (int i=y+1; i < totalLengthOfArray-y+1; i++) {
                arrayToReturn[counter] = multi[x][i];
                counter += 1;
            }
        } else {
            arrayToReturn = new int[totalLengthOfArray-1];
            int counter = 0;
            for (int i=0; i < y; i++) {
                arrayToReturn[counter] = multi[x][i];
                counter += 1;
            }
            for (int i=y; i < totalLengthOfArray-1; i++) {
                arrayToReturn[counter] = multi[x][i];
                counter += 1;
            }
        }

        return arrayToReturn;

    }

    public static void main(String[] args) {
        int[] array1 = findNearbyInArray(0 ,2, 2);
        for (int i : array1) {
            System.out.println(i);
        }

        System.out.println(Arrays.toString(findNearbyInArray(0 ,2, 2)));
        System.out.println(Arrays.toString(findNearbyInArray(1 ,0, 1)));
        System.out.println(Arrays.toString(findNearbyInArray(1 ,3, 5)));

    }

}
