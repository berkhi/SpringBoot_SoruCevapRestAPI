package com.berkhayta.springbootsorucevaprestapi.service;

import com.berkhayta.springbootsorucevaprestapi.dto.request.SoruSaveRequestDto;
import com.berkhayta.springbootsorucevaprestapi.dto.response.SoruListAllResponseDto;
import com.berkhayta.springbootsorucevaprestapi.entity.Cevap;
import com.berkhayta.springbootsorucevaprestapi.entity.Soru;
import com.berkhayta.springbootsorucevaprestapi.exceptions.ErrorType;
import com.berkhayta.springbootsorucevaprestapi.exceptions.SoruCevapAppException;
import com.berkhayta.springbootsorucevaprestapi.mapper.SoruMapper;
import com.berkhayta.springbootsorucevaprestapi.repository.CevapRepository;
import com.berkhayta.springbootsorucevaprestapi.repository.SoruRepository;
import com.berkhayta.springbootsorucevaprestapi.utility.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SoruService extends ServiceManager<Soru, Long> {
    private final SoruRepository soruRepository;
    private final CevapRepository cevapRepository;
    private final SoruMapper soruMapper;

    // constructor aracılığıyla bağımlılıkların enjekte ettik (Dependency Injection)
    @Autowired
    public SoruService(SoruRepository soruRepository, CevapRepository cevapRepository, SoruMapper soruMapper) {
        super(soruRepository);
        this.soruRepository = soruRepository;
        this.cevapRepository = cevapRepository;
        this.soruMapper = soruMapper;
    }

    // Bir soruyu verilen `SoruSaveRequestDto` nesnesiyle kaydetmek için
    public Soru saveSoru(SoruSaveRequestDto dto) {
        // Dto dan Mapper aracılığıyla Soru nesnesi oluşturuluyor
        Soru soru = soruMapper.soruSaveRequestDtoToSoru(dto);
        //Dto daki cevap listesinden Cevap nesneleri oluşturulup Soru ile ilişkilendiriliyoruz
        List<Cevap> cevaplar = dto.cevaplar().stream()
                .map(choice -> Cevap.builder()
                        .icerik(choice)
                        .soru(soru)//soruyla ilişkilendiriliyor
                        .build())
                .collect(Collectors.toList());

        // dto daki doğru cevap indeksi kullanılarak doğru cevap atanıyor
        Cevap correctCevap = cevaplar.get(dto.correctAnswerIndex());

        soru.setCevaplar(cevaplar);
        soru.setCorrectCevap(correctCevap);

        return soruRepository.save(soru);
    }

    // Tüm soruları ve ilişkili cevapları listeleyen metod
    public List<SoruListAllResponseDto> findAllSorularWithCevaplar() {
        List<Soru> sorular = soruRepository.findAll();
        return sorular.stream()
                .map(soruMapper::soruToSoruListAllResponseDto)
                .collect(Collectors.toList());
    }

    //Verilen ID'ye göre soruyu ve ilişkili cevaplarını bulan metod
    public SoruListAllResponseDto findSoruByIdWithCevaplar(Long id) {
        //veritabanından ID'ye göre soru bulunuyor bulamazsa hata veriliyor
        Soru soru = soruRepository.findById(id)
                .orElseThrow(() -> new SoruCevapAppException(ErrorType.QUESTION_NOT_FOUND, "Soru not found with id: " + id));
        //bulunan soru DTO formatına Mapper ile dönüştürülüp döndürülüyor
        return soruMapper.soruToSoruListAllResponseDto(soru);
    }

}
