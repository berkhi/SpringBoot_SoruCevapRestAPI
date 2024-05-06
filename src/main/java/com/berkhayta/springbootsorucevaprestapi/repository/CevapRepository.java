package com.berkhayta.springbootsorucevaprestapi.repository;

import com.berkhayta.springbootsorucevaprestapi.entity.Cevap;
import com.berkhayta.springbootsorucevaprestapi.entity.Soru;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CevapRepository extends JpaRepository<Cevap, Long> {
}
