package array;


import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;


/*
Given 2 int arrays a[]={1,2,3,4,5} and b[]={0,1,2,2,3}
where b is the array of index
where a.length=b.length

We need to create a new array res where res[b[i]]= a[i]
where if res[b[i]] contains an element already,we need to move it to the right

In the above example
res = {1,2,4,5,3}
 */
public class IntegerArrayABToRes {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {0, 1, 2, 2, 2};

        Arrays.stream(new IntegerArrayABToRes().replaceAiWithBi(a, b))
                .forEach(System.out::print);
        System.out.println(" ");

        b = new int[]{0, 1, 2, 2, 3};
        Arrays.stream(new IntegerArrayABToRes().replaceAiWithBi(a, b))
                .forEach(System.out::print);
    }

    private int[] replaceAiWithBi(int[] a, int[] b) {
        Map<Integer, Integer> mapInteger = new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            if (mapInteger.get(b[i]) != null) {
                reverseMap(mapInteger, b[i]);
            }
            mapInteger.put(b[i], a[i]);
        }
        return mapInteger.values().stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private void reverseMap(Map<Integer, Integer> mapInteger, int i) {
        if (mapInteger.get(i) == null) {
            mapInteger.put(i, mapInteger.get(i - 1));
            return;
        }
        reverseMap(mapInteger, i + 1);
        mapInteger.put(i, mapInteger.get(i - 1));
    }
}


