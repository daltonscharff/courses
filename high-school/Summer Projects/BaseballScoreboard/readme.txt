=== Baseball Scoreboard ===
====== User's Manual ======

_Introduction______________
Usinging the BaseballScoreboard.jar program along with the included graphic (BaseballScoreboard.lsgfx) in Livestream Studio allows for complete control of this baseball scoreboard via a standard numberpad input.


_Setup_____________________
To begin using this baseball scoreboard, first open Livestream Studio and navigate to the GFX module in which you would like this graphic to be located. Next, click on the Add Layer button (the "+" sign), select "Import Layer", and click "Livestream Graphics". Within the file location window, navigate to this folder and select "BaseballScoreboard.lsgfx" and click "Open".

To populate the scoreboard, navigate to the BaseballScoreboard folder and run the BaseballScoreboard.jar file. Fill in your team's infomation and then click "Create". The graphic in Livestream Studio should have updated.

If the graphic is not showing up correctly, go into the settings for the graphic and ensure that the file location is pointing to the .csv file entitled "scoreboard.csv". Also make sure "Watch file for update", "Use first row as column titles", and "Read only" are checked. Make sure that "Comma" is selected under the Separators area. Finally, ensure that Auto PUSH/PULL is enabled.


_Controls__________________
Key Pressed:	Action Performed

     1		ball counter + 1
     2		strike counter + 1
     3		out counter + 1, set balls and strikes to 0
     4		toggle man on third
     5		toggle man on second
     6		toggle man on first
     7		no operation
     8		home score + 1
     9		away score + 1
     +		increment inning counter
     /		home Score - 1
     *		away Score - 1
     -		decrement inning counter


_Customization_____________
Upon the first run of BaseballScoreboard.jar, a defaults.txt file is created and populated with the home team's name and color. For even greater customization, editing the lines in this file change the defauls for when the BaseballScoreboard.jar is opened. The following is an explanation for each line in the defaults.txt file.

Home			Home Team Name
0			Home Team Color in relation to its position in the drop down box (i.e., 0 = Black)
Away			Away Team Name
1			Away Team Color in relation to its position in the drop down box (i.e., 1 = Blue_Light)
true			Whether 3 outs will increment the inning counter (i.e., true = yes, it will increment)
scoreboard.csv		File saving location*

*This final line allows the user to change the file name and location of the .csv file which the program creates. This is for advanced users only. If this is changed, be sure to update the file location in the BaseballScoreboard.lsgfx settings within Livestream Studio.

If you require a custom color bar for your team, navigate to ..\BaseballScoreboard\images\colorBars and add your own file. Note that color bar dimensions are 332px wide by 50px high. The use of .png files is recommended.


_Resetting the Program______
If for any reason an incorrectable error has been made to the defaults.txt file, simply delete it and rerun the BaseballScoreboard.jar application again. This will create a new defaults.txt file. The scoreboard.csv will also be remade every time the user hits "Create" in the BaseballScorebaord.jar application or enters a new number into the input field.