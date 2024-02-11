package com.zeinDev.tryservice.repository;

import com.zeinDev.tryservice.entity.Try;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TryRepository extends JpaRepository<Try,Long> {


    Try findByTryId(String id);
}
