package com.app.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

@Reposi
public interface UserRestRepository extends PagingAndSortingRepository<User, Long> {
    List<User> findByRole(String role);
}
