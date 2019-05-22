@for /F %%i in ('netstat -a^|findstr 1230') do ( set pid1=%%i)
@for /F %%j in ('netstat -a^|findstr 4200') do ( set pid2=%%j)

@echo pid_server=%pid1%
@echo pid_client=%pid2%

gradlew --stop

@taskkill /F /PID %pid1%
@taskkill /F /PID %pid2%