package PaneView;

import Ruleta.*;
import TDA.CircularlyDoubleLinkedList;
import java.io.File;
import java.util.LinkedHashSet;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author omarc
 */
public class PaneManagement {

    VBox iniRoot;
    Stage gameStage;
    Scene gameScene;
    Pane gameRoot;

    public VBox getIniRoot() {
        iniRoot = new VBox(20);

        String style = "-fx-font-weight: bold; -fx-font-size: 16px;-fx-background-color: #44BEC6;";

        HBox circleHb = new HBox(20);
        Label circleLabel = new Label("Circulos: ");
        circleLabel.setStyle(style);
        TextField circleText = new TextField();

        circleHb.getChildren().addAll(circleLabel, circleText);

        HBox eleHb = new HBox(20);
        Label eleLabel = new Label("Elementos: ");
        eleLabel.setStyle(style);
        TextField eleText = new TextField();

        eleHb.getChildren().addAll(eleLabel, eleText);

        HBox betHb = new HBox(20);
        Label betLabel = new Label("Apuesta: ");
        betLabel.setStyle(style);
        TextField betText = new TextField();

        betHb.getChildren().addAll(betLabel, betText);

        //Anadiendo funcionalidades opcionales a confirmar                
        CheckBox wildcard = new CheckBox("Comodin ");
        wildcard.setStyle(style);

        CheckBox compDecition = new CheckBox("Ayuda computador ");
        compDecition.setStyle(style);

        Button playButton = new Button("Jugar");
        playButton.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");
        playButton.setOnAction(e -> {
            String bet = betText.getText().trim();
            String cir = circleText.getText().trim();
            String ele = eleText.getText().trim();
            if (isNumeric(bet) && isNumeric(cir) && isNumeric(ele) && Integer.valueOf(cir) > 1 && Integer.valueOf(cir) < 9 && Integer.valueOf(ele) > 1 && Integer.valueOf(ele) < 10 && Integer.valueOf(bet) > 0) {
                RuletaNum rn = constructRuleta(Integer.valueOf(cir), Integer.valueOf(ele));
                
            } else {
                if (!(isNumeric(bet) && isNumeric(cir) && isNumeric(ele))) {                    
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Alerta de ingreso de datos");
                    alert.setHeaderText("Error");
                    alert.setContentText("Ingrese datos numericos en los cuadros de texto solicitados.");
                    alert.show();
                } else if (!(Integer.valueOf(cir) > 1 && Integer.valueOf(cir) < 9)) {                    
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Alerta de ingreso de datos");
                    alert.setHeaderText("Error");
                    alert.setContentText("Ingrese un numero mayor a 1 y menor a 9 para la cantidad de circulos");
                    alert.show();
                } else if (!(Integer.valueOf(ele) > 1 && Integer.valueOf(ele) < 10)) {                    
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Alerta de ingreso de datos");
                    alert.setHeaderText("Error");
                    alert.setContentText("Ingrese un numero mayor a 1 y menor a 10 para la cantidad de elementos");
                    alert.show();
                } else if (!(Integer.valueOf(bet) > 0)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Alerta de ingreso de datos");
                    alert.setHeaderText("Error");
                    alert.setContentText("Ingrese una apuesta mayor a 0");
                    alert.show();
                }

            }

        });

        iniRoot.getChildren().addAll(circleHb, eleHb, betHb, wildcard, compDecition, playButton);
        File path = new File("src/Resources/roulette-switch-hero.jpg");
        Image img = new Image(path.toURI().toString());
        iniRoot.setBackground(new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(500, 500, false, false, false, false))));
        iniRoot.setPadding(new Insets(200, 20, 40, 20));

        return iniRoot;
    }
    
    public Pane getGameRoot(RuletaNum rn){
        
        RuletaController rc = new RuletaController();
                gameRoot = new Pane();
                gameScene = new Scene(gameRoot, 625, 750);
                rc.generateRuleta(rn, 625, gameRoot);
        
        
        return gameRoot;
    }

    public RuletaNum constructRuleta(int circles, int elements) {
        LinkedHashSet<CirculoNumerico> circleSet = new LinkedHashSet<>();
        for (int i = 0; i < circles; ++i) {
            CirculoNumerico cn = new CirculoNumerico(new CircularlyDoubleLinkedList());
            cn.llenarListaNum(elements);
            circleSet.add(cn);
        }

        return new RuletaNum(circleSet);
    }

    public boolean isNumeric(String string) {
        if (string.equals("")) {
            return false;
        }
        return string.matches("[+-]?\\d*(\\.\\d+)?");
    }

}
