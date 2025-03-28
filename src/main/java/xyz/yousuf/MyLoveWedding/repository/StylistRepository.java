package xyz.yousuf.MyLoveWedding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.yousuf.MyLoveWedding.entities.Stylist;

@Repository
public interface StylistRepository extends JpaRepository<Stylist, Long> {
}
