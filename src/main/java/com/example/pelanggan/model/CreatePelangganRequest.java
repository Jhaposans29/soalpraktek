package com.example.pelanggan.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePelangganRequest {

    @NotBlank(message = "ID Pelanggan harus terisi")

    private String idPelanggan;

    @NotBlank(message = "Nama harus terisi ")
    @Column(name = "nama")
    private String nama;

    @NotBlank(message = "Alamat harus terisi")
    private String alamat;

    @NotBlank(message = "Jenis Kelamin harus terisi")
    private String jenisKelamin;

    @NotNull(message = "Umur harus terisi")
    @Min(value = 0, message = "umur harus lebih dari 0")
    private int umur;

    @NotBlank(message = "Pekerjaan harus terisi")
    private String pekerjaan;

    @NotNull(message = "Penghasilan harus terisi")
    @Min(value = 0, message = "Penghasilan harus lebih dari 0")
    private Long penghasilan;
}
