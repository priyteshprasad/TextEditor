# TextEditor
# Components used
JFrame: Application Window
 >JMenuBar: MenuBar, filemenu, editmenu
 >Panel (container)
   >scroll pane (adjusting to testarea)
     >textarea
JTextArea: TextArea

# FileMenu: (menu items)
1. New File
2. Open File
3. Save File

# Edit Menu:
1. Cut
2. Copy
3. Paste
4. Selectall
5. close

Button -> click > actionEvent
checkBox -> click > actionEvent
 we have to listen to action event

Interface ActionListner: Package inside java 
only method ->actionPerformed();
if(actionEvent == newFile) {then create new file}

actionListener ---listens---> actionEvent-->actionPerformed

# Open File:
click on "Open File" --actionEvent---> 1.open file picker (JFileChooser)-> select path & file -> click on open button -> copy all the ext inside the editor area


intermediate String => "current lien"
output string=> "complete text

# Save File:
click "save file" ---actionEvent-->1.open file picker(JFileChooser) -> 2. select path and file -> 3.click on save button -> get text from textArea and save it in file.txt

# New Window:
click "new file" ->create new TextEditor object


