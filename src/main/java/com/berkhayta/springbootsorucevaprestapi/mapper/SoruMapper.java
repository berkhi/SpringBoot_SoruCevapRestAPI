package com.berkhayta.springbootsorucevaprestapi.mapper;

import com.berkhayta.springbootsorucevaprestapi.dto.request.SoruSaveRequestDto;
import com.berkhayta.springbootsorucevaprestapi.dto.response.CevapListAllResponseDto;
import com.berkhayta.springbootsorucevaprestapi.dto.response.SoruListAllResponseDto;
import com.berkhayta.springbootsorucevaprestapi.entity.Cevap;
import com.berkhayta.springbootsorucevaprestapi.entity.Soru;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SoruMapper {
    SoruMapper INSTANCE = Mappers.getMapper(SoruMapper.class);

    @Mapping(source = "cevaplar", target = "cevaplar", qualifiedByName = "stringsToCevaplar")
    //SoruSaveRequestDto dan Soru ya dönüştürürken cevaplar listesini dönüştürmek için stringsToCevaplar ı kullanıyoruz
    Soru soruSaveRequestDtoToSoru(SoruSaveRequestDto saveRequestDto);

    //soru nesnesini SoruListAllResponseDto ya dönüştüren metot
    SoruListAllResponseDto soruToSoruListAllResponseDto(Soru soru);

    //cevap nesnesini CevapListAllResponseDto ya dönüştüren metot
    CevapListAllResponseDto cevapToCevapListAllResponseDto(Cevap cevap);

    @Named("stringsToCevaplar")
    //gelen string listesinden Cevap nesneleri oluşturup liste olarak döndüren metot
    default List<Cevap> stringsToCevaplar(List<String> strings) {
        if (strings == null) {
            return null; // null kontrolü
        }
        return strings.stream()
                //String den Cevap nesnesine dönüşüm yapar ve build metodu ile yeni Cevap nesnesi oluşturur
                .map(icerik -> Cevap.builder().icerik(icerik).build())
                //dönüştürülen Cevap nesnelerini bir liste halinde döndürür
                .collect(Collectors.toList());
    }
}