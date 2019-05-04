# Multiple Client Support Server
#### This repository contains a simple code written in java which shows how a server can support multiple clients simultaneously using threads.

### Instructions
1. Compile the 'ChatServer.java' file using javac.
2. Compile the 'Client.java' file using javac.
3. Start the server by using the following command 'java ChatServer'. It will start the server which by default listenes on address 'localhost' and port 9000.
4. Start the client application by using the follwing command 'java Client localhost 9000' on a seperate terminal. It will start the client which will make a connection request to the server listening on localhost:9000.
5. The server will ask for a client id which has been put in a static database. There are two client ids avaiable - 'client1' and 'client2'.
6. Open one another terminal and use 'java Client localhost 9000' to connect 2nd client to the server.
7. After entering client id, you can type anything on the client terminal and it will be reflected on the server terminal.
8. Try typing through both the terminals to see how server handles both the clients simultaneously.
