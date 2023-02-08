# SDETPRO_Appium
## I. Run to test on local
### 1. Run manually via TestSuite.xml
* Create resources/test-suites/LocalTestSuite.xml (template from testng.org -> Documentation -> testng.xml + Add parameters)
* Edit Configurations: add New Configuration -> TestNG -> rename -> set Test kind = Suite -> select Absolute path of .xml -> Apply -> OK
* Input Environment Variable: `remote=true/false`
  * `true`: run on hub-node of Selenium Grid, Pre-condition: run hub port 4444 on computer with ip = {environment variable - `hub`} and run appium node(s)
  * `false`: run on local appium server, Pre-condition: run local appium server port 4723 before
* Click Run button manually (click Debug button for debug mode)
### 2. Run via TestSuite.xml by Maven command (Selenium K10)
* On pom file: edit plugin Surefire
```
<suiteXmlFile>${suite}</suiteXmlFile>
```
* Command to run
```
mvn clean test -Dsuite="Path/From/Content/Root/of/LocalTestSuite.xml"
```
### 3. Run via .jar file
* Command to build (create .jar file)
```
mvn clean package -DskipTests=true
```
* Command to run (remove all allure-re* folders before to generate new Allure report)
```
java -Dplatform=android/ios -Dremote=true/fasle -jar target/SDETPRO_Appium-1.0-SNAPSHOT-fat-tests.jar
```
## II. Run via Jenkins
* Set-up Jenkins job to run via .jar file
* Build with Parameters this Jenkins job manually (or Build periodical Schedule)
  * `platform = android/ios`: build with platform `android` OR `ios`
  * `remote = true/false`
    * `true`: run on hub-node of Selenium Grid, Pre-condition: run hub port 4444 on computer with ip = {`hub`} and run appium node(s)
    * `false`: run on local appium server (on computer is installed Jenkins), Pre-condition: run local appium server port 4723 before
  * `hub = ip_address`: using in case `remote = true`
* Build the upstream Jenkins job: build with all platform `android` AND `ios`