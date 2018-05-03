set projectRootPath=C:\spring-boot\feb-2018\crudBackend
set tomcatServerPath=C:\sw\apache-tomcat-7.0.79
cd %projectRootPath%
set JAVA_HOME=%JAVA_HOME_8%
set JRE_HOME=%JRE_HOME_8%
set path=%JAVA_HOME%\bin;%JRE_HOME%\bin;%M2_HOME%\bin;C:\sw\node-v6.11.2
cd %projectRootPath%\restClient
call ng build --prod
cd %projectRootPath%
call mvn clean package -Dmaven.test.skip=true
cd %tomcatServerPath%\bin
call shutdown.bat
cd %tomcatServerPath%\webapps
call rmdir /s /q crud-demo
call del crud-demo.war
cd %projectRootPath%\target
call copy crud-demo.war %tomcatServerPath%\webapps
cd %tomcatServerPath%\bin
call startup.bat
cd %projectRootPath%
