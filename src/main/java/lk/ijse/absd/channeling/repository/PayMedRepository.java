package lk.ijse.absd.channeling.repository;

import lk.ijse.absd.channeling.entity.Pay_med;
import lk.ijse.absd.channeling.entity.Pay_med_pk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayMedRepository extends JpaRepository<Pay_med, Pay_med_pk> {
}
