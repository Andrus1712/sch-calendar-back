package com.app.layer.business.mapper.persistence.dao.impl;

import com.app.layer.business.mapper.persistence.dao.IClientDAO;
import com.app.layer.domain.entity.ClientEntity;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class ClientDAOImpl implements IClientDAO {

    private final EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public Optional<ClientEntity> findById(Long id) {
        var entity = entityManager.find(ClientEntity.class, id);
        return Optional.ofNullable(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientEntity> findAll() {
        return entityManager.createQuery("from ClientEntity", ClientEntity.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ClientEntity>> findByName(String clientName) {
        var entity = entityManager.createQuery("from ClientEntity where (firstName = :firstName or lastName = :lastName)", ClientEntity.class)
                .setParameter("firstName", clientName)
                .setParameter("lastName", clientName)
                .getResultList();
        return Optional.ofNullable(entity);
    }

    @Override
    @Transactional
    public ClientEntity save(ClientEntity clientEntity) {
        entityManager.persist(clientEntity);
        entityManager.flush();
        return clientEntity;
    }

    @Override
    @Transactional
    public ClientEntity update(ClientEntity clientEntity) {
        return entityManager.merge(clientEntity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        entityManager.remove(entityManager.find(ClientEntity.class, id));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClientEntity> findByEmail(String email) {
        var entity = entityManager.createQuery("from ClientEntity where email = :email", ClientEntity.class)
                .setParameter("email", email)
                .getSingleResult();
        return Optional.ofNullable(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClientEntity> findByPhone(String phone) {
        var entity = entityManager.createQuery("from ClientEntity where phone = :phone", ClientEntity.class)
                .setParameter("phone", phone)
                .getSingleResult();
        return Optional.ofNullable(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<ClientEntity>> findByIdIn(List<Integer> ids) {
        var entity = entityManager.createQuery("from ClientEntity where id in (:ids)", ClientEntity.class)
                .setParameter("ids", ids)
                .getResultList();
        return Optional.ofNullable(entity);
    }
}
