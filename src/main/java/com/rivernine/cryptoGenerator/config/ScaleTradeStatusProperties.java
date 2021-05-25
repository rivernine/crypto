package com.rivernine.cryptoGenerator.config;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rivernine.cryptoGenerator.common.dto.BidMarketResponseDto;
import com.rivernine.cryptoGenerator.schedule.getCandle.dto.CandleDto;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
@Component
@NoArgsConstructor
@Getter
@Setter
public class ScaleTradeStatusProperties {

  public int level;
  public List<String> pricePerLevel;
  public List<BidMarketResponseDto> bidInfoPerLevel;
  public Map<LocalDateTime, CandleDto> candleDtoMap;

  public void addCandlesDtoMap(LocalDateTime key, CandleDto candleDto) {
    if(!this.candleDtoMap.containsKey(key)) {
      this.candleDtoMap.put(key, candleDto);
    }
  }
  
  public void printCandlesDtoMap() {
    for(LocalDateTime key: this.candleDtoMap.keySet()) {
      log.info(this.candleDtoMap.get(key).toString());
    }
  }

  public void addBidInfoPerLevel(BidMarketResponseDto bidMarketResponseDto) {
    this.bidInfoPerLevel.add(bidMarketResponseDto);
  }

  public void increaseLevel() {
    this.level++;
  }

  public void init() {
    this.level = 0;
    this.pricePerLevel = new ArrayList<>(
      Arrays.asList("6000.0", "20000.0", "100000.0", "500000.0", "2000000.0"));
    this.candleDtoMap = new HashMap<>();
    this.bidInfoPerLevel = new ArrayList<>();
  }
}
