package daos;

import app.StudentMarksBST;
import datastructures.BinarySearchTree;
import helpers.Sorts;
import helpers.TextColours;
import model.DisplayOrder;
import model.StudentMarks;
import view.aView;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class bstDAOImpl<E> extends DAO<E>{

    private BinarySearchTree<StudentMarks> theBST;
    private final aView theView;
    public static final char DELIMITER = ',';
    public static final char EOLN='\n';
    public static final String QUOTE="\"";
    public static final String USERDIRECTORY = System.getProperty("user.dir");

    private String stripQuotes(String str) {
        return str.substring(1, str.length()-1);
    }

    public bstDAOImpl() {
        this.theBST = new BinarySearchTree<>();
        this.theView = new aView();
    }

    public BinarySearchTree<StudentMarks> getTheBST() { return theBST; }

    public void setTheBST(BinarySearchTree<StudentMarks> theBST) { this.theBST = theBST; }

    @Override
    public void loadFromFile(String filename) {
        String transactionFile = USERDIRECTORY +"\\" + filename;
        ArrayList<StudentMarks> dataSet = new ArrayList<>();
        Sorts<StudentMarks> sort = new Sorts<>();

        try (BufferedReader br = new BufferedReader(new FileReader(transactionFile))) {
            // variables
            String theStudentID;
            String theGivenName;
            String theLastname;
            int theCT1;
            int theCT2;
            int theCT3;
            int theModuleMark;

            String[] temp;
            String line = br.readLine();
            while(line!=null){
                temp=line.split(Character.toString(DELIMITER));
                theStudentID = temp[0];
                theGivenName = temp[1];
                theLastname = temp[2];
                theCT1 = Integer.parseInt(temp[3]);
                theCT2= Integer.parseInt(temp[4]);
                theCT3 = Integer.parseInt(temp[5]);
                theModuleMark = Integer.parseInt(temp[6]);

                StudentMarks aMark = new StudentMarks();
                aMark.setStudentID(theStudentID);
                aMark.setGivenName(theGivenName);
                aMark.setLastname(theLastname);
                aMark.setCT1(theCT1);
                aMark.setCT2(theCT2);
                aMark.setCT3(theCT3);
                aMark.calculateModuleMark();

                // Insert into the dataset
                this.theBST.addNode(aMark);
                dataSet.add(aMark);
                line = br.readLine();

            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(StudentMarksBST.class.getName()).log(Level.INFO, null, ex);
        }

        sort.BSort(dataSet);
        this.theBST.createBalancedTree(dataSet,0, dataSet.size() - 1);

    }

    @Override
    public void writeToFile(String filename) {
        try {
            File myFile = new File(USERDIRECTORY +"\\" + filename);

            if(myFile.exists()){
                myFile.delete();
                System.out.println("File deleted: " + myFile.getName());
            }
            else if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myFile = new File(USERDIRECTORY +"\\" + filename);
            FileWriter myWriter = new FileWriter(myFile.getName());
            String tmp = this.theBST.toString();
            while (tmp != null) {
                if(tmp.getleftNode() == null){
                    myWriter.write(tmp.getNodeData().CSVFormat());
                }
                else {
                    myWriter.write(tmp.getNodeData().CSVFormat() + "\n");
                }
                tmp = tmp.getrightNode();
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void add(E theData) { this.theBST.addNode((StudentMarks) theData); }

    @Override
    public void update(E theData) {

    }

    @Override
    public void findData(int theData) {
        StudentMarks dataToFind = new StudentMarks("","","",0,0,0,Integer.parseInt(theData));
        StudentMarks found = theBST.findItem(dataToFind);
        if(found != null){
            this.theView.displayABSTItem(found);
        }
        else{
            System.out.format("The entry %s was %s found!\n", theData, TextColours.TEXT_RED + "not" + TextColours.TEXT_RESET);
        }
    }


    @Override
    public E getData(String theData) { return null; }

    @Override
    public void removeData(int theData) {
        StudentMarks dataToFind = new StudentMarks("","","",0,0,0,Integer.parseInt(theData));
        StudentMarks found = theBST.findItem(dataToFind);
        if(found != null){
            this.theBST.deleteNode(found);
            System.out.format("The entry below has been %s from the list!\n", TextColours.TEXT_RED + "deleted" + TextColours.TEXT_RESET);
            this.theView.displayABSTItem(found);
        }
        else{
            System.out.format("The entry %s was %s found!\n", theData, TextColours.TEXT_RED + "not" + TextColours.TEXT_RESET);
        }

    }

    public void displayBST(DisplayOrder order){ this.theView.displayBST(this.theBST, order); }

    public void displayBSTChart(){
        // Add your code here
    }

}
