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

import it.preventivo.entity.Preventivo;
import it.preventivo.entity.Utente;
import it.preventivo.service.PreventivoService;
import it.preventivo.service.UtenteService;

@Controller
@RequestMapping("/preventivi")
public class PreventivoController {

    @Autowired
    private PreventivoService preventivoService;

    // Metodo per ottenere tutti i preventivi e visualizzarli in una pagina
    @GetMapping
    public String getAllPreventivi(Model model) {
        model.addAttribute("preventivi", preventivoService.findAll());
        return "preventivi";
    }

    // Metodo per ottenere un preventivo specifico per ID e visualizzarlo in una pagina
    @GetMapping("/{id}")
    public String getPreventivoById(@PathVariable("id") Long id, Model model) {
        Optional<Preventivo> preventivo = preventivoService.findById(id);
        if (preventivo.isPresent()) {
            model.addAttribute("preventivo", preventivo.get());
            return "preventivo";
        } else {
            // Se il preventivo non esiste, reindirizza alla lista dei preventivi
            return "redirect:/preventivi";
        }
    }

    // Metodo per mostrare il form di creazione di un nuovo preventivo
    @GetMapping("/new")
    public String showNewPreventivoForm(Model model) {
    	List<Utente> utenti = UtenteService.getAllUtenti(); // Supponiamo che ci sia un service per gli utenti
    	model.addAllAttributes(utenti);
        model.addAttribute("preventivo", new Preventivo());
        return "newPreventivo";
    }

    // Metodo per salvare un nuovo preventivo
    @PostMapping("/save")
    public String savePreventivo(@ModelAttribute("preventivo") Preventivo preventivo) {
        preventivoService.save(preventivo);
        return "redirect:/preventivi";
    }

    // Metodo per mostrare il form di modifica di un preventivo esistente
    @GetMapping("/{id}/edit")
    public String showEditPreventivoForm(@PathVariable("id") Long id, Model model) {
        Optional<Preventivo> preventivo = preventivoService.findById(id);
        if (preventivo.isPresent()) {
            model.addAttribute("preventivo", preventivo.get());
            return "editPreventivo";
        } else {
            // Se il preventivo non esiste, reindirizza alla lista dei preventivi
            return "redirect:/preventivi";
        }
    }

    // Metodo per aggiornare un preventivo esistente
    @PostMapping("/{id}/update")
    public String updatePreventivo(@PathVariable("id") Integer id, @ModelAttribute("preventivo") Preventivo preventivo) {
        preventivoService.save(preventivo);
        return "redirect:/preventivi";
    }

    // Metodo per eliminare un preventivo esistente
    @GetMapping("/{id}/delete")
    public String deletePreventivo(@PathVariable("id") Long id) {
        preventivoService.deleteById(id);
        return "redirect:/preventivi";
    }
}
