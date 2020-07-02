package com.localcoin.bdeval.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.localcoin.bdeval.entity.AtmCashPickup;

import java.util.List;

public interface CashPickupRepository extends CrudRepository<AtmCashPickup, Integer>
{
    @Query(value="SELECT * FROM atm_cash_pickup acp " +
            "order by atm_identifier, expected_pickup, actual_pickup", nativeQuery = true)
    List<AtmCashPickup> findAllPickup();
}
