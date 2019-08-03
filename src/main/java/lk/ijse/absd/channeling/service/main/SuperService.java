package lk.ijse.absd.channeling.service.main;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SuperService<T, K> {
    T add(T t);

    T update(T t);

    T search(K k);

    boolean delete(K k);

    List<T> getAll();
}
