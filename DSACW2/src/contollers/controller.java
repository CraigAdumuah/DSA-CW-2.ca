package contollers;

import daos.bstDAOImpl;
import helpers.InputHelper;
import helpers.OutputHelper;
import helpers.TextColours;
import model.DisplayOrder;
import model.StudentMarks;


public class controller {

    private final bstDAOImpl<StudentMarks> bstDAO;
    private final InputHelper inputHelper;

    public controller() {
        this.bstDAO = new bstDAOImpl<>();
        this.inputHelper = new InputHelper();
    }

    /**
     * Displays the menu and uses an InputHelper object
     * to accept valid user choice.
     * An appropriate private method is called to implement the choice.
     */
    public void run() {
        boolean finished = false;

        int iChoice;
        this.setup();

        do {
            this.theMenu();
            iChoice = inputHelper.readInt("Enter choice", 5,1);
            switch (iChoice) {
                // Add more cases
                case 1:
                    this.findAMark();
                    System.out.println();
                    break;
                case 2:
                    this.displayMarksAscending();
                    System.out.println();
                    break;
                case 3:
                    this.displayMarksDescending();
                    System.out.println();
                    break;
                case 4:
                    this.displayChart();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("All done! Bye ...");
                    finished = true;
                    break;
                default: // invalid option
                    System.out.println("Oops! Something has went wrong!");
                    break;


            }
        }while(!finished);
    }
    private void theMenu() {
        // Print menu to console
        System.out.println(TextColours.TEXT_GREEN + "Student Marks");
        System.out.println("-----------------------"  + TextColours.TEXT_RESET);
        System.out.println("1: Find a Mark");
        System.out.println("2: Display Marks in ascending order");
        System.out.println("3: Display Marks in descending order");
        System.out.println("4: Display Marks in bar chart");
        System.out.println("5: Exit");
        System.out.println();
    }

    private void findAMark() {
        System.out.println("Find a Mark ");
        System.out.println("-----------");
        int aMark = inputHelper.readInt("Please enter a Mark ");
        this.bstDAO.findData(aMark);
    }

    private void displayMarksAscending() {
        System.out.println("Display Terms in ascending order");
        System.out.println("--------------------------------");
        this.bstDAO.displayBST( DisplayOrder.ASCENDING);
    }

    private void displayMarksDescending() {
        System.out.println("Display Terms in descending order");
        System.out.println("---------------------------------");
        this.bstDAO.displayBST( DisplayOrder.DESCENDING);
    }

    private void displayChart() {
        System.out.println("Display Marks in Chart order");
        System.out.println("---------------------------------");
        this.bstDAO.displayBST( DisplayOrder.INORDER);
    }


    private void setup(){
        System.out.println(TextColours.TEXT_CYAN + "Class Test Data");
        System.out.println("-----------------------"  + TextColours.TEXT_RESET);
        this.bstDAO.loadFromFile("ClassTestData.txt");
    }

}
