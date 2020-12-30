package DataType;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class CollectionsTest {
    @Test
    public void test1() {
        Integer[] arr = {3, 7, -1, 4};
        System.out.println(Collections.max(Arrays.asList(arr)));
    }

}
