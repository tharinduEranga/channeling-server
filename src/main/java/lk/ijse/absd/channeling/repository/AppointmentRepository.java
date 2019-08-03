package lk.ijse.absd.channeling.repository;

import lk.ijse.absd.channeling.entity.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointments, Integer> {
}
