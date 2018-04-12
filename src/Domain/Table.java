package Domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table implements Comparable<Table>{
    private int n;
    private int m;
    private int config[][];
    private int occupation;

    public Table(int n, int m) {
        this.n = n;
        this.m = m;
        config = new int[n][m];
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                config[i][j]=0;
        occupation = 0;
    }

    public Table(Table t) {
        this.n = t.getN();
        this.m = t.getM();
        config = new int[n][m];
        int [][] con = t.getConfig();
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                config[i][j]=con[i][j];
        this.occupation = t.getOccupation();
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int[][] getConfig() {
        return config;
    }

    public void setConfig(int[][] config) {
        this.config = config;
    }

    public int getOccupation() {
        return occupation;
    }

    public void setOccupation(int occupation) {
        this.occupation = occupation;
    }

    public int getOccupationLevel() {
        for(int i=n-1;i>=0;i--)
            for(int j=m-1;j>=0;j--)
                if(config[i][j]==1)
                    return i;
        return 0;
    }

    public int getFilling() {
        int nrde0=0;
        int j;
        int max[] = new int[m];
        for (j=0;j<m;j++)
            max[j]=m-1;
        for (int i=0;i<m;i++) {
            j=n-1;
            while (j>=0 && config[j][i]!=1) {
                max[i]=j;
                j--;
            }
        }
        for (int i=0;i<m;i++) {
            for (j=0;j<max[i]&&j<n;j++) {
                if (config[j][i]==0)
                    nrde0++;
            }
        }
        return nrde0;
    }

    public List<Table> addForm(Form form){
        List<Table> list = new ArrayList<>();
        int arg[][] = form.getArg();
        int col, colFinish, row;
        boolean done;
        for (col = 0; col < m; col++) {
            done=false;
            colFinish = col + form.getLatime() - 1;
            if (colFinish < m) {
                row = 0;
                while (!done && row+form.getInaltime()-1<n) {
                    Table t = new Table(this);
                    int configuration[][] = t.getConfig();
                    for (int inaltime=0;inaltime< form.getInaltime();inaltime++)
                        for (int latime=0;latime< form.getLatime();latime++)
                            configuration[row+inaltime][col+latime] += arg[inaltime][latime];
                    if (t.isValid()) {
                        done = true;
                        t.setOccupation(occupation + 4);
                        list.add(t);
                    } else {
                        row++;
                    }
                }

            }
        }
        return list;
    }

    public boolean isValid() {
        int i;
        int j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (config[i][j] != 0 && config[i][j] != 1)
                    return false;
            }
        }
        return true;
    }

    @Override
    public int compareTo(Table o) {
        return this.occupation - o.getOccupation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Table table = (Table) o;

        if (n != table.n) return false;
        if (m != table.m) return false;
        if (occupation != table.occupation) return false;
        return Arrays.deepEquals(config, table.config);
    }

    @Override
    public int hashCode() {
        int result = n;
        result = 31 * result + m;
        result = 31 * result + Arrays.deepHashCode(config);
        result = 31 * result + occupation;
        return result;
    }

    @Override
    public String toString() {
        System.out.println("Configuration:\n");
        for(int i=n-1;i>=0;i--) {
            for (int j = 0; j <m; j++) {
                if(config[i][j]==1)
                    System.out.print("■");
                else
                    System.out.print("□");
                System.out.print(" ");
            }
            System.out.println();
        }
        return "Table{" +
                "n=" + n +
                ", m=" + m +
                ", occupation=" + occupation +
                '}';
    }
}


