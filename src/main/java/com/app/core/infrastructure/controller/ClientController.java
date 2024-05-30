package com.app.core.infrastructure.controller;

import com.app.core.business.facade.IClientFacade;
import com.app.core.domain.dto.ClientDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/client")
@AllArgsConstructor
public class ClientController {

    private final IClientFacade clientFacade;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClient() {
        return new ResponseEntity<>(this.clientFacade.getAllClient(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id) {
        return new ResponseEntity<>(this.clientFacade.findById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {
        return new ResponseEntity<>(this.clientFacade.createNew(clientDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        return new ResponseEntity<>(this.clientFacade.update(id, clientDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ClientDTO> deleteClient(@PathVariable Long id) {
        this.clientFacade.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
