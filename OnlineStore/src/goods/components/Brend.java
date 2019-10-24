package goods.components;

public class Brend {
    private int brandFoundationYear;
    private String brandName;
    private int brandEmployeesNumber;
    private int brandSellCountiesNumber;

    public Brend() {
    }

    public Brend(int brandFoundationYear, String brandName, int brandEmployeesNumber, int brandSellCountiesNumber) {
        this.brandFoundationYear = brandFoundationYear;
        this.brandName = brandName;
        this.brandEmployeesNumber = brandEmployeesNumber;
        this.brandSellCountiesNumber = brandSellCountiesNumber;
    }

    public int getBrandFoundationYear() {
        return brandFoundationYear;
    }

    public String getBrandName() {
        return brandName;
    }

    public int getBrandEmployeesNumber() {
        return brandEmployeesNumber;
    }

    public int getBrandSellCountiesNumber() {
        return brandSellCountiesNumber;
    }


}
