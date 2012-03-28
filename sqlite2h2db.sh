#!/bin/sh
rm db/test.*
echo '.dump' | sqlite3 db/test.sqlite3 > db/test-export.sql
cat db/test-export.sql \
    | sed -e 's/^PRAGMA.*;//g' \
    | sed -e 's/"\([a-zA-Z_]*\)"/\1/g' \
    | sed -e 's/AUTOINCR/AUTO_INCR/g' | grep -v sqlite | grep -iv unique \
    > db/import.sql && java -cp $HOME/.m2/repository/com/h2database/h2/1.3.165/h2-1.3.165.jar \
                          org.h2.tools.RunScript -url "jdbc:h2:./db/test" -user "sa" -script "./db/import.sql"
