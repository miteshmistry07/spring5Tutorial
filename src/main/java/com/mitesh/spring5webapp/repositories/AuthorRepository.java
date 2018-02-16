package com.mitesh.spring5webapp.repositories;

import com.mitesh.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;
//allows you to do CRUD operations on the repository that you have without having to write SQL
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
