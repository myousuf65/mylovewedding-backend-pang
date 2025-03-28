package xyz.yousuf.MyLoveWedding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yousuf.MyLoveWedding.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);

    Customer findByName(String name);
}
