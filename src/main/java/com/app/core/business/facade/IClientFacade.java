package com.app.core.business.facade;

import com.app.core.domain.dto.ClientDTO;

import java.util.List;

public interface IClientFacade {

    List<ClientDTO> getAllClient();

    ClientDTO findById(Long id);

    ClientDTO createNew(ClientDTO clientDTO);

    ClientDTO update(Long id, ClientDTO clientDTO);

    void delete(Long id);
}
