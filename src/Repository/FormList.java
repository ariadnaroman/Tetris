package Repository;

import Domain.Form;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FormList {
    private static FormList instance;
    private List<Form> validForms;

    private FormList() {
        validForms = new ArrayList<Form>();
        populate();
    }

    private void populate() {
        validForms.add(new Form(1,new int[][]{{1,1,1,1},{0,0,0,0}}));
        validForms.add(new Form(2,new int[][]{{1,0,0,0},{1,1,1,0}}));
        validForms.add(new Form(3,new int[][]{{1,1,1,0},{1,0,0,0}}));
        validForms.add(new Form(4,new int[][]{{1,1,1,0},{0,1,0,0}}));
        validForms.add(new Form(5,new int[][]{{1,1,0,0},{1,1,0,0}}));
        validForms.add(new Form(6,new int[][]{{0,1,1,0},{1,1,0,0}}));
        validForms.add(new Form(7,new int[][]{{1,1,0,0},{0,1,1,0}}));
    }

    public static FormList getInstance() {
        if (instance==null)
            instance = new FormList();
        return instance;
    }

    public Form getRandomForm() {
        Random rand = new Random();
        int formID = rand.nextInt(7);
        Form form = validForms.get(formID);
        return form;
    }

    public List<Form> getValidForms() {
        return validForms;
    }
}
