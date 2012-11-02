/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utils;

import java.util.Collection;

/**
 *
 * @author Federico
 */
public class Tabla {

    private int page;
    private int total;
    private int records;
    private Collection<IFila> rows;

    public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }

    public int getRecords()
    {
        return records;
    }

    public void setRecords(int records)
    {
        this.records = records;
    }

    public Collection<IFila> getRows()
    {
        return rows;
    }

    public void setRows(Collection<IFila> rows)
    {
        this.rows = rows;
    }

    public int getTotal()
    {
        return total;
    }

    public void setTotal(int total)
    {
        this.total = total;
    }

    
}
