package lk.ijse.absd.channeling.repository;

import lk.ijse.absd.channeling.entity.Doc_days;
import lk.ijse.absd.channeling.entity.Doc_days_pk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocDaysRepository extends JpaRepository<Doc_days, Doc_days_pk> {
}
