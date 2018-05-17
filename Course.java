
public class Course
{
    String name;
    boolean assigned;
    double grade;
    double rFromFront;
    double rFromTeacher;
    double workHours;
    double teacherVisits;

    static double rff;
    static double rft;
    static double wh;
    static double tv;
    static double gr;
    static double num;

    public Course()
    {

    }

    public Course(String name, String assigned, String grade, String rFromFront, String rFromTeacher, String workHours, String teacherVisits)
    {
        this.name = name;
        if(assigned.equals("No"))
        {
            this.assigned = false;
        } else this.assigned = true;
        this.grade = strToDub(grade, 5);
        this.rFromFront = strToDub(rFromFront, 1);
        this.rFromTeacher = strToDub(rFromTeacher, 2);
        this.workHours = strToDub(workHours, 3);
        this.teacherVisits = strToDub(teacherVisits, 4);
    }

    public void setName(String n)
    {
        name = n;
    }

    public void setAssigned(boolean n)
    {
        assigned = n;
    }

    public void setGrade(double n)
    {
        grade = n;
    }

    public void setRFromFront(int n)
    {
        rFromFront = n;
    }

    public void setRFromTeacher(int n)
    {
        rFromTeacher = n;
    }

    public void setWorkHours(int n)
    {
        workHours = n;
    }

    public void setTeacherVisits(int n)
    {
        teacherVisits = n;
    }

    public double strToDub(String str, int i)
    {
        if(!str.equals(""))
        {
            double a = new Double(str);
            switch(i) {
                case 1: {
                    rff+=a;
                    break;
                }
                case 2: {
                    rft+=a;
                    break;
                }
                case 3: {
                    wh+=a;
                    break;
                }
                case 4: {
                    tv+=a;
                    break;
                }
                case 5: {
                    gr+=a;
                    break;
                }
            }
            num+=1;
            return a;
        } else {
            switch(i) {
                case 1: {
                    return rff/num;
                    //break;
                }
                case 2: {
                    return rft/num;
                    //break;
                }
                case 3: {
                    return wh/num;
                    //break;
                }
                case 4: {
                    return tv/num;
                    //break;
                }
            }
        }
        return 0;
    }

}
