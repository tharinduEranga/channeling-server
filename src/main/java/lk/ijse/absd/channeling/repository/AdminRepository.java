package lk.ijse.absd.channeling.repository;

import lk.ijse.absd.channeling.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByUserName(String userName);
}
