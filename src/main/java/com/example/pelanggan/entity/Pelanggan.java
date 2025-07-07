package com.example.pelanggan.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "data_pelanggan")
@NoArgsConstructor
@AllArgsConstructor
public class Pelanggan {


    @Id
    private String id;

    @Column(name = "nama")
    private String nama;

    private String alamat;

    private String jenisKelamin;

    private Integer umur;

    private String pekerjaan;

    private Long penghasilan;
}
