import java.util.*;

/**
 * @author bin
 * @date 2022-12-01-16:26
 */
public class SetList {

    public static void main(String[] args) {

        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("a", 1);
        hashMap.put("b", 2);


        Set<String> keys = hashMap.keySet();

//        for (String key : keys) {
//            if("a".equals(key)) {
//                hashMap.remove("a");
//            }
//        }
        System.out.println(keys.toString());

        hashMap.remove("a");

        System.out.println(hashMap.get("a"));

        System.out.println(keys.toString());

        int[] is = {1, 2, 3};
        int[] is2 = {3, 2, 1};
        Arrays.sort(is2);
        System.out.println(Arrays.equals(is, is2));

        System.out.println("-----------------");

        /**
         * ArrayList, LinkedList 不能越过数据长度取值
         * 普通数组可以根据数组长度取值
         */

        ArrayList<String> arrayList = new ArrayList<>(10);
        arrayList.add("1");

//        System.out.println(arrayList.get(1));

        LinkedList<String> strings = new LinkedList<>();

//        strings.add("a");
//        System.out.println(strings.getFirst());

        String[] str = new String[10];
        System.out.println(str[9]);

    }
}
