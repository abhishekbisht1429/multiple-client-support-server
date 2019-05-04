import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
class ClientHandler extends Thread {
	private Socket socket;
	private int connNumber;
	ClientHandler(Socket socket,int connNumber) {
		this.socket = socket;
		this.connNumber = connNumber;
		start();
	}

	@Override
	public void run() {
		System.out.println("Server>>handling new client "+connNumber);
		try(Scanner input = new Scanner(socket.getInputStream());
			PrintWriter output = new PrintWriter(socket.getOutputStream(),true)) {
			output.println("Enter Client ID");
			String clientId = input.nextLine();

			if(Database.getInstance().getClient(clientId)!=null) {
				output.println("200");

				String temp;
				while(!((temp=input.nextLine()).equals("-1"))) {
					Console.print(clientId+" : "+temp);
				}
				System.out.println(clientId+" exiting");
			} else {
				output.println("-1");
			}
		} catch(IOException ioE) {
			ioE.printStackTrace();
		}
	}
}
