# Appium
Appium Framework in Java which supports Automation of Native Application

#####Quick Start#####
1) Environment supported is Mac OS with Version 10+

2) Appiun Setup
   Pre-req: Make sure that you have JAVA 1.8 + on your machine, Also note Appium is not compatible to JAVA 10 and Android also has some issues with JAVA 10.

1.  Appium is a node server, so you should have node & npm installed on your machine.
    For installing node, you can choose multiple install methods via brew/apt-get etc.
    For installing NPM, go to https://www.npmjs.com/get-npm

    Install NodeJs---> 14+ Version

2.  Install Android SDK

3.  Install XCode

4.  Install Appium **1.20+**

    ```$ sudo npm install -g appium@1.21 --unsafe-perm=true --allow-root```

5.  Install Appium Doctor to verify Appium Installation.
    ```
    $ sudo npm install -g appium-doctor --unsafe-perm=true --allow-root
    ```
    Run below command to verify appium setup.
    ```
    $ appium-doctor
    ```You can ignore "Bin directory for $JAVA_HOME is not set" error. But except this everything should be green when you run "appium-doctor" , configure the JAVA_HOME and ANDROID_HOME environment  variables </i>

6) Supported for Android OS

#####Running the Tests#####
q) Clone the Repo
a) Run InstallApp class , so that APK file gets installed in the Device if its not installed
b) Run the textng.xml file
