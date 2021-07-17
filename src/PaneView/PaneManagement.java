package PaneView;

import Ruleta.*;
import TDA.CircularlyDoubleLinkedList;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Random;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
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
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

/**
 *
 * @author omarc
 */
public class PaneManagement {

    VBox iniRoot;

    static Stage gameStage;
    static Scene gameScene;
    static Pane gameRoot;
    static RuletaNum rn;
    static ToggleGroup functionsToggle = new ToggleGroup();
    static ComboBox cb;
    static TextField betText;
    static int forbiddenNum = 0;
    static int actions = 0;
    static boolean mandatoryRotation;
    static boolean mandatoryElimination;

    static boolean forbiddenBoolean = false;
    static boolean computerBoolean = false;

    public VBox getIniRoot() {
        iniRoot = new VBox(17);

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
        betText = new TextField();

        betHb.getChildren().addAll(betLabel, betText);

        //Anadiendo funcionalidades opcionales a confirmar                               
        CheckBox forbiddenNumber = new CheckBox("Numero prohibido");
        forbiddenNumber.setStyle(style);

        CheckBox compDecition = new CheckBox("Ayuda computador ");
        compDecition.setStyle(style);

        Button playButton = new Button("Jugar");
        playButton.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");
        playButton.setOnAction(e -> {

            String bet = betText.getText().trim();
            String cir = circleText.getText().trim();
            String ele = eleText.getText().trim();

            if (isNumeric(bet) && isNumeric(cir) && isNumeric(ele) && Integer.valueOf(cir) > 1 && Integer.valueOf(cir) < 9 && Integer.valueOf(ele) > 1 && Integer.valueOf(ele) < 10 && Integer.valueOf(bet) > 0) {

                forbiddenBoolean = forbiddenNumber.isSelected();
                computerBoolean = compDecition.isSelected();

                rn = constructRuleta(Integer.valueOf(cir), Integer.valueOf(ele));
                forbiddenNum = getForbiddenNum(rn);

                gameRoot = getGameRoot(rn);
                gameScene = new Scene(gameRoot, 1000, 675);
                gameStage = new Stage();
                gameStage.setScene(gameScene);
                gameStage.show();

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

        iniRoot.getChildren().addAll(circleHb, eleHb, betHb, forbiddenNumber, compDecition, playButton);
        File path = new File("src/Resources/roulette-switch-hero.jpg");
        Image img = new Image(path.toURI().toString());
        iniRoot.setBackground(new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(500, 500, false, false, false, false))));
        iniRoot.setPadding(new Insets(185, 20, 40, 20));

        return iniRoot;
    }

    public Pane getGameRoot(RuletaNum rn) {
        gameRoot = new Pane();
        RuletaController rc = new RuletaController();
        rc.generateRuleta(rn, 650, gameRoot);

        VBox vb = new VBox(15);
        RadioButton rotateRb = new RadioButton("Rotacion");
        rotateRb.setUserData("R");
        rotateRb.setSelected(true);

        RadioButton eliminateRb = new RadioButton("Eliminacion");
        eliminateRb.setUserData("E");

        Label orientationLb = new Label("Direccion de giro:");
        cb = new ComboBox();
        cb.getItems().addAll("Izquierda", "Derecha");
        cb.setValue(cb.getItems().get(0));

        rotateRb.setToggleGroup(functionsToggle);
        eliminateRb.setToggleGroup(functionsToggle);

        vb.getChildren().addAll(rotateRb, orientationLb, cb, eliminateRb);

        if (forbiddenBoolean) {
            HBox forbiddenHb = new HBox(10);
            Label forbiddenTitle = new Label("Numero prohibido: ");
            Label forbiddenNumber = new Label(String.valueOf(forbiddenNum));
            forbiddenHb.getChildren().addAll(forbiddenTitle, forbiddenNumber);
            vb.getChildren().add(forbiddenHb);
            if (isForbidden(rn, forbiddenNum)) {
                exitGame("Se ha conseguido un numero negativo o el valor es igual al numero prohibido");
            }
        }

        if (actions == 4 && computerBoolean) {
            computerMovement(rn);
            actions = 0;
        }

        if (rn.calcularValorRuleta() == Integer.valueOf(betText.getText())) {
            exitGame("Felicidades, ha ganado el juego!");
        }

        if (rn.calcularValorRuleta() == 0) {
            exitGame("Ya no tiene mas circulos... GameOver");
        }

        HBox valueHb = new HBox(10);
        Label valueTitle = new Label("Valor: ");
        Label valueNumber = new Label(String.valueOf(rn.calcularValorRuleta()));
        valueHb.getChildren().addAll(valueTitle, valueNumber);
        vb.getChildren().add(valueHb);

        HBox betHb = new HBox(10);
        Label betTitle = new Label("Apuesta: ");
        Label betNumber = new Label(betText.getText());
        betHb.getChildren().addAll(betTitle, betNumber);
        vb.getChildren().add(betHb);

        vb.setLayoutX(700);
        vb.setLayoutY(30);

        gameRoot.getChildren().addAll(vb);

        return gameRoot;

    }

    public void exitGame(String message) {
        gameStage.close();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Juego Finalizado");
        alert.setHeaderText("El juego se ha terminado");
        alert.setContentText(message);
        alert.show();
    }

    public boolean isForbidden(RuletaNum rn, int forbbidenNumber) {

        for (CirculoNumerico cn : rn.getRuletasNumericas()) {
            for (int i = 0; i < cn.getListaNumerica().size(); i++) {
                if (cn.getListaNumerica().get(i) < 0 || cn.getListaNumerica().get(i) == forbbidenNumber || rn.calcularValorRuleta() == forbbidenNumber) {
                    return true;
                }
            }
        }
        return false;

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

    public int getForbiddenNum(RuletaNum rn) {

        int fn = new Random().nextInt(10) + 10;
        while (betText.getText().equals(String.valueOf(fn))) {
            fn = new Random().nextInt(10);
        }
        return fn;
    }

    public void computerMovement(RuletaNum ruletaNumerica) {
        Random random = new Random();

        //indice random para remover un elemento o rotar una lista circular
        int index1 = random.nextInt(2);
        // index1 = 0 para rotar
        // index1 = 1 para eliminar

        //indice random para obtener una de las listas (para rotacion)
        int bound = ruletaNumerica.getRuletasNumericas().size();
        int index2 = random.nextInt(bound);

        //indice random para aplicar el remove() en caso de eliminacion
        int indexRemove = 0;

        // variable boolean de control para el sentido de las rotaciones
        boolean rotacion = random.nextBoolean();
        // rotacion = true para rotar a la derecha
        // rotacion = false para rotar a la izquierda

        if (index1 == 0) {

            if (rotacion) {
                ruletaNumerica.getCircleNumByIndex(index2).rotarDerecha();
            } else {
                ruletaNumerica.getCircleNumByIndex(index2).rotarIzquierda();
            }
            //mostrarAlerta
        } else {
            for (CirculoNumerico cn : ruletaNumerica.getRuletasNumericas()) {
                cn.getListaNumerica().remove(indexRemove);

            }
            //mostrarAlerta
        }

    }

}
