package com.wcappel.ffbackend.repository;

import com.wcappel.ffbackend.misc.TradeId;
import com.wcappel.ffbackend.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade, TradeId> {

}
