package it.preventivo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.preventivo.entity.Utente;
import it.preventivo.service.UtenteService;

@Controller
@RequestMapping("/utenti")
public class UtenteControllerThymeleaf {

    @Autowired
    private UtenteService utenteService;

    @GetMapping
    public String getAllUtenti(Model model) {
        List<Utente> utenti = utenteService.findAll();
        model.addAttribute("utenti", utenti);
        return "utenti";
    }

    @GetMapping("/new")
    public String showNewUtenteForm(Model model) {
        model.addAttribute("utente", new Utente());
        return "new_utente";
    }

    @PostMapping
    public String saveUtente(@ModelAttribute("utente") Utente utente) {
        utenteService.save(utente);
        return "redirect:/utenti";
    }

    @GetMapping("/edit/{id}")
    public String showEditUtenteForm(@PathVariable("id") long id, Model model) {
        Optional<Utente> utente = utenteService.findById(id);
        if (utente.isPresent()) {
            model.addAttribute("utente", utente.get());
            return "edit_utente";
        } else {
            return "redirect:/utenti";
        }
    }

    @PostMapping("/update/{id}")
    public String updateUtente(@PathVariable("id") long id, @ModelAttribute("utente") Utente utenteDetails) {
        Optional<Utente> optionalUtente = utenteService.findById(id);
        if (optionalUtente.isPresent()) {
            Utente utente = optionalUtente.get();
            utente.setCategoriaLavoriId(utenteDetails.getCategoriaLavoriId());
            utente.setCognome(utenteDetails.getCognome());
            utente.setCreatoIl(utenteDetails.getCreatoIl());
            utente.setDataDiNascita(utenteDetails.getDataDiNascita());
            utente.setEmail(utenteDetails.getEmail());
            utente.setModificatoIl(utenteDetails.getModificatoIl());
            utente.setNome(utenteDetails.getNome());
            utente.setPassword(utenteDetails.getPassword());
            utenteService.save(utente);
        }
        return "redirect:/utenti";
    }

    @GetMapping("/delete/{id}")
    public String deleteUtente(@PathVariable("id") long id) {
        utenteService.deleteById(id);
        return "redirect:/utenti";
    }
}

