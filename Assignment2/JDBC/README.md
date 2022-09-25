## Getting Started
- Init with =>& 'C:\Program Files\Java\jdk-18.0.2.1\bin\java.exe' '--enable-preview' '-XX:+ShowCodeDetailsInExceptionMessages' '@C:\Users\visha\AppData\Local\Temp\cp_98awcusdxiob5sj86wmo3kyhd.argfile' 'initDB'

- ShowBikes => & 'C:\Program Files\Java\jdk-18.0.2.1\bin\java.exe' '--enable-preview' '-XX:+ShowCodeDetailsInExceptionMessages' '@C:\Users\visha\AppData\Local\Temp\cp_98awcusdxiob5sj86wmo3kyhd.argfile' 'ShowBikes' 'Type-mountain_bike' 'Number_of_gears-5' 'Wheel_base'

- SearchTable => & 'C:\Program Files\Java\jdk-18.0.2.1\bin\java.exe' '--enable-preview' '-XX:+ShowCodeDetailsInExceptionMessages' '@C:\Users\visha\AppData\Local\Temp\cp_98awcusdxiob5sj86wmo3kyhd.argfile' 'TestMyBicycles' 'SearchTable' 'Type' 'Number_of_gears' 

- DeleteRow => & 'C:\Program Files\Java\jdk-18.0.2.1\bin\java.exe' '--enable-preview' '-XX:+ShowCodeDetailsInExceptionMessages' '@C:\Users\visha\AppData\Local\Temp\cp_98awcusdxiob5sj86wmo3kyhd.argfile' 'TestMyBicycles' 'DeleteRow' 'Type-mountain_bike' 'Number_of_gears-4' 'Wheel_base-36' 'Height-1' 'Color-steel' 'Construction_material-carbon'

- InsertRow => c:; cd 'c:\Users\visha\OneDrive\Documents\UNCC\Sem3\IoT\IoTAssignments\Assignment2\JDBC'; & 'C:\Program Files\Java\jdk-18.0.2.1\bin\java.exe' '--enable-preview' '-XX:+ShowCodeDetailsInExceptionMessages' '@C:\Users\visha\AppData\Local\Temp\cp_98awcusdxiob5sj86wmo3kyhd.argfile' 'TestMyBicycles' 'InsertRow' 'Type-mountain_bike' 'Number_of_gears-4' 'Wheel_base-36' 'Height-1' 'Color-steel' 'Construction_material-carbon' 

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).