package com.example.qualitycontrolsystem.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WardRepository extends JpaRepository<Ward, Long> {
    @Query(value = "SELECT * FROM ward WHERE wid LIKE ?1% ORDER BY name", nativeQuery = true)
    List<Ward> findByWid(String id);

    @Query(value = "SELECT * FROM ward WHERE wid LIKE ?1 ORDER BY name", nativeQuery = true)
    Ward findWardByWid(String id);
}
