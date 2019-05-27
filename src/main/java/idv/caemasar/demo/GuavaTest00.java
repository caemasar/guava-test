package idv.caemasar.demo;

import com.google.common.base.CaseFormat;

import java.util.Scanner;

/**
 * GuavaTest00
 *
 * @author BISC
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2019
 * @since 2019-01-11
 */
public class GuavaTest00 {
    public static void main(String[] args) throws Exception {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入：");
            String str = sc.nextLine();
            System.out.println(CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, str));
        }

    }
}
