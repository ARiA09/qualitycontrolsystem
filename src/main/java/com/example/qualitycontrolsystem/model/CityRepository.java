package com.example.qualitycontrolsystem.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    @Query(value = "SELECT * FROM city WHERE cid LIKE ?1 ORDER BY name", nativeQuery = true)
    City findCityByCid(String cid);
}
