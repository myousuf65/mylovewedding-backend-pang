package xyz.yousuf.MyLoveWedding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.yousuf.MyLoveWedding.entities.Lawyer;

@Repository
public interface LawyerRepository extends JpaRepository<Lawyer, Long> {
}
