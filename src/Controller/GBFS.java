package Controller;

import Domain.Form;
import Domain.Table;
import Repository.FormList;

import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class GBFS extends InformedSearchMethod {
    private Table maxCovered;
    private Stack<Table> toVisit;
    private int n;
    private int m;

    public GBFS(int n,int m) {
        maxCovered = new Table(n,m);
        toVisit = new Stack<>();
        this.n=n;
        this.m=m;
    }



    public Table search()  {
        toVisit.push(new Table(n,m));
        while(!toVisit.empty()) {
            Table table = toVisit.pop();
            Form form = FormList.getInstance().getRandomForm();
            System.out.println();
            System.out.println();
            System.out.println("S-a generat forma: ");
            System.out.println(form);
            List<Table> children = table.addForm(form);
            if (!children.isEmpty()) {
                maxCovered = (Table) getBestFit(children);
                System.out.println("Tabela curenta este: ");
                System.out.println(maxCovered);
                System.out.println();
                toVisit.push(children.get(0));
            }
        }
        return maxCovered;
    }

    @Override
    Object getBestFit(List population) {
        population.sort(Comparator.comparingInt(Table::getFilling).thenComparingInt(Table::getOccupationLevel));
        return population.get(0);
    }
}
