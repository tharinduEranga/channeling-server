package lk.ijse.absd.channeling.repository;

import lk.ijse.absd.channeling.entity.Days;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaysRepository extends JpaRepository<Days, Integer> {
}
