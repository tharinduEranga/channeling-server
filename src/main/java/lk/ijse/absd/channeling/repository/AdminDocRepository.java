package lk.ijse.absd.channeling.repository;

import lk.ijse.absd.channeling.entity.Admin_doctor;
import lk.ijse.absd.channeling.entity.Admin_doctor_pk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDocRepository extends JpaRepository<Admin_doctor, Admin_doctor_pk> {

}
