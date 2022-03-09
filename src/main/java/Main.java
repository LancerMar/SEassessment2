import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        String file_patch_LoR = "list_of_teaching_requirements.txt";
        FileIO file_LoR = new FileIO_LoD(file_patch_LoR);

        String file_patch_LoS = "list_of_staffs.txt";
        FileIO file_LoS = new FileIO_LoD(file_patch_LoS);

        ListOfData lodR = file_LoR.load();
        ListOfData lodS = file_LoS.load();
        LoR loR = (LoR) lodR;
        LoS loS = (LoS) lodS;

        System.err.println("-----This is the data that read from file-----");
        loR.print(System.err);
        loS.print(System.err);

        TeachingRequire course1 = new TeachingRequire("Basic Chinese","chinese",70,new CourseDate(11,1,2022),new CourseDate(20,4,2022));
        TeachingRequire course2 = new TeachingRequire("Web Science","computer",95,new CourseDate(7,1,2022),new CourseDate(1,3,2022));
        TeachingRequire course3 = new TeachingRequire("Algorithms","math",150,new CourseDate(30,12,2021),new CourseDate(5,3,2022));
        loR.add_teachingRequire(course1);
        loR.add_teachingRequire(course2);
        loR.add_teachingRequire(course3);

        Staff staff1 = new Staff("Kroos",21,"male","chinese","is training");
        Staff staff2 = new Staff("Yuki",25,"female","chinese","not trained");
        Staff staff3 = new Staff("Emma",30,"female","computer","is training");
        Staff staff4 = new Staff("Bob",43,"male","electronic","not trained");
        loS.add_staff(staff1);
        loS.add_staff(staff2);
        loS.add_staff(staff3);
        loS.add_staff(staff4);

        List<Staff> staffs = loS.getLoS();
        Administrator administrator1 = new Administrator("Zoe", 41, "female");
        administrator1.add_staff(staffs.get(0));
        administrator1.add_staff(staffs.get(1));
        administrator1.add_staff(staff1);
        administrator1.add_staff(staff2);
        Administrator administrator2 = new Administrator("Viktor", 37, "male");
        administrator2.add_staff(staffs.get(2));
        administrator2.add_staff(staffs.get(3));
        administrator2.add_staff(staff3);
        administrator2.add_staff(staff4);

        System.err.println();
        System.err.println("-----This is result of searching suitable staff-----");
        administrator1.search_staff(loR,loS);

        System.err.println();
        System.err.println("-----This is the result of this course system-----");
        loR.print(System.err);
        loS.print(System.err);
        administrator1.print(System.err);
        System.err.println();
        administrator2.print(System.err);
        System.err.println();
        file_LoR.save(loR);
        file_LoS.save(loS);
        System.err.println("-----Data of classes and staffs has been saved in file-----");

    }

}
