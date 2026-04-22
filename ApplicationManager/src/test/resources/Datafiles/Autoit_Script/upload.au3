
#CS AutoItSetOption("WinTitleMatchMode","2") ; set the select mode to select using substring
### if $CmdLine[0]<1 then
### ; Arguments are not enough
### msgbox(0,"Error","Supply all the arguments, Dialog title,Run/Save/Cancel and Path to save(optional)")
### Exit
### EndIf
 #CE

#CS If WinWaitActive("Open") Then
###    Sleep(2000)
###    Send($CmdLine[1])
###    ;Send("file:///D:/Sumer/workspace/OnGuard_Demo/drivers/chromedriver.exe")
###    Send("{TAB}")
###    Send("{TAB}")
###    Send("{SPACE}")
###    Sleep(2000)
### ElseIf  WinWaitActive("File Upload") Then
###       Send($CmdLine[1])
### 	  Sleep(1000)
### 	  Send("{ENTER}")
### EndIf
 #CE

;WinWaitActive("Open")
WinWaitActive("Open","&Open",5)

If WinExists("Open") Then

   Sleep(2000)
   Send($CmdLine[1])
   ;Send("file:///D:/Sumer/workspace/OnGuard_Demo/drivers/chromedriver.exe")
   Send("{TAB}")
   Send("{TAB}")
   Send("{SPACE}")
   Sleep(2000)
Else

   WinWaitActive("File Upload","&Open",5)
   Send($CmdLine[1])
   ;Send("file:///D:/Sumer/workspace/OnGuard_Demo/drivers/chromedriver.exe")
   Sleep(1000)
   Send("{ENTER}")
EndIf

