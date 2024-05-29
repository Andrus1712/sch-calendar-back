package com.app.layer.business.facade;

import com.app.layer.domain.dto.ClientDTO;

import java.util.List;

public interface IClientFacade {

    List<ClientDTO> getAllClient();

    ClientDTO findById(Long id);

    ClientDTO createNew(ClientDTO clientDTO);

    ClientDTO update(Long id, ClientDTO clientDTO);

    void delete(Long id);
}
