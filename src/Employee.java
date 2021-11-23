/*
Lớp Employee kế thừa lớp Staff thực thi hàm tính lương của ICalculator,
ngoài ra còn có thêm trường giờ làm thêm - overTimeHours.
*/
public class Employee extends Staff {
    private int overTimeHours;

    public Employee(int id, String name, int factorOfSalary, String startDate, Department department, int dayOff, int overTimeHours) {
        super(id, name, factorOfSalary, startDate, department, dayOff);
        this.overTimeHours = overTimeHours;
    }

    public int getOverTimeHours() {
        return overTimeHours;
    }

    public void setOverTimeHours(int overTimeHours) {
        this.overTimeHours = overTimeHours;
    }

//    @Override
//    public void displayInformation() {
//        System.out.println("Mã nhân viên            : " + super.getId());
//        System.out.println("Tên nhân viên           : " + super.getName());
//        System.out.println("Bộ phận làm việc        : " + super.getDepartment().getDepartmentName());
//        System.out.println("Hệ số lương             : " + super.getFactorOfSalary());
//        System.out.println("Ngày bắt đầu làm việc   : " + super.getStartDate());
//        System.out.println("Số ngày nghỉ            : " + super.getDayOff());
//        System.out.println("Số giờ làm thêm         : " + getOverTimeHours());
//        System.out.println("Lương nhân viên         : " + calculateSalary() + " VNĐ");
//        System.out.println();
//    }

    @Override
    public void displayInformation() {
        String format = "%-30s%s%n";
        System.out.printf(format, "Mã nhân viên:", super.getId());
        System.out.printf(format, "Tên nhân viên:", super.getName());
        System.out.printf(format, "Bộ phận làm việc:", super.getDepartment().getDepartmentName());
        System.out.printf(format, "Hệ số lương:", super.getFactorOfSalary());
        System.out.printf(format, "Ngày bắt đầu làm việc:", super.getStartDate());
        System.out.printf(format, "Số ngày nghỉ:", super.getDayOff());
        System.out.printf(format, "Số giờ làm thêm:", getOverTimeHours());
        System.out.printf(format, "Lương nhân viên:", calculateSalary() + " VNĐ");
        System.out.printf("%n");
    }

    @Override
    public int calculateSalary() {
        return super.getFactorOfSalary() * 3_000_000 + getOverTimeHours() * 200_000;
    }
}
