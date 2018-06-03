@REM ===============================================================================
@REM   FICHIER : xxxxxxxxxxxxxxxxxxxxx
@REM
@REM   DESCRIPTION FONCTIONNELLE
@REM
@REM   Script de lancement du batch de xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
@REM
@REM   SYNTAXE D'APPEL
@REM
@REM    xxxxxxxxsxxxxxxxxxxxxxxxxxxxxxxxx.ksh xxxxx xxxx ...
@REM
@REM   		Les param�tres
@REM
@REM    		- xxxxxxxxxxxxxxxxxxxx : ......
@REM
@REM
@REM   CODE RETOUR
@REM
@REM     0 		OK
@REM     Autre  ERREUR
@REM
@REM 	Pour AIX :
@REM 	La variable BASEDIR doit etre d�finie en dehors du ksh
@REM     Elle precise le repertoire dans lequel l'applicatif a ete installe
@REM ===============================================================================

@echo off

set ERROR_CODE=0

:init
@REM Decide how to startup depending on the version of windows

@REM -- Win98ME
if NOT "%OS%"=="Windows_NT" goto Win9xArg

@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" @setlocal

@REM -- 4NT shell
if "%eval[2+2]" == "4" goto 4NTArgs

@REM -- Regular WinNT shell
set CMD_LINE_ARGS=%*
goto WinNTGetScriptDir

@REM The 4NT Shell from jp software
:4NTArgs
set CMD_LINE_ARGS=%$
goto WinNTGetScriptDir

:Win9xArg
@REM Slurp the command line arguments.  This loop allows for an unlimited number
@REM of arguments (up to the command line limit, anyway).
set CMD_LINE_ARGS=
:Win9xApp
if %1a==a goto Win9xGetScriptDir
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto Win9xApp

:Win9xGetScriptDir
set SAVEDIR=%CD%
%0\
cd %0\..\.. 
set BASEDIR=%CD%
cd %SAVEDIR%
set SAVE_DIR=
goto repoSetup

:WinNTGetScriptDir
set BASEDIR=%~dp0\..

:repoSetup


if "%JAVACMD%"=="" set JAVACMD=java

if "%REPO%"=="" set REPO=%BASEDIR%\lib

set CLASSPATH="%BASEDIR%"\conf;"%REPO%"\c3p0-0.9.5.2.jar;"%REPO%"\mchange-commons-java-0.2.11.jar;"%REPO%"\postgresql-9.3-1102-jdbc41.jar;"%REPO%"\generator-profil-batch-core-1.7-SNAPSHOT.jar;"%REPO%"\spring-ldap-core-2.0.2.RELEASE.jar;"%REPO%"\spring-data-commons-1.6.1.RELEASE.jar;"%REPO%"\jcl-over-slf4j-1.7.1.jar;"%REPO%"\spring-ldap-core-tiger-2.0.2.RELEASE.jar;"%REPO%"\joda-time-2.9.4.jar;"%REPO%"\joda-convert-1.8.1.jar;"%REPO%"\spring-core-3.2.14.RELEASE.jar;"%REPO%"\commons-logging-1.2.jar;"%REPO%"\spring-tx-3.2.14.RELEASE.jar;"%REPO%"\spring-beans-3.2.14.RELEASE.jar;"%REPO%"\spring-expression-3.2.14.RELEASE.jar;"%REPO%"\toolbox-batch-4.0-Final.jar;"%REPO%"\jetty-6.1.26.jar;"%REPO%"\jetty-util-6.1.26.jar;"%REPO%"\servlet-api-2.5-20081211.jar;"%REPO%"\log4j-api-2.3.jar;"%REPO%"\log4j-core-2.3.jar;"%REPO%"\log4j-slf4j-impl-2.3.jar;"%REPO%"\slf4j-api-1.7.18.jar;"%REPO%"\spring-test-3.2.14.RELEASE.jar;"%REPO%"\spring-context-3.2.14.RELEASE.jar;"%REPO%"\spring-jms-3.2.14.RELEASE.jar;"%REPO%"\spring-aop-3.2.14.RELEASE.jar;"%REPO%"\aopalliance-1.0.jar;"%REPO%"\spring-jdbc-3.2.14.RELEASE.jar;"%REPO%"\spring-orm-3.2.14.RELEASE.jar;"%REPO%"\spring-oxm-3.2.14.RELEASE.jar;"%REPO%"\spring-instrument-3.2.14.RELEASE.jar;"%REPO%"\spring-batch-core-3.0.4.RELEASE.jar;"%REPO%"\com.ibm.jbatch-tck-spi-1.0.jar;"%REPO%"\javax.batch-api-1.0.jar;"%REPO%"\xstream-1.4.4.jar;"%REPO%"\xmlpull-1.1.3.1.jar;"%REPO%"\xpp3_min-1.1.4c.jar;"%REPO%"\jettison-1.2.jar;"%REPO%"\spring-batch-infrastructure-3.0.4.RELEASE.jar;"%REPO%"\spring-retry-1.1.0.RELEASE.jar;"%REPO%"\spring-batch-integration-3.0.4.RELEASE.jar;"%REPO%"\spring-integration-core-4.0.1.RELEASE.jar;"%REPO%"\spring-messaging-4.0.5.RELEASE.jar;"%REPO%"\commons-dbcp2-2.1.1.jar;"%REPO%"\commons-pool2-2.4.2.jar;"%REPO%"\aspectjrt-1.8.9.jar;"%REPO%"\aspectjweaver-1.8.9.jar;"%REPO%"\toolbox-base-4.0-Final.jar;"%REPO%"\generator-profil-batch-spring-1.7-SNAPSHOT.jar
goto endInit

@REM Reaching here means variables are defined and arguments have been captured
:endInit

%JAVACMD% %JAVA_OPTS%  -classpath %CLASSPATH_PREFIX%;%CLASSPATH% -Dapp.name="generator-profil-batch-spring" -Dapp.repo="%REPO%" -Dapp.home="%BASEDIR%" -Dbasedir="%BASEDIR%" org.springframework.batch.core.launch.support.CommandLineJobRunner classpath:/jobs/job.xml exampleJob %CMD_LINE_ARGS%
if ERRORLEVEL 1 goto error
goto end

:error
if "%OS%"=="Windows_NT" @endlocal
set ERROR_CODE=%ERRORLEVEL%

:end
@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" goto endNT

@REM For old DOS remove the set variables from ENV - we assume they were not set
@REM before we started - at least we don't leave any baggage around
set CMD_LINE_ARGS=
goto postExec

:endNT
@REM If error code is set to 1 then the endlocal was done already in :error.
if %ERROR_CODE% EQU 0 @endlocal


:postExec

if "%FORCE_EXIT_ON_ERROR%" == "on" (
  if %ERROR_CODE% NEQ 0 exit %ERROR_CODE%
)

exit /B %ERROR_CODE%
