package labb2.view;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import labb2.Main;
import labb2.model.Command;
import labb2.model.PrototypesModule;
import labb2.model.Shape;

/**
 * Created by luben on 2016-03-09.
 */
public class ToolsController extends Controller {
    @FXML
    private MenuButton shapes;
    @FXML
    private TableView<Command> undoList;
    @FXML
    private TableColumn<Command,String> commandColumn;
    @FXML
    private MenuButton commands;

//    private ObservableList<Command> observableCommands= FXCollections.observableList(Main.getCommands());

    @FXML
    @Override
    protected void initialize() {
        PrototypesModule.listShapeNames().forEach(s -> shapes.getItems().add(new MenuItem(s)));
        shapes.getItems().forEach(menuItem -> menuItem.setOnAction(event -> selected(menuItem.getText())));


//        observableCommands.setAll(Main.getCommands());
//        main.getCommands().addListener((ListChangeListener<? super Command>) observable -> {
//            System.out.printf("hej");
//        });
//        observableCommands.add((Command) PrototypesModule.findAndCloneAttributes("fill", Color.BLACK));
//        undoList.setItems(observableCommands);
//        commandColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
//        commands.getItems().addAll();

    }

    @Override
    public void setMainApp(Main main) {
        this.main = main;
        main.getCommands().addListener((ListChangeListener<? super Command>) observable -> System.out.printf("hej"));//TODO add menuItem on listener
    }


    @Override
    public void toolClicked(Shape a) {

    }

    private void selected(String o){
        main.clicked((Shape) PrototypesModule.findAndClone(o));
        shapes.setText(o);
    }

    @FXML
    private void select(){

    }

    @FXML
    private void undo(){
        main.undo();
    }

}
