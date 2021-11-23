/*
Lớp Department gồm các thông tin của một bộ phận:
mã bộ phận, tên bộ phận, số nhân viên trong 1 bộ phận.
*/
public class Department {
    private int departmentId;
    private String departmentName;
    private int staffCount;

    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.staffCount = 0;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getStaffCount() {
        return staffCount;
    }

    public void setStaffCount(int staffCount) {
        this.staffCount = staffCount;
    }

    public void addStaffCount() {
        this.staffCount++;
    }

    public void subtractStaffCount() {
        this.staffCount--;
    }

    @Override
    public String toString() {
        String format = "%-30s%-10s%s";
        return String.format(format, "Bộ phận: " + departmentName, "Mã: " + departmentId, "Số nhân viên: " + staffCount);
    }
}
