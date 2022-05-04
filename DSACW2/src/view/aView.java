package view;

import datastructures.BinarySearchTree;
import datastructures.Node;
import helpers.OutputHelper;
import helpers.TextColours;
import model.DisplayOrder;
import model.StudentMarks;

public class aView {
    //bst asc
    public void displayBSTItemAsc(Node<StudentMarks> root) {
        if (root.leftNode != null) {
            displayBSTItemAsc(root.leftNode);
        }
        System.out.println(TextColours.TEXT_BLUE + "\nAscending");
        System.out.println("--------"  + TextColours.TEXT_RESET);
        System.out.format("| %-20s | %-20s | %-20s | %2d | %2d | %2d | %2d |\n", root.getNodeData().getStudentID(), root.getNodeData().getGivenName(), root.getNodeData().getLastname(), root.getNodeData().getCT1(), root.getNodeData().getCT2(), root.getNodeData().getCT3(), root.getNodeData().getModuleMark());
        if (root.rightNode != null) {
            displayBSTItemAsc(root.rightNode);
        }
    }

    //bst desc
    public void displayBSTItemDesc(Node<StudentMarks> root) {
        if (root.rightNode != null) {
            displayBSTItemDesc(root.rightNode);
        }
        System.out.println(TextColours.TEXT_YELLOW + "\nDescending");
        System.out.println("--------"  + TextColours.TEXT_RESET);
        System.out.format("| %-20s | %-20s | %-20s | %2d | %2d | %2d | %2d |\n", root.getNodeData().getStudentID(), root.getNodeData().getGivenName(), root.getNodeData().getLastname(), root.getNodeData().getCT1(), root.getNodeData().getCT2(), root.getNodeData().getCT3(), root.getNodeData().getModuleMark());
        if (root.leftNode != null) {
            displayBSTItemDesc(root.leftNode);
        }
    }

    public void displayBST(BinarySearchTree<StudentMarks> theBST, DisplayOrder order) {
        System.out.println(OutputHelper.repeat("-", 55));
        System.out.format("| %-20s | %-20s | %-20s | %2d | %2d | %2d | %-2d |\n", "Student ID","Given Name","Lastname","Class Test 1","Class Test 2","Class Test 3", "Module Mark");
        System.out.println(OutputHelper.repeat("-", 55));

        switch (order) {
            case ASCENDING:
                displayBSTItemAsc(theBST.getRoot());
                break;
            case DESCENDING:
                displayBSTItemDesc(theBST.getRoot());
                break;
            default:
                System.out.println("Oops! Something has went wrong!");
                break;
        }
        System.out.println(OutputHelper.repeat("-", 55));
    }



    public void displayABSTItem(StudentMarks anItem){
        System.out.println(OutputHelper.repeat("-",55));
        System.out.format ("| %-20s | %-20s | %-20s | %2d | %2d | %2d | %-2d |\n", "Student ID", "Given Name","Lastname", "Class Test 1", "Class Test 2", "Class Test 3","Module Mark");
        System.out.println(OutputHelper.repeat("-",55));
        System.out.format("| %-20s | %-20s | %-20s | %2d | %2d | %2d | %2d |\n", anItem.getStudentID(), anItem.getGivenName(), anItem.getLastname(),anItem.getCT1(), anItem.getCT2(), anItem.getCT3(), anItem.getModuleMark());
        System.out.println(OutputHelper.repeat("-",55));
    }

    public void displayStudentScoreInChart(Node<StudentMarks> root){

    }

    public void displayAsChart(BinarySearchTree<StudentMarks> theBST){


        }

    }

