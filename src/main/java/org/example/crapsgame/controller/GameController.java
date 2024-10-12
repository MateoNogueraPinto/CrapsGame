package org.example.crapsgame.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.example.crapsgame.model.Dice;
import org.example.crapsgame.model.Game;
import org.example.crapsgame.view.alert.AlertBox;

import java.util.ArrayList;

public class GameController {

    @FXML
    private Label pointLabel, shootLabel;

    @FXML
    private ImageView dice1ImageView, dice2ImageView;

    Dice dice1, dice2;
    ArrayList<Game> games = new ArrayList<Game>();

    public GameController() {
        this.dice1 = new Dice();
        this.dice2 = new Dice();
    }

    @FXML
    public void onHandleButtonRollTheDice(ActionEvent event) {
        this.dice1.rollDice();
        this.dice2.rollDice();
        this.dice1ImageView.setImage(this.dice1.getDiceImage());
        this.dice2ImageView.setImage(this.dice2.getDiceImage());
    }

    public void instructions() {
        AlertBox alertBox = new AlertBox();
        alertBox.showMessage("Instrucciones del juego Craps", "Cómo jugar Craps:", """
                1. El jugador tira dos dados.
                2. Si el resultado es 7 u 11 en el primer lanzamiento, ganas automáticamente.
                3. Si el resultado es 2, 3 o 12, pierdes.
                4. Si el resultado es 4, 5, 6, 8, 9 o 10, ese número se convierte en tu 'punto'.
                5. Debes seguir tirando los dados para intentar sacar el 'punto'.
                6. Si sacas el 'punto' antes de un 7, ganas.
                7. Si sacas un 7 antes de tu 'punto', pierdes.
                """);
    }
}
