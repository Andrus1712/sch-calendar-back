package com.app.layer.business.service.impl;

import com.app.layer.business.service.IClientService;
import com.app.layer.common.exception.ClientNotFoundException;
import com.app.layer.domain.entity.ClientEntity;
import com.app.layer.business.mapper.persistence.dao.IClientDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements IClientService {

    private final IClientDAO clientDAO;

    @Override
    public ClientEntity findById(Long id) {
        return getClient(id);
    }

    private ClientEntity getClient(Long id) {
        var client = clientDAO.findById(id);
        if (client.isEmpty()) {
            throw new ClientNotFoundException();
        }
        return client.get();
    }

    @Override
    public List<ClientEntity> findAll() {
        return clientDAO.findAll();
    }

    @Override
    public List<ClientEntity> findByName(String clientName) {
        var client = clientDAO.findByName(clientName);
        if (client.isEmpty()) {
            throw new ClientNotFoundException();
        }
        return client.get();
    }

    @Override
    public ClientEntity save(ClientEntity clientEntity) {
        return clientDAO.save(clientEntity);
    }

    @Override
    public ClientEntity update(Long id, ClientEntity clientEntity) {
        var client = clientDAO.findById(id);
        if (client.isPresent()) {
            ClientEntity currentClient = client.get();
            currentClient.setFirstName(clientEntity.getFirstName());
            currentClient.setLastName(clientEntity.getLastName());
            currentClient.setEmail(clientEntity.getEmail());
            currentClient.setPhone(clientEntity.getPhone());
            currentClient.setBirthDate(clientEntity.getBirthDate());
            return clientDAO.update(currentClient);
        } else {
            throw new UnsupportedOperationException("Error while updating client");
        }
    }

    @Override
    public void delete(Long id) {
        try {

        var client = clientDAO.findById(id);
        if (client.isPresent()) {
            this.clientDAO.delete(id);
        } else {
            throw new ClientNotFoundException();
        }
        } catch (Exception e) {
            throw new UnsupportedOperationException("Error while deleting client");
        }
    }

    @Override
    public ClientEntity findByEmail(String email) {
        var client = clientDAO.findByEmail(email);
        if (client.isEmpty()) {
            throw new ClientNotFoundException();
        }
        return client.get();
    }

    @Override
    public ClientEntity findByPhone(String phone) {
        var client = clientDAO.findByPhone(phone);
        if (client.isEmpty()) {
            throw new ClientNotFoundException();
        }
        return client.get();
    }

    @Override
    public List<ClientEntity> findByIdIn(List<Integer> ids) {
        var client = clientDAO.findByIdIn(ids);
        if (client.isEmpty()) {
            throw new ClientNotFoundException();
        }
        return client.get();
    }
}
