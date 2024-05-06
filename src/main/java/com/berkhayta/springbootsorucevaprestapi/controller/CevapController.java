package com.berkhayta.springbootsorucevaprestapi.controller;

import com.berkhayta.springbootsorucevaprestapi.dto.request.CevapSaveRequestDto;
import com.berkhayta.springbootsorucevaprestapi.service.CevapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static com.berkhayta.springbootsorucevaprestapi.constant.EndPoints.*;

@RestController
@RequestMapping(ROOT + CEVAP)
@RequiredArgsConstructor
public class CevapController {
    private final CevapService cevapService;

    /**
     *
     * Bu kısımda ekstra olarak önceden eklenmiş ID si belirli olan soruya şık ekleme, silme ve güncelleme işlemleri eklenecek
     *
     */
    @PostMapping("/cevaplar")
    public ResponseEntity<?> saveCevapDto(@RequestBody CevapSaveRequestDto dto) {
        cevapService.saveCevap(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
