import java.util.List;

public class Main {

    public static void main(String[] args) {

        String file_patch_LoR = "list_of_teaching_requirements.txt";
        FileIO_LoD file_LoR = new FileIO_LoD(file_patch_LoR);

        String file_patch_LoS = "list_of_staffs.txt";
        FileIO_LoD file_LoS = new FileIO_LoD(file_patch_LoS);

        TeachingRequire course1 = new TeachingRequire("aaa","math",50,new CourseDate(25,12,2021),new CourseDate(3,12,2022));
        TeachingRequire course2 = new TeachingRequire("bbb","french",50,new CourseDate(25,12,2021),new CourseDate(3,12,2022));
        TeachingRequire course3 = new TeachingRequire("ccc","computer",50,new CourseDate(25,12,2021),new CourseDate(3,12,2022));

        LoR loR = new LoR();
        loR.add_teachingRequire(course1);
        loR.add_teachingRequire(course2);
        loR.add_teachingRequire(course3);

        // try {
        //     file_LoR.save(loR);
        // } catch (Exception e1) {
        //     e1.printStackTrace();
        // }

        Staff staff1 = new Staff("zzz",40,"male","math");
        Staff staff2 = new Staff("yyy",40,"female","computer");
        Staff staff3 = new Staff("xxx",40,"female","math");
        Staff staff4 = new Staff("www",40,"male","french");

        LoS loS = new LoS();
        loS.add_staff(staff1);
        loS.add_staff(staff2);
        loS.add_staff(staff3);
        loS.add_staff(staff4);

        // try {
        //     file_LoS.save(loS);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        Administrator administrator1 = new Administrator("ad1", 30, "male");
        administrator1.add_staff(staff1);
        administrator1.add_staff(staff2);
        Administrator administrator2 = new Administrator("ad2", 80, "male");
        administrator2.add_staff(staff3);
        administrator2.add_staff(staff4);

        List<TeachingRequire> requires = loR.getLoR();

        for (TeachingRequire teachingRequire:requires){
            Staff result = loS.find_staff_by_major(teachingRequire.getRequirement());
            if (result!=null){
                teachingRequire.setStaff(result);
                loR.update_teachRequire(teachingRequire);
                result.setTraining(true);
            }
            else {
                System.out.println("There is no suitable staff for class:"+teachingRequire.getClassName());
            }
        }

        loR.print(System.err);
        loS.print(System.err);
        administrator1.print(System.err);
        System.err.println();
        administrator2.print(System.err);
        System.err.println();
        System.err.println("------------------------------------");

        // FileIO fileIO = new FileIOImpl();
        // fileIO.save(loR, loS);

    }

}
