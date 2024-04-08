package com.gss.demo.Repositories;

import com.gss.demo.Entities.RateData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RateDataRepository extends MongoRepository<RateData,String>{

    Optional<List<RateData>> findByCurrency(String currency);

    Optional<Page<RateData>> findBySourceOrDate(String source,String date, Pageable pageable);

    Page<RateData> findBySource(String source, Pageable pageable);

    Page<RateData> findByCurrency(String currency, Pageable pageable);
}