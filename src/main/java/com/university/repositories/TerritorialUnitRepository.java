package com.university.repositories;

import com.university.domain.TerritorialUnit;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Repository
public interface TerritorialUnitRepository extends Neo4jRepository<TerritorialUnit, Long> {

    @Query("MATCH (n) RETURN n LIMIT 25")
    Collection<TerritorialUnit> getAll();

    @Query("MATCH (m:TerritorialUnit {name: 'Ukraine' } )-[:PARENT*0..15]->(r)<-[:RECEIVED]-(e:Revenue)  RETURN m,r,e")
    Collection<TerritorialUnit> getAllUsers();
}
