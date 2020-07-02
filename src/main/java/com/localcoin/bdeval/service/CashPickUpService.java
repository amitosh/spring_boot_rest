package com.localcoin.bdeval.service;

import com.localcoin.bdeval.controller.Range;
import com.localcoin.bdeval.controller.RangeInfoVO;
import com.localcoin.bdeval.entity.AtmCashPickup;
import com.localcoin.bdeval.repository.CashPickupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CashPickUpService
{
    @Autowired
    CashPickupRepository cashPickupRepository;

    public List<RangeInfoVO> findRangeInfoVOs()
    {
        Map<String, RangeInfoVO> rangeInfoVOMap = new LinkedHashMap<>();
        LocalDate expectedPickup = null;
        LocalDate actualPickup = null;

        for(AtmCashPickup atmCashPickup : cashPickupRepository.findAllPickup())
        {
            String name = atmCashPickup.getAtmIdentifier();

            if(rangeInfoVOMap.get(name) == null)
                rangeInfoVOMap.put(name, new RangeInfoVO(name));

            RangeInfoVO rangeInfoVO = rangeInfoVOMap.get(name);

            if(expectedPickup == null)
                expectedPickup = atmCashPickup.getExpectedPickup();

            if(atmCashPickup.getActualPickup() != null)
            {
                actualPickup = atmCashPickup.getActualPickup();
                Range range = new Range(expectedPickup, actualPickup);
                rangeInfoVO.getRanges().add(range);

                expectedPickup = null;
            }
        }

        return new ArrayList(rangeInfoVOMap.values());
    }
}
