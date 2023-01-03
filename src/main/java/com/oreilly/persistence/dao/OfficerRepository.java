package com.oreilly.persistence.dao;

import com.oreilly.persistence.entities.Officer;
import com.oreilly.persistence.entities.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OfficerRepository extends JpaRepository<Officer, Integer> {
    List<Officer> findByRank(Rank rank);
    List<Officer> findByLastNameLikeAndRank(String like, Rank rank);
    List<Officer> findAllByRankAndLastNameContaining(Rank rank, String string);
    List<Officer> findAllByRankAndFirstNameContaining(Rank rank, String string);
    Optional<Officer> findById(Integer id);
    List<Officer> deleteByFirstNameAndRank(String name, Rank rank);
}
