package com.berkhayta.springbootsorucevaprestapi.service;

import com.berkhayta.springbootsorucevaprestapi.dto.request.CevapSaveRequestDto;
import com.berkhayta.springbootsorucevaprestapi.dto.response.CevapListAllResponseDto;
import com.berkhayta.springbootsorucevaprestapi.entity.Cevap;
import com.berkhayta.springbootsorucevaprestapi.mapper.CevapMapper;
import com.berkhayta.springbootsorucevaprestapi.repository.CevapRepository;
import com.berkhayta.springbootsorucevaprestapi.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CevapService extends ServiceManager<Cevap, Long> {
    private final CevapRepository cevapRepository;

    public CevapService(CevapRepository cevapRepository) {
        super(cevapRepository);
        this.cevapRepository = cevapRepository;
    }

    public Cevap saveCevap(CevapSaveRequestDto dto) {
        return cevapRepository.save(CevapMapper.INSTANCE.cevapSaveRequestDtoToCevap(dto));
    }

}
