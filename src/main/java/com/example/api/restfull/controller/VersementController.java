package com.example.api.restfull.controller;


import com.example.api.restfull.exception.ResourceNoteFoundException;
import com.example.api.restfull.model.Client;
import com.example.api.restfull.model.Versement;
import com.example.api.restfull.repository.ClientRepository;
import com.example.api.restfull.repository.VersementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/API/Banking/Versement")
public class VersementController {
    @Autowired
    private VersementRepository versementRepository;

    //Mi get versement rehetra
    @GetMapping("")
    public List<Versement> getAllVersement() {
        return this.versementRepository.findAll();
    }

    //Mi get versement by  idVersement
    @GetMapping("/{idVersement}")
    public ResponseEntity<Versement> getVersementById(@PathVariable(value = "idVersement") Long idVersement)
            throws ResourceNoteFoundException {
        Versement versement = versementRepository.findById(idVersement)
                .orElseThrow(() -> new ResourceNoteFoundException("Client qui porte l'id :: " + idVersement+ " non trouver!"));
        return ResponseEntity.ok().body(versement);
    }

    //Creation na versement
    @PostMapping("")
    public Versement createVersement(@RequestBody Versement versement) {
        return this.versementRepository.save(versement);
    }

    //Manao MAJ na client
    @PutMapping("/{idVersement}")
    public Versement updateVersement(@PathVariable(value = "idVersement") Long idVersement, @RequestBody Versement versementDetails) throws ResourceNoteFoundException {

        Versement versement = versementRepository.findById(idVersement)
                .orElseThrow(() -> new ResourceNoteFoundException("Client qui porte l'id :: " + idVersement+ " non trouver!"));

        //client.setNum_compte(clientDetails.getNum_compte());
        versement.setDateVersement(versement.getDateVersement());
        versement.setMontant_Versement(versementDetails.getMontant_Versement());
        versement.setClient(versementDetails.getClient());

        Versement updateVersement = versementRepository.save(versement);
        return updateVersement;
    }

    @DeleteMapping("/{idVersement}")
    public Map<String, Boolean> deleteVersement(@PathVariable(value = "idVersement") Long idVersement)
            throws ResourceNoteFoundException {
        Versement versement = versementRepository.findById(idVersement)
                .orElseThrow(() -> new ResourceNoteFoundException("Client qui porte l'id :: " + idVersement+ " non trouver!"));
        System.out.println("deletePatient"+versement.toString());
        versementRepository.delete(versement);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Versement supprimer", Boolean.TRUE);
        return response;

    }
}
