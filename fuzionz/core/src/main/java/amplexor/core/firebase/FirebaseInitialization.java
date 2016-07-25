package amplexor.core.firebase;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FirebaseInitialization {

    public FirebaseInitialization() throws FileNotFoundException {
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setServiceAccount(new FileInputStream("./fuzionz-c829e080ffcd.json"))
                .setDatabaseUrl("https://databaseName.firebaseio.com/")
                .build();
        FirebaseApp.initializeApp(options);
    }
}
