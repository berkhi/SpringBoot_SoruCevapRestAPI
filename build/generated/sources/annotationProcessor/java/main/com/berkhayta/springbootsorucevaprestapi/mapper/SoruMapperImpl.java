package com.berkhayta.springbootsorucevaprestapi.mapper;

import com.berkhayta.springbootsorucevaprestapi.dto.request.SoruSaveRequestDto;
import com.berkhayta.springbootsorucevaprestapi.dto.response.CevapListAllResponseDto;
import com.berkhayta.springbootsorucevaprestapi.dto.response.SoruListAllResponseDto;
import com.berkhayta.springbootsorucevaprestapi.entity.Cevap;
import com.berkhayta.springbootsorucevaprestapi.entity.Soru;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T15:38:29+0300",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21 (Oracle Corporation)"
)
@Component
public class SoruMapperImpl implements SoruMapper {

    @Override
    public Soru soruSaveRequestDtoToSoru(SoruSaveRequestDto saveRequestDto) {
        if ( saveRequestDto == null ) {
            return null;
        }

        Soru.SoruBuilder soru = Soru.builder();

        soru.cevaplar( stringsToCevaplar( saveRequestDto.cevaplar() ) );
        soru.icerik( saveRequestDto.icerik() );

        return soru.build();
    }

    @Override
    public SoruListAllResponseDto soruToSoruListAllResponseDto(Soru soru) {
        if ( soru == null ) {
            return null;
        }

        Long id = null;
        String icerik = null;
        List<CevapListAllResponseDto> cevaplar = null;
        CevapListAllResponseDto correctCevap = null;

        id = soru.getId();
        icerik = soru.getIcerik();
        cevaplar = cevapListToCevapListAllResponseDtoList( soru.getCevaplar() );
        correctCevap = cevapToCevapListAllResponseDto( soru.getCorrectCevap() );

        SoruListAllResponseDto soruListAllResponseDto = new SoruListAllResponseDto( id, icerik, cevaplar, correctCevap );

        return soruListAllResponseDto;
    }

    @Override
    public CevapListAllResponseDto cevapToCevapListAllResponseDto(Cevap cevap) {
        if ( cevap == null ) {
            return null;
        }

        Long id = null;
        String icerik = null;

        id = cevap.getId();
        icerik = cevap.getIcerik();

        CevapListAllResponseDto cevapListAllResponseDto = new CevapListAllResponseDto( id, icerik );

        return cevapListAllResponseDto;
    }

    protected List<CevapListAllResponseDto> cevapListToCevapListAllResponseDtoList(List<Cevap> list) {
        if ( list == null ) {
            return null;
        }

        List<CevapListAllResponseDto> list1 = new ArrayList<CevapListAllResponseDto>( list.size() );
        for ( Cevap cevap : list ) {
            list1.add( cevapToCevapListAllResponseDto( cevap ) );
        }

        return list1;
    }
}
