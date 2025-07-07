package com.example.pelanggan.service;

import com.example.pelanggan.entity.Pelanggan;
import com.example.pelanggan.model.CreatePelangganRequest;
import com.example.pelanggan.model.PelangganResponse;
import com.example.pelanggan.model.UpdatePelangganRequest;
import com.example.pelanggan.repository.PelangganRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PelangganService {

    @Autowired
    private PelangganRepository pelangganRepository;
    @Autowired
    private ValidationService validationService;


    private PelangganResponse pelangganResponse(Pelanggan pelanggan) {
        return PelangganResponse.builder()
                .id(pelanggan.getId())
                .nama(pelanggan.getNama())
                .alamat(pelanggan.getAlamat())
                .jenisKelamin(pelanggan.getJenisKelamin())
                .pekerjaan(pelanggan.getPekerjaan())
                .penghasilan(pelanggan.getPenghasilan())
                .build();
    }


    @Transactional(readOnly = true)
    public List<Pelanggan> getPelanggan() {
        List<Pelanggan> pelanggan = pelangganRepository.findAll();

        if(pelanggan.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tidak ada antrian");
        }
        return pelanggan;
    }

    @Transactional
    public PelangganResponse create(CreatePelangganRequest request){
        validationService.validate(request);
        boolean exist = pelangganRepository.existsById(request.getId());
        if(exist){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pelanggan tidak ditemukan");
        }
        Pelanggan pelanggan = new Pelanggan();
        pelanggan.setId(request.getId());
        pelanggan.setNama(request.getNama());
        pelanggan.setAlamat(request.getAlamat());
        pelanggan.setJenisKelamin(request.getJenisKelamin());
        pelanggan.setPekerjaan(request.getPekerjaan());
        pelanggan.setPenghasilan(request.getPenghasilan());
        pelanggan = pelangganRepository.save(pelanggan);

        return pelangganResponse(pelanggan);
    }



    @Transactional
    public void delete(String id) {
        Pelanggan pelanggan =pelangganRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pelanggan tidak ditemukan"));

        pelangganRepository.delete(pelanggan);
    }

    @Transactional
    public PelangganResponse update(UpdatePelangganRequest request) {
         validationService.validate(request);
        Pelanggan pelanggan = pelangganRepository.findById(request.getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pelanggan tidak ditemukan"));

        pelanggan.setId(request.getId());
        pelanggan.setNama(request.getNama());
        pelanggan.setAlamat(request.getAlamat());
        pelanggan.setJenisKelamin(request.getJenisKelamin());
        pelanggan.setUmur(request.getUmur());
        pelanggan.setPekerjaan(request.getPekerjaan());
        pelanggan.setPenghasilan(request.getPenghasilan());

        pelanggan = pelangganRepository.save(pelanggan);
        return pelangganResponse(pelanggan);
    }


}
