package com.erica.project.apply.dto.employer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Getter
@Setter
public class Request_JobPostDto {

    private String employer_id;

    // 가게이름
    @NotEmpty(message = "가게명을 입력하세요.")
    private String employerCompname;

    // 시급
    @NotNull(message = "시급을 입력하세요.")
    private int salaryPerTime;

    // 지역
    @NotEmpty(message = "지역을 입력하세요.")
    private String location;

    // 날짜
    @NotNull(message = "근무일을 입력하세요.")
    private Date workDate;

    // 시작시간
    @NotNull(message = "시작시간을 입력하세요.")
    private Time workTimeFrom;

    // 종료시간
    @NotNull(message = "종료시간을 입력하세요.")
    private Time workTimeTo;

    // String 형태의 시간을 Time 객체로 변환
    public void setWorkTimeFrom(String workTimeFrom) {
        this.workTimeFrom = convertToSqlTime(workTimeFrom);
    }

    public void setWorkTimeTo(String workTimeTo) {
        this.workTimeTo = convertToSqlTime(workTimeTo);
    }

    private Time convertToSqlTime(String timeString) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            long ms = sdf.parse(timeString).getTime();
            return new Time(ms);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid time format: " + timeString, e);
        }
    }
}
