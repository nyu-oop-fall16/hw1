Homework 1
----------------

The purpose of this homework is to get you up and running with all the tools you will be using over the course of the semester. 

In order to get full credit you must do several things.

* Clone this Github repository.
* A log of your first sbt console session.
* Some commits to your Github repository.   

Detailed instructions on how to do these things are below. 

**For all things that require your email, please use your NYU email only.

Step 0: Platform
----------------
Using Windows in this course is not advised. I will provide support and instruction for OSX and Linux. I know next to nothing about Windows and may be unable to help you if you have issues. 

If you have a system running Windows, I recommend installing an Ubuntu virtual machine using VirtualBox. VirtualBox is free. Instructions can be found [here]( http://www.psychocats.net/ubuntu/virtualbox).

** Make sure to give your system plenty of disk space, at least 30 gigs, if possible. Don't worry VirtualBox will only actually use what it needs.

Once you've followed the above instructions, start the VM. Open the Devices menu option and click 'Insert guest additions CD image.' You will be prompted to run some software from that image. Follow the instructions and install the guest additions. This will give you better screen resolution.

Step 1: Github Account
---------------------
Complete this ASAP, you will not be able to complete the assignment until I've added you to the Github organization for the class, which will give you access to the repository.

* Sign up for [a Github account](https://github.com/), if you do not have one already. If you do have one already, associate your nyu email address with that account [here](https://github.com/settings/emails).
* Email me your Github username to shepherd@cs.nyu.edu from your NYU email account with the subject OOP Github Account. The only thing in the body should be the username.
* You will get an email from Github with an invitation to join the nyu-oop organization. Follow the instructions to accept the invitation.
* If you are unfamiliar with Git, watch the [first two git basics video](http://git-scm.com/videos).
* If you are unfamiliar with Github, watch [this YouTube video](https://www.youtube.com/watch?v=0fKg7e37bQE).

A [simple git cheatsheet](http://rogerdudler.github.io/git-guide/). A [complete reference](http://www.git-scm.com/book/en/v2).

I suggest using the command line or the Intellij integration, but in a pinch [this GUI](https://desktop.github.com/) might be useful.
 
Step 2: Install tools
---------------------
<b><u>Homebrew</u></b> [OSX only] 
 
Homebrew is a package manager for OSX, which makes installing development software much easier. We will use it to install Sbt and Astyle. You will find it useful in the future for install of other things as well.

* [OSX] Install using the instructions [here](http://brew.sh/)

<b><u>XCode</u></b> [OSX only]   

XCode is a development environment for Macs. We will not be using it, but installing it installs a number of useful Unix command line tools. If you are already able to compile and execute C++ on your machine, you can skip this step, otherwise..

* [OSX] Install XCode 6.4 from [here](https://developer.apple.com/xcode/downloads/)

<b><u>Git</u></b>
* [Ubuntu] Git is pre-installed on Ubuntu.
* [OSX] From terminal: ```brew install git```
* You can test the install of git on your system by running the command `git` from terminal. You should see usage information.
* Finally run the following commands from terminal:<br>
   ```git config --global user.email "your@email.com"```<br>
   ```git config --global user.name "Your Name"```<br>
   (The email should be the same email you used to register your github account)

<b><u>Java</u></b>  
[OSX]
* From the terminal ```/usr/libexec/java_home -V```  This command will tell you what versions of the JDK are installed on your machine.
* You need 1.6 and 1.7 for this course. 
* If you do not have Java 1.6 already - Download and install [Java 6](https://support.apple.com/kb/DL1572?viewlocale=en_US&locale=en_US) 
* If you do not have Java 1.7 already - Download and install [Java 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)
* Once you are are done open your ~/.bash_profile and make sure that your JAVA_HOME is configured like this  
    ```export JAVA_HOME=`/usr/libexec/java_home -v 1.7```   

[Ubuntu]
* From terminal: ```sudo apt-get install build-essential openjdk-7-jdk dejagnu```
* Use the following commands and follow the instructions to make sure that Java 7 is selected
     ```sudo update-alternatives --config java ```  
     ```sudo update-alternatives --config javac ```

<b><u>Sbt</u></b>    

Sbt is an open source build tool for Scala and Java projects, similar to Maven or Ant. More information can be found [here](https://en.wikipedia.org/wiki/SBT_%28software%29). (You will need this to do the homeworks and project)  

* [OSX]  From terminal: ```brew install sbt```
* [Ubuntu] From terminal:<br>
   ```echo "deb https://dl.bintray.com/sbt/debian /" | sudo tee -a /etc/apt/sources.list.d/sbt.list```<br>
   ```sudo apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 642AC823```<br>
   ```sudo apt-get update```<br>
   ```sudo apt-get install sbt```  
* Confirm success by running the command from terminal: 
    ```sbt    ```
    (Sbt should start. Ctrl+c to quit.)

** More detailed instructions can be found [here](http://www.scala-sbt.org/release/tutorial/Installing-sbt-on-Linux.html).

<b><u>Astyle</u></b>  

AStyle is a code formatter that works for Java and C++. This will be critical for collaboration and debugging of your code. In our Sbt project I have included custom tasks that will run the formatter for you on the your source and target code. However, in order for this to work you must install Astyle first.

* [OSX] ```brew install astyle```
* [Ubuntu] ```sudo apt-get install astyle```
* Confirm success by running the command from a terminal ```astyle``` (You should see the message 'Artistic Style has terminated')

Step 3: Clone your hw1 repository and push a commit
-------------------------------------------------
You should have received an email from Github notifying you that you have been added to the 'nyu-oop-fall16' organization. This means you have access to class repositories. This is where you will get your homework assignments as well as project resources and code used in class.

* Open a browser [here](https://github.com/nyu-oop-fall16/) and locate hw1
* Choose a place on your computer for your homeworks to reside and open a terminal to that location.
* Execute the following series of commands: <br/>
  ```git clone https://github.com/nyu-oop-fall16/<YOUR_GITHUB_USERNAME>-hw1.git```<br/>
  ```cd hw1   ```<br/>
  ```>sbt-rocks.txt   ```<br/>
  ```git add sbt-rocks.txt    ```<br/>
  ```git commit -m "First commit" sbt-rocks.txt   ```<br/>
  ```git push origin master   ```<br/>  

You should now see a file 'sbt-rocks.txt' on the Github page for your hw1 repository. 

Step 4: Execute some commands in Sbt
------------------------------------
You are now going to have your first session with sbt. As previously mentioned, sbt is an interactive build tool. What this means it that you can interact with it on the command line to do things like compile, test, debug and run your code. 

In this step you are going to run some sbt commands that you will need while working on homework and the project. 

* Open a terminal to where you checked out your hw1 repository.
* Perform the ls command and note the contents of the project directory.
* The files of any Sbt repo contain the following things...
  <ul>
  <li>*build.sbt* - the main project definition file. Where library dependencies are declared and custom commands are defined.
  <li>*project* – project definition files, nothing that interesting to you.
  <li>*src/main* – app code goes here, in a subdirectory indicating the code’s language (e.g. src/main/java)
  <li>*src/main/resources* – static files you want added to your jar (e.g. logging config)
  <li>*src/test* – like src/main, but for tests
  <li>*target* – the destination for generated stuff (e.g. class files, jars)
  </ul>
* Start sbt by running the ```sbt``` command. After sbt does some initialization of the project, you will presented with a command prompt ```>```
* Enter the command ```compile```. This will run all the code under the Java code under src/ directory.
* Enter the command ```test```. This will run all the JUnit tests found under src/test directory. (There is only one right now, but you will be writing one later in this assignment.)
* Copy the terminal output for the above commands to the file sbt-rocks.txt.
* Type Ctrl+c to quit sbt.
* Use the following commands to publish your changes to Github:<br>
   ```git commit -m "SBT console output" sbt-rocks.txt```<br>
   ```git push origin master```<br>

You can confirm that everything was successful by browsing the sbt-rocks.txt file on Github.

Step 5: Get Intellij & Clion
---------------------------------
We will be using the [IntelliJ Idea Java IDE](https://www.jetbrains.com/idea/) as well as the [CLion C++ IDE](https://www.jetbrains.com/clion/). [It is my opinion that these tools are superior to anything else available](https://plumbr.eu/blog/java/why-we-dropped-eclipse-in-favour-of-intellij). It is what we will use in class. And I will be demonstrating debugging and development techniques with these tools that will make your life easier. 

* Sign up for [free student licenses](https://www.jetbrains.com/shop/eform/students) (Reminder: use your NYU email)
* In the meantime, download the [Ultimate Edition Free 30-day trial]](https://www.jetbrains.com/idea/download/) of Intellij.
* [Ubuntu] Untar the downloaded archive by clicking it and then using the "Extract" menu item. Extract to location of your choice. Open that location and follow the instructions inside the "Install-Linux-tar.txt" file.
* [OSX] Open the disk image and use the installer.
* When prompted, select "Evaluate for 30 days". Install the license when you get them in an email from Jetbrains.
* During the "Customize" phase on the "*Featured* plugins screen", select and install the 'Scala' plugin. It should be in the top left corner of this screen. This is necessary to get Sbt integration in Intellij.
* For reference, here is a link to the [Intellij documentation](https://www.jetbrains.com/idea/help/basic-concepts.html).
* Also download the Clion [free 30-day trial](https://www.jetbrains.com/clion/). The process to install it is similar to Intellij.

There are many many free plugins available for Intellij. You should feel free to install anything that sounds useful to you. You can explore whats available from the "Preferences" menu in Intellij.

Step 6: Open the hw1 repository in IntelliJ
-------------------------------------------
* Open Intellij and click the "Import Project" menu item.
* Navigate to your cloned repository and select the "hw1" directory and click "Import".
* Click the radio button "Import project from external model".
* Highlight SBT. Click Next.
* Check "Use Auto-import", "Download sources and docs" and "Download SBT sources and docs". Do not hit "Finish" yet.
* The dropdown for the Project SDK will mostly likely be empty. We need to configure a JVM.
  * Click "New" and then "JDK". 
  * Most likely IntelliJ will guess correctly where your JDK is. If not..
  * [Ubuntu] it is ```/usr/lib/jvm/java-7-openjdk-amd64```
  * [OSX] Where your JVM is depends on what version of OSX you are using. On newer versions of OSX you can use this command to find the location of the JDK ```/usr/libexec/java_home -v 1.7```). 
  * Select the JDK folder. Click "Finish". 
  * Post on Piazza if you need help, most likely others have had the same problem and figured it out.
* It may take Intellij a few minutes to initialize the project.
* If you are prompted with a message like "Unregistered VCS root detected", click "Add root".

Step 7: Execute Point.java in IntelliJ
--------------------------------------
* Download [Point.java](https://dl.dropboxusercontent.com/u/14203263/Point.java)
* Save it into the hw1 project to the src/main/java/edu/nyu/oop directory.
* In Intellij on the left pane titled 'Project', using what you learned about the sbt directory structure, navigate the project and find Point.java. Open it.
* Click the 'Run' menu item. Click "Edit Configurations". 
* In the top left corner click the '+' icon.
* Click 'Application'.
* In the 'Name' field type 'Point'.
* In the 'User classpath from module' dropdown, select 'hw1'.
* Click the '...' button next to the 'Main Class' field. Find Point.java and select it. Hit 'OK'.
* In the top right, you should see a dropdown with the name 'Point' in it with a green arrow to the right of it. 
* Click the green arrow. You should see some output in a pane at the bottom of IntelliJ like this.
   ```Point(1.0, 2.0, 3.0, 4.0)
      Distance from origin: 5.477225575051661```
* In 'VCS' menu, click the entry that says 'Enable Version Control Integration'
* Select Git. Hit OK.
* Open the Git integration window by using the command 'Command+k' on OSX or the command 'Control+k' on Ubuntu.
* Enter a commit message.
* On the 'Commit' button there is a little arrow pointing down. Click it and select 'Commit & Push'.
* Complete the push to the master branch.
* Check Github and confirm that Point.java is now in the repository.

You are done!
