import java.util.ArrayList;
import java.util.List;
class Database {
	private static List<String> clientIds;
	private static Database database;
	static {
		clientIds = new ArrayList<>();
		clientIds.add("client1");
		clientIds.add("client2");
	}

	private Database() {

	}

	public static Database getInstance() {
		if(database==null)
			database = new Database();
		return database;
	}

	public List<String> getClients() {
		return clientIds;
	}

	public String getClient(String id) {
		for(String str:clientIds) {
			if(id.equals(str))
				return str;
		}
		return null;
	}
}
