/*
    Name: Duaa Shahzad
    Date: 9/29/2019
    Class: CSC1120
    Pledge: I have neither given nor received unauthorized aid on this program.
    Description: Bullseye is a program that computes the scores for two players
        and determines who, if anyone, wins the bullseye game.
    Input: The coordinates are read from a file, games.txt, using Scanner class and read into an ArrayList.
    Output:The program will display the winner after several rounds of play.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bullseye
{
    Scanner input = new Scanner(new File("games.txt"));

    int rows = 0;
    int columns = 0;
    double radius1 = 0;
    double radius2 = 0;
    double theScore = 0;
    double theScore1 = 0;
    double theScore2 = 0;
    double[][] score;
    double[][] scorePlayer1 = new double[1000][2];
    double[][] scorePlayer2 = new double[1000][2];

    public Bullseye() throws FileNotFoundException
    {
        //can read file into ArrayList in this
    }

    //Reads the file into an ArrayList, and then puts the ArrayList values into a 2D array.
    //This also is called in the main to return the output
    public String read() throws FileNotFoundException {
        Scanner input = new Scanner(new File("games.txt"));
        ArrayList<Double> array = new ArrayList<>();

        while(input.hasNext() == true)
        {
            array.add(input.nextDouble());
            rows++;
        }

        rows = rows/2;

        score = new double[rows][2];

        int theIndex = 0;
        for(int i = 0; i < score.length; i++)
        {
            for(int j = 0; j < score[i].length; j++)
            {
                score[i][j] = array.get(theIndex);
                theIndex++;
            }
        }

            fillPlayer1();
            fillPlayer2();

            for(int i = 0; i < score.length; i++)
                for(int j = 0; j < score[i].length; j++) {

                    getTheScore1();
                    getTheScore2();
                    return winner(theScore1, theScore2);
                }


        return null;
    }

    //Returns the coordinates in the score array
    public double getScoreArray()
    {
        for(int r = 0; r < score.length; r++)
        {
            for(int c = 0; c < score[r].length; c++)
            {
                return score[r][c];
            }
        }
        return 0;
    }

    //Fills the first three coordinate pairs into the scorePlayer1 array
    public double[][] fillPlayer1()
    {
        int counter = 0;
        for(int r = 0; r < score.length; r++)

            for(int c = 0; c < score[r].length; c++)
            {
                if(counter < 6)
                {
                    scorePlayer1[r][c] = score[r][c];

                    radius1 = Math.pow(score[r][c],2) + Math.pow(score[r][c],2) ; // need to add + y^2
                    radius1 = Math.sqrt(radius1);
                    return scorePlayer1;
                }
                else
                {

                }

                counter++;
            }
        return scorePlayer1;
    }



    //Fills the last three coordinate pairs into the scorePlayer2 array
    public double[][] fillPlayer2()
    {
        int counter = 0;
        for(int r = 0; r < score.length; r++)
        {
            for(int c = 0; c < score[r].length; c++)
            {
                if(counter < 6)
                {

                }
                else if(counter < 12)
                {
                    scorePlayer2[r][c] = score[r][c];
                    radius2 = Math.pow(score[r][c],2) + Math.pow(score[r][c],2) ; // need to add + y^2
                    radius2 = Math.sqrt(radius2);
                    return scorePlayer2;
                }
                else
                {

                }

                counter++;
            }
        }

        return scorePlayer2;

    }

    //uses the radius computed for player 1 to calculate the score for player 1
    public double getTheScore1()
    {
        if(radius1 <= 4)
        {
            theScore1 += 100;
        }
        else if(radius1 > 4 && radius1 <= 8 )
        {
            theScore1 += 80;
        }
        else if(radius1 > 8 && radius1 <= 12)
        {
            theScore1 += 60;
        }
        else if(radius1 > 12 && radius1 <= 16)
        {
            theScore1 += 40;
        }
        else if(radius1 > 16 && radius1 <= 20)
        {
            theScore1 += 20;
        }
        else
        {
            theScore1 += 0;
        }

        return theScore1;

    }

    //uses the radius computed for player 1 to calculate the score for player 2
    public double getTheScore2()
    {
        if(radius2 <= 4)
        {
            theScore2 += 100; //should be +=
        }
        else if(radius2 > 4 && radius2 <= 8 )
        {
            theScore2 += 80;
        }
        else if(radius2 > 8 && radius2 <= 12)
        {
            theScore2 += 60;
        }
        else if(radius2 > 12 && radius2 <= 16)
        {
            theScore2 += 40;
        }
        else if(radius2 > 16 && radius2 <= 20)
        {
            theScore2 += 20;
        }
        else
        {
            theScore2 += 0;
        }

        return theScore2;

    }

    //takes in 2 parameters of each players' scores to determine the winner
    public String winner(double player1, double player2)
    {
       //double player1 = getTheScore1();
       //double player2 = getTheScore2();
        //for(int i = 0; i < score.length; i +)
        //i+=12 - try to find way to loop by column

            if (player1 > player2) {
                return "Score: " + player1 + " to " + player2 + " Player 1 wins! ";
            } else if (player1 < player2) {
                return "Score: " + player1 + " to " + player2 + " Player 2 wins! ";
            } else {
                return "Score: " + player1 + " to " + player2 + " Tie! ";
            }
    }


}

