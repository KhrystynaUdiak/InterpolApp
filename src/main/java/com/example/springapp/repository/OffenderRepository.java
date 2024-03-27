package com.example.springapp.repository;

import com.example.springapp.model.Offender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface OffenderRepository extends JpaRepository<Offender, Long> {
    @Query(value = "SELECT o from Offender o " +
            "where (:firstName is NULL or o.firstName ilike  %:firstName%) " +
            "and (:lastName is NULL or o.lastName ilike %:lastName%) " +
            "and (:alias is NULL or o.alias ilike %:alias%) " +
            "and (:minAge is NULL or o.age > :minAge -1) " +
            "and (:maxAge is NULL or o.age < :maxAge +1)" +
            "and (:keyword is NULL or o.firstName ilike %:keyword% or o.lastName ilike %:keyword% or o.alias ilike %:keyword% or o.criminalCase ilike %:keyword%) " +
            "and (:lastPlaceOfResidence is NULL or o.location.id in (select id from Location where lastPlaceOfResidence ilike %:lastPlaceOfResidence%)) ORDER BY o.lastName" )
    List<Offender> getByCriteria(@Param ("firstName") String firstName, @Param ("lastName") String lastName, @Param ("alias") String alias,
                                @Param ("minAge") Integer minAge, @Param ("maxAge") Integer maxAge,
                                 @Param ("lastPlaceOfResidence") String lastPlaceOfResidence, @Param("keyword") String keyword);

}