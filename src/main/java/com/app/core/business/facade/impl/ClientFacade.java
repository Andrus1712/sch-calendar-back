package com.app.core.business.facade.impl;

import com.app.core.business.facade.IClientFacade;
import com.app.core.business.mapper.ClientMapper;
import com.app.core.business.service.IClientService;
import com.app.core.domain.dto.ClientDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientFacade implements IClientFacade {

    private final IClientService clientService;
    private final ClientMapper clientMapper;

    @Override
    public List<ClientDTO> getAllClient() {
        var entities = this.clientService.findAll();
        return entities.stream()
                .map(this.clientMapper::toClientDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO findById(Long id) {
        return this.clientMapper.toClientDTO(this.clientService.findById(id));
    }

    @Override
    public ClientDTO createNew(ClientDTO clientDTO) {
        var entity = this.clientService.save(this.clientMapper.toClientEntity(clientDTO));
        return this.clientMapper.toClientDTO(entity);
    }

    @Override
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        return this.clientMapper.toClientDTO(this.clientService.update(id, this.clientMapper.toClientEntity(clientDTO)));
    }

    @Override
    public void delete(Long id) {
        this.clientService.delete(id);
    }
}
