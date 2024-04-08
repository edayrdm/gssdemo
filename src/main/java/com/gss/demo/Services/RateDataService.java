package com.gss.demo.Services;

import java.util.List;
import java.util.Objects;
import com.gss.demo.Entities.RateData;
import com.gss.demo.Repositories.RateDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RateDataService {

    @Autowired
    RateDataRepository rateDataRepository;

    // function to create a new rate data
    public RateData createRateData(RateData rate) {
        return rateDataRepository.save(rate);
    }
    // function return a data by id or null in case it doesn't exist
    public RateData getRateDataById(String id) {
        return rateDataRepository.findById(id).orElse(null);
    }
    // function return a data by currency name or null in case it doesn't exist
    public List<RateData> getRateDataByCurrency(String id) {
        return rateDataRepository.findByCurrency(id).orElse(null);
    }
    // function that retrieve all data from database
    public List<RateData> getAllRateData() {
        return rateDataRepository.findAll();
    }

    public Page<RateData> findAllByPage(Pageable pageable) {
        return rateDataRepository.findAll(pageable);
    }

    public Page<RateData> getRateDataBySourceAndNameAndDate(String source, String currency, String date,Pageable pageable) {

        Page<RateData> result = rateDataRepository.findAll(pageable);

        if ( currency != null)
            result = rateDataRepository.findByCurrency(currency, pageable);

        if ( source != null) {
            assert result != null;
            result.map(c -> Objects.equals(c.getSource(), source)
            );
        }

        if ( date != null) {
            assert result != null;
            result.map(c -> Objects.equals(c.getDate(), date)
            );
        }
        return result;
    }
}