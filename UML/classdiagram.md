	
@startuml

class Person {
    - string name
    - int age
    - string gender
    + void set_name()
    + void set_age()
    + void set_gender()
    + void print()
}

class Administrator {
    - ArrayList<Person> staffs
    + void add_staff()
    + void print() 
}

class Staff {
    - Administrator administrator
    - string majord
    - Boolean 
    + void set_administrator()
    + void set_major()
    + string get_major()
    + void set_training()
    + void print()
}

class LOS{
    - ArrayList<Person> los
    + void add_staff()
    + Person find_staff_by_major()
    + void delete_staff()
    + void print_staffs()
}

Person <|-- Administrator
Person <|-- Staff
LOS "1" *-- "many" Person

class CourseDate{
    - int day
    - int month
    - int year
    + void set_day()
    + void set_month()
    + void set_year()
    + void print_date()
}

class TeachingRequire{
    - string className
    - CourseDate startDate
    - CourseDate endDate
    - int capacity
    - Person staff
    + void set_className()
    + void set_startDate()
    + void set_endDate()
    + void set_capacity()
    + void set_staff()
    + void print() 
}

class LOR{
    - ArrayList<TeachingRequire> lor
    + void add_teachingRequire()
    + Person find_teachingRequire_by_className()
    + void delete_teachingRequire()
    + void print_teachingRequires()
}

TeachingRequire "1" *-- "many" CourseDate
LOR "1" *-- "many" TeachingRequire
TeachingRequire *-- Person

@enduml