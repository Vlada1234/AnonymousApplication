package com.anonymousask.anonymousask.repository;

import com.anonymousask.anonymousask.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
        Collection<Post> findAllByOrderByCreationDateDesc();

        Optional<Post> findById(Long id);
}
