package queries;

import java.util.List;
import model.TableRow;

public interface ITableQueries {
	
	public List<TableRow> findAllRows();
	
	public <T> TableRow findRowById(T id);
}