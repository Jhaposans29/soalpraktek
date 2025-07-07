package com.example.pelanggan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PelangganResponse {

    private String id;
    
    private String idPelanggan;
    
    private String nama;
    
    private String alamat;
    
    private String jenisKelamin;
    
    private Integer umur;
    
    private String pekerjaan;
    
    private Long penghasilan;

}
