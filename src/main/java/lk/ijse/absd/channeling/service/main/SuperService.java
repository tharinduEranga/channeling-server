package lk.ijse.absd.channeling.service.main;

import lk.ijse.absd.channeling.dto.util.CommonResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SuperService<T, K> {
    CommonResponse<T> add(T t);

    CommonResponse<T> update(T t);

    CommonResponse<T> search(K k);

    CommonResponse<T> delete(K k);

    CommonResponse<List<T>> getAll();
}
