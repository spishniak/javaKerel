package com.shpp.p2p.cs.ispishniak;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part4 extends KarelTheRobot {

    /* це коментар :) */
    public void run() throws Exception {
        firstStep();
        secondStep();


    }
    /*Передумава: На кожній клітинці встановлений біппер . Робот в стартовому положені дивиться на схід.
     * Результат: Збирає біпери через одну клітинку. */
    private void secondStep() throws Exception {
        while (leftIsClear()) {
            firstLineOdd();
            goToTheSecondLine();
            secondLineEven();
            goToTheSecondLine();

        }
        if(beepersPresent()){
            firstLineOdd();
        }else{
            turnRight();
            turnRight();
        }

    }
    /* передумова: якщо праворуч не має стіни
* результат : повернути праворуч, зробити один крок, повернути праворуч, якщо тіна є повернути двічі праворуч */
    private void goToTheSecondLine() throws Exception {
        if(rightIsClear()){
            turnRight();
            move();
            turnRight();

        }else {
            turnRight();
            turnRight();
        }


    }

    private void secondLineEven() throws Exception {
        pickBeeper();
        while (frontIsClear()){
            move();
            if(frontIsClear()){
                move();
                if(beepersPresent()){
                    pickBeeper();
                }

            }
        }
        returnToTheBeginningOfTheLine();
    }
    /* Передумова: попереду немає стіни , на кожній клітинці є біппер
     * Результат:  Збираємо через один біпер поки не буде стіни і повертаємось на початок рядка*/

    private void firstLineOdd() throws Exception {
        while(frontIsClear()){
            move();
            pickBeeper();
            if(frontIsClear()){
                move();
            }

        }
        returnToTheBeginningOfTheLine();
    }

    /*==============================
* =============================

    /*Передумава: стартове полеження Робота південно-західне , дивиться на схід та ліворуч не має стіни
     * Результат: На кожній клітинці встановлений біппер . Робот повернувся в стартове положення*/
    private void firstStep() throws Exception {
        while (leftIsClear()) {
            reachTheWallAndPutBeeper();
            returnToTheBeginningOfTheLine();
            moveToTheExtColumnTurnRight();
        }
        reachTheWallAndPutBeeper();
        returnToStartingPosition();
    }
    /*Передумава: На кожній клітинці встановлений один біппер.
     * Результат: Робот повертається в стартове положення*/
    private void returnToStartingPosition() throws Exception {
        turnAround();
        while(frontIsClear()){
            move();
        }
        turnLeft();
        while (frontIsClear()){
            move();
        }
        turnLeft();
    }
    /*Передумава: якщо попереду не має стіни
     * Результат: Робот повертає на 180 градусів та рухається вперед поки не буде стіни*/
    private void returnToTheBeginningOfTheLine() throws Exception {
        turnAround();
        while(frontIsClear()){
            move();
        }

    }
    /*Передумова: якщо праворуч не має стіни
     * Результат Робот повертає праворуч від себе, робить крок, ще раз повертає праворуч.
     * Переходить на інший рядок*/
    private void moveToTheExtColumnTurnRight() throws Exception {
        if(rightIsClear()){
            turnRight();
            move();
            turnRight();
        }
    }


    /*Передумава: немає попереду перешкод
     * Результат покласти біппер і зробити крок якщо немає попереду перешкод */
    private void reachTheWallAndPutBeeper() throws Exception {
        while(frontIsClear()){
            putBeeper();
            move();
        }
        putBeeper();
    }

    /*Передумава: немає
     * Результат Робот повертає на 180 градусів */
    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }
    /*Передумава: немає
     * Результат Робот повертає праворуч від себе */
    private void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }
}