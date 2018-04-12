package Domain;

import java.util.Arrays;

public class Form {
    private int formID;
    private int inaltime;
    private int latime;
    private int arg[][] = new int[2][4];


    public Form(int formID, int[][] arg) {
        this.formID = formID;
        this.arg = arg;
        if (arg[1][0] + arg[1][1] + arg[1][2] + arg[1][3] != 0)
            this.inaltime = 2;
        else
            this.inaltime = 1;
        this.latime = Math.max(arg[0][0],arg[1][0]) + Math.max(arg[0][1],arg[1][1]) + Math.max(arg[0][2],arg[1][2]) + Math.max(arg[0][3],arg[1][3]);
    }

    public Form() {
    }

    public int getFormID() {
        return formID;
    }

    public void setFormID(int formID) {
        this.formID = formID;
    }

    public int[][] getArg() {
        return arg;
    }

    public void setArg(int[][] arg) {
        this.arg = arg;
    }

    public int getInaltime() {
        return inaltime;
    }

    public void setInaltime(int inaltime) {
        this.inaltime = inaltime;
    }

    public int getLatime() {
        return latime;
    }

    public void setLatime(int latime) {
        this.latime = latime;
    }

    @Override
    public String toString() {
        System.out.println("Form configuration: ");
        for (int i=1;i>=0;i--) {
            for (int j = 0; j <4; j++) {
                if(arg[i][j]==1)
                    System.out.print("■");
                else
                    System.out.print("□");
                System.out.print(" ");
            }
            System.out.println();
        }

        return "Form{" +
                "formID=" + formID +
                ", inaltime=" + inaltime +
                ", latime=" + latime +
                '}';
    }
}
