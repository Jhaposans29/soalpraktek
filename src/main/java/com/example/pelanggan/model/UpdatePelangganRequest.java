package com.example.pelanggan.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class UpdatePelangganRequest {

    @NotNull(message = "ID harus terisi")
    private String id;

    @NotBlank(message = "Nama harus terisi")
    private String nama;

    @NotBlank(message = "Alamat harus terisi")
    private String alamat;

    @NotBlank(message = "Jenis Kelamin harus terisi")
    private String jenisKelamin;

    @NotNull(message = "Umur harus terisi")
    @Min(value = 0, message = "Umur tidak boleh negatif")
    private Integer umur;

    @NotBlank(message = "Pekerjaan harus terisi")
    private String pekerjaan;

    @NotNull(message = "Penghasilan harus terisi")
    @Min(value = 0, message = "Penghasilan tidak boleh negatif")
    private Long penghasilan;
}
