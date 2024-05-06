package com.berkhayta.springbootsorucevaprestapi.controller;

import com.berkhayta.springbootsorucevaprestapi.dto.request.SoruSaveRequestDto;
import com.berkhayta.springbootsorucevaprestapi.dto.response.SoruListAllResponseDto;
import com.berkhayta.springbootsorucevaprestapi.service.SoruService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.berkhayta.springbootsorucevaprestapi.constant.EndPoints.*;

@RestController
@RequestMapping(ROOT + SORU)
@RequiredArgsConstructor
public class SoruController {
    private final SoruService soruService;

    @PostMapping("/sorular")
    public ResponseEntity<?> saveSoruDto(@RequestBody SoruSaveRequestDto dto) {
        //SoruService ile gelen dto yu kaydeder
        soruService.saveSoru(dto);
        // HTTP 201 Created statüsü ile boş bir yanıt döndürür
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Tüm soruları listeleyen GET endpoint'i
    @GetMapping("/sorular")
    public ResponseEntity<List<SoruListAllResponseDto>> findAllSoruDto() {
        //SoruService aracılığıyla tüm soruları cevaplar dahil olacak şekilde liste halinde döndürür
        List<SoruListAllResponseDto> sorular = soruService.findAllSorularWithCevaplar();
        return ResponseEntity.ok(sorular);
    }

    // Belirli bir soru ve onun cevaplarını döndüren GET endpoint'i
    @GetMapping("/{id}/cevaplar")
    public ResponseEntity<SoruListAllResponseDto> findSoruByIdWithCevaplar(@PathVariable Long id) {
        // Gelen id ile soruyu bulur ve cevaplarını da dahil ederek dto olarak döndürür
        SoruListAllResponseDto soruDto = soruService.findSoruByIdWithCevaplar(id);
        return ResponseEntity.ok(soruDto);
    }

}
