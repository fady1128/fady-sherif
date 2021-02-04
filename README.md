			
			Instabug Challenge

  What is it?
  -----------
First part:
you will find an exncel file called testplan-testcases-testBugs.xlsx containing three different sheets
   1) First sheet called High level scenarios
     -- this is the list of ideas or business 
   2) Second sheet called Test Cases
     -- i choose here an example for a module and wrote a brief test cases for 
   3) Third sheet called Bugs
     -- this sheet contains list of bugs i found and Mention (clear title - reproduce steps - needed attachments - affected devices - network - severity and priority) 


Second Part:
3) Third sheet called Bugs
     -- this sheet contains list of bugs i found and Mention (clear title - reproduce steps - needed attachments - affected devices - network - severity and priority) 
     
Third Part:
you will find a folder called Instabug_Task containg all test automation implementation inside

follow the follwoing steps please:

1) you need to download latest JAVA JDK 
 
 Installing JAVA JDK 
  ----------------

  1) Unpack the archive where you would like to store the binaries, e.g.:
    Windows
      unzip jdk-15.0.2

  2) A directory called "jdk-15.0.2" will be created.

  3) Add the bin directory to your PATH, e.g.:
    Windows
      set PATH="c:\program files\jdk-15.0.2\bin";%PATH%

  4) Run "java -version" to verify that it is correctly installed 

2) you need to download latest MAVEN

 Installing Maven
  ----------------

  1) Unpack the archive where you would like to store the binaries, e.g.:
    Windows
      unzip apache-maven-3.x.y.zip

  2) A directory called "apache-maven-3.x.y" will be created.

  3) Add the bin directory to your PATH, e.g.:
    Windows
      set PATH="c:\program files\apache-maven-3.x.y\bin";%PATH%

  4) Make sure JAVA_HOME is set to the location of your JDK

  5) Run "mvn -version" to verify that it is correctly installed 

3) you need to check that this path contains chromedriver.exe i attached Instabug_Task\Dependencies 
4) you need to update two things in this path in Instabug_Task\src\main\java\utils.java when you open it
    -- CHROME_LOCATION: with your chromedriver.exe location in your pc
    -- EXCEL_PATH: TestDataUsers.xls with your location in your pc
    -- Note TestDataUsers.xls should be in format for 97-2003 excel greater that this is out of scope
