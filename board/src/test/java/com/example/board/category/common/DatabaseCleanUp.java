package com.example.board.category.common;

import com.example.board.category.adapter.out.persistence.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@ActiveProfiles("test")
public class DatabaseCleanUp {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    CategoryRepository categoryRepository;

    public void cleanUp() {
        categoryRepository.deleteAll();
    }

    @Transactional
    public void execute() {
        entityManager.flush();
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY FALSE").executeUpdate();
        entityManager.createNativeQuery("TRUNCATE TABLE CATEGORY").executeUpdate();
        entityManager.createNativeQuery("SET REFERENTIAL_INTEGRITY TRUE").executeUpdate();
    }
}
