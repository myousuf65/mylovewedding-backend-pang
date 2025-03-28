package xyz.yousuf.MyLoveWedding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Jpa21Utils;
import org.springframework.stereotype.Repository;
import xyz.yousuf.MyLoveWedding.entities.Photographer;

@Repository
public interface PhotographerRepository extends JpaRepository<Photographer, Long> {
}
