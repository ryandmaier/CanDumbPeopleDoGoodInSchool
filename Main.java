import com.opencsv.*;
import java.util.*;
import java.io.*;
public class Main
{
    String txt;
    ArrayList<String[]> responses = new ArrayList<String[]>();
    ArrayList<Course> courses = new ArrayList<Course>();
    

    public Main()
    {
        txt = "Can dumb people do good in school_ Smart people say yes! (Responses) - Form Responses 1.csv";
        run();
        System.out.println(getNumDataPoints());
        getMemesThatAreSexyAndDank();
    }

    public void run()
    {
        try {
            CSVReader reader = new CSVReader(new FileReader(txt));
            String[] nextLine;
            boolean firstDone = false;
            while((nextLine=reader.readNext())!=null)
            {
                if(firstDone)
                {
                    responses.add(nextLine);
                    for(int i = 4; i<59; i+=7)
                    {
                        if(!nextLine[i].equals(""))
                        {
                            Course c = new Course(nextLine[i], nextLine[i+1], nextLine[i+2], nextLine[i+3], nextLine[i+4], nextLine[i+5], nextLine[i+6]);
                            courses.add(c);
                        }

                    }
                } else firstDone = true;
            }//4,11,18
            System.out.println("Gotcha");
        } catch(IOException e) { System.out.println("u fucked up"); }
    }

    public int getNumDataPoints()
    {
        int sum = 0;
        for(int i = 1; i<responses.size(); i++)
        {
            String a = responses.get(i)[3];
            sum += new Integer(a.substring(0,1));
        }
        return sum;
    }

    public void getMemesThatAreSexyAndDank()
    {
        int rff = 0;
        int rft = 0;
        int wh = 0;
        int tv = 0;
        int gr = 0;
        for(int i = 0; i<courses.size(); i++)
        {
            Course c = courses.get(i);
            rff+=c.rFromFront;
            rft+=c.rFromTeacher;
            wh+=c.workHours;
            tv+=c.teacherVisits;
            gr+=c.grade;
        }
        int n = courses.size();
        System.out.println("Mean rows from front: " + rff/n);
        System.out.println("Mean rows from teacher: " + rft/n);
        System.out.println("Mean studying hours: " + wh/n);
        System.out.println("Mean teacher visit score: " + tv/n);
        System.out.println("Mean grade: " + gr/n);
        System.out.println();
    }

}
