@echo off

REM Do not run clean cause it deletes failed.txt file
mvn compile test surefire-report:report-only  -B -PfailedTestCategory

REM exit 0