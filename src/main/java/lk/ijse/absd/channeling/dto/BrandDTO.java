package lk.ijse.absd.channeling.dto;

public class BrandDTO {
    private int brandId;
    private String name;

    public BrandDTO() {
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BrandDTO{" +
                "brandId=" + brandId +
                ", name='" + name + '\'' +
                '}';
    }
}
