package com.google.solution.accident;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;


@Getter
@ToString
public class AccidentApiQueryParameter {

    @NotNull
    private String ServiceKey;

    @NotNull
    private Integer searchYearCd;

    @NotNull
    private String siDo;

    @NotNull
    private String guGun;

    @NotNull
    private String type = "json";

    @NotNull
    private Integer numOfRows = 10;

    @NotNull
    private Integer pageNo = 1;

    public AccidentApiQueryParameter(String ServiceKey, Integer searchYearCd, String siDo, String guGun) {
        this.ServiceKey = ServiceKey;
        this.searchYearCd = searchYearCd;
        this.siDo = siDo;
        this.guGun = guGun;
    }

    public AccidentApiQueryParameter(String ServiceKey, Integer searchYearCd, String siDo, String guGun, Integer numOfRows, Integer pageNo) {
        this.ServiceKey = ServiceKey;
        this.searchYearCd = searchYearCd;
        this.siDo = siDo;
        this.guGun = guGun;
        this.numOfRows = numOfRows;
        this.pageNo = pageNo;
    }

}
