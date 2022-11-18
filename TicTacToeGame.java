package com.tictactoe;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeGame {
    Scanner scan = new Scanner(System.in);
    //Create Instance array
    static String board[];
    String userName;
    //create constructor
    public TicTacToeGame(String[] board) {
        TicTacToeGame.board = board;
    }
    //Ask Name method
    public void askName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String userName = scan.nextLine();
        System.out.println("Welcome " + userName + " to the World of Tic-Tac-Toe Game");
    }
    public void chooseLetter(){
        System.out.println(userName + ", Please choose your Favourite word 'X' or 'O' ");
        String check = scan.nextLine();
        String cLetter = checkLetter(check);
        while (cLetter == null){
            System.out.println(userName + ", Please choose your Favourite word 'X' or 'O' ");
            check = scan.nextLine();
            cLetter = checkLetter(check);
        }
        System.out.println("You choose " + cLetter);
    }
    public String checkLetter(String check){
        System.out.println(check);
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

    public static void main(String[] args) {
        //Create Array Board
        String[] board = new String[10];
        for (int i = 0; i < 10; i++) {
            board[i] = String.valueOf(i + 1);
        }

        //Ask name Object
        TicTacToeGame game = new TicTacToeGame(board);
        game.askName();
        //Ask them to choose letter
        game.chooseLetter();

        }
    }
