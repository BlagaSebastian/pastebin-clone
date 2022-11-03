package com.pastebin.Services;

import com.pastebin.models.Paste;
import com.pastebin.repositories.PasteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasteService {
    @Autowired
    private final PasteRepository pasteRepo;

    public PasteService(PasteRepository pasteRepo) {
        this.pasteRepo = pasteRepo;
    }


    public void savePaste(Paste paste) {
        pasteRepo.save(paste);
    }

    public void deletePasteById(int pasteId) {
        pasteRepo.deleteById(pasteId);
    }

    public List<Paste> getAll() {
        return pasteRepo.findAll();
    }

    public Paste getPasteById(int pasteId) {
        Optional<Paste> optional = pasteRepo.findById(pasteId);
        Paste paste;
        if (optional.isPresent()) {
            paste = optional.get();
        } else {
            throw new RuntimeException("Can not found the paste with pasteId: " + pasteId);
        }
        return paste;
    }
}
