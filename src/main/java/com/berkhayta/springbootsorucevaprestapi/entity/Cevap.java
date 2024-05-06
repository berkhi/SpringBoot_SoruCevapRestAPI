package com.berkhayta.springbootsorucevaprestapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tblcevap")
public class Cevap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String icerik;

    @ManyToOne(fetch = FetchType.EAGER)
    // Birden fazla cevabın aynı soruya ait olabileceğini gösterir
    @JoinColumn(name = "soru_id")
    // Cevapların bağlı olduğu sorunun ID'sini tutar
    private Soru soru;

}