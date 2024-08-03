package com.app.core.persistence.dao;

import com.app.core.domain.entity.ClientEntity;

import java.util.List;
import java.util.Optional;

public interface IClientDAO {
    Optional<ClientEntity> findById(Long id);

    List<ClientEntity> findAll();

    Optional<List<ClientEntity>> findByName(String clientName);

    ClientEntity save(ClientEntity clientEntity);

    ClientEntity update(ClientEntity clientEntity);

    void delete(Long id);

    Optional<ClientEntity> findByEmail(String email);

    Optional<ClientEntity> findByPhone(String phone);

    Optional<List<ClientEntity>> findByIdIn(List<Integer> ids);
}
