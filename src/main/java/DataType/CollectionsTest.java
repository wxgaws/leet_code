package DataType;

import org.junit.Test;

import java.util.*;

public class CollectionsTest {
    @Test
    public void test1() {
        Integer[] arr = {3, 7, -1, 4};
        System.out.println(Collections.max(Arrays.asList(arr)));
    }

    @Test
    public void test2(){
        Map<Integer,Integer>  map=new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        System.out.println(Collections.min(map.values()));
    }

}
