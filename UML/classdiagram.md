	
@startuml

class Person {
    - String name
    - int age
    - String gender
    + void set_name()
    + String getName()
    + void set_age()
    + int getAge()
    + void set_gender()
    + getGender()
    + void print()
}

class Administrator {
    - ArrayList<Person> staffs
    + void add_staff()
    + void print()
}

class Staff {
    - Administrator administrator
    - String major
    - Boolean training
    + void set_administrator()
    + Administrator getAdministrator()
    + void set_major()
    + String getMajor()
    + string get_major()
    + void set_training()
    + boolean getTraining()
    + void print()
}

class LoS{
    - ArrayList<Staff> los
    + List<Staff> getLoS()
    + void add_staff()
    + Person find_staff_by_major()
}

Person <|-- Administrator
Person <|-- Staff
LoS "1" *-- "many" Person

class CourseDate{
    - int day
    - int month
    - int year
    + void set_day()
    + int getDay()
    + void set_month()
    + int getMonth()
    + void set_year()
    + int getYear()
    + void print_date()
}

class TeachingRequire{
    - String className
    - CourseDate startDate
    - CourseDate endDate
    - int capacity
    - Person staff
    + void set_className()
    + String getClassName()
    + void set_startDate()
    + String getRequirement()
    + void set_endDate()
    + int getCapacity()
    + void set_capacity()
    + Staff getStaff()
    + void set_staff()
    + CourseDate getStartDate()
    + void setStartDate()
    + CourseDate getEndDate()
    + void setEndDate()
    + void print() 
}

class LoR{
    - ArrayList<TeachingRequire> loR
    + List<TeachingRequire> getLoR()
    + void add_teachingRequire()
    + void update_teachRequire()
}

TeachingRequire "1" *-- "many" CourseDate
LoR "1" *-- "many" TeachingRequire
TeachingRequire *-- Person

Interface FileIO{
    + load()
    + save(ListOfData lod)
}

class FileIO_LoD{
    - String loc_filePath
    - String readJsonFile()
    - WriteJsonFile(String str_LoD)
}

FileIO <|-- FileIO_LoD

interface ListOfData {
    + print(PrintStream ps)
    + String get_json_str();
    + parse_json_str(String str_json);
}

ListOfData <|-- LoR
ListOfData <|-- LoS
FileIO_LoD *-- ListOfData

class main{
    + static void main(String[] args)
}
@enduml