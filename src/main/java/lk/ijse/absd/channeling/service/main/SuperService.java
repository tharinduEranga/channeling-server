package lk.ijse.absd.channeling.service.main;

import lk.ijse.absd.channeling.dto.util.CommonResponse;
import org.springframework.stereotype.Service;

@Service
public interface SuperService<T, K> {
    CommonResponse add(T t);

    CommonResponse update(T t);

    CommonResponse search(K k);

    CommonResponse delete(K k);

    CommonResponse getAll();
}
