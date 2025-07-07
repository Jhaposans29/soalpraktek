package com.example.pelanggan.repository;

import com.example.pelanggan.entity.Pelanggan;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PelangganRepository extends JpaRepository<Pelanggan, String> {
    String id(String id);
}
