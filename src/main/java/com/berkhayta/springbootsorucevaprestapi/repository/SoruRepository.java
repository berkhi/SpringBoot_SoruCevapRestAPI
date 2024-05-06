package com.berkhayta.springbootsorucevaprestapi.repository;

import com.berkhayta.springbootsorucevaprestapi.entity.Soru;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoruRepository extends JpaRepository<Soru, Long> {

}
