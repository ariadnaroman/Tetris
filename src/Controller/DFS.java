package Controller;

import Domain.Form;
import Domain.Table;
import Repository.FormList;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class DFS extends UninformedSearchMethod {
    private Table maxCovered;
    private HashMap<Integer,Table> visited;
    private Stack<Table> toVisit;
    private int n;
    private int m;

    public DFS(int n,int m) {
        maxCovered = new Table(n,m);
        visited = new HashMap<>();
        toVisit = new Stack<>();
        this.n=n;
        this.m=m;
    }

    public Table search()  {
        toVisit.push(new Table(n,m));
        while(!toVisit.empty()) {
            Table table = toVisit.pop();
            visited.put(table.hashCode(),table);
            if (table.compareTo(maxCovered)>0)
                maxCovered = table;
            Form form = FormList.getInstance().getRandomForm();
            List<Table> children = table.addForm(form);
            for (Table child : children)
                if (!visited.containsValue(child))
                    toVisit.push(child);
        }
        return maxCovered;
    }
}
