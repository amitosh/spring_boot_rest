package com.localcoin.bdeval.controller;

import java.util.List;

import com.localcoin.bdeval.service.CashPickUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BDController
{
    @Autowired
    CashPickUpService cashPickUpService;

    @ResponseBody
    @GetMapping(path = "/search_ranges", produces = "application/json")
    public List<RangeInfoVO> searchRanges()
    {
        return cashPickUpService.findRangeInfoVOs();
    }
}
