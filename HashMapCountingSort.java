import java.util.*;

public class Solution {

    /**
     * Sorts integer values by adding them to a
     * hashmap with a key relative to the max value.
     */
    public static void main(String args[]) {

        ///////////////////
        //Unrelated setup//
        ///////////////////

        HashMap<Double, Integer> valStore = new HashMap<>();

        int size = 10;
        int[] arrayValues = new int[size];

        for (int i = 0; i < size; i++) {
            arrayValues[i] = i;
        }

        //shuffling the array...
        List<Integer> tmpList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            tmpList.add(arrayValues[i]);
        }

        Collections.shuffle(tmpList);

        for (int i = 0; i < size; i++) {
            arrayValues[i] = tmpList.get(i);
            System.out.print(arrayValues[i] + ",");
        }


        ///////////
        //HashMapSort//
        ///////////

        int min = arrayValues[0], max = arrayValues[0];
        System.out.print("\n max---> " + max + ",  min--->" + min);
        //Sets min and max values for the array
        for (int i = 1; i < size; i++) {
            if (arrayValues[i] < min) {
                min = arrayValues[i];
            }
            if (arrayValues[i] > max) {
                max = arrayValues[i];
            }
        }

        System.out.print("\n max " + max + ",  min " + min);
        //Adds values to the hashmap, using val/max as the key
        for (int i = 0; i < size; i++) {
            valStore.put((double) arrayValues[i] / max, arrayValues[i]);
            System.out.print("\n arrayValues=" + arrayValues[i] + "/ Max =" + max + "= " + arrayValues[i] / max + "," + arrayValues[i]);
        }

        //Starts at min value, checking each val from min to max.
        //Adds element to array if valExistCheck/max is a key
        System.out.print("\n");
        for (int valExistCheck = min, index = 0; valExistCheck <= max && index < size; valExistCheck++) {
            if (valStore.containsKey((double) valExistCheck / max)) {
                arrayValues[index] = valStore.get((double) valExistCheck / max);
                System.out.print(arrayValues[index] + ",");
                index++;
            }
        }

        ///////
        //End//
        ///////
        System.out.print("\n\n\n");
        for (int i = 0; i < size; i++) {
            System.out.print(arrayValues[i] + ",");
        }

    }

}
