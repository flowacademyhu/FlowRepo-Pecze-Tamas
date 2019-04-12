#!/bin/bash
path=pwd;
sudo -i -u root
echo $path
cd $path
java DbGenerator.java >> /tmp/sql_inserts.sql
psql -U  postgres -d flowhub -c /tmp/sql_inserts.sql