#!/bin/bash

# Do not run clean cause it deletes failed.txt file

mvn compile test surefire-report:report-only  -B -PfailedTestCategory -Dbrowser=${browser}

echo "[INFO] ------------------------------------------------------------------------"
echo "[INFO]  All tests are done"
echo "[INFO] ------------------------------------------------------------------------"

exit 0