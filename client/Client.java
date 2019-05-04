import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.PrintWriter;
import java.util.Scanner;
class Client {
	public static void main(String[] args) {
		try(Socket socket = new Socket(args[0],Integer.parseInt(args[1]))) {
			Scanner input = new Scanner(socket.getInputStream());
			Scanner stdin = new Scanner(System.in);
			PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
			System.out.println("Server>>"+input.nextLine());
			String clientId = stdin.nextLine();//accept client id from the client
			output.println(clientId);//send the client id to the server

			int code = Integer.parseInt(input.nextLine().trim()); // get the return code for id verfication
			if(code==200) {
				System.out.println("*******************Welcome "+clientId+"(Enter -1 to exit)*******************");
				String temp;
				while(!((temp=stdin.nextLine()).equals("-1"))) {
					output.println(temp);
				}
				output.println("-1");
			}
			else
				System.out.println("auth failed");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
