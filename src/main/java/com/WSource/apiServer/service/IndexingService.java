package com.WSource.apiServer.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class IndexingService {
    private final EntityManager em;

    @Transactional
    public void initiateIndexing() throws InterruptedException {
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(em);
        fullTextEntityManager.createIndexer().startAndWait();
    }
}