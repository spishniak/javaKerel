package com.shpp.ispishniak.cs;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part3 extends KarelTheRobot {


    public void run() throws Exception {
        putBeeperThroughStep();
        turnAround();
        collectBeepers();
        turnAround();
        moveForward();
        distributeBeepers();
        putBeeper();
        turnAround();
        deletedBeeper();
}
    /*Передумова: всі біппери роставлені на місцях . Робот Знаходиться у стартовому положенні
    * Результат : перший біпер пропускаємо , решту біпперів прибираємо */
    private void deletedBeeper() throws Exception {
        moveForward();
        turnAround();
        while (noBeepersPresent()){
            move();

        }
        while (frontIsClear()){
            move();
            pickBeeper();
        }
    }
/*Передумова: Біппери знаходяться в крайній клітинці
* Результат: Робот розтавляє накопичені Біпери на кожно клітинку.Таким чином половина усього шляху
* в біпперах */
    private void distributeBeepers() throws Exception {
        while (beepersPresent()){
            turnAround();
            pickBeeper();
            move();
            while(beepersPresent()){
                move();
            }
            putBeeper();
            turnAround();
            moveForward();
        }
    }
/*Передумова: попереду немає стіни біппери ростовлені кожні два кроки
* Результат: робот накопичує роставленні біппери  в останій клітинці*/
    private void collectBeepers() throws Exception {
        while (frontIsClear()){
            move();
            if(beepersPresent()){
                pickBeeper();
                turnAround();
                moveForward();
                putBeeper();
                turnAround();
            }
        }
    }
    /*Передумова: попереду немає стіни
    * Результат: Робот йде до стіни */
    private void moveForward() throws Exception {
        while(frontIsClear()){
            move();
        }
    }
    /*Передумава: немає
     * Результат Робот повертає на 180 градусів */
    private void turnAround() throws Exception {
        turnLeft();
        turnLeft();
    }

    /* Передумова попереду немає стіни
    * встановлює один біппер кожні два кроки*/
    private void putBeeperThroughStep() throws Exception {
    while (frontIsClear()){
        move();
        putBeeper();
        if(frontIsClear()){
            move();
        }
    }
    }


}