package idv.caemasar.demo;


/**
 * 其他干部类型
 *
 * @author hyj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2018
 * @since 2018年4月12日
 */
public enum OtherCarderMapType {
    /**
     * 后备干部
     */
    AC01001B(1, "后备干部"),
    /**
     * 选调生
     */
    AC01002B(2, "选调生"),
    /**
     * 是否秘书
     */
    AC01003B(3, "领导秘书"),
    /**
     * 师职转业干部
     */
    AC01004B(4, "师职转业干部"),
    /**
     * 挂职干部
     */
    AC01005B(5, "挂职干部"),
    /**
     * 优秀年轻干部
     */
    AC01070B(6, "优秀年轻干部"),
    /**
     * 援藏干部人才
     */
    AC01071B(7, "援藏干部人才"),
    /**
     * 援疆干部人才
     */
    AC01072B(8, "援疆干部人才"),
    /**
     * 援川干部人才
     */
    AC01073B(9, "援川干部人才"),
    /**
     * 东西部扶贫协作干部人才
     */
    AC01074B(0, "东西部扶贫协作干部人才");

    /**
     * 是这个干部类型的数据字典
     */
    public static final String IS = "01";

    /**
     * 获取当前序号
     */
    private final int number;
    /**
     * 获取当前序号对应的中文名
     */
    private final String content;

    /**
     * 获取当前序号
     */
    OtherCarderMapType(int number, String content) {
        this.number = number;
        this.content = content;
    }

    /**
     * 当前序号的值
     */
    public int getNumber() {
        return number;
    }

    /**
     * 当前序号对应的中文名的值
     */
    public String getContent() {
        return content;
    }

    /**
     * 校验值是否在枚举里面存在
     *
     * @param number 字典的值
     * @return 是否存在
     * @author hyj
     * @since 2018年4月12日
     */
    public static boolean hasExist(int number) {
        for (OtherCarderMapType e : OtherCarderMapType.values()) {
            if (e.getNumber() == number) {
                return true;
            }
        }

        return false;
    }
}