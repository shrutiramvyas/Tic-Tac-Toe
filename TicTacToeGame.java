package com.tictactoe;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeGame {
    Scanner scan = new Scanner(System.in);
    //Create Instance array
    static String board[];
    String userName;
    String turn = "X";
    String player1 = userName;
    String player2 = "computer";
    String player = player1;
    String winner = null;
    //create constructor
    public TicTacToeGame(String[] board) {
        TicTacToeGame.board = board;
    }
    //Ask Name method
    public String askName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String userName = scan.nextLine();
        System.out.println("Welcome " + userName + " to the World of Tic-Tac-Toe Game");
        return userName;
    }

    public void chooseLetter(){
        System.out.println("Please choose your Favourite word 'X' or 'O' ");
        String check = scan.nextLine();
        String cLetter = checkLetter(check);
        while (cLetter == null){
            System.out.println("Please choose your Favourite word 'X' or 'O' ");
            check = scan.nextLine();
            cLetter = checkLetter(check);
        }
        System.out.println("You choose " + cLetter);
    }
    public String checkLetter(String check){
        switch(check){
            case "X":
            case "x":
                return "X";
            case "o":
            case "O":
                return "O";
            default:
                System.out.println("Wrong choice");
                return null;
        }
    }
    public void checkInput(String userName) {
        System.out.println(userName + " Turn, Enter a slot number : ");
        while (winner == null) {
            int slotInput;
            try {
                slotInput = scan.nextInt();
                if (slotInput < 0 || slotInput > 9) {
                    System.out.println("Invalid input, Please re-enter the slot");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid number,Please reEnter slot number");
                continue;
            }
            if (board[slotInput - 1].equals(String.valueOf(slotInput))) {
                board[slotInput - 1] = turn;
                if (turn.equals("x")) {
                    turn = "o";
                    player = player2;

                } else {
                    turn = "x";
                    player = player1;
                }
                draw();
                winner = checkWinner(turn);
            } else {
                System.out.println("slot already taken,renter slot");
            }
        }
    }
    public void draw(){
        System.out.println("|-----------|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|-----------|");
    }
    public void checkWinner(String turn){
        System.out.println("checking winner");
    }
    public static void main(String[] args) {
        //Create Array Board
        String[] board = new String[10];
        for (int i = 0; i < 10; i++) {
            board[i] = String.valueOf(i + 1);
        }

        //Ask name Object
        TicTacToeGame game = new TicTacToeGame(board);
        String userName=game.askName();
        //Ask them to choose letter
        game.chooseLetter();
        //display board
        game.draw();
        game.checkInput(userName);
        }
    }
