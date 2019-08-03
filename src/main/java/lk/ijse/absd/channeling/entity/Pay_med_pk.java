package lk.ijse.absd.channeling.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Pay_med_pk implements Serializable {
    private int medicineId;
    private int paymentId;

    public Pay_med_pk() {
    }

    public Pay_med_pk(int medicineId, int paymentId) {
        this.medicineId = medicineId;
        this.paymentId = paymentId;
    }


    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pay_med_pk that = (Pay_med_pk) o;
        return medicineId == that.medicineId &&
                paymentId == that.paymentId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(medicineId, paymentId);
    }

}
