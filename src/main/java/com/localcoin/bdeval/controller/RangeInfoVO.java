package com.localcoin.bdeval.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RangeInfoVO
{

    public RangeInfoVO(String atm)
    {
        this.atm = atm;
    }

    public RangeInfoVO(String atm, List<Range> ranges)
    {
        super();
        this.atm = atm;
        this.ranges = ranges;
    }

    private String atm;
    private List<Range> ranges = new ArrayList<Range>();

    public String getAtm()
    {
        return atm;
    }

    public void setAtm(String atm)
    {
        this.atm = atm;
    }

    public List<Range> getRanges()
    {
        return ranges;
    }

    public void setRanges(List<Range> ranges)
    {
        this.ranges = ranges;
    }

}

