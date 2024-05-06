package com.berkhayta.springbootsorucevaprestapi.dto.request;

import java.util.List;

public record SoruSaveRequestDto(String icerik, List<String> cevaplar, int correctAnswerIndex) {
}