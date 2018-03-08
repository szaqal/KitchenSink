package szaq;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class App {
	public static void main(String[] args) throws Exception {

		String config = "{}";

		InputStream serviceAccount = new ByteArrayInputStream(config.getBytes());

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl("https://test-adb3b.firebaseio.com/").build();
		FirebaseApp.initializeApp(options);
		System.out.println("App initialized ");
		
		final FirebaseDatabase database = FirebaseDatabase.getInstance();
		DatabaseReference ref = database.getReference();
		DatabaseReference dataRef = ref.child("key");
		
		
		dataRef.setValueAsync("val").get();
		System.out.println("Here");
	}
}
