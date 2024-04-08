package com.gss.demo.Controllers;

import java.util.List;
import com.gss.demo.Entities.RateData;
import com.gss.demo.Services.RateDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/rates")
public class RateDataController {
    @Autowired
    RateDataService rateDataService;

    //Create new Rate Data
    @PostMapping(path="/demo", consumes =MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RateData> createRateData(@RequestBody RateData rateData){

        RateData newData = rateDataService.createRateData(rateData);
        return new ResponseEntity<RateData>(newData,HttpStatus.CREATED);
    }
    //Get rate data by id
    @GetMapping(path="/demo/{dataRateId}",produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RateData> getRateDataById(@PathVariable String dataId) {

        RateData dataFound = rateDataService.getRateDataById(dataId);
        return new ResponseEntity<RateData>(dataFound,HttpStatus.OK);
    }
    //Get all rate data
    @GetMapping(path="/demo", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RateData>> getAllRateData() {

        List<RateData> dataList = rateDataService.getAllRateData();
        return new ResponseEntity<List<RateData>>(dataList,HttpStatus.OK);
    }

    //Get rate data by currency
    @GetMapping(path="/{currency}", produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RateData>> getRateDataByName(@PathVariable("currency") String currency) {

        List<RateData> dataList = rateDataService.getRateDataByCurrency(currency);
        return new ResponseEntity<List<RateData>>(dataList,HttpStatus.OK);
    }
    //Get rate data by PAGE parameters
    @GetMapping(produces =MediaType.APPLICATION_JSON_VALUE)
    public Page<RateData> findAllByPage(@RequestParam(name = "page" , defaultValue = "0") int page,
                                                    @RequestParam(name = "sizePerPage", defaultValue = "2") int sizePerPage,
                                                    @RequestParam(name = "source"  , required = false ) String source,
                                                    @RequestParam(name = "currency" , required = false) String currency,
                                                    @RequestParam(name = "date" , required = false) String date) {

        Pageable pageable = PageRequest.of(page, sizePerPage);
        return rateDataService.getRateDataBySourceAndNameAndDate(source, currency, date, pageable);
    }
}