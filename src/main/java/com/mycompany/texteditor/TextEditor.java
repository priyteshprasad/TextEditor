/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.texteditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author PRIYTESH PRASAD
 */
public class TextEditor implements ActionListener{
    JFrame frame;
    JMenuBar menuBar;
    
    JMenu file, edit;
    
    JMenuItem newFile, openFile, saveFile;
    JMenuItem cut, copy, paste, selectall, close;
    
    JTextArea textarea;
    TextEditor(){
        //Initialize a frame
        frame = new JFrame();
        
        //Initiialize menuBar
        menuBar = new JMenuBar();
        
        //initialize text area
        textarea = new JTextArea();
        
        //Initialize menus
        file = new JMenu("File");
        edit = new JMenu("Edit");
        
        //Initialize file menu items
        newFile = new JMenuItem("New Window");
        openFile = new JMenuItem("Open File");
        saveFile = new JMenuItem("Save File");
        
        //add action listener to file menu
        newFile.addActionListener(this); //TextEditor is this
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        
        //add menu items to filemenu
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        
        //initialize edit menu item
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        selectall = new JMenuItem("Select all");
        close = new JMenuItem("Close");
        
        //Add actionListener to edit menu items
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectall.addActionListener(this);
        close.addActionListener(this);
        
        //add to edit menu
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectall);
        edit.add(close);
        
        //add to menubar
        menuBar.add(file);
        menuBar.add(edit);
        
        //set menuBar to frame
        frame.setJMenuBar(menuBar);
        
        //create content pane
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5,5,5,5));
        panel.setLayout(new BorderLayout(0,0));
        panel.setBounds(frame.getX(), frame.getY(), frame.getWidth(), frame.getHeight());
        //add textarea to panel
        panel.add(textarea, BorderLayout.CENTER);
        //create scroll pane
        JScrollPane scrollPane = new JScrollPane(textarea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // add scroll pane to panel
        panel.add(scrollPane);
        //add panel to frame
        frame.add(panel);
       
        
        //set dimention of the frame
        frame.setBounds(0, 0, 400, 400);
        frame.setTitle("Accio Text Editor");
        frame.setVisible(true);
        frame.setLayout(null);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent){
        
        if(actionEvent.getSource() == cut){
            //perform cut
            textarea.cut();
        }
        if(actionEvent.getSource() == copy){
            //perform copy
            textarea.copy();
        }
        if(actionEvent.getSource() == paste){
            //perform paste
            textarea.paste();
        }
        if(actionEvent.getSource() == selectall){
            //perform selectAll
            textarea.selectAll();
        }
        if(actionEvent.getSource() == close){
            //perform close editor option
            System.exit(0);
        }
        if(actionEvent.getSource() == openFile){
            JFileChooser fileChooser = new JFileChooser("C:");
            int chooseOption = fileChooser.showOpenDialog(null);
            
            //if we have clicked on open button
            if(chooseOption == JFileChooser.APPROVE_OPTION){
                //Getting selected file
                File file = fileChooser.getSelectedFile();
                
                //get path of selected file
                String filePath = file.getPath();
                
                try{
                    //Initialize file reader
                    FileReader fileReader = new FileReader(filePath);
                    
                    //Initilize Buffer Reader
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String intermediate = "", output = "";
                    //read content of the file lini by line
                    while((intermediate = bufferedReader.readLine()) != null){
                        output += intermediate + '\n';
                    }
                    //set the output string to text area
                    textarea.setText(output);
                    
                }catch(FileNotFoundException fileNotFoundException){
                    fileNotFoundException.printStackTrace();
                }catch(IOException fileNotFoundException){
                    fileNotFoundException.printStackTrace();
                }
            }
            
        }
        if(actionEvent.getSource() == saveFile){
                //initilize file picker
                JFileChooser fileChooser = new JFileChooser("C:");
                //Get choose option from file chooser
                int chooseOption = fileChooser.showSaveDialog(null);
                //check if we clicked on save button
                if(chooseOption == JFileChooser.APPROVE_OPTION){
                    //creat a new file with choosen directory path and file name
                    File file = new File(fileChooser.getSelectedFile().getAbsolutePath() + ".txt");
                    try{
                        //initilize file writer
                        FileWriter fileWriter = new FileWriter(file);
                        //initilize Buffered writer 
                        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                        //Write content of text area  to file
                        textarea.write(bufferedWriter);
                        bufferedWriter.close();
                    }catch(IOException ioException){
                        ioException.printStackTrace();
                    }
                }
            }
        if(actionEvent.getSource() == newFile){
            TextEditor newTextEditor = new TextEditor();
        }
       
    }

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
    }
}

