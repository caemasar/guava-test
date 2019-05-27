package idv.caemasar.demo;

import java.util.regex.Pattern;

/**
 * EmTest
 *
 * @author BISC
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2019
 * @since 2019-05-09
 */
public class EmTest {
    public static void main(String[] args) {
//        for (OtherCarderMapType e : OtherCarderMapType.values()) {
//            System.out.println(e==null);
//            System.out.println(e);
//        }
        String HTT = "ATT";

        String pattern = "[A-V]TT";
        System.out.println(Pattern.matches(pattern, HTT));
    }
}
