package com.berkhayta.springbootsorucevaprestapi.dto.response;

import java.util.List;

public record SoruListAllResponseDto(Long id, String icerik, List<CevapListAllResponseDto> cevaplar, CevapListAllResponseDto correctCevap) {
}
