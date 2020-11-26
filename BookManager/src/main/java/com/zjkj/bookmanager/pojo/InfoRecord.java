package com.zjkj.bookmanager.pojo;

import java.util.Date;

public class InfoRecord {
    private Integer id;

    private Long jobNumber;

    private Long number;

    private Date lendDate;

    private Date returnDate;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(Long jobNumber) {
        this.jobNumber = jobNumber;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InfoRecord{" +
                "id=" + id +
                ", jobNumber=" + jobNumber +
                ", number=" + number +
                ", lendDate=" + lendDate +
                ", returnDate=" + returnDate +
                ", status=" + status +
                '}';
    }
}