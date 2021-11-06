package central.lojas;
import java.io.IOException;

import central.lojas.telas.login;

public class CentralLojasMain {
	public static void main(String[] args) throws IOException {
		login inicio = new login();
		inicio.interFace.setVisible(true);
	}

	
}
