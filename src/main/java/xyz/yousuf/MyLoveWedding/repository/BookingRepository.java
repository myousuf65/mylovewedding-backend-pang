package xyz.yousuf.MyLoveWedding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.yousuf.MyLoveWedding.entities.Booking;
import xyz.yousuf.MyLoveWedding.entities.Customer;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByCustomer(Customer customer);
}
