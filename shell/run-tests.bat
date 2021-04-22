@echo off

REM This script need to get ${testCategory} variable from Jenkins
REM Do not run clean cause it deletes failed.txt file
clean compile test surefire-report:report-only  -B -P${testCategory} -DBUILD_URL=${BUILD_URL}

REM exit 0