/*
Lớp trừu tượng Staff mô tả các đặc tính chung của nhân viên:
1. Phương thức trừu tượng displayInformation hiển thị thông tin
2. Các trường: mã nhân viên, tên, hệ số lương, ngày bắt đầu làm, bộ phận, số ngày nghỉ.
*/
abstract class Staff implements ICalculator {
    private int id;
    private String name;
    private int factorOfSalary;
    private String startDate;
    private Department department;
    private int dayOff;

    public Staff(int id, String name, int factorOfSalary, String startDate, Department department, int dayOff) {
        this.id = id;
        this.name = name;
        this.factorOfSalary = factorOfSalary;
        this.startDate = startDate;
        this.department = department;
        department.addStaffCount();
        this.dayOff = dayOff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFactorOfSalary() {
        return factorOfSalary;
    }

    public void setFactorOfSalary(int factorOfSalary) {
        this.factorOfSalary = factorOfSalary;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getDayOff() {
        return dayOff;
    }

    public void setDayOff(int dayOff) {
        this.dayOff = dayOff;
    }

    public abstract void  displayInformation();
}
