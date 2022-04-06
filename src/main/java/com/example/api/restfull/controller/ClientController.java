package com.example.api.restfull.controller;


import com.example.api.restfull.exception.ResourceNoteFoundException;
import com.example.api.restfull.model.Client;
import com.example.api.restfull.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/API/Banking/Client")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    //Mi get client rehetra
    @GetMapping("")
    public List<Client> getAllClient() {
        return this.clientRepository.findAll();
    }

    //Mi get client by  IdClient
    @GetMapping("/{idClient}")
    public ResponseEntity<Client> getClientById(@PathVariable(value = "idClient") Long idClient)
            throws ResourceNoteFoundException {
        Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new ResourceNoteFoundException("Client qui porte l'id :: " + idClient+ " non trouver!"));
        return ResponseEntity.ok().body(client);
    }

    //Creation na client
    @PostMapping("")
    public Client createClient(@RequestBody Client client) {

        return this.clientRepository.save(client);
    }

    //Manao MAJ na client
    @PutMapping("/{idClient}")
    public Client updateCLient(@PathVariable(value = "idClient") Long idClient, @RequestBody Client clientDetails) throws ResourceNoteFoundException {

        Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new ResourceNoteFoundException("Client qui porte l'id :: " + idClient+ " non trouver!"));

        client.setNum_compte(clientDetails.getNum_compte());
        client.setNom(clientDetails.getNom());
        client.setPrenom(clientDetails.getPrenom());
        client.setSolde(clientDetails.getSolde());
        client.setNumero_phone(clientDetails.getNumero_phone());
        client.setAdress(clientDetails.getAdress());

        Client updatedClient = clientRepository.save(client);
        return updatedClient;
    }


    //Delete client
    @DeleteMapping("/{idClient}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "idClient") Long idClient)
            throws ResourceNoteFoundException {
             Client client = clientRepository.findById(idClient)
                .orElseThrow(() -> new ResourceNoteFoundException("Client qui porte l'id :: " + idClient+ " non trouver!"));
             System.out.println("deletePatient"+client.toString());
        clientRepository.delete(client);
        Map<String, Boolean> response = new HashMap<>();
        response.put("client supprimer", Boolean.TRUE);
        return response;

    }
}
/*
* client.setNum_compte(client.getNum_compte());
        client.setNom(client.getNom());
        client.setPrenom(client.getPrenom());
        client.setSolde(client.getSolde());
        client.setNumero_phone(client.getNumero_phone());
        client.setAdress(client.getAdress());*/