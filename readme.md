#README
Bonan Cao <bonanc@andrew.cmu.edu>
Oct. 21. 2015
This directory holds the the JAVA project for project 1 Unit 6 PartA of 18-641, the class diagram and the outputs of project. The details are as follows.

Two projects are included:
- Server
- Client
The server is updated in this unit while the client part is the same as last unit.
The using of database on server is implemented in this unit. We now update the database when operating on the linkedhashmap.
An interface is designed for the operations on the database.
The txt file for SQL: CreateTable.txt, SQL.txt.

Test: 
Run the MainDriver in the server project.
The methods for adding autos, updating the name of option sets and updating the price of options are shown in the test. Deleting is also tested.

The outputs of test are shown in test_output.txt.
The diagram is shown in class_diagram_client.png and class_diagram_server.png.
The list of files:
  ▾ bonanc_Project1_Unit6/
    ▾ Project_1_Client/
      ▾ bin/
        ▾ adapter/
            BuildAuto.class
            CreateAuto.class
            EditAuto.class
            FixAuto.class
            ProxyAutomobile.class
            UpdateAuto.class
        ▾ client/
            CarModelOptionsIO.class
            ClientDriver.class
            DefaultSocketClient.class
            SelectCarOption.class
        ▾ constants/
            ClientConstants.class
            SizeConstants.class
        ▾ exception/
            AutoException.class
            ExceptionEnum.class
            FixHelper.class
        ▾ model/
            Automotive.class
            OptionSet$Option.class
            OptionSet.class
        ▾ scale/
            EditOptions.class
        ▾ servlet/
            ModifyAuto.class
            SelectAuto.class
            ShowChoice.class
        ▾ util/
            FileIO.class
      ▾ src/
        ▾ adapter/
            BuildAuto.java
            CreateAuto.java
            EditAuto.java
            FixAuto.java
            ProxyAutomobile.java
            UpdateAuto.java
        ▾ client/
            CarModelOptionsIO.java
            ClientDriver.java
            DefaultSocketClient.java
            SelectCarOption.java
        ▾ constants/
            ClientConstants.java
            SizeConstants.java
        ▾ exception/
            AutoException.java
            ExceptionEnum.java
            FixHelper.java
        ▾ model/
            Automotive.java
            OptionSet.java
        ▾ scale/
            EditOptions.java
        ▾ servlet/
            ModifyAuto.java
            SelectAuto.java
            ShowChoice.java
        ▾ util/
            FileIO.java
      ▾ WebContent/
        ▾ META-INF/
            MANIFEST.MF
        ▾ WEB-INF/
          ▸ lib/
            web.xml
          ModifyAuto.jsp
          ShowChoice.jsp
        1.properties
        2.properties
        3.properties
        4.properties
        exception.log
        Ford Focus Wagon ZTW.dat
        Ford Focus Wagon ZTW.txt
        representations.aird
        ▾ Project_1_Server/
          ▾ bin/
            ▾ adapter/
                BuildAuto.class
                CreateAuto.class
                EditAuto.class
                EditAutoDB.class
                FixAuto.class
                ProxyAutomobile.class
                UpdateAuto.class
            ▾ constants/
                ClientConstants.class
                DBConstants.class
                SizeConstants.class
            ▾ database/
                CreateTable.class
                DBOperation.class
                SQLConnection.class
            ▾ driver/
                MainDriver.class
            ▾ exception/
                AutoException.class
                ExceptionEnum.class
                FixHelper.class
            ▾ model/
                Automotive.class
                OptionSet$Option.class
                OptionSet.class
            ▾ scale/
                EditOptions.class
            ▾ server/
                AutoServer.class
                BuildCarModelOptions.class
                DefaultSocketClient.class
                Multithread.class
                ServerDriver.class
            ▾ util/
                FileIO.class
          ▾ src/
            ▾ adapter/
                BuildAuto.java
                CreateAuto.java
                EditAuto.java
                EditAutoDB.java
                FixAuto.java
                ProxyAutomobile.java
                UpdateAuto.java
            ▾ constants/
                ClientConstants.java
                DBConstants.java
                SizeConstants.java
            ▾ database/
                CreateTable.java
                DBOperation.java
                SQLConnection.java
            ▾ driver/
                MainDriver.java
            ▾ exception/
                AutoException.java
                ExceptionEnum.java
                FixHelper.java
            ▾ model/
                Automotive.java
                OptionSet.java
            ▾ scale/
                EditOptions.java
            ▾ server/
                AutoServer.java
                BuildCarModelOptions.java
                DefaultSocketClient.java
                Multithread.java
                ServerDriver.java
            ▾ util/
                FileIO.java
            1.properties
            2.properties
            CreateTable.txt
            exception.log
            Ford Focus Wagon ZTW(with wrong format).txt
            Ford Focus Wagon ZTW(without basePrice).dat
            Ford Focus Wagon ZTW(without basePrice).txt
            Ford Focus Wagon ZTW.dat
            Ford Focus Wagon ZTW.txt
            representations.aird
            SQL.txt
          ChangeLog.txt
          class_diagram_client.png
          class_diagram_server.png
          Lessons Learnt in Mini 1.txt
          readme.txt
          test_output.txt
