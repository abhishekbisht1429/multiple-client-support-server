import java.net.ServerSocket;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
class ChatServer {
	private static int connCount;
	public static void main(String[] args) {
		try(ServerSocket serverSocket = new ServerSocket(9000,10,InetAddress.getByName("localhost"))) {
			while(true) { //accept all incoming requests
				Socket socket = serverSocket.accept();
				connCount++;
				new ClientHandler(socket,connCount);//start new thread to handle the incoming request
			}
		} catch(IOException ioE) {
			ioE.printStackTrace();
		}
	}
}
