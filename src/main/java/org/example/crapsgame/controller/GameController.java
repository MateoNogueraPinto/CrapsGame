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
    private Label pointLabel, shootLabel, pointLabel1, shotLabel1;

    @FXML
    private ImageView dice1ImageView, dice2ImageView;

    private int currentGameIndex = 0;
    private Game currentGame;

    Dice dice1, dice2;
    ArrayList<Game> games = new ArrayList<Game>();

    public GameController() {
        this.dice1 = new Dice();
        this.dice2 = new Dice();
    }

    @FXML
    public void initialize() {
        pointLabel1.setText("0");
        shotLabel1.setText("0");
    }

    @FXML
    public void onHandleButtonRollTheDice(ActionEvent event) {

        if (currentGameIndex > games.size() - 1) {
            currentGame = new Game();
            games.add(currentGame);
        }

        currentGame.rollDices();

        this.dice1ImageView.setImage(currentGame.getDice1().getDiceImage());
        this.dice2ImageView.setImage(currentGame.getDice2().getDiceImage());

        this.updateGameInterface();
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

    public void updateGameInterface() {
        this.updateShot();

        if (currentGame.isWin()) {
            updateWins();
        } else if (currentGame.isLose()) {
            updateLosses();
        } else if (pointLabel.getText().isEmpty()) {
            updatePoint();
        }

    }

    public void updateWins() {
        int currentWins = Integer.parseInt(shotLabel1.getText());
        shotLabel1.setText(Integer.toString(currentWins + 1));
        pointLabel.setText("");
        currentGameIndex++;
    }

    public void updateLosses() {
        int currentLosses = Integer.parseInt(pointLabel1.getText());
        pointLabel1.setText(Integer.toString(currentLosses + 1));
        pointLabel.setText("");
        currentGameIndex++;
    }

    public void updateShot() {
        shootLabel.setText(Integer.toString(currentGame.getShoot()));
    }

    public void updatePoint() {
        currentGame.setPoint();
        pointLabel.setText(Integer.toString(currentGame.getPoint()));
    }
}
