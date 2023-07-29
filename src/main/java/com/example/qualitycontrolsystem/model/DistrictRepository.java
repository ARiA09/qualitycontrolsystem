package com.example.qualitycontrolsystem.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {

    @Query(value = "SELECT * FROM district WHERE did LIKE ?1% ORDER BY name", nativeQuery = true)
    List<District> findByDid(String id);

    @Query(value = "SELECT * FROM district WHERE did LIKE ?1 ORDER BY name", nativeQuery = true)
    District findDistrictByDid(String id);

}
