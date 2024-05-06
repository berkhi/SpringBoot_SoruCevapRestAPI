package com.berkhayta.springbootsorucevaprestapi.mapper;

import com.berkhayta.springbootsorucevaprestapi.dto.request.CevapSaveRequestDto;
import com.berkhayta.springbootsorucevaprestapi.dto.response.CevapListAllResponseDto;
import com.berkhayta.springbootsorucevaprestapi.dto.response.SoruListAllResponseDto;
import com.berkhayta.springbootsorucevaprestapi.entity.Cevap;
import com.berkhayta.springbootsorucevaprestapi.entity.Soru;
import org.mapstruct.*;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CevapMapper {
    CevapMapper INSTANCE = Mappers.getMapper(CevapMapper.class);

    Cevap cevapSaveRequestDtoToCevap(CevapSaveRequestDto saveRequestDto);
}
