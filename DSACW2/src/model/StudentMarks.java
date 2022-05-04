package model;

public class StudentMarks implements Comparable<StudentMarks>{
    //variables added
    private String StudentID;
    private String GivenName;
    private String Lastname;
    private int CT1;
    private int CT2;
    private int CT3;
    private int ModuleMark;

//constructor
    public StudentMarks(){
        this.StudentID = "";
        this.GivenName = "";
        this.Lastname = "";
        this.CT1 = 0;
        this.CT2 = 0;
        this.CT3 = 0;
        this.ModuleMark = 0;
    }

    /**
     * This constructor will create an instance of Tournament Card
     * @param StudentID is the students ID
     * @param givenName is the students first name
     * @param lastname is the students lastname
     * @param ct1 is the students score for the first test
     * @param ct2 is the students score for the second test
     * @param ct3 is the students score for the third test
     * @param module mark is the students module mark
     */

    public String getStudentID() { return this.StudentID; }

    public void setStudentID(String studentID) { this.StudentID = studentID; }

    public String getGivenName() { return this.GivenName; }

    public void setGivenName(String givenName) { this.GivenName = givenName; }

    public String getLastname() { return this.Lastname; }

    public void setLastname(String lastname) { this.Lastname = lastname; }

    public int getCT1() { return this.CT1; }

    public void setCT1(int CT1) { this.CT1 = CT1; }

    public int getCT2() { return this.CT2; }

    public void setCT2(int CT2) { this.CT2 = CT2; }

    public int getCT3() { return this.CT3; }

    public void setCT3(int CT3) {this.CT3 = CT3; }

    public int getModuleMark() { return this.ModuleMark; }

    public void setModuleMark(int moduleMark) { this.ModuleMark = moduleMark; }

    public void calculateModuleMark(){
        int moduleMark = (int) ((this.CT1 * 0.3) + (this.CT2 * 0.3) + (this.CT3 * 0.4));
        this.setModuleMark(moduleMark);
    }

    public String CSVFormat(){
        String outputStr = this.StudentID + "," + this.GivenName + "," + this.Lastname + "," + this.CT1 + "," + this.CT2 + "," + this.CT3 + "," + this.ModuleMark + ",";
        return outputStr;
    }

    @Override
    public String toString() {
        return "StudentMarks{" +
                ", StudentID='" + StudentID + '\'' +
                ", GivenName='" + GivenName + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", OutwardNine=" + CT1 +
                ", InwardNine=" + CT2 +
                ", RoundTotal=" + CT3 +
                ", ModuleMark='" + ModuleMark + '\'' +
                '}';
    }

    @Override
    public int compareTo(StudentMarks anEntry) {

        return 0;
    }
}
