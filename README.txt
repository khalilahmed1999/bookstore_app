What is this?
-------------
This is my first javaFX project, a simple bookstore application using Oracle Database to store book and order datas.
It was intended to be a practice of how to build a GUI and use the MVC model for communicating with the database.
It is capable to add, modify and delete books and organize them into a category system. You can browse books, add them 
to a cart and order them.

How to try it out? (on Windows)
-------------------------------
After downloading, an Oracle (I used version 11g) database needed to be created by importing the provided .sql file in 
the 'database' folder.

Then with the command line you should walk into the 'bookstore' folder.

From here the source files are needed to be compiled with these lines:
>dir /s /B *.java > sources.txt
>javac @sources.txt

(The compiler needs access to the Oracle ojdbc6.jar driver. If you didn't add it before to the classpath environment 
variable, then use the -cp option like this: javac -cp <path to ojdbc6.jar> @sources.txt)

After the compilation you step one folder back (cd ..) and start the app like this:
>java bookstore.view.Main

The app prompts you to connect with the username and password you created for the imported database.
