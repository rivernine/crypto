package com.rivernine.cryptoGenerator.config;

import com.rivernine.cryptoGenerator.schedule.orders.dto.OrdersChanceDto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Component
@NoArgsConstructor
@Getter
@Setter
public class StatusProperties {

  @Value("${testParameter.currentStatus}")
  public int currentStatus;
  public Boolean bidRunning = false;
  public Boolean bidPending = false;
  public Boolean askRunning = false;
  public Boolean askPending = false;
  public String uuid;
  public Boolean lossCut = false;

  public OrdersChanceDto ordersChanceDtoForBid;
  public OrdersChanceDto ordersChanceDtoForAsk;

  public void init(){
    this.currentStatus = 0;
    this.bidRunning = false;
    this.bidPending = false;
    this.askRunning = false;
    this.askPending = false;
    this.uuid = null;
    this.lossCut = false;

    this.ordersChanceDtoForBid = null;
    this.ordersChanceDtoForAsk = null;

  }
}
