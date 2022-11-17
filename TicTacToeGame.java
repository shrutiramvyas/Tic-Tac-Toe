package com.tictactoe;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeGame {
    Scanner scan = new Scanner(System.in);
    //Create Instance array
    static String board[];
    //create constructor
    public TicTacToeGame(String[] board) {
        TicTacToeGame.board = board;
    }
    public static String checkLetter(String check){
        switch(check){
            case "X":
            case "x":
                return "X";
            case "o":
            case "O":
                return "O";
            default:
                System.out.println("Wrong choice");
                Scanner scan = new Scanner(System.in);
                check = scan.nextLine();
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String userName = scan.nextLine();
        System.out.println("Welcome "+ userName +" to the World of Tic-Tac-Toe Game");
        System.out.println(userName + ", Please choose your Favourite word 'X' or 'O' ");
        String check = scan.nextLine();
        String cLetter = checkLetter(check);
        String[] board = new String[10];
        for(int i = 0; i < 10; i++){
            board[i]=String.valueOf(i+1);
        }
        TicTacToeGame game = new TicTacToeGame(board);
    }
}
