*Experta ART Refactored App Test - Solution*

Environment Requeriments:
Java 1.8
sts-3.9.5.RELEASE
Maven 3+

Download the project repository and import within IDE (the application was developed using sts-3.9.5.RELEASE version)

Use MAVEN mvn clean install commands to download and to compile the project.

Run the project in console with the option mvn spring-boot:run

Open http://localhost:8080/attention/postconfirm?attentionId=1&driverId=1 to test the service

Open http://localhost:8080/indexIOS.html to access the page that simulates the IOS device end-point

Open http://localhost:8080/indexAndroid.html to access the page that simulates the ANDROID device end-point

Check the pages indexIOS.html and indexAndroid.html for validate if the confirmation message was pushed in the correct device depends on the user type of the service .



