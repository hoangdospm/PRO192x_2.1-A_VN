import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/*
Lớp HumanResources thực hiện chương trình quản lý nhân sự.
*/
public class HumanResources {
    //ArrayList departments lưu các bộ phận của công ty
    public static ArrayList<Department> departments = new ArrayList<>();

    //ArrayList titles lưu các chức danh của quản lý
    public static ArrayList<String> titles = new ArrayList<>();

    //ArrayList staffs lưu tất cả nhân viên của công ty
    public static ArrayList<Staff> staffs = new ArrayList<>();

    //Phương thức chạy luồng chính của chương trình
    public static void main(String[] args) {
        //Gọi 2 phương thức khởi tạo các bộ phận, chức danh
        initiateDepartment();
        initiateTitle();
        //Gọi khởi tạo sẵn 11 nhân viên, comment dòng dưới nếu muốn bắt đầu từ 0 nhân viên
        initiateStaff();
        Scanner console = new Scanner(System.in);
        boolean stop = false;
        String control;
        do {
            control = chooseFunction(console);
            switch (control) {
                case "0":
                    stop = true;
                    displayEscape();
                    break;
                case "1":
                    displayAllStaff();
                    break;
                case "2":
                    displayAllDepartment();
                    break;
                case "3":
                    displayStaffOfDepartment();
                    break;
                case "4":
                    importStaff(console);
                    break;
                case "5":
                    searchStaff(console);
                    break;
                case "6":
                    displayStaffSalary();
                    break;
                case "7":
                    displayStaffSortBySalary(console);
                    break;
                default:
                    displayError(control);
                    break;
            }
        } while (!stop);
    }

    //Phương thức khởi tạo các bộ phận của công ty
    public static void initiateDepartment() {
        departments.add(new Department(0, "Xây dựng phần mềm"));
        departments.add(new Department(1, "Thiết kế Web / App"));
        departments.add(new Department(2, "Nghiên cứu sản phẩm"));
    }

    //Phương thức khởi tạo các chức danh của quản lý
    public static void initiateTitle() {
        titles.add("Business Leader");
        titles.add("Project Leader");
        titles.add("Technical Leader");
    }

    //Phương thức khởi tạo 11 nhân viên
    public static void initiateStaff() {
        Staff employee0 = new Employee(0, "Prom", 5, "20/01/2009", departments.get(2), 2, 11);
        Staff employee1 = new Employee(1, "Alex", 2, "20/01/2021", departments.get(0), 2, 3);
        Staff employee2 = new Employee(2, "Bob", 3, "20/01/2019", departments.get(2), 10, 6);
        Staff employee3 = new Employee(3, "David", 2, "01/03/2019", departments.get(2), 11, 6);
        Staff employee4 = new Employee(4, "Europe", 1, "01/08/2021", departments.get(1), 1, 2);
        Staff employee5 = new Employee(5, "Fury", 2, "01/08/2020", departments.get(0), 2, 2);
        Staff employee6 = new Employee(6, "Glory", 8, "12/08/2007", departments.get(2), 0, 13);
        Staff employee7 = new Employee(7, "Harry", 4, "23/11/2015", departments.get(1), 12, 0);
        Staff manager1 = new Manager(8, "Claw", 3, "20/01/2019", departments.get(0), 10, "Business Leader");
        Staff manager2 = new Manager(9, "Black", 4, "01/01/2010", departments.get(1), 2, "Technical Leader");
        Staff manager3 = new Manager(10, "Ken", 2, "31/01/2021", departments.get(2), 3, "Project Leader");
        staffs.add(employee0);
        staffs.add(employee1);
        staffs.add(employee2);
        staffs.add(employee3);
        staffs.add(employee4);
        staffs.add(employee5);
        staffs.add(employee6);
        staffs.add(employee7);
        staffs.add(manager1);
        staffs.add(manager2);
        staffs.add(manager3);
    }

    //Phương thức hiển thị menu tổng và lấy yêu cầu từ người dùng
    public static String chooseFunction(Scanner console) {
        String control;
        System.out.println("MENU TỔNG - LỰA CHỌN CHỨC NĂNG");
        System.out.println("Phím 1. Hiển thị danh sách nhân viên hiện có trong công ty.");
        System.out.println("Phím 2. Hiển thị các bộ phận trong công ty.");
        System.out.println("Phím 3. Hiển thị các nhân viên theo từng bộ phận.");
        System.out.println("Phím 4. Thêm nhân viên mới vào công ty.");
        System.out.println("Phím 5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên.");
        System.out.println("Phím 6. Hiển thị bảng lương của nhân viên toàn công ty.");
        System.out.println("Phím 7. Hiển thị danh sách nhân viên tăng / giảm dần theo lương.");
        System.out.println("Phím 0. Kết thúc chương trình.");
        System.out.print("-> Chọn chức năng của bạn: ");
        control = console.nextLine().trim();
        System.out.println();
        return control;
    }

    //Phương thức hiển thị lời chào khi người dùng chọn kết thúc chương trình
    public static void displayEscape() {
        System.out.println("Xin chào và hẹn gặp lại.");
        System.out.println("CHƯƠNG TRÌNH KẾT THÚC!");
    }

    //Phương thức hiển thị thông tin của tất cả nhân viên
    public static void displayAllStaff() {
        System.out.println("THÔNG BÁO: Bạn vừa yêu cầu hiển thị toàn bộ nhân viên (Chức năng 1).");
        if (staffs.size() == 0) {
            System.out.println("Hiện tại công ty không có nhân viên nào.");
            System.out.println("Không thể hiển thị toàn bộ nhân viên.");
            System.out.println();
            return;
        }
        for (Staff staff : staffs) {
            staff.displayInformation();
        }
    }

    //Phương thức hiển thị thông tin của tất cả bộ phận
    public static void displayAllDepartment() {
        System.out.println("THÔNG BÁO: Bạn vừa yêu cầu hiển thị danh sách bộ nhận (Chức năng 2).");
        for (Department department : departments) {
            System.out.println("-) " + department);
        }
        System.out.println();
    }

    //Phương thức hiển thị thông tin của nhân viên theo từng bộ phận
    public static void displayStaffOfDepartment() {
        System.out.println("THÔNG BÁO: Bạn vừa yêu cầu hiển thị nhân viên theo bộ phận (Chức năng 3).");
        if (staffs.size() == 0) {
            System.out.println("Hiện tại công ty không có nhân viên nào.");
            System.out.println("Không thể hiển thị nhân viên theo bộ phận.");
            System.out.println();
            return;
        }
        for (Department department : departments) {
            System.out.println(department);
            System.out.println();
            for (Staff staff : staffs) {
                if (staff.getDepartment().getDepartmentId() == department.getDepartmentId()) {
                    staff.displayInformation();
                }
            }
            System.out.println("-------------------------");
            System.out.println();
        }
    }

    //Phương thức thêm nhân viên mới
    public static void importStaff(Scanner console) {
        System.out.println("THÔNG BÁO: Bạn vừa yêu cầu nhập nhân viên (Chức năng 4).");
        System.out.println("Phím 1. Nhập nhân viên thông thường.");
        System.out.println("Phím 2. Nhập nhân viên cấp quản lý.");
        System.out.println("Phím 0. Thoát chức năng.");
        System.out.print("-> Chọn chức năng của bạn: ");
        String control = console.nextLine().trim();
        System.out.println();
        switch (control) {
            case "0":
                return;
            case "1":
                importEmployee(console);
                break;
            case "2":
                importManager(console);
                break;
            default:
                displayError(control);
                break;
        }
    }

    //Phương thức thêm nhân viên thông thường
    public static void importEmployee(Scanner console) {
        System.out.println("Nhập thông tin nhân viên thông thường.");
        int id = importId(console);
        String name = importName(console);
        int factorOfSalary = importFactorOfSalary(console);
        String startDate = importStaffDate(console);
        Department department = importDepartment(console);
        int dayOff = importDayOff(console);
        int overTimeHours = importOverTimeHours(console);
        Staff staff = new Employee(id, name, factorOfSalary, startDate, department, dayOff, overTimeHours);
        staffs.add(staff);
        System.out.println("Đã nhập xong, hiển thị thông tin nhân viên mới nhập.");
        staff.displayInformation();
    }

    //Phương thức thêm nhân viên cấp quản lý
    public static void importManager(Scanner console) {
        System.out.println("Nhập thông tin nhân viên cấp quản lý.");
        int id = importId(console);
        String name = importName(console);
        int factorOfSalary = importFactorOfSalary(console);
        String startDate = importStaffDate(console);
        Department department = importDepartment(console);
        int dayOff = importDayOff(console);
        String title = importTitle(console);
        Staff staff = new Manager(id, name, factorOfSalary, startDate, department, dayOff, title);
        staffs.add(staff);
        System.out.println("Đã nhập xong, hiển thị thông tin nhân viên mới nhập.");
        staff.displayInformation();
    }

    //Phương thức nhập mã nhân viên mới
    public static int importId(Scanner console) {
        System.out.print("Nhập mã nhân viên: ");
        int id = console.nextInt();
        console.nextLine();
        return id;
    }

    //Phương thức nhập tên nhân viên mới
    public static String importName(Scanner console) {
        System.out.print("Nhập tên nhân viên: ");
        return console.nextLine().trim();
    }

    //Phương thức nhập hệ số lương của nhân viên mới
    public static int importFactorOfSalary(Scanner console) {
        System.out.print("Nhập hệ số lương: ");
        int factorOfSalary = console.nextInt();
        console.nextLine();
        return factorOfSalary;
    }

    //Phương thức nhập ngày làm việc của nhân viên mới
    public static String importStaffDate(Scanner console) {
        System.out.print("Nhập ngày bắt đầu làm việc (dd/mm/yyyy): ");
        return console.nextLine();
    }

    //Phương thức nhập bộ phận làm việc của nhân viên mới
    public static Department importDepartment(Scanner console) {
        System.out.println("Nhập bộ phận làm việc: ");
        System.out.println("-) Phím 0 để chọn bộ phận Xây dựng phần mềm.");
        System.out.println("-) Phím 1 để chọn bộ phận Thiết kế Web / App.");
        System.out.println("-) Phím 2 để chọn bộ phận Nghiên cứu sản phẩm.");
        System.out.print("-> Chọn bộ phận: ");
        int departmentId = console.nextInt();
        return departments.get(departmentId);
    }

    //Phương thức nhập số ngày nghỉ của nhân viên mới
    public static int importDayOff(Scanner console) {
        System.out.print("Nhập số ngày nghỉ: ");
        return console.nextInt();
    }

    //Phương thức nhập số giờ làm thêm của nhân viên mới
    public static int importOverTimeHours(Scanner console) {
        System.out.print("Nhập giờ làm thêm: ");
        int overTimeHours = console.nextInt();
        console.nextLine();
        return overTimeHours;
    }

    //Phương thức nhập chức danh của nhân viên mới
    public static String importTitle(Scanner console) {
        System.out.println("Nhập chức danh: ");
        System.out.println("-) Phím 0 để chọn chức danh Business Leader.");
        System.out.println("-) Phím 1 để chọn chức danh Project Leader.");
        System.out.println("-) Phím 2 để chọn chức danh Technical Leader.");
        System.out.print("-> Chọn chức danh: ");
        int titleIndex = console.nextInt();
        console.nextLine();
        return titles.get(titleIndex);
    }

    //Phương thức tìm kiếm nhân viên theo mã hoặc tên
    public static void searchStaff(Scanner console) {
        System.out.println("THÔNG BÁO: Bạn vừa yêu cầu tìm kiếm nhân viên (Chức năng 5).");
        if (staffs.size() == 0) {
            System.out.println("Hiện tại công ty không có nhân viên nào.");
            System.out.println("Không thể tìm kiếm nhân viên.");
            System.out.println();
            return;
        }
        System.out.println("Phím 1. Tìm kiếm theo mã nhân viên.");
        System.out.println("Phím 2. Tìm kiếm theo tên nhân viên.");
        System.out.println("Phím 0. Thoát chức năng.");
        System.out.print("-> Chọn chức năng của bạn: ");
        String control = console.nextLine().trim();
        System.out.println();
        switch (control) {
            case "0":
                return;
            case "1":
                searchStaffById(console);
                break;
            case "2":
                searchStaffByName(console);
                break;
            default:
                displayError(control);
                break;
        }
    }

    //Phương thức tìm kiếm nhân viên bằng mã
    public static void searchStaffById(Scanner console) {
        System.out.print("Bạn vừa yêu cầu tìm kiếm theo mã nhân viên, vui lòng nhập mã: ");
        int staffId = console.nextInt();
        console.nextLine();
        boolean invalidId = true;
        for (Staff staff : staffs) {
            if (staff.getId() == staffId) {
                invalidId = false;
                staff.displayInformation();
                break;
            }
        }
        if (invalidId) {
            System.out.println("Mã nhân viên không hợp lệ! Không thể tìm thấy nhân viên!");
            System.out.println();
        }
    }

    //Phương thức tìm kiếm nhân viên bằng tên
    public static void searchStaffByName(Scanner console) {
        System.out.print("Bạn vừa yêu cầu tìm kiếm theo tên nhân viên, vui lòng nhập tên: ");
        String staffName = console.nextLine().trim().toLowerCase();
        boolean invalidName = true;
        for (Staff staff : staffs) {
            if (staffName.equals(staff.getName().toLowerCase())) {
                invalidName = false;
                staff.displayInformation();
                break;
            }
        }
        if (invalidName) {
            System.out.println("Tên nhân viên không hợp lệ! Không thể tìm thấy nhân viên!");
            System.out.println();
        }
    }

    //Phương thức hiển thị bảng lương của tất cả nhân viên
    public static void displayStaffSalary() {
        System.out.println("THÔNG BÁO: Bạn vừa yêu cầu hiển thị bảng lương nhân viên (Chức năng 6).");
        if (staffs.size() == 0) {
            System.out.println("Hiện tại công ty không có nhân viên nào.");
            System.out.println("Không thể hiển thị bảng lương.");
            System.out.println();
            return;
        }
        String format = "%-20s%-30s%s%n";
        System.out.printf(format, "Mã nhân viên", "Tên nhân viên", "Lương");
        for (Staff staff : staffs) {
            System.out.printf(format, staff.getId(), staff.getName(), staff.calculateSalary() + " VNĐ");
        }
        System.out.println();
    }

    //Phương thức sắp xếp nhân viên tăng / giảm dần theo lương và hiển thị danh sách
    public static void displayStaffSortBySalary(Scanner console) {
        System.out.println("THÔNG BÁO: Bạn vừa yêu cầu hiển thị nhân viên đã sắp xếp (Chức năng 7).");
        if (staffs.size() == 0) {
            System.out.println("Hiện tại công ty không có nhân viên nào.");
            System.out.println("Không thể sắp xếp và hiển thị nhân viên.");
            System.out.println();
            return;
        }
        System.out.println("Phím 1. Sắp xếp tăng dần.");
        System.out.println("Phím 2. Sắp xếp giảm dần.");
        System.out.println("Phím 0. Thoát chức năng.");
        System.out.print("-> Chọn chức năng của bạn: ");
        String control = console.nextLine().trim();
        System.out.println();
        //Định nghĩa Comparator tăng / giảm dần theo lương phục vụ cho phương thức sắp xếp
        Comparator <Staff> salaryAscending = (o1, o2) -> o1.calculateSalary() - o2.calculateSalary();
        Comparator <Staff> salaryDescending = (o1, o2) -> o2.calculateSalary() - o1.calculateSalary();
        switch (control) {
            case "0":
                return;
            case "1":
                staffs.sort(salaryAscending);
                break;
            case "2":
                staffs.sort(salaryDescending);
                break;
            default:
                displayError(control);
                return;
        }
        displayStaffSalary();
    }

    //Phương thức hiển thị thông báo người dùng nhập yêu cầu không hợp lệ
    public static void displayError(String control) {
        System.out.println("Bạn vừa nhập [" + control + "]. Yêu cầu không hợp lệ!");
        System.out.println("Thực hiện chức năng thất bại! Chuyển về Menu tổng.");
        System.out.println();
    }
}