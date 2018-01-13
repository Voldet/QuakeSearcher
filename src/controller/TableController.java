package controller;

import bean.Earthquake;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

/**
 * Author Vold
 */
@SuppressWarnings("rawtypes")
public class TableController<T> implements ViewController {
    private TableView<T> tableView;
    ArrayList<TableColumn> tableColumns = new ArrayList<TableColumn>();

    /**
     * To control the table columns 
     * It will put all the quake information into the column
     * @param tableView
     */
    @SuppressWarnings("unchecked")
	public TableController(TableView<T> tableView){
        this.tableView = tableView;
        this.tableView.getColumns().stream().forEach(tableColumns::add);
        this.tableColumns.stream().forEach(q->q.setCellValueFactory(new PropertyValueFactory<Earthquake, Object>(q.getText())));
    }

    @Override
    public void refresh() {
    }

    /**
     * To refresh the table view
     * @param list
     */
    public void refresh(ObservableList<T> list){
        this.tableView.setItems(list);
    }
}