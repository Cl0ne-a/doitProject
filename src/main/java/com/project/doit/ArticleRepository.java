package com.project.doit;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "dbarticle", path = "dbarticle")
public interface ArticleRepository extends JpaRepository<DBArticle, Integer> {
    @NotNull List<DBArticle> findAll();
    List<DBArticle> findAllByColourEquals(Colour colour);
    int countDBArticleByReference(int id);
    int countByArticleReaderId(int id);
    int countDistinctByArticleReader(DBUser user);
}