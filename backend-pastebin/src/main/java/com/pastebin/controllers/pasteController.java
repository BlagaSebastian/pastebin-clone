package com.pastebin.controllers;

import com.pastebin.Services.PasteService;
import com.pastebin.models.Paste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class pasteController {

    @Autowired
    private final PasteService pasteService;


    public pasteController(PasteService pasteService) {
        this.pasteService = pasteService;
    }



    @GetMapping("/paste")
    public String goToPastePage(Model model) {
        List<Paste> pasteList = pasteService.getAll();
        model.addAttribute("pasteList", pasteList);
        return "pastePage";
    }

    @GetMapping("/paste/add")
    public String addPaste(Model model) {
        model.addAttribute("paste", new Paste());
        return "addPastePage";
    }
    @PostMapping(value = "paste/save")
    public String savePaste(@ModelAttribute("paste") Paste paste) {
        pasteService.savePaste(paste);
        return "redirect:/paste";
    }

    @RequestMapping("paste/delete/{pasteId}")
    public String deletePaste(@PathVariable(name = "pasteId") int pasteId) {
        pasteService.deletePasteById(pasteId);
        return "redirect:/paste";
    }

    @RequestMapping("paste/edit/{pasteId}")
    public String editPaste(@PathVariable(name = "pasteId") int pasteId, Model model) {
        model.addAttribute("paste", pasteService.getPasteById(pasteId));
        return "editPaste";
    }
}
