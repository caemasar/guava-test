package idv.caemasar.demo;

import com.google.common.base.CaseFormat;

/**
 * GuavaReverseTest
 *
 * @author BISC
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2018
 * @since 2018-12-24
 */
public class GuavaReverseTest {
    public static void main(String[] args) {
        String[] list = {"decisionNumber",
                "decisionName",
                "punishmentCategorie",
                "",
                "illegalFact",
                "punishmentBasis",
                "administrativeName",
                "creditCode",
                "organizationCode",
                "businessNumber",
                "taxNumber",
                "idcardNumber",
                "punishmentContent",
                "legalPerson",
                "punishmentDecisionDate",
                "punishmentAuthority",
                "currentState",
                "localCode",
                "note",
                "articleId",
                "push",
                "noticePeriod",
                "modifyDate",
                "articleUuid"};

        for (String s : list) {
            System.out.println(CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, s));
        }

    }
}
