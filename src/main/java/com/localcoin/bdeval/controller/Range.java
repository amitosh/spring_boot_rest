package com.localcoin.bdeval.controller;

import java.time.LocalDate;

public class Range
{
    public Range(LocalDate start_date, LocalDate end_date)
    {
        this.start_date = start_date;
        this.end_date = end_date;
    }

    private LocalDate start_date;

    private LocalDate end_date;

    public LocalDate getStart_date()
    {
        return start_date;
    }

    public void setStart_date(LocalDate start_date)
    {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date()
    {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date)
    {
        this.end_date = end_date;
    }
}
