@echo off
title Remote

javac -cp ".;../Libraries/jdom-2.0.6.jar" -sourcepath ../init ../init/*.java
start "Remote" /D"../init" java Remote
exit
