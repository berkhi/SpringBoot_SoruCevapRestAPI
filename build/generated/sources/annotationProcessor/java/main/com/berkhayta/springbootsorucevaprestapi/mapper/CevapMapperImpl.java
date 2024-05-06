package com.berkhayta.springbootsorucevaprestapi.mapper;

import com.berkhayta.springbootsorucevaprestapi.dto.request.CevapSaveRequestDto;
import com.berkhayta.springbootsorucevaprestapi.entity.Cevap;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T15:38:29+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21 (Oracle Corporation)"
)
@Component
public class CevapMapperImpl implements CevapMapper {

    @Override
    public Cevap cevapSaveRequestDtoToCevap(CevapSaveRequestDto saveRequestDto) {
        if ( saveRequestDto == null ) {
            return null;
        }

        Cevap.CevapBuilder cevap = Cevap.builder();

        cevap.icerik( saveRequestDto.icerik() );

        return cevap.build();
    }
}
