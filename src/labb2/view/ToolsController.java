package labb2.view;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import labb2.Main;
import labb2.model.PrototypesModule;
import labb2.model.Shape;

/**
 * Created by luben on 2016-03-09.
 */
public class ToolsController extends Controller {
    @FXML
    private MenuButton shapes;

    @FXML
    private ChoiceBox<Canvas> selectComands;

//    private ObservableList<Command> observableCommands= FXCollections.observableList(Main.getCommands());

    @FXML
    @Override
    protected void initialize() {
        PrototypesModule.listShapeNames().forEach(s -> shapes.getItems().add(new MenuItem(s)));
        shapes.getItems().forEach(menuItem -> menuItem.setOnAction(event -> selected(menuItem.getText())));
//        selectComands.getItems().addAll(Main.commands.stream().map(Command::getName).collect(Collectors.toList()));//TODO mayebeybaby

//        selectComands.getItems().addListener((ListChangeListener<? super Canvas>) observable -> selectComands.setValue(selectComands.getItems().get(main.getCurrentLayer()-1))); //complex set new layer to current layer
        selectComands.setOnAction(event -> main.setCurrentLayer(selectComands.getValue()));//TODO set main.currentlayer to selected
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
//        main.commands.addListener((ListChangeListener<? super Command>) observable -> System.out.printf("hej"));//TODO add menuItem on listener
    }

    public void addSelectCommands(Canvas c){
        selectComands.getItems().add(c);
    }

    @Override
    public void toolClicked(Shape a) {

    }

    public void removeLayer(Canvas l){
        selectComands.getItems().remove(l);
    }

    private void selected(String o){
        main.clicked((Shape) PrototypesModule.findAndClone(o));
        shapes.setText(o);
    }



    @FXML
    private void undo(){
        main.undo();
    }

}
