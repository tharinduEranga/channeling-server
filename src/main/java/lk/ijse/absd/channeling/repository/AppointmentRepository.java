package lk.ijse.absd.channeling.repository;

import lk.ijse.absd.channeling.entity.Appointments;
import lk.ijse.absd.channeling.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointments, Integer> {
    List<Appointments> findByDoctorAndDate(Doctor doctor, Date date);

    List<Appointments> findAllByDateAfterOrDateOrderByDateAsc(Date date, Date date2);
}
