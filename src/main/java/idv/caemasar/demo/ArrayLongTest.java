package idv.caemasar.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayLongTest
 * 
 * @copyright 广州明动软件有限公司 Copyright (c) 2019
 * @since 2019-04-26
 * @author BISC
 * @version 1.0
 */
public class ArrayLongTest {
    public static void main(String[] args) {
        List<Long> longs = new ArrayList<>();
        longs.add(new Long(1L));
        longs.add(new Long(1L));
        longs.add(new Long(1L));
        longs.add(new Long(1L));
        longs.add(new Long(2L));
        longs.add(new Long(3L));
        longs.add(new Long(4L));
        longs.add(new Long(5L));
        System.out.println(longs);
        System.out.println(longs.contains(3L));
    }
}
