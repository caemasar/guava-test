package idv.caemasar.demo;

/**
 * FormatDateTest
 *
 * @author BISC
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2019
 * @since 2019-04-24
 */
public class FormatDateTest {

    private static final String YEAR_MARK = "年";
    private static final String MOBTH_MARK = "月";
    private static final String DAY_MARK = "日";

    public static void main(String[] args) {
        String cg02006 = "2016年1月8日";
        String yearStr = null;
        String monthStr = null;
        String dayStr = null;
        yearStr = String.format("%02d", Integer.parseInt(cg02006.substring(0, cg02006.indexOf(YEAR_MARK))));
        monthStr = String.format("%02d", Integer.parseInt(cg02006.substring(cg02006.indexOf(YEAR_MARK) + 1, cg02006.indexOf(MOBTH_MARK))));
        dayStr = String.format("%02d", Integer.parseInt(cg02006.substring(cg02006.indexOf(MOBTH_MARK) + 1, cg02006.indexOf(DAY_MARK))));
        System.out.println(yearStr);
        System.out.println(monthStr);
        System.out.println(dayStr);

        System.out.println(new StringBuffer().append(yearStr).append(YEAR_MARK).append(monthStr).append(MOBTH_MARK).append(dayStr).append(DAY_MARK).toString());
    }
}
