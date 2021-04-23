@echo off

:: Do not run clean cause it deletes failed.txt file

mvn compile test surefire-report:report-only  -B -PfailedTestCategory -Dbrowser=%browser%

echo [INFO] ------------------------------------------------------------------------
echo [INFO]  Failed tests end
echo [INFO] ------------------------------------------------------------------------

REM exit 0