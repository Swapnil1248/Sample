/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

 class Allergy{
    public enum ReporterEnum{
        PATIENT, RELATIVE, DOCTOR
    }

    public enum SeverityEnum{
        LOW, HIGH, MEDIUM
    }

     private Set<String> symptoms;
     private Date timeReported;
     private SeverityEnum severity;
     private ReporterEnum reporter;

     public void setTimeReported(Date time){
         this.timeReported = time;
     }

     public void setSymptoms(Set<String> symptoms) {
         this.symptoms = symptoms;
     }

     public Set<String> getSymptoms() {
         return symptoms;
     }

     public Date getTimeReported() {
         return timeReported;
     }

    public void setSeverity(SeverityEnum s){
         this.severity = s;
     }

     public void setReporter(ReporterEnum r){
         this.reporter = r;
     }
 }

class Patient{
   private String name;
   private List<Allergy> allergyList;

    public void setName(String name) {
        this.name = name;
    }

    public void setAllergyList(List<Allergy> allergyList) {
        this.allergyList = allergyList;
    }

    public String getName() {
        return name;
    }

    public List<Allergy> getAllergyList() {
        return allergyList;
    }
}
/* Name of the class has to be "Main" only if the class is public. */
public class AllergyTest
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Allergy a = new Allergy();
        Set<String> symptoms = new HashSet<String>();
        symptoms.add("Headache");
        symptoms.add("Nausea");
        a.setSymptoms(symptoms);
        a.setTimeReported(new Date()); // Check ways to add other dates

        Allergy.ReporterEnum reporter = Allergy.ReporterEnum.DOCTOR;
        Allergy.SeverityEnum severity = Allergy.SeverityEnum.LOW;

        a.setSeverity(severity);
        a.setReporter(reporter);

        Patient dummy = new Patient();
        dummy.setName("Cerner");
        List<Allergy> listOfAllegry = new ArrayList<Allergy>();
        listOfAllegry.add(a);
        dummy.setAllergyList(listOfAllegry);

        System.out.println("pupu");
    }
}