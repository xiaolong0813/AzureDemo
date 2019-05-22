#!/usr/bin/env bash
./gradlew --stop

subo kill `sudo lsof -t -i:4200`
subo kill `sudo lsof -t -i:1230`