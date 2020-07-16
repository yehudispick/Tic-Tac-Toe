/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yehudis
 */
public class TicTacToe extends JFrame {
    String user="X";
    String computer="O";
    int col = 3;
    int row = 3;
    int turn = 0;
   // boolean userTurn = true;
    Boolean winner = false;
     int square = 100;
    JLabel MyLabels[][] = new JLabel[3][3];
    
    public TicTacToe() {
        setup();
    }
   
    public void setup() {
        
        setSize(new Dimension(400, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Tic Tac Toe");
        GridLayout MyLayout = new GridLayout(col, row);
        JPanel game = new JPanel();
        game.setLayout(MyLayout);
        
        
        for (int i = 0; i< MyLabels.length; i++)
        {
            for (int j = 0; j< MyLabels[i].length; j++)
            {
                int row = i;
                int col = j;
                JLabel MyLabel = new JLabel("", SwingConstants.CENTER);
                MyLabels[i][j] = new JLabel();
                 MyLabels[i][j] = MyLabel;
                
                game.add(MyLabel);
                add(game, BorderLayout.CENTER);
                MyLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                MyLabels[row][col].setFont(new Font("Arial", Font.BOLD, 100));
                MyLabels[row][col].setHorizontalAlignment(SwingConstants.CENTER);
                MyLabels[row][col].setForeground(Color.ORANGE);
                MyLabels[row][col].setBackground(Color.LIGHT_GRAY);
                MyLabel.addMouseListener(new MouseAdapter()
                {
                    @Override
                    public void mousePressed(MouseEvent e)
                    {
                        
                        if (MyLabel.getText().isEmpty())
                        {
                            if (doTurn(row, col, user)){                                            
                                    computerTurn();
                      
                            }
                        }
     
                    }
                });
            }
        }
                    
        JPanel buttons = new JPanel();
        JButton restart = new JButton("Restart");
        JButton quit = new JButton("Quit");
        buttons.add(restart);
        buttons.add(quit);
        add(buttons, BorderLayout.SOUTH);
        restart.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               turn=0;
                for (int i = 0; i < MyLabels.length; i++)
                {
                    for (int j = 0; j < MyLabels[i].length; j++)
                    {
                        MyLabels[i][j].setText("");
                    }
                }
            }
        }
        );
        quit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               JOptionPane.showMessageDialog(null, "Thanks for playing! \nExiting application...");
               dispose();
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 400);
        setLocationRelativeTo(null);       
    }

    public static void main(String[] args) {
        new TicTacToe().setVisible(true);
    }
      
    private void computerTurn(){
        while (true)
        {
            int row = (int) (Math.random() * 3);
            int col = (int) (Math.random() * 3);
            if (isEmptyCell(row, col))
            {
                doTurn(row, col, computer);
                break;
            }

        }

    }
        private boolean doTurn(int row, int col, String symbol)
    {
        turn++;
        MyLabels[row][col].setText(symbol);
         if (CheckifWinner(symbol)) {
            JOptionPane.showMessageDialog(this, symbol + " is the Winner", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            winner = true;
            return false;
           
        }

        if (turn >= 9)
        {
            JOptionPane.showMessageDialog(this, "It's a Tie", "Tic Tac Toe", JOptionPane.INFORMATION_MESSAGE);
            return false;
            //System.exit(0);
        }
        return true;

    }

    //use method so user can also use not to overwrite himself
    private boolean isEmptyCell(int row, int col)
    {
        return MyLabels[row][col].getText().isEmpty();

    }

    public void cpuTurn()
    {
        int x = 0;
        int y = 0;

        while (true)
        {
            x = (int) (Math.random() * 3);
            y = (int) (Math.random() * 3);
            System.out.println(x);
            System.out.println(y);
            if (MyLabels[x][y].getText().isEmpty())
            {
                MyLabels[x][y].setText("O");
                MyLabels[x][y].setForeground(Color.RED);

                break;
            } else
            {
                continue;
            }
        }

    }

        public  boolean CheckifWinner(String symbol) {
           if ((MyLabels[0][0].getText().equals(symbol) && MyLabels[0][1].getText().equals(symbol) && MyLabels[0][2].getText().equals(symbol))
                    || (MyLabels[1][0].getText().equals(symbol) && MyLabels[1][1].getText().equals(symbol) && MyLabels[1][2].getText().equals(symbol))
                    || (MyLabels[2][0].getText().equals(symbol) && MyLabels[2][1].getText().equals(symbol) && MyLabels[2][2].getText().equals(symbol))) {
                return true;
               
            } else if ((MyLabels[0][0].getText().equals(symbol) && MyLabels[1][0].getText().equals(symbol) && MyLabels[2][0].getText().equals(symbol))
                    || (MyLabels[0][1].getText().equals(symbol) && MyLabels[1][1].getText().equals(symbol) && MyLabels[2][1].getText().equals(symbol))
                    || (MyLabels[0][2].getText().equals(symbol) && MyLabels[1][2].getText().equals(symbol) && MyLabels[2][2].getText().equals(symbol))) {
                return true;
             
            } else if ((MyLabels[0][0].getText().equals(symbol) && MyLabels[1][1].getText().equals(symbol) && MyLabels[2][2].getText().equals(symbol))
                    || (MyLabels[2][0].getText().equals(symbol) && MyLabels[1][1].getText().equals(symbol) && MyLabels[0][2].getText().equals(symbol))) {
                return true;

            }
           
            return false;
         
        }
}


        
