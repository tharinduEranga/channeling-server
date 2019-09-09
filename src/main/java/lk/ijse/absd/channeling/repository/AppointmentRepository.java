package lk.ijse.absd.channeling.repository;

import lk.ijse.absd.channeling.dto.query.AppointmestsByMonth;
import lk.ijse.absd.channeling.entity.Appointments;
import lk.ijse.absd.channeling.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointments, Integer> {
    List<Appointments> findByDoctorAndDate(Doctor doctor, Date date);

    List<Appointments> findAllByDateAfterOrDateOrderByDateAsc(Date date, Date date2);

    @Query(value = "SELECT DISTINCT new lk.ijse.absd.channeling.dto.query.AppointmestsByMonth" +
            "( FUNCTION('MONTHNAME',a.date) , COUNT(a.appointmentId) ) " +
            "FROM Appointments a " +
            "WHERE year(a.date)= :year " +
            "GROUP by month(a.date)")
    List<AppointmestsByMonth> getAppointmentsMonthWiseByYear(@Param("year") int year);

}
