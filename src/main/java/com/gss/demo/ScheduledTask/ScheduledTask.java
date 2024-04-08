package com.gss.demo.ScheduledTask;

import com.gss.demo.Entities.Currency;
import com.gss.demo.Entities.Moneys;
import com.gss.demo.Entities.RateData;
import com.gss.demo.Services.CurrencyFactory;
import com.gss.demo.Services.RateDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    @Autowired
    RateDataService rateDataService;

    @Autowired
    CurrencyFactory currencyFactory;

    @Scheduled(cron = "0 0 * * * ?")
    public ResponseEntity<RateData> getCurrencyEuro() {

        currencyFactory = new CurrencyFactory(Moneys.EURO);
        Currency curr = currencyFactory.getCurrency();

        RateData rateData = new RateData("MB",curr.getBuyingPrice(), curr.getSellingPrice(), curr.getName(), curr.getDate());
        rateDataService.createRateData(rateData);

        return new ResponseEntity<RateData>(rateData, HttpStatus.OK);
    }

    @Scheduled(cron = "0 0 * * * ?")
    public ResponseEntity<RateData> getCurrencyDollar() {

        currencyFactory = new CurrencyFactory(Moneys.US_DOLLAR);
        Currency curr = currencyFactory.getCurrency();

        RateData rateData = new RateData("MB",curr.getBuyingPrice(), curr.getSellingPrice(), curr.getName(), curr.getDate());
        rateDataService.createRateData(rateData);

        return new ResponseEntity<RateData>(rateData, HttpStatus.OK);
    }
}