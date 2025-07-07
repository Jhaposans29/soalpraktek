package com.example.pelanggan.controller;

import com.example.pelanggan.entity.Pelanggan;
import com.example.pelanggan.model.CreatePelangganRequest;
import com.example.pelanggan.model.PelangganResponse;
import com.example.pelanggan.model.UpdatePelangganRequest;
import com.example.pelanggan.model.WebResponse;
import com.example.pelanggan.repository.PelangganRepository;
import com.example.pelanggan.service.PelangganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller; // Pakai Controller biasa
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PelangganController {

    @Autowired
    private PelangganService pelangganService;

    @Autowired
    private PelangganRepository pelangganRepository;

    // 🔹 TAMPILKAN PAGE HTML DENGAN DATA
    @GetMapping("/")
    public String halamanIndex(Model model) {
        List<Pelanggan> pelangganList = pelangganService.getPelanggan();
        model.addAttribute("pelangganList", pelangganList);
        model.addAttribute("pelangganForm", new CreatePelangganRequest());
        return "index"; // templates/index.html
    }

    // 🔹 SAVE DATA DARI FORM
    @PostMapping("/save")
    public String saveThymeleaf(@ModelAttribute("pelangganForm") CreatePelangganRequest form) {
        pelangganService.create(form);
        return "redirect:/";
    }

    // 🔹 HAPUS DATA
    @GetMapping("/delete/{id}")
    public String deleteThymeleaf(@PathVariable String id) {
        pelangganRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable String id, Model model) {
        Pelanggan pelanggan = pelangganRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));

        model.addAttribute("pelangganForm", pelanggan); // Tidak Optional!
        model.addAttribute("pelangganList", pelangganService.getPelanggan());
        return "index";
    }




    @PostMapping(
            path = "/create-pelanggan",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public WebResponse<PelangganResponse> create(@RequestBody CreatePelangganRequest request) {
        PelangganResponse pelangganResponse = pelangganService.create(request);
        return WebResponse.<PelangganResponse>builder().data(pelangganResponse).build();
    }

    @PutMapping(
            path = "/update-pelanggan",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public WebResponse<PelangganResponse> update(@RequestBody UpdatePelangganRequest request) {
        PelangganResponse pelangganResponse = pelangganService.update(request);
        return WebResponse.<PelangganResponse>builder()
                .data(pelangganResponse)
                .build();
    }

    @DeleteMapping("/delete-pelanggan/{pelangganId}")
    @ResponseBody
    public WebResponse<String> deleteApi(@PathVariable String pelangganId) {
        pelangganService.delete(pelangganId);
        return WebResponse.<String>builder().data("Successfully deleted").build();
    }
}
