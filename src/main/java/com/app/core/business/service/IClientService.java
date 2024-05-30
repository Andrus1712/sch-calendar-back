package com.app.core.business.service;

import com.app.core.domain.entity.ClientEntity;

import java.util.List;

public interface IClientService {
    ClientEntity findById(Long id);

    List<ClientEntity> findAll();

    List<ClientEntity> findByName(String clientName);

    ClientEntity save(ClientEntity clientEntity);

    ClientEntity update(Long id, ClientEntity clientEntity);

    void delete(Long id);

    ClientEntity findByEmail(String email);

    ClientEntity findByPhone(String phone);

    List<ClientEntity> findByIdIn(List<Integer> ids);
}
