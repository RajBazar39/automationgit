### Steps to get started:

0.- Before make sure your local machine has all the dependencies satisfied:
https://j.m0012242008.com/confluence/stepdefs.screens/viewpage.action?pageId=56069045

1.- Clone the project
 
2.- Open IntelliJ and select Import project, select the pom.xml in the root of the cloned repository.

3.- IntelliJ should detect it is a maven project and it will download all the dependencies described in the pom file.

4.- Configure PLATFORM environment variable with one of the following values: "android" , "ios" or "all"

For example: `export PLATFORM=android`

5.- In the terminal run the following two commands to execute the tests in the configured OS:

`mvn clean test`

    
### To add a new library to the QA framework:

1.- Find the new library in https://mvnrepository.com/

2.- Select the package and version you want to install and in the Maven tab copy the maven dependency/

3.- Open pom.xml file in the root of this project and paste within <dependencies> tag the new <dependency>.

4.- Open the maven IntelliJ window and sync the pom libraries to download the latest by clicking the refresh button. 


