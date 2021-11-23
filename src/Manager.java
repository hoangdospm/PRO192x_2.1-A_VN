/*
Lớp Manager kế thừa lớp Staff thực thi hàm tính lương của ICalculator,
ngoài ra còn có thêm trường chức danh - title.
*/
public class Manager extends Staff {
    private String title;

    public Manager(int id, String name, int factorOfSalary, String startDate, Department department, int dayOff, String title) {
        super(id, name, factorOfSalary, startDate, department, dayOff);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //Phương thức tính lương trách nhiệm dựa trên chức danh
    public int getTitleSalary() {
        switch (title) {
            case "Business Leader":
                return 8_000_000;
            case "Project Leader":
                return 5_000_000;
            case "Technical Leader":
                return 6_000_000;
        }
        return 0;
    }

//    @Override
//    public void displayInformation() {
//        System.out.println("Mã nhân viên            : " + super.getId());
//        System.out.println("Tên nhân viên           : " + super.getName());
//        System.out.println("Bộ phận làm việc        : " + super.getDepartment().getDepartmentName());
//        System.out.println("Hệ số lương             : " + super.getFactorOfSalary());
//        System.out.println("Ngày bắt đầu làm việc   : " + super.getStartDate());
//        System.out.println("Số ngày nghỉ            : " + super.getDayOff());
//        System.out.println("Chức danh               : " + getTitle());
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
        System.out.printf(format, "Chức danh:", getTitle());
        System.out.printf(format, "Lương nhân viên:", calculateSalary() + " VNĐ");
        System.out.printf("%n");
    }

    @Override
    public int calculateSalary() {
        return super.getFactorOfSalary() * 5_000_000 + getTitleSalary();
    }
}
