package com.wcappel.ffbackend.controller;

import com.wcappel.ffbackend.model.Trade;
import com.wcappel.ffbackend.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/ffapi/v1/trades") class TradeController {
    @Autowired private TradeRepository tradeRepository;

    @GetMapping("/getalltrades") List<Trade> getAllTrades() {
        return tradeRepository.findAll();
    }

    @PostMapping("/addtrade") public Trade addTrade(@RequestBody Trade t) {
        System.out.println(t);
        return tradeRepository.save(t);
    }
}
