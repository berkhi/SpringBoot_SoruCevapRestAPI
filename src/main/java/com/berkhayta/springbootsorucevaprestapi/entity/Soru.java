package com.berkhayta.springbootsorucevaprestapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tblsoru")
public class Soru {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String icerik;

    @OneToMany(mappedBy = "soru", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cevap> cevaplar;

    @OneToOne
    @JoinColumn(name = "correct_cevap_id", referencedColumnName = "id")
    // Doğru cevabın ID'sini `tblsoru` tablosunda `correct_cevap_id` sütunuyla saklar.
    private Cevap correctCevap;

}
