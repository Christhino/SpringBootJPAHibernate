package com.example.api.restfull.controller;

import com.example.api.restfull.exception.ResourceNoteFoundException;
import com.example.api.restfull.model.Client;
import com.example.api.restfull.model.Retrait;
import com.example.api.restfull.model.Versement;
import com.example.api.restfull.repository.ClientRepository;
import com.example.api.restfull.repository.RetraitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/API/Banking/Retrait")
public class RetraitController {
    @Autowired
    private RetraitRepository retraitRepository;

    //Mi get retrait rehetra
    @GetMapping("")
    public List<Retrait> getAllRetrait() {
        return this.retraitRepository.findAll();
    }

    //Mi get retrait by  idVersement
    @GetMapping("/{idRetrait}")
    public ResponseEntity<Retrait> getRetraittById(@PathVariable(value = "idRetrait") Long idRetrait)
            throws ResourceNoteFoundException {
        Retrait retrait = retraitRepository.findById(idRetrait)
                .orElseThrow(() -> new ResourceNoteFoundException("Client qui porte l'id :: " + idRetrait+ " non trouver!"));
        return ResponseEntity.ok().body(retrait);
    }

    //Creation na versement
    @PostMapping("")
    public Retrait createRetrait(@RequestBody Retrait retrait) {
        return this.retraitRepository.save(retrait);
    }

    //Manao MAJ na retrait
    @PutMapping("/{idRetrait}")
    public Retrait updateRetrait(@PathVariable(value = "idRetrait") Long idRetrait, @RequestBody Retrait retraitDetails) throws ResourceNoteFoundException {

        Retrait retrait = retraitRepository.findById(idRetrait)
                .orElseThrow(() -> new ResourceNoteFoundException("Client qui porte l'id :: " + idRetrait+ " non trouver!"));

        retrait.setNum_cheque(retraitDetails.getNum_cheque());
        retrait.setNum_compte(retraitDetails.getNum_compte());
        retrait.setMontant_retrait(retraitDetails.getMontant_retrait());
        retrait.setDate_retrait(retraitDetails.getDate_retrait());

        Retrait updateRetrait = retraitRepository.save(retrait);
        return updateRetrait;
    }

    @DeleteMapping("/{idRetrait}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "idRetrait") Long idRetrait)
            throws ResourceNoteFoundException {
        Retrait retrait = retraitRepository.findById(idRetrait)
                .orElseThrow(() -> new ResourceNoteFoundException("Client qui porte l'id :: " + idRetrait+ " non trouver!"));
        System.out.println("deletePatient"+retrait.toString());
        retraitRepository.delete(retrait);
        Map<String, Boolean> response = new HashMap<>();
        response.put("retrait supprimer", Boolean.TRUE);
        return response;

    }
}
